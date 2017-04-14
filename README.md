# Taxi-Service

Investigating the software structure required to support Taxi Services.

You will get customer requests to go from a vertex source
to a vertex destination and you will have to return the closest available taxi.
A taxi is termed as busy or available, depending on whether it is currently
servicing a customer request or not. Initially, all the taxi’s will be marked as
available. They wait at different vertices of the graph. 

We will assume that there is a universal clock that moves in discrete time
steps. The time starts from 0 and increases in steps of 1. Assume that a cus-
tomer requests a taxi to go from vertex source to vertex destination. Among
all the available taxis, we will choose the nearest taxi to service the customer
request. This taxi will be marked as busy from current-time till current-time
+ distanceGraph(taxiPosition,source) + distanceGraph(source,destination),
i.e., the taxi will be busy for the time it takes for it to reach the customer
from its current position, and then again for the time it takes for it to trans-
port the customer from source to destination. After servicing the customer
request, the cab waits at the destination vertex for subsequent customer re-
quests.We will assume that an available taxi remains stationary and just waits for a customer request

1. Design a Graph. Given a list of edges, you should be able to create a
graph. Implement a debug function to print the graph.
2. Implement the shortest path algorithm. Given any two vertices source
and destination, you should be able to find distanceGraph(source, destination).
3. Introduce the concept of a taxi. The property of taxi should be a tuple
(currentposition, availability). You can use a set to store all the taxis.
4. Implement the function for servicing a customer without introducing
the concept of time. This can be done in two simple steps:
  (a) Determine the distance from all available taxi’s to the customer’s
  source vertex. Choose the taxi with the minimum distance. In
  case there are multiple taxi’s at the same distance from the cus-
  tomer’s position, choose one randomly.
  (b) Determine the path to drive the taxi from its current position
  to customer’s source vertex, and then to customer’s destination
  vertex.
After servicing the customer, the taxi’s position should be the cus-
tomer’s destination vertex.

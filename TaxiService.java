
public class TaxiService {

	Graph graph = new Graph();


	public Taxi nearestTaxi(Position a,int t) throws Exception{
		MySet<Taxi> m =graph.availableTaxis(t);
		int j =Integer.MAX_VALUE;
		Taxi cab = new Taxi("null",null);
		for(int i=0;i<m.sizeM();i++)
		{
			if(j>graph.shortestPath(m.member(i).currentposition, a)){
				j=graph.shortestPath(m.member(i).currentposition, a);
				cab = m.member(i);
			}
		}
		return cab;
	}

	public void performAction(String actionMessage) throws Exception {

		System.out.println("##########################   " + actionMessage);
		String[] s = actionMessage.split(" ");
		switch(s[0]){

		case "edge":
			Edge e = new Edge(graph.giveVertex(s[1]),graph.giveVertex(s[2]),Integer.parseInt(s[3]));
			graph.addEdge(e);
			break;

		case "taxi":
			if(graph.isVertex(s[2])!=true){
				System.out.print("Vertex " + s[2] +" does not exist");
			}
			else{
				Edge z =graph.giveEdge(graph.giveVertex(s[2]),graph.nearest(graph.giveVertex(s[2])));
				Position p = new Position(z,0);
				Taxi t = new Taxi(s[1],p);             //create nearest vertex to this vertex
				graph.addTaxi(t);
				break;
			}
		case "customer":
			int a1 =Integer.parseInt(s[3]);
			int a2 =Integer.parseInt(s[6]);
			Edge e1 = graph.giveEdge(graph.giveVertex(s[1]),graph.giveVertex(s[2]));
			Edge e2 = graph.giveEdge(graph.giveVertex(s[4]),graph.giveVertex(s[5]));
			Position source = new Position(e1,a1);
			Position dest = new Position(e2,a2);
			int a =Integer.parseInt(s[7]);

			MySet<Taxi> m= graph.availableTaxis(a);
			for(int i =0;i<m.sizeM();i++)
			{
				System.out.print("Path of " + m.member(i).taxiName + ": ");
				graph.printPath(m.member(i).currentposition,source);                    
				System.out.println();
			}
			System.out.println("**Choose " +nearestTaxi(source,a).taxiName+" to service the customer request ***");
			System.out.print("Path of the customer: ");
			Taxi cab = nearestTaxi(source,a);
			graph.printPath(source,dest);
			System.out.println();
			int y = a + graph.shortestPath(nearestTaxi(source,a).currentposition,source) + graph.shortestPath(source,dest); 
			cab.bookedTill(y);			
			cab.currentposition=dest;
	
			break;

		case "printTaxiPosition":
			int x =Integer.parseInt(s[1]);
			MySet<Taxi> m1 =graph.availableTaxis(x);
			for(int i=0;i<m1.sizeM();i++){
				System.out.println(m1.member(i).taxiName + " : " + m1.member(i).currentposition.vertexA.vertex +" ," + m1.member(i).currentposition.vertexB.vertex +" ," +m1.member(i).currentposition.t);
			} 
		}
	}
}

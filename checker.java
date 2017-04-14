
public class checker {
	
    public static void main(String[] args) throws Exception
    {
        Graph g = new Graph();
    
        g.addEdge(new Edge(g.giveVertex("indiagate"),g.giveVertex("chanakyapuri"),30));
        //system.out.println(g.vertices.sizeM());
        g.addEdge(new Edge(g.giveVertex("indiagate"),g.giveVertex("AIIMS"),30));
        g.addEdge(new Edge(g.giveVertex("indiagate"),g.giveVertex("lajpatnagar"),50));
        g.addEdge(new Edge(g.giveVertex("chanakyapuri"),g.giveVertex("AIIMS"),20));
        g.addEdge(new Edge(g.giveVertex("AIIMS"),g.giveVertex("lajpatnagar"),15));
        g.addEdge(new Edge(g.giveVertex("chanakyapuri"),g.giveVertex("iitmaingate"),50));
        g.addEdge(new Edge(g.giveVertex("AIIMS"),g.giveVertex("iitmaingate"),30));
        g.addEdge(new Edge(g.giveVertex("lajpatnagar"),g.giveVertex("iitmaingate"),40));
        
       // g.addTaxi(new Taxi(("shaktimaan"),g.giveVertex("iitmaingate")));     
      //  g.addTaxi(new Taxi(("batman"),g.giveVertex("lajpatnagar")));
       // g.addTaxi(new Taxi(("superman"),g.giveVertex("indiagate")));
      // System.out.println(g.shortestPath1(g.giveVertex("indiagate"),g.giveVertex("chanakyapuri")));
        g.printPath1(g.giveVertex("indiagate"),g.giveVertex("chanakyapuri"));
      /*  Edge e2 =g.giveEdge(g.giveVertex("chanakyapuri"), g.giveVertex("indiagate"));
        Edge e1 = g.giveEdge(g.giveVertex("iitmaingate"), g.giveVertex("lajpatnagar"));
        Position p1 = new Position(e1,0);
        Position p2 = new Position(e2,0);
        g.printPath(p1, p2);
        System.out.println(g.shortestPath(p1, p2));*/
   

    }
	
	
}

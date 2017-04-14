
public class Taxi {

	Graph g;
	Position currentposition;
	int availability =0;
	String taxiName;
	Vertex source;
	Vertex Destination;
	MySet<Edge> path;			 

	public Taxi(String name,Position curr){
		currentposition = curr;
		taxiName = name;
		availability =0;
		path = new MySet<Edge>();
	}

	public boolean available(int t){
		if(availability-t<=0)
		{return true;}
		else{return false;}
	}

	public void bookedTill(int t) throws Exception{
		availability = t;
	}

	public Vertex nextDestination(Position p) throws Exception{

		Vertex v1 = g.nearestVertex(p);
		Vertex v2 = null;
		MySet<Vertex> m = g.sort(g.vertices);
		for(int i=0;i<m.sizeM();i++)
		{
			if(m.member(i).vertex.equals(v1.vertex))
			{
				v2 =m.member((i+1)%m.sizeM()); 
			}
		}
		return v2;
	}


}


public class Edge {

	Vertex start;
	Vertex end;
	int distance;

	public Edge(Vertex a,Vertex b,int i){
		start = a;
		end = b;
		distance = i;
	}
	
	public Edge reverse(){
		return new Edge(this.end,this.start,this.distance);
	}
}


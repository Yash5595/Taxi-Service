
public class Position {

	Vertex vertexA;
	Vertex vertexB;
	int t;
	Edge edge;
	
	public Position(Edge e,int t){
		this.t= t;
		vertexA = e.start;
		vertexB = e.end;
		edge =e;
	}
	
}


public class Vertex {

	Vertex parent;
	String vertex;
	MySet<Edge> edges;
	int value;
	public Vertex (String v){
	    vertex =v;
		edges = new MySet<Edge>();
	}
		
	public void addE(Edge e){
		edges.add(e);
	}
	
	public void deleteE(Edge e){
		edges.Delete(e);
	}
	
	public void setValue(int a){
		value =a;
	}
	
	public void setParent(Vertex a){
		parent = a;
	}
	
}

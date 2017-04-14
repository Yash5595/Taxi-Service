import java.util.ArrayList;
import java.util.Collections;

public class Graph {

	MySet<Vertex> vertices = new MySet<Vertex>();
	MySet<Edge> edges = new MySet<Edge>();
	MySet<Taxi> taxiList = new MySet<Taxi>();
	//MySet<Vertex> vertices2 = sort(vertices);

	public void addVertex(Vertex v) throws Exception{
		vertices.add(v);
		sort(vertices);
	}

	public void removeVertex(Vertex v){
		vertices.Delete(v);
	}

	public Boolean Alphabetical(Vertex a,Vertex b){
		int i=0;
		Boolean v =false;
		String s1 = a.vertex;
		String s2 = b.vertex;
		while(i<Integer.min(s1.length(),s2.length()))
		{
			if(s1.charAt(i)<s2.charAt(i))
			{
				v = true;
				break;
			}
			else if (s1.charAt(i)==s2.charAt(i))
			{
				i++;
			}
			else
			{
				break;
			}
		}                                              // yas , yash 
		return v;
	}

	public MySet<Vertex> sort(MySet<Vertex> m) throws Exception{	         
		Vertex temp;
		MySet<Vertex> m2 = new MySet<Vertex>();
		Vertex[] v= new Vertex[m.sizeM()];
		for(int k=0;k<m.sizeM();k++)
		{
			v[k] = m.member(k);
		}
		for (int i = 1; i <v.length; i++) {
			for(int j = i ; j > 0 ; j--){                  // in decr order then reverse
				if(Alphabetical(v[j-1], v[j])==true){
					temp = v[j-1];
					v[j-1] = v[j];
					v[j] = temp;
				}
			}
		}

		for(int l=0;l<v.length;l++)
		{
			m2.add(v[l]);
		}
		return m2;

	}

	public void addEdge (Edge e) throws Exception{
		Vertex v1 = giveVertex(e.start.vertex);
		Vertex v2 = giveVertex(e.end.vertex);
		edges.add(e);
		edges.add(e.reverse());
		v1.addE(e);
		v2.addE(e.reverse());

	}		

	public void removeEdge(Edge e) throws Exception{
		Vertex v1 = e.start;
		Vertex v2 = e.end;
		if(vertices.IsMember(v1) && vertices.IsMember(v2)){

			edges.Delete(e);
			edges.Delete(e.reverse());		
			v1.deleteE(e);
			v2.deleteE(e.reverse());
		}
		else{
			throw new Exception("Edge cannot be deleted");
		}
	}


	public int shortestPath1(Vertex a,Vertex b) throws Exception{

		MySet<Vertex> q =new MySet<Vertex>();
		for(int z =0;z<vertices.sizeM();z++){
			q.add(vertices.member(z));
			vertices.member(z).setValue(Integer.MAX_VALUE);
			q.member(z).setParent(null);
		}

		Vertex u =new Vertex(null);
		if(a.vertex.equals(b.vertex)){
			return 0;
		}
		else
		{		
			a.setValue(0);	

			while(!q.IsEmpty())
			{
				int j=Integer.MAX_VALUE;
				for(int i=0;i<q.sizeM();i++){
					if(j>q.member(i).value){
						j=q.member(i).value;
						u =q.member(i);					 
					}
				}
				q.Delete(u);

				MySet<Edge> e =new MySet<Edge>();
				for(int k=0;k<u.edges.sizeM();k++)
				{
					e.add(u.edges.member(k));
				}	    	   	 
				for(int y =0;y<e.sizeM();y++)
				{
					if(q.IsMember(e.member(y).end))
					{
						int alt = j + e.member(y).distance;
						if(alt<e.member(y).end.value)
						{
							e.member(y).end.setValue(alt);
							e.member(y).end.setParent(u);
						}
					}  
				}
			}
		}
		return b.value;
	}

	public int shortestPath(Position source,Position dest) throws Exception{
		//4 cases take min of them
		int a = shortestPath1(source.vertexA,dest.vertexA) + source.t + dest.t;
		int b = shortestPath1(source.vertexA,dest.vertexB) + source.t + (dest.edge.distance-dest.t);
		int c = shortestPath1(source.vertexB,dest.vertexA) + (source.edge.distance-source.t) + dest.t;
		int d = shortestPath1(source.vertexB,dest.vertexB) + (source.edge.distance-source.t) + (dest.edge.distance-dest.t);

		MySet<Integer> m =new MySet<Integer>();
		m.add(a);
		m.add(b);
		m.add(c);
		m.add(d);
		int j=Integer.MAX_VALUE;
		for(int i=0;i<m.sizeM();i++){
			if(j>m.member(i))
			{
				j= m.member(i);
			}
		}
		return j;
	}

	public void printPath1(Vertex a,Vertex b) throws Exception{
		ArrayList<String> l = new ArrayList<String>();
		int t =shortestPath1(a,b);
		Vertex x = b;
		while(!x.vertex.equals(a.vertex))
		{
			l.add(x.vertex);
			x = x.parent;
		}
		l.add(a.vertex);
		Collections.reverse(l);
		for(int i=0;i<l.size();i++){
		System.out.print(l.get(i) + " ,");
		}
		//System.out.print("Time Taken is : " + t);
	}

	
	public void printPath(Position source,Position dest) throws Exception{
		int t =shortestPath(source,dest);
		int a = shortestPath1(source.vertexA,dest.vertexA) + source.t + dest.t;
		int b = shortestPath1(source.vertexA,dest.vertexB) + source.t + (dest.edge.distance-dest.t);
		int c = shortestPath1(source.vertexB,dest.vertexA) + (source.edge.distance-source.t) + dest.t;
		//int d = shortestPath1(source.vertexB,dest.vertexB) + (source.edge.distance-source.t) + (dest.edge.distance-dest.t);
		
		if(t==a){
			printPath1(source.vertexA,dest.vertexA);
		}
		else if(t==b){
			printPath1(source.vertexA,dest.vertexB);
		}
		else if(t==c){
			printPath1(source.vertexB,dest.vertexA);
		}
		else{
			printPath1(source.vertexB,dest.vertexB);
		}
		System.out.print("Time Taken is : " + t);
	}



	public boolean isVertex(String a) throws Exception{
		boolean temp =false;
		for(int i=0;i<vertices.sizeM();i++){
			if(vertices.member(i).vertex.equals(a)){
				temp =true;
				break;
			}
		}
		return temp;
	}

	public Vertex giveVertex(String a) throws Exception{
		Vertex x = null;
		if(isVertex(a)==true){
			for(int i=0;i<vertices.sizeM();i++){
				if(vertices.member(i).vertex.equals(a)){
					x= vertices.member(i);}
			}
		}
		else{
			x = new Vertex(a);
			vertices.add(x);
		}
		return x;		
	}

	public Edge giveEdge(Vertex a,Vertex b) throws Exception{
		Edge e =null;
		for(int i=0;i<edges.sizeM();i++){
			if(edges.member(i).start.vertex.equals(a.vertex) && edges.member(i).end.vertex.equals(b.vertex)){
				e=  edges.member(i);
			}
		}
		return e;
	}

	public int giveNumber(Vertex v) throws Exception{
		MySet<Vertex> m = sort(vertices);
		int t=0;
		for(int i=0;i<m.sizeM();i++){
			if(m.member(i).vertex.equals(v.vertex)){
				t=i;
			}
		}
		return t;
		
	}
	
	public void addTaxi(Taxi t) throws Exception{
		if(!vertices.IsMember(t.currentposition.vertexA)){
			throw new Exception(t.currentposition.vertexA.vertex +" does not exist!");	
		}
		else{
			taxiList.add(t);	
		}
	}
	
	public void deleteTaxi(Taxi t){
		taxiList.Delete(t);
	}

	public MySet<Taxi> availableTaxis(int t) throws Exception{
		MySet<Taxi> ms = new MySet<Taxi>();
		for(int i=0;i<taxiList.sizeM();i++){
			if(taxiList.member(i).available(t)==true){
				ms.add(taxiList.member(i));
			}
		}
		return ms;
	}


	public Vertex nearest(Vertex v) throws Exception{
		int j =Integer.MAX_VALUE;
		Vertex a =null;
		for(int i=0;i<v.edges.sizeM();i++)
		{
			if(j>v.edges.member(i).distance)
			{
				j = v.edges.member(i).distance;
				a = v.edges.member(i).end;
			}
		}
		return a;
	}

	public Vertex nearestVertex(Position p) throws Exception{
		Vertex v = null;
		if(p.t<p.edge.distance-p.t)
		{
			v= p.vertexA;
		}
		else if(p.t>p.edge.distance-p.t)
		{
			v= p.vertexB;
		}
		else
		{
			if(Alphabetical(p.vertexA,p.vertexB)==true)
			{
				v =p.vertexA;
			}
			else
			{
				v = p.vertexB;
			}
		}
		return v;
	}

		
	
}
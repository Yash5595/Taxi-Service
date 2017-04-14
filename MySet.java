
public class MySet<X> {
	public MyLinkedList<X> l;
	public MySet(){
		l= new MyLinkedList<X>();
	}


	public X member(int a) throws Exception{
		Node<X> x =l.head;
		if(a>=l.getsize()){
			throw new Exception("Index Out of Bound");}
		else{
			int i=0;
			while(i<a){
				x=x.getnext();
				i++;
			}
		}
		return (x.getElement());    
	}

	public void add(X x){
		if(IsMember(x)==false){

			Node<X> v = new Node<X>(x,l.head);
			if(l.head==null){
				l.head=v;
				l.size++;
			}
			else{v.setnext(l.head);
			l.head=v;
			l.size++;
			}
		}
	}
		
	public int sizeM(){
		return l.getsize();			
	}

	public boolean IsEmpty(){
		return (l.getsize()==0);
	}

	public boolean IsMember(X x){
		Node<X> h = l.head;
		for(int i=0;i<l.getsize();i++){
			if(h.getElement().equals(x)==true)
			{return true;}
			else{
				h= h.getnext();
			}
		}
		return false;
	}


	public MySet<X> Union (MySet<X> a) throws Exception{	
		MySet<X> m = new MySet<X>();   	
		for(int i=0;i<a.sizeM();i++){
			m.add(a.member(i)); 
		}if(l==null){
			return a;}
		while(l.head!=null){
			if(m.IsMember(l.head.getElement())==false){
				m.add(l.head.getElement());
				l.head=l.head.getnext();}
			else{l.head=l.head.getnext();}}
		return m;}

	public MySet<X> Intersection (MySet<X> a){
		MySet<X> m = new MySet<X>();
		for(int i=0;i<l.getsize();i++){
			if(a.IsMember(l.head.getElement())==true){
				m.add(l.head.getElement());
				l.head=l.head.getnext();  
			} 
			else{l.head=l.head.getnext();}	
		}  
		return m;
	}      

	public void Delete(X o) {
		if(IsMember(o)==false)
		{
			try{
				throw new IllegalStateException("Object not found");
			}
			catch(IllegalStateException e){
				System.out.println("Object not found");
			}
		}
		int x=0;
		Node<X> n = l.head;
		for(int i=0;i<(l.getsize()-1);i++){
			if(n.getElement().equals(o)){
				x=i;
				break;
			}
			n=n.getnext();
		}
		l.delete(x);
	}

}

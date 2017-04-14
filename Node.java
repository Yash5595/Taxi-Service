
public class Node<X> {

  protected X element;
    protected Node<X> next;
   
   public Node(X s,Node<X> n){
	   element = s;
	   next = n;
   }    
	  public X getElement()
	  {return element;}
	   public void setElement(X newElem)
       {element = newElem; }
	  public Node<X> getnext()
	  {return next;}
	   public void setnext(Node<X> newNext)
	   {next = newNext;}
	     
   
}

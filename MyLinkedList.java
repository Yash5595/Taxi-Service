
public class MyLinkedList<X> {
	
    public Node<X> head;
    public Node<X> end ;
    public int size ;
    
    /*  Constructor  */
    public MyLinkedList()
    {
        head = null;
        end = null;
        size = 0;
    }
    /*  Function to check if list is empty  */
    public boolean isEmpty()
    {
        return head == null;
    }
    /*  Function to get size of list  */
    public int getsize()
    {
        return size;
    }
    /*  Function to insert an element at begining  */
    public void add(X val)
    {
        Node<X> nptr = new Node<X>(val, null);
        size++ ;
        if(head == null)
        {
            head = nptr;
            end = head;
        }
        else
        {
            nptr.setnext(head);
            head = nptr;
        }
    }
    /*  Function to insert an element at end  */
    public void addl(X val)
    {
        Node<X> nptr = new Node<X>(val,null);
        size++ ;
        if(head == null)
        {
            head = nptr;
            end = head;
        }
        else
        {
            end.setnext(nptr);
            end = nptr;
        }
    }

    public void insertAtPos(X val , int pos)
    {
        Node<X> nptr = new Node<X>(val, null);
        Node<X> ptr = head;
        if(pos==0)
            add (val);
        else if(pos == size)
           addl(val);
        else
        {
            pos=pos-1;
            for (int i = 0; i < size-1; i++)
            {
                if (i == pos)
                {
                    Node<X> tmp = ptr.getnext() ;
                    ptr.setnext(nptr);
                    nptr.setnext(tmp);
                    break;
                }
                ptr = ptr.getnext();
            }
            size++ ;
        }
    }

    
	 public X data(int i) throws Exception{
		if(getsize()<=i){throw new Exception ("number of children is less than asked");}
		else{
			Node<X> x =head;
			int c=0;
			while(c<i){
				x=x.getnext();
				c++;
			}
			return x.getElement();
		}
		
}

	 public void delete(int pos)
	    {
	        if (pos == 0)
	        {
	            head = head.getnext();
	            size--;
	            return ;
	        }
	        if (pos == size-1)
	        {
	            Node<X> s = head;
	            Node<X> t = head;
	            while (s != end)
	            {
	                t = s;
	                s = s.getnext();
	            }
	            end = t;
	            end.setnext(null);
	            size --;
	            return;
	        }
	        Node<X> ptr = head;
	        pos = pos - 1 ;
	        for (int i = 0; i < size - 2; i++)
	        {
	            if (i == pos)
	            {
	                Node<X> tmp = ptr.getnext();
	                tmp = tmp.getnext();
	                ptr.setnext(tmp);
	                break;
	            }
	            ptr = ptr.getnext();
	        }
	        size-- ;
	    }
	 
    }




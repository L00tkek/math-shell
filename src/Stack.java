public class LinkedStack<E>
{
    Node<E> head;

    public LinkedStack() 
    {
        this.head = null;
    }

    @Override
    public void push(E newEntry) 
    {
        if(newEntry != null) 
        {
            this.head = new Node<E>(newEntry, this.head);
        }
    }

    public E pop() 
    {
        return getTop(true);
    }

    public E peek() 
    {
        return getTop(false);
    }

    private E getTop(boolean remove) 
    {
        if(this.head != null) 
        {
            E toReturn = this.head.val;

            if(remove) 
            {
                this.head = this.head.next;
            }

            return toReturn;
        }
        else 
        {
            return null;
        }
    }

    public boolean isEmpty() 
    {
        return (this.head == null);
    }

    public void clear() 
    {
        this.head = null;
    }

    public String toString() 
    {
        if(this.head == null) 
        {
            return "";
        }
        else 
        {
            Node n = this.head;
            String str = "";

            while(n != null) 
            {
                str += n.val + ", ";
                n = n.next;
            }

            return str.substring(0, str.length() - 2); //-2 is to get rid of trailing ", "s
        }
    }
}

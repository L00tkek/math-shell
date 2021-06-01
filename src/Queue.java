public class Queue<E> 
{
    Node<E> head;
    Node<E> tail;

    public Queue() 
    {
        this.head = null;
        this.tail = null;
    }

    public void enqueue(E val) 
    {
        if(isEmpty()) 
        {
            this.head = new Node<E>(val, null);
            this.tail = this.head;
        }
        else 
        {
            this.tail.next = new Node<E>(val, null);
            this.tail = this.tail.next;
        }
    }

    public E dequeue() 
    {
        if(!isEmpty()) 
        {
            E toReturn = this.head.val;
            this.head = this.head.next;
            return toReturn;
        }
        return null;
    }

    public boolean isEmpty() 
    {
        return (this.head == null);
    }

    public boolean contains(E toFind) 
    {
        if(!isEmpty()) 
        {
            Node<E> n = this.head;

            while(n != null) 
            {
                if(n.val.equals(toFind)) 
                {
                    return true;
                }
                n = n.next;
            }
        }
        return false;
    }
}

class DynIntArray 
{
    void add(int e) 
    {

    }
    void setElementAt(int i, int e) 
    {

    }
    int getElementAt(int i) 
    {
        return 0; 
    }
    int getElementCount() 
    {
        return 0; 
    }
    void print() 
    {

    }
    public static void main(String args[]) 
    {
        for (int i = 0; i < 2; i++) 
        {
            DynIntArray da = null;
            //macht erst ein Array und gibt es aus und wiederholt dann das selbe mit einer Liste
            if (i == 0) 
            { 
                da = new DIAarray(); 
            }
            else 
            if (i == 1) 
            { 
                da = new DIAlist(); 
            }
            da.add(4); da.add(8); da.add(10); da.add(1); da.print(); 
            da.setElementAt(0, 0); da.add(5);
            da.setElementAt(2, da.getElementAt(2) + 10); da.print();
            System.out.println("DIA: elements=" + da.getElementCount() +
            " da[4]=" + da.getElementAt(4) +
            " da[9]=" + da.getElementAt(9));
        }
        
    }
}

class DIAarray extends DynIntArray
{
    private int Array [] = new int[1] ;
    private int Anzahl = 0;
    private int Kapazität = 1;

    void add(int e) 
    {
        if(Anzahl == Kapazität)
        {
            int temp[] = new int[Kapazität+1];
            for(int i = 0; i<Kapazität; i++)
            {
                temp[i]= Array[i];
            }
            Array = temp;
            Kapazität = Kapazität +1;
        }
        Array[Anzahl] = e;
        Anzahl++;
    }
    
    void setElementAt(int i, int e) 
    {
        if(i<=Anzahl-1)
        {
            Array[i]=e;
        }
    }
    int getElementAt(int i) 
    {
        if(i<=Anzahl-1)
        {
            return Array[i];
        }
        else
        {
            return 0;
        }
    }
    int getElementCount() 
    {
        return Anzahl; 
    }
    void print() 
    {
        System.out.print("[");
        for(int i = 0; i<Anzahl; i++)
        {
            System.out.print(Array[i]);
            if(i<Anzahl-1)
            {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println("");

        //der hätte es einfacher gemacht aber wir sollen ja keine vorgefertigten Klassen implementieren
        //System.out.println(Arrays.toString(Array));
    }
}
    
class DIAlist extends DynIntArray
{
    private node head = null;

    class node
    {
        private int data;
        private node next;

        //Konstruktor für Knoten
        node (int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    
    //an letzte Stelle einfügen
    public void add(int e) 
    {
        node newNode = new node(e);

        //falls newNode das erste Element ist
        if(this.head == null)
        {
            this.head = newNode;
        }
        else
        {
            //Knoten der die Liste bis zum Ende durchwandert
            node last = this.head;
            while(last.next!=null)
            {
                //Knoten wird auf eigenen Nachfolger gesetzt
                last = last.next;
            }
            last.next = newNode;
        }
    }
    void setElementAt(int i, int e) 
    {
        node set = this.head;
        int count = 0;
        //geht Liste durch und ersetzt, wenn ntes Element gleich i ist
        while(set!=null)
        {
            if(count == i)
            {
                set.data = e;
                return;
            }
            set = set.next;
            count++;
        }
    }
    int getElementAt(int i) 
    {
        node get = this.head;
        int count = 0;

        //basically genau der Setter
        while(get!=null)
        {
            if(count==i)
            {
                return get.data;
            }
            count++;
            get = get.next;
        }
        //Element nicht vorhanden
        return 0; 
        
    }
    int getElementCount() 
    {
        int count = 0;
        node current = this.head;

        while(current!=null)
        {
            count++;
            current = current.next;
        }
        return count; 
    }
    void print() 
    {
        if (this.head == null) 
        {
			System.out.println("Liste leer");
		} 
        else 
        {
			node current = this.head;
            System.out.print("[");
			while (current != null) 
            {
				System.out.print(current.data);
                if(current.next != null)
                {
                    System.out.print(", ");
                }
				current = current.next;
			}
            System.out.print("]");
            System.out.println("");
		}
    }
}
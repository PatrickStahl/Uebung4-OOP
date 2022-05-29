import java.util.Arrays;

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
            extend();
        }
        Array[Anzahl] = e;
        Anzahl++;
    }

    void extend()
    {
        int temp[] = new int[Kapazität+1];
        for(int i = 0; i<Kapazität; i++)
        {
            temp[i]= Array[i];
        }
        Array = temp;
        Kapazität = Kapazität +1;
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
        System.out.println(Arrays.toString(Array));
    }
}
    
class DIAlist extends DynIntArray
{

}
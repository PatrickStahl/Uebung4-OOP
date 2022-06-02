class Einwohner
{
    public int einkommen;
    void setEinkommen(int einkommen)
    {
        this.einkommen = einkommen;
    }

    public int zuVersteuerndesEinkommen()
    {
        //nur an einer Stelle im Programm
        return einkommen/10;
    }

    public int steuer()
    {
        if(zuVersteuerndesEinkommen()<=1)
        {
            return 1;
        }
        return zuVersteuerndesEinkommen();
    }
}

class Adel extends Einwohner
{
    public int steuer()
    {
        if(zuVersteuerndesEinkommen()<=20)
        {
            return 20;
        }
        return zuVersteuerndesEinkommen();
    }
}

class Koenig extends Einwohner
{
    public int steuer()
    {
        return 0;
    }
}

class Bauer extends Einwohner
{

}

class Leibeigener extends Bauer
{
    void setEinkommen(int einkommen)
    {
        this.einkommen = einkommen-12;
    }
}

public class Königreich
{
    public static void main(String[] args) 
    {
        Leibeigener Wolfram = new Leibeigener();
        Wolfram.setEinkommen(3);
        System.out.println("Steuer: " + Wolfram.steuer() + " Gulden");
    }
}
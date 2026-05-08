package Ex4.Dominio;

public abstract class Animal {
    protected String som;

    public Animal(String som)
    {
        this.som=som;
    }

    public String getSom(){return som;}
    public abstract void exibir();
    
}

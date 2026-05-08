package Ex1.Dominio;

public abstract class Veiculos
{
    protected String marca;
    protected String modelo;
    
    public Veiculos(String modelo, String marca)
    {
        this.marca=marca;
        this.modelo=modelo;
    }
    
    public abstract void exibirDados();
}















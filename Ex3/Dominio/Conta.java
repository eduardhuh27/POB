package Ex3.Dominio;
public abstract class Conta
{
    protected String nome;
    protected double saldo;
    
    public Conta(String nome, double saldo)
    {
        this.nome=nome;
        this.saldo=saldo;
    }
}
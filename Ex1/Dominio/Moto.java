package Ex1.Dominio;

public class Moto extends Veiculos
{
    protected int cilindradas;
    
    public Moto(String marca, String modelo,int cilindradas)
    {
        super(modelo,marca);
        this.cilindradas=cilindradas;
    }
    
    @Override
    public void exibirDados()
    {
        System.out.println("Marca:"+marca+"\nModelo:"+modelo+"\nCilindradas:"+cilindradas+"CC");
    }
    
}
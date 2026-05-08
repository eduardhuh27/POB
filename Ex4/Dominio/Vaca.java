package Ex4.Dominio;

public class Vaca extends Animal {
    protected String tipo;

    public Vaca(String som,String tipo)
    {
        super(som);
        this.tipo=tipo;

    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public void exibir()
    {
        System.out.println("Som de um "+getTipo()+":"+super.getSom());
    }
}
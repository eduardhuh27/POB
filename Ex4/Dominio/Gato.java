package Ex4.Dominio;

public class Gato  extends Animal {
    protected String cor;

    public Gato(String som,String cor)
    {
        super(som);
        this.cor=cor;

    }

    public String getCor() {
        return cor;
    }

    @Override
    public void exibir()
    {
        System.out.println("Som de um "+getCor()+":"+super.getSom());
    }
}


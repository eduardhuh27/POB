package Ex4.Dominio;

public class Cachorro extends Animal {
    protected String raca;

    public Cachorro(String som,String raca)
    {
        super(som);
        this.raca=raca;

    }

    public String getRaca() {
        return raca;
    }

    @Override
    public void exibir()
    {
        System.out.println("Som de um "+getRaca()+":"+super.getSom());
    }
}

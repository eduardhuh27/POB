package Ex5.Dominio;

public class Cliente implements Autenticavel {
    protected String nome;
    protected int id;

    public Cliente(String nome,int id)
    {
        this.nome=nome;
        this.id=id;
    }
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    @Override
    public void exibirId()
    {
        System.out.println("Id do cliente "+getNome()+":"+getId());
    }
    
}

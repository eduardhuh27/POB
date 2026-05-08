package Ex2.Dominio;


public class Gerente extends Funcionario
{
    protected String departamento;
    
    public Gerente(String nome, double salario,String departamento)
    {
        super(nome,salario);
        this.departamento=departamento;
    }
    
    public double getSalario(){return salario;}

    @Override
    public double calcSalario()
    {
        return ((getSalario())*1.5);
    }
    public void exibir()
    {
        System.out.println("Nome:"+nome+ "\nDepartamento:"+departamento+"\nSalario:"+calcSalario());
    }
}
package Ex5.Dominio;

import java.util.Random;
public class Gerente extends Funcionario implements Autenticavel
{
    protected String departamento;
    
    public Gerente(String nome, double salario,String departamento)
    {
        super(nome,salario);
        this.departamento=departamento;
    }
    
  

    @Override
    public double calcSalario()
    {
        double salario=super.getSalario()*1.5;
        return salario;
    }
    public void exibir()
    {
        System.out.println("Nome:"+nome+ "\nDepartamento:"+departamento+"\nSalario:"+super.getSalario());
    }

    
    @Override
    public void exibirId(){
        Random rand=new Random();
        System.out.println("Id do gerente "+super.getNome()+":"+rand.nextInt(15));
    }
}
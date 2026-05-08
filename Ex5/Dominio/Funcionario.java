package Ex5.Dominio;

public abstract class Funcionario
{
    protected String nome;
    protected double salario;
    
    public Funcionario(String nome,double salario){
        this.nome=nome;
        this.salario=salario;
    }
    public String getNome() {
        return nome;
    }
    public double getSalario(){return salario;}
    
    public abstract double calcSalario();
}
package Ex6.Dominio;

public class  Funcionario implements Pagavel
{
    protected String cpf;
    protected double salario;
    
    public Funcionario(String cpf,double salario)
    {
        this.cpf=cpf;
        
        this.salario=salario;
    }
    
    public void setSalario(double salario){this.salario=salario;}
    public void setCpf(String cpf){this.cpf=cpf;}

    public double getSalario(){return salario;}
    public String getCpf(){return cpf;}

    public void exibirDados(){
        System.out.println("CPF:"+getCpf()+"Salario:"+getSalario());
    };    
    @Override
    public  double calcularPagamento(){
        return salario;
    }
    @Override
    public String toString() {
        return "CPF: " + cpf +
               " | Salário: R$ " + salario +
               " | Pagamento: R$ " + calcularPagamento();
    }
}

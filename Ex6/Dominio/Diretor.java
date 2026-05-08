package Ex6.Dominio;

public class Diretor extends Funcionario{
    private double bonus;
    
    public Diretor(String cpf,double salario,double bonus)
    {
        super(cpf,salario);
        this.bonus=bonus;
    }
    
    public double getBonus(){return bonus;}
    public void setBonus(double bonus){this.bonus=bonus;}
    
    
    @Override
    public void exibirDados()
    {
     System.out.println("CPF:"+super.getCpf()+"Salario:"+super.getSalario()+"Bonificacao:"+getBonus());   
    } 
       @Override
    public  double calcularPagamento(){
        return salario+bonus;
    }
    @Override
    public String toString() {
        return "CPF: " + cpf +
               " | Salario: R$ " + salario +
               " | Comissao: R$" + bonus+
               " | Pagamento: R$ " + calcularPagamento();
    }

    
}
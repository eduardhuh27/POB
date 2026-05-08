package Ex6.Dominio;

public class Vendedor extends Funcionario{
    private double comissao;
    
    public Vendedor(String cpf,double salario,double comissao)
    {
        super(cpf,salario);
        this.comissao=comissao;
    }
    
    public double getComissao(){return comissao;}
    public void setComissao(double comissao){this.comissao=comissao;}
 
    @Override
    public void exibirDados()
    {
     System.out.println("CPF:"+super.getCpf()+"Salario:"+super.getSalario()+"Comissao:"+getComissao());   
    } 
      @Override
    public  double calcularPagamento(){
        return salario+comissao;
    }
    @Override
    public String toString() {
        return "CPF: " + cpf +
               " | Salario: R$ " + salario +
               " | Comissao: R$" + comissao+
               " | Pagamento: R$ " + calcularPagamento();
    }
}
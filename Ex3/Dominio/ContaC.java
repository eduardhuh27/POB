package Ex3.Dominio;
public class ContaC extends Conta{
    protected int taxaSaque;
    
    public ContaC(String nome,double saldo,int taxaSaque)
    {
        super(nome,saldo);
        this.taxaSaque=taxaSaque;
    }
    public void setSaldo(double saldo){this.saldo=saldo;}
    public double getSaldo(){return saldo;}

    public double saque(double valor)
    {
        double Nsaldo;
        Nsaldo= getSaldo()-(valor* 1 +(taxaSaque/100.0));
        setSaldo(Nsaldo);
        System.out.println("Saldo apos saque:"+Nsaldo);
        return Nsaldo;
    }
}
package Ex11.Model;

public abstract class Veiculo {
    private String placa;
    private double custoFixo;

    public Veiculo(String placa, double custoFixo) throws PlacaException
    {
        if(placa.length() != 7)
        {
            throw new PlacaException(placa);

        }
        this.placa=placa;
        this.custoFixo=custoFixo;
    }

    public String getPlaca(){return placa;}
    public void setPlaca(String placa){this.placa=placa;}
    public double getCusto(){return custoFixo;}
    public void setPlaca(double custoFixo){this.custoFixo=custoFixo;}

    public abstract double calcCustoTotal();
    public abstract double calcIPVA();
    
    @Override
    public String toString()
    {
        return  "Placa: "+placa+"\t Custo Fixo: "+ custoFixo;
    }
}

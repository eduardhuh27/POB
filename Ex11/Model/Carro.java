package Ex11.Model;

public class Carro extends Veiculo implements Tribiutavel {
    private int quilometragem;

    public Carro(String placa,double custoFixo, int quilometragem) throws PlacaException
    {
        super(placa,custoFixo);
        this.quilometragem=quilometragem;
    }

    @Override
    public double calcCustoTotal(){

       return (calcIPVA()+getCusto()+(quilometragem*0.15));
    }

    @Override
    public double calcIPVA()
    {
        return (getCusto()*0.04);
    }
 
    @Override
    public String toString()
    {
     return "Tipo do veiculo: "+getClass().getSimpleName() +
                "\tPlaca: "+getPlaca()+
                "\tCusto Fixo: "+ getCusto()+
                "\tCusto total:"+calcCustoTotal()+
                "\tQuilometragem: "+quilometragem;
    }
}

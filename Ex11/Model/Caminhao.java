package Ex11.Model;

public class Caminhao extends Veiculo implements Tribiutavel {
    private double toneladasCarga;

    public Caminhao(String placa,double custoFixo, double toneladasCarga) throws PlacaException
    {
        super(placa,custoFixo);
        this.toneladasCarga=toneladasCarga;
    }

    @Override
    public double calcCustoTotal(){

       return (calcIPVA()+getCusto()+(toneladasCarga*50.0));
    }

    @Override
    public double calcIPVA()
    {
        return (getCusto()*0.15);
    }

    @Override
    public String toString()
    {
        return "Tipo do veiculo: "+getClass().getSimpleName() +
        "\tPlaca: "+getPlaca()+
        "\tCusto Fixo: "+ getCusto()+
        "\tCusto Total: "+calcCustoTotal()+
        "\tCarga: "+toneladasCarga+" toneladas";
    }
}



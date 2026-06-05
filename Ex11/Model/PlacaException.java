package Ex11.Model;

public class PlacaException extends RuntimeException {
    private String placa;

    public PlacaException(String placa)
    {
        super("Erro: Placa com tamanho incorreto:"+placa.length()+" esperado 7");
        this.placa=placa;
    }
}

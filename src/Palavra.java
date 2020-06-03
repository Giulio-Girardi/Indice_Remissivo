public class Palavra {


    private String valor;
    private String paginas;
    private Palavra proxima;

    public Palavra(String valor, String paginas) {
        this.valor = valor;
        this.paginas = paginas + ",";
        proxima = null;
    }

    public Palavra(String valor, Palavra proxima) {
        this.valor = valor;
        this.proxima = proxima;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public Palavra getProxima() {
        return proxima;
    }

    public void setProxima(Palavra proxima) {
        this.proxima = proxima;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}
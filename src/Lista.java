
public class Lista {

    //primeiro elemento da lista
    private Palavra head;
    //ultimo elemento da lista
    private Palavra tail;
    //contador do numero de elementos
    private int count;
    private String listaWords;


    public Lista() {
        head = null;
        tail = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public void add(String valor, String paginas) { // O(1)
        if (indexOf(valor) > -1) {
            Palavra palavra = get(indexOf(valor));
            String p = palavra.getPaginas();
            palavra.setPaginas(p + paginas + ",");
            System.out.println(palavra.getPaginas());
        } else {
            Palavra n = new Palavra(valor, paginas);

            if (head == null) {
                head = n;
            } else {
                tail.setProxima(n);
            }
            tail = n;
            count++;
        }
    }

    public Palavra get(int index) { // O(n)
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == count - 1)
            return tail;

        Palavra aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.getProxima();
            c++;
        }
        return aux;
    }

    public boolean contains(String valor) { // O(n)
        Palavra aux = head;
        while (aux != null) {
            if (valor.equals(aux.getValor())) {
                return true;
            }
            aux = aux.getProxima();
        }
        return false;
    }

    public int indexOf(String valor) {
        Palavra aux = head;
        for (int i = 0; i < count; i++) {
            if (aux.getValor().equals(valor)) {
                return i;
            }
            aux = aux.getProxima();
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        Palavra aux = head;

        while (aux != null) {
            s.append(aux.getValor().toString());
            s.append("\n");
            aux = aux.getProxima();
        }

        return s.toString();
    }
}
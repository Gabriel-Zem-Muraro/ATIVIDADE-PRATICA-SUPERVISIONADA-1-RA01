public class Node {
    private Elemento dado;
    private Node proximo;

    public Node(Elemento dado) {
        this.dado = dado;
        this.proximo = null;
    }

    public Elemento getDado() {
        return dado;
    }

    public void setDado(Elemento dado) {
        this.dado = dado;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
}


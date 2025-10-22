public class Fila {
    private Node frente;
    private Node tras;

    public Fila() {
        this.frente = null;
        this.tras = null;
    }

    public void addFila(Elemento elemento) {
        Node novoNode = new Node(elemento);
        
        if (estaVazia()) {
            frente = novoNode;
            tras = novoNode;
        } else {
            tras.setProximo(novoNode);
            tras = novoNode;
        }
    }

    public Elemento remFila() throws Exception {
        if (estaVazia()) {
            throw new Exception("Fila vazia! Nao ha clientes para atender.");
        }
        
        Elemento elemento = frente.getDado();
        frente = frente.getProximo();
        
        if (frente == null) {
            tras = null;
        }
        
        return elemento;
    }

    public boolean estaVazia() {
        return frente == null;
    }

    public String listarFila() {
        if (estaVazia()) {
            return "Fila vazia!";
        }

        String resultado = "\n------------------- ATENDIMENTO (FILA) -------------------\n";
        Node atual = frente;
        int posicao = 1;

        while (atual != null) {
            resultado = resultado + posicao + ". " + atual.getDado().paraString() + "\n";
            atual = atual.getProximo();
            posicao = posicao + 1;
        }
        resultado = resultado + "-------------------------------------------------------------------------\n";
        return resultado;
    }

    public int contarElementos() {
        int contador = 0;
        Node atual = frente;
        while (atual != null) {
            contador = contador + 1;
            atual = atual.getProximo();
        }
        return contador;
    }

    public Node getFrente() {
        return frente;
    }
}


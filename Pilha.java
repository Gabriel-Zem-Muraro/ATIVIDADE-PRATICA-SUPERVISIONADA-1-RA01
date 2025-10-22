public class Pilha {
    private Node topo;

    public Pilha() {
        this.topo = null;
    }

    public void addPilha(Elemento elemento) {
        Node novoNode = new Node(elemento);
        novoNode.setProximo(topo);
        topo = novoNode;
    }

    public Elemento remPilha() throws Exception {
        if (estaVazia()) {
            throw new Exception("Pilha vazia! Nao ha elementos para remover.");
        }
        Elemento elemento = topo.getDado();
        topo = topo.getProximo();
        return elemento;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public String listarPilha() {
        if (estaVazia()) {
            return "Pilha vazia!";
        }

        int total = contarElementos();
        String resultado = "\n========== HISTORICO (PILHA) ==========\n";
        
        String listaInvertida = inverterPilha(topo, total, total);
        resultado = resultado + listaInvertida;
        
        resultado = resultado + "========================================================\n";
        resultado = resultado + "Total de solicitacoes: " + total + "\n";
        return resultado;
    }
    
    private String inverterPilha(Node node, int posicaoAtual, int total) {
        if (node == null) {
            return "";
        }
        
        String proximasLinhas = inverterPilha(node.getProximo(), posicaoAtual - 1, total);
        
        String linhaAtual = "[" + posicaoAtual + "] " + node.getDado().paraString();
        
        if (posicaoAtual == total) {
            linhaAtual = linhaAtual;
        } else if (posicaoAtual == 1) {
            linhaAtual = linhaAtual;
        } else {
            linhaAtual = linhaAtual + "\n";
        }
        
        return linhaAtual + proximasLinhas;
    }

    public int contarElementos() {
        int contador = 0;
        Node atual = topo;
        while (atual != null) {
            contador = contador + 1;
            atual = atual.getProximo();
        }
        return contador;
    }

    public Node getTopo() {
        return topo;
    }
}


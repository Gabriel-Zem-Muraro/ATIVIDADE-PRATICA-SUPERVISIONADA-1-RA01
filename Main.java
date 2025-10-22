import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Main {
    private static Pilha pilhaHistorico;
    private static Fila filaAtendimento;

    public static void main(String[] args) {
        pilhaHistorico = new Pilha();
        filaAtendimento = new Fila();

        System.out.println("----------------------------------------\n");
        System.out.println("  SISTEMA DE ATENDIMENTO AO CLIENTE");
        System.out.println("----------------------------------------\n");

        carregarDados();

        try {
            BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
            boolean continuar = true;

            while (continuar) {
                System.out.println("\n---------- MENU PRINCIPAL ----------");
                System.out.println("1 - Gerenciar Pilha (Historico)");
                System.out.println("2 - Gerenciar Fila (Fila de Atendimento)");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opcao: ");

                String opcao = leitor.readLine();

                if (opcao.length() == 0) {
                    continue;
                }

                char escolha = opcao.charAt(0);

                if (escolha == '1') {
                    menuPilha(leitor);
                } else if (escolha == '2') {
                    menuFila(leitor);
                } else if (escolha == '0') {
                    salvarDados();
                    System.out.println("\nEncerrando sistema...");
                    continuar = false;
                } else {
                    System.out.println("\nOpcao invalida! Digite um numero correspondente a uma das opcoes disponiveis.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void menuPilha(BufferedReader leitor) {
        try {
            boolean voltarMenu = false;

            while (!voltarMenu) {
                System.out.println("\n---------- MENU PILHA (HISTORICO) ----------");
                System.out.println("1 - Adicionar solicitacao");
                System.out.println("2 - Remover solicitacao");
                System.out.println("3 - Visualizar historico");
                System.out.println("0 - Voltar");
                System.out.print("Escolha uma opcao: ");

                String opcao = leitor.readLine();

                if (opcao.length() == 0) {
                    continue;
                }

                char escolha = opcao.charAt(0);

                if (escolha == '1') {
                    adicionarSolicitacao(leitor);
                } else if (escolha == '2') {
                    removerSolicitacao();
                } else if (escolha == '3') {
                    visualizarHistorico();
                } else if (escolha == '0') {
                    voltarMenu = true;
                } else {
                    System.out.println("\nOpcao invalida! Digite um numero correspondente a uma das opcoes disponiveis.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void menuFila(BufferedReader leitor) {
        try {
            boolean voltarMenu = false;

            while (!voltarMenu) {
                System.out.println("\n---------- MENU FILA (ATENDIMENTO) ----------");
                System.out.println("1 - Adicionar cliente");
                System.out.println("2 - Atender proximo cliente");
                System.out.println("3 - Visualizar fila");
                System.out.println("0 - Voltar");
                System.out.print("Escolha uma opcao: ");

                String opcao = leitor.readLine();

                if (opcao.length() == 0) {
                    continue;
                }

                char escolha = opcao.charAt(0);

                if (escolha == '1') {
                    adicionarCliente(leitor);
                } else if (escolha == '2') {
                    atenderCliente();
                } else if (escolha == '3') {
                    visualizarFila();
                } else if (escolha == '0') {
                    voltarMenu = true;
                } else {
                    System.out.println("\nOpcao invalida! Digite um numero correspondente a uma das opcoes disponiveis.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void adicionarSolicitacao(BufferedReader leitor) throws Exception {
        System.out.println("\n--- Adicionar Solicitacao ao TOPO da Pilha ---");
        
        System.out.print("ID da solicitacao (ex: REQ011): ");
        String id = leitor.readLine();
        
        System.out.print("Descricao da solicitacao: ");
        String descricao = leitor.readLine();
        
        System.out.print("Data e hora (AAAA-MM-DD HH:MM): ");
        String dataHora = leitor.readLine();
        
        Elemento elemento = new Elemento(id, descricao, dataHora);
        pilhaHistorico.addPilha(elemento);
        
        System.out.println("\nSolicitacao adicionada a pilha");
    }

    private static void removerSolicitacao() {
        if (pilhaHistorico.estaVazia()) {
            System.out.println("\nPilha vazia!");
            return;
        }

        try {
            Elemento removido = pilhaHistorico.remPilha();
            System.out.println("\nSolicitacao removida da pilha");
            System.out.println(removido.paraString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void visualizarHistorico() {
        System.out.println(pilhaHistorico.listarPilha());
    }

    private static void adicionarCliente(BufferedReader leitor) throws Exception {
        System.out.println("\n--- Adicionar Cliente ---");
        
        System.out.print("ID do cliente (ex: CLI011): ");
        String id = leitor.readLine();
        
        System.out.print("Nome do cliente: ");
        String nome = leitor.readLine();
        
        System.out.print("Motivo do atendimento: ");
        String motivo = leitor.readLine();
        
        Elemento elemento = new Elemento(id, nome, motivo);
        filaAtendimento.addFila(elemento);
        
        System.out.println("\nCliente adicionado a fila");
    }

    private static void atenderCliente() {
        if (filaAtendimento.estaVazia()) {
            System.out.println("\nFila  vazia");
            return;
        }

        try {
            Elemento atendido = filaAtendimento.remFila();
            System.out.println("\nCliente atendido:");
            System.out.println(atendido.paraString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void visualizarFila() {
        System.out.println(filaAtendimento.listarFila());
    }

    private static void carregarDados() {

        carregarHistorico();
        carregarFila();
        
        System.out.println("Historico: " + pilhaHistorico.contarElementos() + " solicitacoes");
        System.out.println("Fila: " + filaAtendimento.contarElementos() + " clientes");
    }

    private static void carregarHistorico() {
        try {
            BufferedReader leitor = new BufferedReader(new FileReader("historico.txt"));
            String linha;
            
            while ((linha = leitor.readLine()) != null) {
                if (linha.length() > 0 && linha.charAt(0) == ' ') {
                    String id = extrairEntreAspas(linha, 0);
                    String descricao = extrairEntreAspas(linha, 1);
                    String dataHora = extrairEntreAspas(linha, 2);
                    
                    if (id.length() > 0) {
                        Elemento elemento = new Elemento(id, descricao, dataHora);
                        pilhaHistorico.addPilha(elemento);
                    }
                }
            }
            
            leitor.close();
        } catch (Exception e) {
            System.out.println("Erro ao carregar historico.txt");
        }
    }

    private static void carregarFila() {
        try {
            BufferedReader leitor = new BufferedReader(new FileReader("filadeatendimento.txt"));
            String linha;
            
            while ((linha = leitor.readLine()) != null) {
                if (linha.length() > 0 && linha.charAt(0) == ' ') {
                    String id = extrairEntreAspas(linha, 0);
                    String nome = extrairEntreAspas(linha, 1);
                    String motivo = extrairEntreAspas(linha, 2);
                    
                    if (id.length() > 0) {
                        Elemento elemento = new Elemento(id, nome, motivo);
                        filaAtendimento.addFila(elemento);
                    }
                }
            }
            
            leitor.close();
        } catch (Exception e) {
            System.out.println("Erro ao carregar filadeatendimento.txt");
        }
    }

    private static String extrairEntreAspas(String linha, int posicao) {
        int contadorAspas = 0;
        int inicio = -1;
        int fim = -1;
        
        int i = 0;
        while (i < linha.length()) {
            if (linha.charAt(i) == '"') {
                if (contadorAspas == posicao + posicao) {
                    inicio = i + 1;
                } else if (contadorAspas == posicao + posicao + 1) {
                    fim = i;
                    break;
                }
                contadorAspas = contadorAspas + 1;
            }
            i = i + 1;
        }
        
        if (inicio != -1 && fim != -1) {
            String resultado = "";
            int j = inicio;
            while (j < fim) {
                resultado = resultado + linha.charAt(j);
                j = j + 1;
            }
            return resultado;
        }
        
        return "";
    }

    private static void salvarDados() {
        salvarHistorico();
        salvarFila();
    }

    private static void salvarHistorico() {
        try {
            FileWriter escritor = new FileWriter("historico.txt");
            escritor.write("Elemento[] historico = new Elemento[] {\n");
            
            Node atual = pilhaHistorico.getTopo();
            int contador = pilhaHistorico.contarElementos();
            int posicao = 1;
            
            while (atual != null) {
                String linha = atual.getDado().paraArquivo();
                if (posicao == contador) {
                    int tamanho = linha.length();
                    String linhaSemVirgula = "";
                    int k = 0;
                    while (k < tamanho - 1) {
                        linhaSemVirgula = linhaSemVirgula + linha.charAt(k);
                        k = k + 1;
                    }
                    escritor.write(linhaSemVirgula + "\n");
                } else {
                    escritor.write(linha + "\n");
                }
                atual = atual.getProximo();
                posicao = posicao + 1;
            }
            
            escritor.write("};\n");
            escritor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void salvarFila() {
        try {
            FileWriter escritor = new FileWriter("filadeatendimento.txt");
            escritor.write("Elemento[] filaAtendimento = new Elemento[] {\n");
            
            Node atual = filaAtendimento.getFrente();
            int contador = filaAtendimento.contarElementos();
            int posicao = 1;
            
            while (atual != null) {
                String linha = atual.getDado().paraArquivo();
                if (posicao == contador) {
                    int tamanho = linha.length();
                    String linhaSemVirgula = "";
                    int k = 0;
                    while (k < tamanho - 1) {
                        linhaSemVirgula = linhaSemVirgula + linha.charAt(k);
                        k = k + 1;
                    }
                    escritor.write(linhaSemVirgula + "\n");
                } else {
                    escritor.write(linha + "\n");
                }
                atual = atual.getProximo();
                posicao = posicao + 1;
            }
            
            escritor.write("};\n");
            escritor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


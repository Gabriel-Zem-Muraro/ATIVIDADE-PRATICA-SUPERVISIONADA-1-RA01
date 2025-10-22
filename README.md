# Sistema de Gerenciamento de Atendimento ao Cliente

Sistema desenvolvido em Java que simula gerenciamento de atendimento ao cliente utilizando Pilha e Fila implementadas com listas encadeadas.

## Informações do projeto

Disciplina: Resolução de Problemas Estruturados em Computação (Turma 4º U)
Curso: Ciência da Computação (Noite) - 2025 / 2º Semestre
Professor: Andrey Cabral
Alunos: João Pedro Bezerra e Gabriel Zem Muraro

---

## Descricao

Implementa duas estruturas de dados:
- **Pilha (LIFO)**: Historico de solicitacoes de servico
- **Fila (FIFO)**: Ordem de atendimento dos clientes

Ambas implementadas manualmente usando listas encadeadas, sem bibliotecas prontas.

---

## Estrutura do Codigo

### Classes Principais

**Node.java**
- Representa os nos da lista encadeada
- Atributos: `Elemento dado`, `Node proximo`

**Elemento.java**
- Armazena os dados (solicitacoes ou clientes)
- Atributos: `String id`, `String campo1`, `String campo2`

**Pilha.java**
- Implementa pilha com lista encadeada
- Metodos: `push()`, `pop()`, `estaVazia()`, `listar()`, `contarElementos()`

**Fila.java**
- Implementa fila com lista encadeada
- Metodos: `enqueue()`, `dequeue()`, `estaVazia()`, `listar()`, `contarElementos()`

**Main.java**
- Programa principal com menus interativos
- Gerencia carregamento e salvamento de dados

---

## Restricoes Implementadas

PROIBIDO utilizar:
- Arrays (int[], String[], etc)
- Collections (List, ArrayList, LinkedList, etc)
- StringBuilder
- split() ou regex
- length() fora de String

PERMITIDO utilizar:
- Tipos primitivos (String, int, float, char, boolean)
- try-catch e throws
- BufferedReader, FileReader, FileWriter
- length() e charAt() apenas para String

---

## Funcionalidades

### Pilha - Historico
1. Adicionar solicitacao (push no topo)
2. Remover solicitacao (pop do topo - LIFO)
3. Visualizar historico completo

### Fila - Atendimento
1. Adicionar cliente (enqueue no final)
2. Atender proximo cliente (dequeue da frente - FIFO)
3. Visualizar fila completa

### Persistencia
- Carregamento automatico de `historico.txt` e `filadeatendimento.txt` ao iniciar
- Salvamento automatico ao encerrar (opcao 0)

---

## Como Executar

### Compilacao
```bash
javac *.java
```

### Execucao
```bash
java Main
```

---

## Como Usar

**Menu Principal**
- 1: Gerenciar Pilha (Historico)
- 2: Gerenciar Fila (Atendimento)
- 0: Salvar e Sair

**Menu Pilha**
- 1: Adicionar solicitacao
- 2: Remover solicitacao
- 3: Visualizar historico
- 0: Voltar

**Menu Fila**
- 1: Adicionar cliente
- 2: Atender proximo cliente
- 3: Visualizar fila
- 0: Voltar

---

## Detalhes de Implementacao

### Pilha (LIFO)
- Adiciona no topo
- Remove do topo
- Ultimo a entrar, primeiro a sair
- Visualizacao invertida usando recursao

### Fila (FIFO)
- Adiciona no final (tras)
- Remove da frente
- Primeiro a entrar, primeiro a sair
- Usa dois ponteiros: frente e tras

### Parse Manual
- Metodo `extrairEntreAspas()` percorre caractere por caractere
- Nao usa split() ou regex
- Identifica aspas e extrai texto manualmente

---

## Formato dos Dados

**Historico (Pilha)**
- ID: REQ001, REQ002...
- Descricao: texto da solicitacao
- Data/Hora: AAAA-MM-DD HH:MM

**Fila (Atendimento)**
- ID: CLI001, CLI002...
- Nome: nome do cliente
- Motivo: motivo do atendimento

---

## Autores

Projeto desenvolvido como Atividade Pratica Supervisionada da disciplina de Resolucao de Problemas Estruturados em Computacao.

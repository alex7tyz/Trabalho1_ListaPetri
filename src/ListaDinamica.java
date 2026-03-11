public class ListaDinamica implements ListaOperacoes {
    No inicio;
    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista dinâmica criada com sucesso!");
    }
    public void adicionarElemento(String elemento) {
        if (inicioEstaVazio()) {
            this.inicio.setConteudo(elemento);
        } else {
            No aux = this.inicio;
            No novoNo = new No(elemento);
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novoNo);
        }
    }
    public void exibir() {
        if (inicioEstaVazio()) {
            System.out.println("Não existem elementos na lista dinâmica.");
        } else {
            No aux = this.inicio;

            while (aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
        }
    }
    private boolean inicioEstaVazio() {
        if (this.inicio.getConteudo() == null) {
            return true;
        } else {
            return false;
        }
    }
    public void removerElemento(String elemento) {
        if (inicioEstaVazio()) {
            System.out.println("Não há elementos a serem removidos.");
        } else {
            if (procurarElemento(elemento)) {

                if (this.inicio.getProx() == null) {
                    System.out.println("Elemento " + elemento + " removido!");
                    this.inicio.setConteudo(null);
                }

                else if (this.inicio.getProx() != null) {
                    No aux = this.inicio;
                    while (aux != null) {

                        if (this.inicio.getConteudo().equals(elemento)) {
                            System.out.println("Elemento " + elemento + " removido!");
                            this.inicio = this.inicio.getProx();
                            return;
                        }

                        else if (aux.getProx() != null &&
                                aux.getProx().getConteudo().equals(elemento)) {

                            System.out.println("Elemento " + elemento + " removido!");
                            aux.setProx(aux.getProx().getProx());
                            return;
                        }

                        aux = aux.getProx();
                    }
                }
            }
        }
    }
    public boolean procurarElemento(String elemento) {
        if (inicioEstaVazio()) {
            System.out.println("Não há elementos a serem procurados.");
            return false;
        }
        No aux = this.inicio;
        while (aux != null) {
            if (aux.getConteudo().equals(elemento)) {
                System.out.println("Elemento " + elemento + " encontrado!");
                return true;
            }
            aux = aux.getProx();
        }
        System.out.println("Elemento " + elemento + " não existe na lista.");
        return false;
    }
    @Override
    public int adicionarVarios(String[] elementos) {
        int cont = 0;
        for (String e : elementos) {
            adicionarElemento(e);
            cont++;
        }
        return cont;
    }
    @Override
    public int contar() {
        int cont = 0;
        No aux = inicio;
        while (aux != null) {
            cont++;
            aux = aux.getProx();
        }
        return cont;
    }
    @Override
    public String obter(int indice) {
        int i = 0;
        No aux = inicio;
        while (aux != null) {
            if (i == indice) return aux.getConteudo();
            i++;
            aux = aux.getProx();
        }
        return null;
    }
    @Override
    public boolean inserir(int indice, String elemento) {
        No novo = new No(elemento);
        if (indice == 0) {
            novo.setProx(inicio);
            inicio = novo;
            return true;
        }
        int i = 0;
        No aux = inicio;
        while (aux != null && i < indice - 1) {
            aux = aux.getProx();
            i++;
        }
        if (aux == null) return false;
        novo.setProx(aux.getProx());
        aux.setProx(novo);
        return true;
    }
    @Override
    public String removerPorIndice(int indice) {
        if (inicio == null) return null;
        if (indice == 0) {
            String valor = inicio.getConteudo();
            inicio = inicio.getProx();
            return valor;
        }
        int i = 0;
        No aux = inicio;
        while (aux.getProx() != null && i < indice - 1) {
            aux = aux.getProx();
            i++;
        }
        if (aux.getProx() == null) return null;
        String valor = aux.getProx().getConteudo();
        aux.setProx(aux.getProx().getProx());

        return valor;
    }
    @Override
    public void limpar() {
        inicio = null;
    }
    @Override
    public int ultimoIndiceDe(String elemento) {
        int indice = -1;
        int i = 0;
        No aux = inicio;
        while (aux != null) {

            if (aux.getConteudo().equals(elemento)) {
                indice = i;
            }
            i++;
            aux = aux.getProx();
        }
        return indice;
    }
    @Override
    public int contarOcorrencias(String elemento) {
        int cont = 0;
        No aux = inicio;
        while (aux != null) {
            if (aux.getConteudo().equals(elemento)) {
                cont++;
            }
            aux = aux.getProx();
        }
        return cont;
    }
    @Override
    public int substituir(String antigo, String novo) {
        int cont = 0;
        No aux = inicio;
        while (aux != null) {
            if (aux.getConteudo().equals(antigo)) {
                aux.setConteudo(novo);
                cont++;
            }
            aux = aux.getProx();
        }
        return cont;
    }
    @Override
    public int removerTodas(String elemento) {
        int cont = 0;
        while (procurarElemento(elemento)) {
            removerElemento(elemento);
            cont++;
        }
        return cont;
    }
}



public class ListaSimples implements ListaOperacoes {
    String [] lista;
    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
        System.out.println("Lista criada com sucesso! Existem " + tamanho + " posições disponíveis.");
    }
    public void adicionarElemento(String elemento) {
        if(!this.estaCheia()) {
            this.lista[encontrarPosicao()] = elemento;
            System.out.println("Elemento " + elemento + "  adicionado com sucesso!");
        }
    }
    public boolean estaCheia() {
        for (int i = 0; i < this.lista.length; i++) {
            if(this.lista[i] == null) {
                return false;
            }
        }
        System.out.println("Não há espaço disponível na lista.");
        return true;
    }
    public boolean estaVazia() {
        for (int i = 0; i < this.lista.length; i++) {
            if(this.lista[i] != null) {
                return false;
            }
        }
        return true;
    }
    private int encontrarPosicao() {
        int i;
        for (i = 0; i < this.lista.length; i++) {
            if(this.lista[i] == null) {
                break;
            }
        }
        return i;
    }
    public void exibirElementos() {
        for (int i = 0; i < this.lista.length; i++) {
            System.out.println("Lista[" + i + "] = " + this.lista[i]);
        }
    }
    public void removerElemento(String elemento) {
        boolean removido = false;
        if(!estaVazia()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null && this.lista[i].equals(elemento)) {
                    this.lista[i] = null;
                    removido = true;
                }
            }
        }
        if(removido) {
            System.out.println("O elemento " + elemento + " foi removido com sucesso!");
        } else {
            System.out.println("O elemento " + elemento + " não existe na lista.");
        }
    }
    public void buscarElemento(String elemento) {
        boolean encontrado = false;
        if(!estaVazia()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null && this.lista[i].equals(elemento)) {
                    encontrado = true;
                }
            }
        }
        if(encontrado) {
            System.out.println("O elemento " + elemento + " existe na lista!");
        } else {
            System.out.println("O elemento " + elemento + " não existe na lista.");
        }
    }
    public int removerTodas(String elemento) {
        int cont = 0;
        for(int i = 0; i < lista.length; i++) {
            if(lista[i] != null && lista[i].equals(elemento)) {
                lista[i] = null;
                cont++;
            }
        }
        return cont;
    }
    public int contar() {
        int contar = 0;
        for(int i = 0; i < lista.length; i++) {
            if(lista[i] != null) {
                contar++;
            }
        }
        return contar;
    }
    public int adicionarVarios(String[] elementos) {
        int adicionados = 0;
        for(String e : elementos) {

            if(!estaCheia()) {
                lista[encontrarPosicao()] = e;
                adicionados++;
            }
        }
        return adicionados;
    }
    public String obter(int indice) {

        if(indice < 0 || indice >= lista.length) {
            return null;
        }
        return lista[indice];
    }
    public boolean inserir(int indice, String elemento) {
        if(indice < 0 || indice >= lista.length) {
            return false;
        }
        if(estaCheia()) {
            return false;
        }
        for(int i = lista.length - 1; i > indice; i--) {
            lista[i] = lista[i-1];
        }
        lista[indice] = elemento;
        return true;
    }
    public String removerPorIndice(int indice) {
        if(indice < 0 || indice >= lista.length) {
            return null;
        }
        String removido = lista[indice];
        for(int i = indice; i < lista.length - 1; i++) {
            lista[i] = lista[i+1];
        }
        lista[lista.length - 1] = null;
        return removido;
    }
    public void limpar() {
        for(int i = 0; i < lista.length; i++) {
            lista[i] = null;
        }
    }
    public int ultimoIndiceDe(String elemento) {
        int indice = -1;
        for(int i = 0; i < lista.length; i++) {
            if(lista[i] != null && lista[i].equals(elemento)) {
                indice = i;
            }
        }
        return indice;
    }
    public int contarOcorrencias(String elemento) {
        int cont = 0;
        for(int i = 0; i < lista.length; i++) {
            if(lista[i] != null && lista[i].equals(elemento)) {
                cont++;
            }
        }
        return cont;
    }
    public int substituir(String antigo, String novo) {
        int cont = 0;
        for(int i = 0; i < lista.length; i++) {
            if(lista[i] != null && lista[i].equals(antigo)) {
                lista[i] = novo;
                cont++;
            }
        }
        return contar();
    }
}
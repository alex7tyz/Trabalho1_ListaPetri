public class Main {

    public static void main(String[] args) {

        ListaSimples lista = new ListaSimples(5);

        lista.adicionarElemento("Ana");
        lista.adicionarElemento("Carlos");
        lista.adicionarElemento("Pedro");

        lista.exibirElementos();
    }
}
import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) throws Exception {
    System.out.println("Oi, gente!");

    String tituloReceita = "Bolo de Cenoura";
    int quantidadeIngredientes = 3;
    double precoVenda = 5.5;
    boolean vegetariana = true;
    // Não existe falsy e truthy como no JS. Ou é true ou é false.

    String nome = "Mara";
    String sobrenome = "Maravilha";
    String nomeAutora = nome + " " + sobrenome;
    System.out.println(nomeAutora);

    if (quantidadeIngredientes < 2 && !vegetariana) {
      System.out.println("Receita legal.");
    } else {
      System.out.println("Receita é difícil");
    }

    int numero = 10;
    System.out.println(numero % 2 == 0);
    // Não se usa === ou !== no Java porque o tipo sempre é o mesmo se for igual.

    int quantidadeReceitas = 4;
    while (quantidadeReceitas != 0) {
      System.out.println("Essa é a receita " + quantidadeReceitas);
      quantidadeReceitas = quantidadeReceitas - 1;
      // Alternativas iguais ao JS:
      // quantidadeReceitas -= 1;
      // quantidadeReceitas--;
    }

    for (int qtd = 4; qtd != 0; qtd--) {
      System.out.println("Essa é a receita " + qtd);
    }

    final int varComoConstNoJS = 10;
    // Assim, não é possível mudar o valor de valorComoConstNoJS.
    // Sem final, você pode mudar o valor, mas não o tipo.

    // Escopos funcionam da mesma forma que no JS.

    String[] receitas = {"Strogonoff", "Feijoada", "Rocambole"};
    // Usa chaves em vez de colchetes nos arrays.

    for (int i = 0; i < receitas.length; i++) {
      System.out.println(receitas[i]);
    }

    System.out.println(receitas);
    // Não imprime o array, só a referência.
    // Pra ver com o array, dá pra ver com o debug, colocando o breakpoint na linha do sout.

    // Não pode declarar um array vazio sem nada. Pra isso, é preciso dizer quantos itens vão ter dentro desse array.
    String[] autores = new String[3];

    // Os valores dentro do array ficam todos como null até preencher.
    autores[0] = "Let";
    autores[1] = "André";
    autores[2] = "Claudia";

    // Se colocar um item com posição além do tamanho do array, dará erro na hora de executar.
    // autores[4] = "Joaquim";

    // Listas são uma alternativa para os arrays quando não sabemos qual será o tamanho total no momento da criação.

    List<String> novosAutores = new ArrayList<>();
    novosAutores.add("Letícia");
    novosAutores.add("Bianca");

    System.out.println(novosAutores.get(1));
    // Se darmos um sout num índice que não existe, dará um erro na execução.
    
  }
}

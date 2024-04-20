import java.util.List;
import java.util.Scanner;

public class Controler {
    View view=new View();
    public void realizaInterface() {
        System.out.printf("Por favor digite o caminho do arquivo a ser lido:");
        Scanner ler = new Scanner(System.in);
        String nomeArq=ler.nextLine();
        view.caregarWordCount(nomeArq);
        System.out.printf("Por favor digite o número de palavras apresentadas por página:");
        int qtdPagina=ler.nextInt();
        System.out.printf("Por favor digite a página a ser apresentada:");
        int numPagina=ler.nextInt();
        System.out.printf("Por favor 1 para ordem decrescente e -1 para ordem crescente do numero de palavras:");
        int isCrescente=ler.nextInt();
        List<ContagemPalavra> lista= view.apresentarArrayWordCount(qtdPagina,numPagina,isCrescente);
        for (ContagemPalavra palavra:lista){
            System.out.printf(palavra.toString());
        }
    }
}

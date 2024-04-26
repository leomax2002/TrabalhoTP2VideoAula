import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Controler {
    View view=new View();
    Model model=new Model();
    public void caregarWordCount(String nomeArquivo)  {
        HashMap<String,Integer> map= model.contarPalavras(nomeArquivo);

        view.arrayPalavras=converteEmLista(map);
    }
    private ArrayList<ContagemPalavra> converteEmLista(HashMap<String,Integer> map){
        ArrayList<ContagemPalavra> arrayPalavras= new ArrayList<>();
        for (String key : map.keySet()) {
            ContagemPalavra objeto = new ContagemPalavra();
            objeto.Palavra= key;
            objeto.quantidade= map.get(key);
            arrayPalavras.add(objeto);
        }
        return arrayPalavras;
    }
    public Object realizaInterface() {
        System.out.printf("Por favor digite o caminho do arquivo a ser lido:");
        Scanner ler = new Scanner(System.in);
        String nomeArq=ler.nextLine();
        this.caregarWordCount(nomeArq);
        System.out.printf("Por favor digite o número de palavras apresentadas por página:");
        int qtdPagina=ler.nextInt();
        System.out.printf("Por favor digite a página a ser apresentada:");
        int numPagina=ler.nextInt();
        System.out.printf("Por favor -1 para ordem decrescente e 1 para ordem crescente do numero de palavras:");
        int isCrescente=ler.nextInt();
        List<ContagemPalavra> lista= view.apresentarArrayWordCount(qtdPagina,numPagina,isCrescente);
        for (ContagemPalavra palavra:lista){
            System.out.println(palavra.toString());
        }
        return null;
    }
}

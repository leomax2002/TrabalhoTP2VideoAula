import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Controler {
    View view=new View();
    Model model = new Model();

    public void caregarWordCount(String nomeArquivo)  {
        view.dadosArray = model.formataTexto(nomeArquivo);
        view.tamanho = view.dadosArray.length;
        if(view.tamanho >= 5000){
            HashMap<String,Integer> map= model.contarPalavras(view.dadosArray, view.wordHash);
            view.arrayPalavras=converteEmLista(map);
            view.dadosArray = model.deletaN(view.dadosArray);
        }
        else{
            HashMap<String,Integer> map= model.contarPalavras(view.dadosArray, view.wordHash);
            view.arrayPalavras=converteEmLista(map);
        }
    }
    public void continuaWord(){
        view.tamanho = view.dadosArray.length;
        if(view.tamanho >= 5000){
            HashMap<String,Integer> map= model.contarPalavras(view.dadosArray, view.wordHash);
            view.arrayPalavras=converteEmLista(map);
            view.dadosArray = model.deletaN(view.dadosArray);
        }
        else{
            HashMap<String,Integer> map= model.contarPalavras(view.dadosArray, view.wordHash);
            view.arrayPalavras=converteEmLista(map);
        }
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

    public void realizaInterface() {
        System.out.printf("Por favor digite o caminho do arquivo a ser lido:");
        Scanner ler = new Scanner(System.in);
        String nomeArq=ler.nextLine();
        this.caregarWordCount(nomeArq);
        if(view.getTamanho()>= 5000){
            System.out.printf("5000 palavras foram lidas, se gostaria de continuar digite 1, caso contrário digite 0:");
            int resposta=ler.nextInt();
            if(resposta == 1){
                this.continuaWord();
            }
        }
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
    }
}

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class View {
    //private final Model model=new Model();
    public ArrayList<ContagemPalavra> arrayPalavras=new ArrayList<>();
    public int tamanho;
    public HashMap<String,Integer> wordHash= new HashMap<>();
    public String[] dadosArray;

    public List<ContagemPalavra> apresentarArrayWordCount(int qtdPagina, int numPagina, int tipoOrdenacao){
        this.ordenarArray(tipoOrdenacao);
        if(qtdPagina*(numPagina+1)<this.arrayPalavras.size()) {
            return this.arrayPalavras.subList(qtdPagina * numPagina, qtdPagina * (numPagina + 1));
        }else{
            return this.arrayPalavras.subList(qtdPagina * numPagina-1, this.arrayPalavras.size()-1);
        }
    }
    public void ordenarArray(int cresceteOuDecrescente){
        System.out.println(arrayPalavras.size());
        if(cresceteOuDecrescente<0){
            Comparator<ContagemPalavra> comparator = Comparator
                    .comparing(e -> (-1)*e.quantidade);
            arrayPalavras.sort(comparator);
        }
        else{
            Comparator<ContagemPalavra> comparator = Comparator
                    .comparing(e -> e.quantidade);
            arrayPalavras.sort(comparator);
        }
    }

    public int getTamanho(){
        return this.tamanho;
    }
}

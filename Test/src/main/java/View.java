import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class View {
    public ArrayList<ContagemPalavra> arrayPalavras=new ArrayList<>();

    public List<ContagemPalavra> apresentarArrayWordCount(int qtdPagina, int numPagina, int tipoOrdenacao){
        ordenarArray(tipoOrdenacao);
        if(qtdPagina*(numPagina+1)<arrayPalavras.size()) {
            return this.arrayPalavras.subList(qtdPagina * numPagina, qtdPagina * (numPagina + 1));
        }else{
            return this.arrayPalavras.subList(qtdPagina * numPagina-1, arrayPalavras.size()-1);
        }
    }

    private void ordenarArray(int cresceteOuDecrescente){
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
}

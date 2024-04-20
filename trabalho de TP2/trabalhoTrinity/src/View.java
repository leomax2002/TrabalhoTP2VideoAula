import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class View {
    private final Model model=new Model();
    private ArrayList<ContagemPalavra> arrayPalavras=new ArrayList<>();
    public void caregarWordCount(String nomeArquivo)  {
        HashMap<String,Integer> map= model.contarPalavras(nomeArquivo);
        arrayPalavras=converteEmLista(map);
    }
    public List<ContagemPalavra> apresentarArrayWordCount(int qtdPagina, int numPagina, int tipoOrdenacao){
        ordenarArray(tipoOrdenacao);
        return this.arrayPalavras.subList(qtdPagina*numPagina,qtdPagina*(numPagina+1));
    }
    private ArrayList<ContagemPalavra> converteEmLista(HashMap<String,Integer> map){
        ArrayList<ContagemPalavra> arrayPalavras= new ArrayList<>();
        ArrayList<String> listOfKeys
                = new ArrayList<>(map.keySet());
        ArrayList<Integer> listOfValues
                = new ArrayList<>(map.values());
        for(int i=0;i==listOfValues.size()-1;i++){
            ContagemPalavra objeto = new ContagemPalavra();
            objeto.Palavra= listOfKeys.get(i);
            objeto.quantidade= listOfValues.get(i);
            arrayPalavras.add(objeto);
        }
        return arrayPalavras;
    }
    private void ordenarArray(int cresceteOuDecrescente){
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

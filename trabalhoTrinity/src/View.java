import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class View {
    private final Model model=new Model();
    private ArrayList<ContagemPalavra> arrayPalavras=new ArrayList<>();
    public void caregarWordCount(String nomeArquivo)  {
        HashMap<String,Integer> map= model.contarPalavras(nomeArquivo);

        this.arrayPalavras=converteEmLista(map);
    }

    public List<ContagemPalavra> apresentarArrayWordCount(int qtdPagina, int numPagina, int tipoOrdenacao){
        ordenarArray(tipoOrdenacao);
        if(qtdPagina*(numPagina+1)<arrayPalavras.size()) {
            return this.arrayPalavras.subList(qtdPagina * numPagina, qtdPagina * (numPagina + 1));
        }else{
            return this.arrayPalavras.subList(qtdPagina * numPagina-1, arrayPalavras.size()-1);
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

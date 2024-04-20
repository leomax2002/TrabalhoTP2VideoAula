import java.io.FileReader;
import java.util.HashMap;

public class Model {
    private String readFile(String nome) throws Exception {
        //constructor of the File class having file as an argument
        FileReader fr=new FileReader(nome);
        System.out.println("file content: ");
        int r=0;
        StringBuilder retorno= new StringBuilder();
        while((r=fr.read())!=-1)
        {
            retorno.append((char) r);
            System.out.print((char)r);  //prints the content of the file
        }
        return retorno.toString();
    };
    private String[] separarPalevras(String arquivo){
        return arquivo.split(",");
    }
    public HashMap<String,Integer> contarPalavras(String entrada){
        HashMap<String,Integer> resposta;
        resposta=new HashMap<>();
        String dados ="";
        try {
            dados =readFile(entrada);
        }catch (Exception e){
            System.out.printf("Erro ao ler arquivo:"+e.getMessage());
        }
        String[] listaPalavras=separarPalevras(dados);
        for(String palavra:listaPalavras){
            Integer quantidade=resposta.get(palavra);
            if(quantidade == null){
                quantidade=1;
                resposta.put(palavra,quantidade);
            }
            else {
                quantidade=quantidade+1;
                resposta.replace(palavra,quantidade);
            }
        }
        return resposta;
    }
}

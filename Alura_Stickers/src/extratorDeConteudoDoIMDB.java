import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class extratorDeConteudoDoIMDB implements extratorDeConteudo {
    
    public List<conteudo> extraiConteudos(String json) {
        // pegar só os dados que são interessantes(Titulo, Poster e Nota)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<conteudo> conteudos = new ArrayList<>();
        
        //popular a lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("image");
            
            var conteudo = new conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }
        
        return conteudos;
    }
}

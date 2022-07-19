import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // fazer conexão http, e buscar os top 250 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI enderco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(enderco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        // System.out.println(body);

        // pegar só os dados que são interessantes(Titulo, Poster e Nota)
        var parser = new JsonParser();
        List<Map<String, String>> ListaDeFilmes = parser.parse(body);
        //System.out.println(ListaDeFilmes.size());
        //System.out.println(ListaDeFilmes.get(0));

        var geradora = new geradoraDeFigurinhas();

        // exibir e manipular os dados


            for (Map<String, String> filme : ListaDeFilmes) {

                String UrlImage = filme.get("image");
                String titulo = filme.get("title");
                InputStream inputStream = new URL(UrlImage).openStream();
                String nomeArquivo = titulo+".png";
                geradora.cria(inputStream, nomeArquivo);

                //System.out.println(filme.get("title"));
                //System.out.println(filme.get("image"));
                //System.out.println(filme.get("imDbRating"));
                //System.out.println();

            }
        }
    }
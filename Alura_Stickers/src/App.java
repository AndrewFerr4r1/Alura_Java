import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // fazer conexão http, e buscar os top 250 filmes

        // String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        // extratorDeConteudo extrator = new extratorDeConteudoDoIMDB();

        String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        extratorDeConteudo extrator = new extratorDeConteudoDaNasa();

        var http = new clienteHttp();
        String json = http.buscaDados(url);
        // System.out.println(body);

        // exibir e manipular os dados
        List<conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new geradoraDeFigurinhas();

            for (int i = 0; i < 3; i++) {

                conteudo conteudo = conteudos.get(i);

                InputStream inputStream = new URL(conteudo.getImagem()).openStream();
                String nomeArquivo = conteudo.getTitulo() + ".png";
                geradora.cria(inputStream, nomeArquivo);

                System.out.println(conteudo.getTitulo());
                System.out.println(conteudo.getImagem());
                System.out.println();

            }
        }
    }
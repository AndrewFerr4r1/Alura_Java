import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class geradoraDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
        // ler a img
        // InputStream inputStream = new FileInputStream(new
        // File("entrada/filme-maior.jpg"));
        // InputStream inputStream = new
        // URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg%22).openStream();

        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // criar nova em memoria com transparencia e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a img original para nova img (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar e estilizar font
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 62);
        graphics.setFont(fonte);
        graphics.setColor(Color.RED);
        // escrever uma frase na nova img
        graphics.drawString("XD", 250, novaAltura - 100);

        // escrever nova img em arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }
}
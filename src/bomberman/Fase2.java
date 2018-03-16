package bomberman;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Tawan Rodrigues
 */
/**
 * Nessa tela o jogo chega em sua segunda fase
 */
public class Fase2 extends Application {

    int posicaox = 55;
    int posicaoy = 320;
    int alturaTela = 400;
    int larguraTela = 600;
    int contaVida = Fase1.getContador();
    private static Stage primaryStage;
    //audio
    private final String fase2Song = getClass().getResource("/songs/fase2.mp3").toString();

    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();
        Scene cena = new Scene(root, larguraTela, alturaTela);
        primaryStage.setScene(cena);

        primaryStage.setTitle("Fase 2");
        cena.setFill(new ImagePattern(new Image("imagem/telas/2fase.jpg")));
        primaryStage.setResizable(false);
        setStage(primaryStage);
        //Audio
        AudioClip audio = new AudioClip(fase2Song);
        //Icone
        Image applicationIcon = new Image(getClass().getResourceAsStream("/imagem/telas/icone.png"));
        primaryStage.getIcons().add(applicationIcon);
        audio.play();

        primaryStage.show();

        Timeline intro = new Timeline(new KeyFrame(Duration.millis(1000),
                ae -> cena.setFill(new ImagePattern(new Image("imagem/telas/cena.png")))));
        intro.play();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fase1.class.getName()).log(Level.SEVERE, null, ex);
        }

        //bloco que contem a linha de texto utilidada para identificar e mostrar ao usuario a quantidade de vida do personagem
        Text texto = new Text("");
        texto.setText("");
        texto.setX(475);
        texto.setY(25);
        texto.setFont(Font.font("Verdana", 25));

        //Iniciação dos objetos
        Personagem bomber = new Personagem(posicaox, posicaoy, 50, 50);
        Mina mina1 = new Mina(135, 334);
        Mina mina2 = new Mina(295, 250);
        Mina mina3 = new Mina(470, 250);
        Mina mina4 = new Mina(105, 230);
        Mina mina5 = new Mina(305, 140);
        Mina mina6 = new Mina(455, 70);
        Mina mina7 = new Mina(445, 30);
        Mina mina8 = new Mina(185, 30);
        Mina mina9 = new Mina(265, 60);
        Mina mina10 = new Mina(321, 20);

        root.getChildren().add(mina1);
        root.getChildren().add(mina2);
        root.getChildren().add(mina3);
        root.getChildren().add(mina4);
        root.getChildren().add(mina5);
        root.getChildren().add(mina6);
        root.getChildren().add(mina7);
        root.getChildren().add(mina8);
        root.getChildren().add(mina9);
        root.getChildren().add(mina10);
        root.getChildren().add(bomber);
        root.getChildren().add(texto);

        //Minas aparecerão durante determinado tempo, método Aparecer() documentado na classe Mina.java
        mina1.Aparecer();
        mina2.Aparecer();
        mina3.Aparecer();
        mina4.Aparecer();
        mina5.Aparecer();
        mina6.Aparecer();
        mina7.Aparecer();
        mina8.Aparecer();
        mina9.Aparecer();
        mina10.Aparecer();

        cena.setOnKeyPressed(new EventHandler<KeyEvent>() {
            //Variaveis utilizadas nos eventos
            int fase = 2;
            int direita = 1, esquerda = 1, down = 1, up = 1;

            @Override
            public void handle(KeyEvent event) {
                //apresenta para o usuario a quantidade de vidas
                texto.setText("" + contaVida);

                posicaox = (int) bomber.getX();
                posicaoy = (int) bomber.getY();

                if (event.getCode().equals(KeyCode.RIGHT)) {
                    direita = bomber.direita(fase, this.direita, posicaox, posicaoy);
                }
                if (event.getCode().equals(KeyCode.LEFT)) {
                    esquerda = bomber.esquerda(fase, this.esquerda, posicaox, posicaoy);
                }
                if (event.getCode().equals(KeyCode.UP)) {
                    up = bomber.up(fase, this.up, posicaox, posicaoy);
                }
                if (event.getCode().equals(KeyCode.DOWN)) {
                    down = bomber.down(fase, this.down, posicaox, posicaoy);
                }

                
                if (contaVida > 0) {
                    if (mina1.calcularDistancia(posicaox, mina1.getX(), posicaoy, mina1.getY())) {
                        bomber.PersonagemExplodido();
                        contaVida = bomber.morte(contaVida);
                    }
                    if (mina2.calcularDistancia(posicaox, mina2.getX(), posicaoy, mina2.getY())) {
                        bomber.PersonagemExplodido();
                        contaVida = bomber.morte(contaVida);
                    }
                    if (mina3.calcularDistancia(posicaox, mina3.getX(), posicaoy, mina3.getY())) {
                        bomber.PersonagemExplodido();
                        contaVida = bomber.morte(contaVida);
                    }
                    if (mina4.calcularDistancia(posicaox, mina4.getX(), posicaoy, mina4.getY())) {
                        bomber.PersonagemExplodido();
                        contaVida = bomber.morte(contaVida);
                    }
                    if (mina5.calcularDistancia(posicaox, mina5.getX(), posicaoy, mina5.getY())) {
                        bomber.PersonagemExplodido();
                        contaVida = bomber.morte(contaVida);
                    }
                    if (mina6.calcularDistancia(posicaox, mina6.getX(), posicaoy, mina6.getY())) {
                        bomber.PersonagemExplodido();
                        contaVida = bomber.morte(contaVida);
                    }
                    if (mina7.calcularDistancia(posicaox, mina7.getX(), posicaoy, mina7.getY())) {
                        bomber.PersonagemExplodido();
                        contaVida = bomber.morte(contaVida);
                    }
                    if (mina8.calcularDistancia(posicaox, mina8.getX(), posicaoy, mina8.getY())) {
                        bomber.PersonagemExplodido();
                        contaVida = bomber.morte(contaVida);
                    }
                    if (mina9.calcularDistancia(posicaox, mina9.getX(), posicaoy, mina9.getY())) {
                        bomber.PersonagemExplodido();
                        contaVida = bomber.morte(contaVida);
                    }
                    if (mina10.calcularDistancia(posicaox, mina10.getX(), posicaoy, mina10.getY())) {
                        bomber.PersonagemExplodido();
                        contaVida = bomber.morte(contaVida);
                    }
                }
                if (posicaox == 45 && posicaoy == 10) {
                    Win win = new Win();
                    win.start(new Stage());
                    audio.stop();
                    Fase2.getStage().close();
                }
                if (contaVida <= 0) {
                    audio.stop();
                    Fase1.setContador(0);
                    GameOver over = new GameOver();
                    over.start(new Stage());
                    Fase2.getStage().close();
                }
            }
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Nesse metodo o usuario receber o valor da primaryStagem, importante para
     * controle de telas
     *
     * @return
     */
    public static Stage getStage() {
        return primaryStage;
    }

    /**
     * Nesse metodo é retornado quantidade de vidas contadas pelo usuario
     *
     * @return
     */
    public static void setStage(Stage primaryStage) {
        Fase2.primaryStage = primaryStage;
    }

}

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
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Tawan Rodrigues Nessa tela inicia o game com a coleta de Vidas
 */
public class Fase1 extends Application {

    int alturaTela = 400;
    int larguraTela = 600;
    int posicaox = 55;
    int posicaoy = 320;
    private static int contaVida = 0;
    private static Stage primaryStage;
    private final String song = getClass().getResource("/songs/life.mp3").toString();

    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();
        Scene cena = new Scene(root, larguraTela, alturaTela);
        primaryStage.setTitle("Fase1");
        cena.setFill(new ImagePattern(new Image("imagem/telas/1fase.jpg")));
        primaryStage.setResizable(false);
        primaryStage.setScene(cena);
        setStage(primaryStage);

        //Implantação do Icone
        Image applicationIcon = new Image(getClass().getResourceAsStream("/imagem/telas/icone.png"));
        primaryStage.getIcons().add(applicationIcon);

        //Implantação do Audio
        AudioClip audio = new AudioClip(song);
        audio.play();

        primaryStage.show();

        //Temporizador da imagem --1ª FASE--
        Timeline intro = new Timeline(new KeyFrame(Duration.millis(1000),
                ae -> cena.setFill(new ImagePattern(new Image("imagem/telas/tela1.png")))));
        intro.play();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fase1.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Instancias dos objetos utilizado na 1ª fase do game
        final Personagem bomber = new Personagem(posicaox, posicaoy, 50, 50);
        final Vida vida1 = new Vida(495, 240);
        final Vida vida2 = new Vida(135, 150);
        final Vida vida3 = new Vida(405, 150);
        Vida vida4 = new Vida(385, 50);
        Vida vida5 = new Vida(265, 60);

        //Adicionar
        root.getChildren().add(vida1);
        root.getChildren().add(vida2);
        root.getChildren().add(vida3);
        root.getChildren().add(vida4);
        root.getChildren().add(vida5);
        root.getChildren().add(bomber);

        //Evento
        cena.setOnKeyPressed(new EventHandler<KeyEvent>() {
            int fase = 1;
            int direita = 1, esquerda = 1, down = 1, up = 1;

            @Override
            public void handle(KeyEvent event) {
                //Tempo para captura de vidas pelo objeto bomber, após o termino entra no metodo fase2(), documentado em personagem.java
                Timeline sair = new Timeline(new KeyFrame(Duration.millis(7000),
                        ae -> fase = bomber.fase2()));
                sair.play();
                //tranformação da posição do personagem no plano cartesiano em numero do tippo inteiro 
                posicaox = (int) bomber.getX();
                posicaoy = (int) bomber.getY();

                //Caso o objeto bomber estiver dentro da região de distancia do objeto vida ele adiciona um valor a variavel contaVidas;
                if (vida1.calcularDistancia(posicaox, vida1.getX(), posicaoy, vida1.getY())) {
                    contaVida = bomber.vida(contaVida);
                }
                if (vida2.calcularDistancia(posicaox, vida2.getX(), posicaoy, vida2.getY())) {
                    contaVida = bomber.vida(contaVida);
                }
                if (vida3.calcularDistancia(posicaox, vida3.getX(), posicaoy, vida3.getY())) {
                    contaVida = bomber.vida(contaVida);
                }
                if (vida4.calcularDistancia(posicaox, vida4.getX(), posicaoy, vida4.getY())) {
                    contaVida = bomber.vida(contaVida);
                }
                if (vida5.calcularDistancia(posicaox, vida5.getX(), posicaoy, vida5.getY())) {
                    contaVida = bomber.vida(contaVida);
                }

                if (event.getCode().equals(KeyCode.RIGHT)) {
                    direita = bomber.direita(fase, this.direita, posicaox, posicaoy);

                }
                //Ações relacionadas aos eventos do teclados
                if (event.getCode().equals(KeyCode.LEFT)) {
                    esquerda = bomber.esquerda(fase, this.esquerda, posicaox, posicaoy);
                }
                if (event.getCode().equals(KeyCode.UP)) {
                    up = bomber.up(fase, this.up, posicaox, posicaoy);
                }
                if (event.getCode().equals(KeyCode.DOWN)) {
                    down = bomber.down(fase, this.down, posicaox, posicaoy);
                }
                if (fase == 2) {
                    if (contaVida <= 0) {
                        audio.stop();
                        GameOver over = new GameOver();
                        over.start(new Stage());
                    } else {
                        audio.stop();
                        Fase2 fase2 = new Fase2();
                        fase2.start(new Stage());
                    }
                        Fase1.getStage().close();
                }

                setContador(contaVida);
            }
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getStage() {
        return primaryStage;
    }

    public static void setStage(Stage primaryStage) {
        Fase1.primaryStage = primaryStage;
    }

    public static int getContador() {
        return contaVida;
    }

    public static void setContador(int contaVida) {
        Fase1.contaVida = contaVida;
    }

}

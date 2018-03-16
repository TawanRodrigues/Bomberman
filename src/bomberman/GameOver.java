package bomberman;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

/**
 *
 * @author Tawan Rodrigues
 */
/**
 * Tela carregada quadando a variavel referente a vida do objeto Personagem é
 * igual a zero
 */
public class GameOver extends Application {

    int alturaTela = 400;
    int larguraTela = 600;
    private static Stage primaryStage;
    //Audio
    private final String title = getClass().getResource("/songs/GameOver.mp3").toString();

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        Scene cena = new Scene(root, larguraTela, alturaTela);
        primaryStage.setTitle("Game Over!");
        primaryStage.setScene(cena);
        primaryStage.setResizable(false);
        cena.setFill(new ImagePattern(new Image("imagem/GameOver/over.jpg")));
        //Icone
        Image applicationIcon = new Image(getClass().getResourceAsStream("/imagem/telas/icone.png"));
        primaryStage.getIcons().add(applicationIcon);
        //Audio
        AudioClip audio = new AudioClip(title);
        audio.play();
        setStage(primaryStage);

        primaryStage.show();

        cena.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    audio.stop();
                    Fase1 fase1 = new Fase1();
                    fase1.start(new Stage());
                    GameOver.getStage().close();
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
     * Nesse metodo o usuario coloca o valor na variavel statica do tipo Stage
     *
     * @param primaryStage
     */

    public static void setStage(Stage primaryStage) {
        GameOver.primaryStage = primaryStage;
    }

}

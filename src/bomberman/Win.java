
package bomberman;

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

/**
 *
 * @author Tawan Rodrigues
* Tela carregada quadando o objeto personagem chega em determinada posicao
*/
 
public class Win extends Application {
    int alturaTela = 400;
    int larguraTela = 600;
    private static Stage primaryStage;
    //Audio
    private final String title = getClass().getResource("/songs/victory.mp3").toString();
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene cena = new Scene(root, larguraTela, alturaTela);
        cena.setFill(new ImagePattern(new Image("imagem/Win/win.jpg")));
        primaryStage.setScene(cena);
        primaryStage.show();
        setStage(primaryStage);
        primaryStage.setResizable(false);
        
        //Icone
        Image applicationIcon = new Image(getClass().getResourceAsStream("/imagem/telas/icone.png"));
        primaryStage.getIcons().add(applicationIcon);
        //Audio
        AudioClip audio = new AudioClip(title);
        audio.play();
        
         cena.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    Menu menu = new Menu();
                    menu.start(new Stage());
                    audio.stop();
                    Win.getStage().close();
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
        Win.primaryStage = primaryStage;
    }
    
}

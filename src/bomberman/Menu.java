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
 */

/**Classe inicial, onde começa o menu*/
public class Menu extends Application {

    int alturaTela = 400;
    int larguraTela = 600;
    static Stage primaryStage;
    private final String menuSong = getClass().getResource("/songs/Title.mp3").toString();
    
    @Override
    public void start(Stage primaryStage) {
        //Tela
        Pane root = new Pane();
        Scene cena = new Scene(root, larguraTela, alturaTela);
        primaryStage.setScene(cena);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Menu");
        cena.setFill(new ImagePattern(new Image("imagem/telas/menu.png")));
        
        //Icone
        Image applicationIcon = new Image(getClass().getResourceAsStream("/imagem/telas/icone.png"));
        primaryStage.getIcons().add(applicationIcon);

        //Audio
        AudioClip audio = new AudioClip(menuSong);
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
                    Menu.getStage().close();
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
   
    public static Stage getStage(){
        return primaryStage;
    }
    
    private static void setStage(Stage primaryStage){
        Menu.primaryStage = primaryStage;
    }
}

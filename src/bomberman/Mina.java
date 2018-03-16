package bomberman;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *Classe para objetos do tipo Mina, contendo valores e métodos para o objeto.
 * o objeto é a "bomba" do game, após serem instanciadas
 *
 * @author Tawan Rodrigues
 */
public class Mina extends Rectangle {
    
    private final String explosao = getClass().getResource("/songs/explosion.mp3").toString();
    AudioClip audio = new AudioClip(explosao);
     
    /** configurações inciais do objeto, após receberem parametros oferecidos pela classe que chamou o objeto*/ 
    public Mina(int posicaox, int posicaoy) {
        this.setX(posicaox);
        this.setY(posicaoy);
        this.setWidth(30);
        this.setHeight(30);
        this.setFill(null);

    }

    /**Método responsavel por fazer o objeto aparecer da tela*/
    public void Aparecer() {
        this.setFill(new ImagePattern(new Image("imagem/bomb/bomba.png")));
        Timeline desaparecer = new Timeline(new KeyFrame(Duration.millis(1000),
                ae -> this.setFill(null)));
        desaparecer.play();

    }

    /**Método responsavel por fazer o objeto explodir e desaparecer da tela*/
    public void Explodir() {
        this.setWidth(55);
        this.setHeight(55);
        this.setFill(new ImagePattern(new Image("imagem/bomb/explode.gif")));
        Timeline desaparecer = new Timeline(new KeyFrame(Duration.millis(3000),
                ae -> this.setFill(null)));
                audio.play();
       
        desaparecer.play();

    }
/**Método responsavel  por calcular se o personagem estar nas proximidades do objeto, se sim o boolean passa a ser verdadeiro e o metodo
     chama o metodo Explodir()*/
    public boolean calcularDistancia(int posicaox, double getx, int posicaoy, double gety) {
        boolean test = (posicaox + 20) > (getx) && (getx) > (posicaox) && (posicaoy + 30) > (gety) && (gety) > (posicaoy);
        if (test) {
            Explodir();
        }
        return test;

    }

}

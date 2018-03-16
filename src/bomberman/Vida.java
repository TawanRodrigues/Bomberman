package bomberman;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * Classe para objetos do tipo Personagem, contendo valores e métodos para o objeto.
 * o objeto é utilizado como vida para o personagem, a cada objeto adicionado na classe é relacionado a um indicador de "vida"
 * 
 * @author Tawan Rodrigues
 */
public class Vida extends Rectangle {

    public Vida(int posicaox, int posicaoy) {
        /** configurações inciais do objeto, após receberem parametros oferecidos pela classe que chamou o objeto*/ 
        this.setX(posicaox);
        this.setY(posicaoy);
        this.setWidth(40);
        this.setHeight(30);
        this.setFill(new ImagePattern(new Image("imagem/vidas/vida.gif")));

    }

    /**Metodo utilizado ao fim do tempo de duração da fase inicial.
     Seu objetivo é retirar o objeto da tela*/
    public void Sumir() {
        this.setFill(null);

    }
    /**Método responsavel  por calcular se o personagem estar nas proximidades do objeto, se sim o boolean passa a ser verdadeiro e o metodo
     chama o metodo sumir()*/
    public boolean calcularDistancia(int posicaox, double getx, int posicaoy, double gety) {
        boolean test = (posicaox + 20) > (getx) && (getx) > (posicaox) && (posicaoy + 30) > (gety) && (gety) > (posicaoy);
        if (test) {
            Sumir();
        }
        return test;

    }

}

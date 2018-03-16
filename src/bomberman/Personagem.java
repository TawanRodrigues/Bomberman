package bomberman;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * Classe para objetos do tipo Personagem, contendo valores e métodos para o
 * objeto.
 *
 * @author Tawan Rodrigues
 */
public class Personagem extends Rectangle {

    public Personagem(int posicaox, int posicaoy, int width, int height) {
        /**
         * configurações inciais do objeto, após receberem parametros oferecidos
         * pela classe que chamou o objeto
         */
        this.setX(posicaox);
        this.setY(posicaoy);
        this.setWidth(width);
        this.setHeight(height);
        this.setFill(new ImagePattern(new Image("imagem/down/down1.png")));
    }

    /**
     * Método que seta a posição do personagem apos o ator ter clicado no botão
     * RIGHT (Seta)
     */
    public int direita(int fase, int direita, int posicaox, int posicaoy) {
        if (posicaox > 500) {
        } else {
            if (direita >= 5) {
                direita = 1;
            }
            switch (direita) {
                case 1:
                    this.setX(getX() + 10);
                    this.setY(posicaoy);
                    this.setFill(new ImagePattern(new Image("imagem/right/right1.png")));
                    break;
                case 2:
                    this.setX(getX() + 10);
                    this.setY(posicaoy);
                    this.setFill(new ImagePattern(new Image("imagem/right/right2.png")));
                    break;
                case 3:
                    this.setX(getX() + 10);
                    this.setY(posicaoy);
                    this.setFill(new ImagePattern(new Image("imagem/right/right1.png")));
                    break;
                case 4:
                    this.setX(getX() + 10);
                    this.setY(posicaoy);
                    this.setFill(new ImagePattern(new Image("imagem/right/right3.png")));
                    break;
            }
        }
        return direita + 1;
    }

    /**
     * Método que seta a posição do personagem apos o ator ter clicado no botão
     * LEFT (Seta para a esquerda)
     */
    public int esquerda(int fase, int esquerda, int posicaox, int posicaoy) {
        if (posicaox < 50) {
        } else {
            if (esquerda >= 5) {
                esquerda = 1;
            }
            switch (esquerda) {
                case 1:
                    this.setX(getX() - 10);
                    this.setY(posicaoy);
                    this.setFill(new ImagePattern(new Image("imagem/left/lef1.png")));
                    break;
                case 2:
                    this.setX(getX() - 10);
                    this.setY(posicaoy);
                    this.setFill(new ImagePattern(new Image("imagem/left/left2.png")));
                    break;
                case 3:
                    this.setX(getX() - 10);
                    this.setY(posicaoy);
                    this.setFill(new ImagePattern(new Image("imagem/left/lef1.png")));
                    break;
                case 4:
                    this.setX(getX() - 10);
                    this.setY(posicaoy);
                    this.setFill(new ImagePattern(new Image("imagem/left/lef3.png")));
                    break;
            }
        }
        return esquerda + 1;
    }

    /**
     * Método que seta a posição do personagem apos o ator ter clicado no botão
     * Down (Seta para a baixo)
     */
    public int down(int fase, int down, int posicaox, int posicaoy) {
        if (down >= 5) {
            down = 1;
        }
        if (fase == 2) {
            if (posicaoy > 310 || 
                35 < posicaox && posicaox < 505 && posicaoy == 230 ||
               (85 < posicaox && posicaox < 525 && posicaoy == 140)||
               (15 < posicaox && posicaox < 485 && posicaoy == 45)) {
            } else {

                switch (down) {
                    case 1:
                        this.setY(getY() + 10);
                        this.setX(posicaox);
                        this.setFill(new ImagePattern(new Image("imagem/down/down1.png")));
                        break;
                    case 2:
                        this.setY(getY() + 10);
                        this.setX(posicaox);
                        this.setFill(new ImagePattern(new Image("imagem/down/down2.png")));
                        break;
                    case 3:
                        this.setY(getY() + 10);
                        this.setX(posicaox);
                        this.setFill(new ImagePattern(new Image("imagem/down/down1.png")));
                        break;
                    case 4:
                        this.setY(getY() + 10);
                        this.setX(posicaox);
                        this.setFill(new ImagePattern(new Image("imagem/down/down3.png")));
                        break;
                }
            }

        }
        if (fase == 1) {
            if (posicaoy > 310) {
            } else {

                switch (down) {
                    case 1:
                        this.setY(getY() + 10);
                        this.setX(posicaox);
                        this.setFill(new ImagePattern(new Image("imagem/down/down1.png")));
                        break;
                    case 2:
                        this.setY(getY() + 10);
                        this.setX(posicaox);
                        this.setFill(new ImagePattern(new Image("imagem/down/down2.png")));
                        break;
                    case 3:
                        this.setY(getY() + 10);
                        this.setX(posicaox);
                        this.setFill(new ImagePattern(new Image("imagem/down/down1.png")));
                        break;
                    case 4:
                        this.setY(getY() + 10);
                        this.setX(posicaox);
                        this.setFill(new ImagePattern(new Image("imagem/down/down3.png")));
                        break;
                }

            }

        }
        return down + 1;
    }

    /**
     * Método que seta a posição do personagem apos o ator ter clicado no botão
     * up (Seta para a cima)
     */
    public int up(int fase, int up, int posicaox, int posicaoy) {
        if (up >= 5) {
            up = 1;
        }
        if (fase == 2) {
            if ((posicaoy < 20) || 25 < posicaox && posicaox < 485 && posicaoy == 280
                    || (65 < posicaox && posicaox < 525 && posicaoy == 190)
                    || (40 < posicaox && posicaox < 485 && posicaoy == 90)) {
            } else {
                if (up >= 5) {
                    up = 1;
                }
                switch (up) {
                    case 1:
                        this.setX(posicaox);
                        this.setY(getY() - 10);
                        this.setFill(new ImagePattern(new Image("imagem/up/up1.png")));
                        break;
                    case 2:
                        this.setX(posicaox);
                        this.setY(getY() - 10);
                        this.setFill(new ImagePattern(new Image("imagem/up/up2.png")));
                        break;
                    case 3:
                        this.setX(posicaox);
                        this.setY(getY() - 10);
                        this.setFill(new ImagePattern(new Image("imagem/up/up1.png")));
                        break;
                    case 4:
                        this.setX(posicaox);
                        this.setY(getY() - 10);
                        this.setFill(new ImagePattern(new Image("imagem/up/up3.png")));
                        break;
                }
            }

        } else {
            if (posicaoy < 20) {
            } else {
                switch (up) {
                    case 1:
                        this.setX(posicaox);
                        this.setY(getY() - 10);
                        this.setFill(new ImagePattern(new Image("imagem/up/up1.png")));
                        break;
                    case 2:
                        this.setX(posicaox);
                        this.setY(getY() - 10);
                        this.setFill(new ImagePattern(new Image("imagem/up/up2.png")));
                        break;
                    case 3:
                        this.setX(posicaox);
                        this.setY(getY() - 10);
                        this.setFill(new ImagePattern(new Image("imagem/up/up1.png")));
                        break;
                    case 4:
                        this.setX(posicaox);
                        this.setY(getY() - 10);
                        this.setFill(new ImagePattern(new Image("imagem/up/up3.png")));
                        break;
                }
            }
        }
        return up + 1;
    }

    /**
     * Método que contar vida e retornar o valor da mesma, método utilizado para
     * contar a vida do personagem adquirinda na primeira fase do jogo
     */
    public int vida(int vida) {
        System.out.println("Vida " + (vida + 1));
        return vida += 1;
    }

    /**
     * Método que contar vida e retornar o valor da mesma menos um inteiro,
     * método utilizado para subtrair a quantidade na variavel contadora de vida
     * do personagem. Metodo chamado na segunda fase(Classe Fase2.java)
     */
    public int morte(int vida) {
        System.out.println("Vida " + (vida - 1));
        return vida -= 1;
    }

    /**
     * Método que retorna o personagem quando está na mesma posição da mina
     * setada na classe fase2.java. O metodo chma outro metodo na classe,
     * chamado reset()
     */
    public void PersonagemExplodido() {

        setFill(null);

        reset();

    }

    /**
     * Método responsavel por retornar um inteiro responsavel pela alternacia no
     * quisito FASE. o metodo chama outro metodo da classe, chamado reset()
     */
    public int fase2() {
        reset();
        return 2;
    }

    /**
     * O método responsavel por resetar a posicao do personagem para o ponto
     * inicial da tela
     */
    public void reset() {

        this.setX(55);
        this.setY(320);

    }
}

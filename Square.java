import java.awt.*;

public class Square extends Rectangle {

    /*************************************************/
    // Constructeur 1 : sans point d'origine
    public Square(int px, Color c){ // Constructeur du carré
        super(px,px,c); // On réutilise le constructeur du rectangle, en mettant en argument uniquement les valeurs px afin de former un carré
    }

    /*************************************************/
    // Constructeur 2 : avec point d'origine
    public Square(int px, Color c, Point point){ // Constructeur du carré avec un point en argument pour son origine
        super(px,px,c,point);
    }

    public void setBoundingBox (int widthBB, int heightBB){
        this.heightBB = heightBB;
        this.widthBB = heightBB;
    }

    /*************************************************/
    // Méthode d'affichage du carré
    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }
}

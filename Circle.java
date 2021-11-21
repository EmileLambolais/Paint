import java.awt.*;

public class Circle extends Ellipse{
     
    public int px;

    /*************************************************/
    // Constructeur 1 : sans point d'origine
    public Circle(int px, Color c){ // Constructeur du carré
        super(px,px,c);
        this.px = px;
    }

    /*************************************************/
    // Constructeur 2 : avec point d'origine
    public Circle(int px, Color c, Point point){ // Constructeur du carré avec un point d'origine
        super(px,px,c,point);
        this.px = px;
    }
    
    public void setBoundingBox (int heightBB, int widthBB){
        this.heightBB = heightBB;
        this.widthBB = heightBB;
    }

    /*************************************************/
    // Méthode d'affichage du cercle
    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

}

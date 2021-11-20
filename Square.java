import java.awt.*;

public class Square extends Rectangle {

    public Square(int px, Color c){ // Constructeur du carré
        super(px,px,c);
    }

    public Square(int px, Color c, Point point){ // Constructeur du carré avec un point en argument pour son origine
        super(px,px,c,point);
    }

    public void setBoundingBox (int widthBB, int heightBB){
        this.heightBB = heightBB;
        this.widthBB = heightBB;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }
}

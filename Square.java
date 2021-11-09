import java.awt.*;

public class Square extends Rectangle {

    public Square(int px, Color c){ // Constructeur du carré
        super(px,px,c);
    }

    public Square(int px, Color c, Point point){ // Constructeur du carré avec un point en argument pour son origine
        super(px,px,c,point);
    }

    public void setBoundingBox (int heightBB, int widthBB){
        this.heightBB = heightBB;
        this.widthBB = heightBB;
    }

    @Override
    public String toString() {
        return "("+heightBB+","+widthBB+")"+point;
    }
}

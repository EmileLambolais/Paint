import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;

public class Drawing extends JPanel implements MouseInputListener {
    
    public int x,y;
    public Color color;
    public String nextFigure;
    public Point origine;
    public ArrayList<String> listOfFigure = new ArrayList<String>();
    public static int totalNumberOfFigure;
    public static String strCurrentLine;

    public Drawing(){
        addMouseListener(this);
    }

    public ArrayList<String> getListOfFigure() {
        return listOfFigure;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setNextFigure(String nextFigure) {
        this.nextFigure = nextFigure;
    }

    public String getNextFigure() {
        return nextFigure;
    }

    public Point getPoint() {
        return origine;
    }

    public int getTotalNumberOfFigure() {
        return totalNumberOfFigure;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        Graphics g = getGraphics();  
        g.setColor(color); 
        
        if (nextFigure == "Rectangle"){
            g.fillRect(e.getX(),e.getY(),200,100);
        }
        
        if (nextFigure == "Carre"){
            g.fillRect(e.getX(),e.getY(),50,50);
        }

        if (nextFigure == "Ellipse"){
            g.fillOval(e.getX(),e.getY(),200,100);
        }

        if (nextFigure == "Cercle"){
            g.fillOval(e.getX(),e.getY(),50,50);
        }

        origine = new Point(e.getX(),e.getY()); // en faisant dessin.getPoint() je récupère directement l'origine du dernier clic effectué
        
        if ((color != null) && (nextFigure != null)){
            // Ajout des caractéristiques de la figure en cours dans une sous liste listCurrentFigure
            listOfFigure.add(nextFigure+" / ");
            listOfFigure.add(color+" / ");
            listOfFigure.add(origine+"\n");

            System.out.println("Figure :"+nextFigure+" / Couleur :"+color+" / Origine :"+origine);
            // System.out.println(listOfFigure);
        }
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}

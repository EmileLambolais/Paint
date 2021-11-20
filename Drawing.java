import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class Drawing extends JPanel implements MouseInputListener {
    
    public int x,y,widthMD,heightMD;
    public Color color;
    public String nextFigure;
    public Point origin, end;
    public ArrayList<Figure> listOfFigure = new ArrayList<Figure>();
    public static int totalNumberOfFigure;
    public static String strCurrentLine;

    public Drawing(){
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < listOfFigure.size(); i++) {
            listOfFigure.get(i).draw(g);
        }
    }

    public ArrayList<Figure> getListOfFigure() {
        return listOfFigure;
    }

    public void openFile(String fileName) {
        Graphics g = getGraphics(); 
        try {
            listOfFigure.clear();
            System.out.println(listOfFigure);
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            int numOfFigure = ois.readInt();
            for (int i = 0; i < numOfFigure; i++) {
                Figure figure = (Figure) ois.readObject();
                listOfFigure.add(figure);
            }
            System.out.println(listOfFigure);
            for (int i = 0; i < listOfFigure.size(); i++) {
                listOfFigure.get(i).draw(g);
            }
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public int getTotalNumberOfFigure() {
        return totalNumberOfFigure;
    }

    public Point getOrigin() {
        return origin;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        origin = new Point(e.getX(),e.getY());  
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        Graphics g = getGraphics();  
        g.setColor(color); 
        end = new Point(e.getX(),e.getY()); // en faisant dessin.getPoint() je récupère directement l'origine du dernier clic effectué

        int width = end.getX()-origin.getX(); // Création de la variable qui définie la largeur
        int height = end.getY()-origin.getY(); // Création de la variable qui définie la hauteur

        if (end.getX()<origin.getX()){
            if (end.getY()>origin.getY()){
                origin = new Point(end.getX(),origin.getY());
            }
            else{
              origin = end; // Dans le cas ou le point de fin est plus petit, alors le point de fin de vient celui d'origine  
            }
        }

        if ((end.getX()>origin.getX()) && (end.getY()<origin.getY())){
            origin = new Point(origin.getX(),end.getY());
        }

        if ((color != null) && (nextFigure != null) && (width != 0)){
            if (nextFigure == "Rectangle"){
                Rectangle rectangle = new Rectangle(Math.abs(width),Math.abs(height),color,origin); // On créé un objet rectangle qui prend comme argument les paramètres de notre rectangle créé juste avant
                rectangle.draw(g); // affichage du rectangle
                listOfFigure.add(rectangle); // On ajoute ici la figure créée dans la liste de figure
            }
            
            if (nextFigure == "Carre"){
                Square carre = new Square(Math.abs(width),color,origin); // Comme le rectangle
                carre.draw(g); // affichage du carré
                listOfFigure.add(carre);
            }

            if (nextFigure == "Ellipse"){
                Ellipse ellipse = new Ellipse(Math.abs(width),Math.abs(height),color,origin); // Comme le rectangle
                ellipse.draw(g);
                listOfFigure.add(ellipse);
            }

            if (nextFigure == "Cercle"){
                Circle cercle = new Circle(Math.abs(width),color,origin); // Comme le rectangle
                cercle.draw(g);
                listOfFigure.add(cercle);
            }
            System.out.println("Figure :"+nextFigure+" / Couleur :"+color+" / Origine :"+origin);
            System.out.println(listOfFigure);
        }       
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
        /*Graphics g = getGraphics();  
        g.setColor(color); 

        this.widthMD = origin.getX()-e.getX();
        this.heightMD = origin.getY()-e.getY();

        if ((color != null) && (nextFigure != null)){
            if (nextFigure == "Rectangle"){
                Rectangle rectangle = new Rectangle(Math.abs(widthMD),Math.abs(heightMD),color,origin); // On créé un objet rectangle qui prend comme argument les paramètres de notre rectangle créé juste avant
                rectangle.draw(g); // affichage du rectangle
            }
            
            if (nextFigure == "Carre"){
                Square carre = new Square(Math.abs(widthMD),color,origin); // Comme le rectangle
                carre.draw(g); // affichage du carré
            }

            if (nextFigure == "Ellipse"){
                Ellipse ellipse = new Ellipse(Math.abs(widthMD),Math.abs(heightMD),color,origin); // Comme le rectangle
                ellipse.draw(g);
            }

            if (nextFigure == "Cercle"){
                Circle cercle = new Circle(Math.abs(widthMD),color,origin); // Comme le rectangle
                cercle.draw(g);
            }
        }*/
    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}

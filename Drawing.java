import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;

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

    public ArrayList<Figure> getListOfFigure() {
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

    public int getTotalNumberOfFigure() {
        return totalNumberOfFigure;
    }

    public Point getOrigin() {
        return origin;
    }

    public Point getEnd() {
        return end;
    }

    public void openFile(ArrayList<Figure> liste){
        this.listOfFigure.clear(); // Supprime toutes les figures qui sont dans la liste au cas ou il y en a d'autre
        listOfFigure = liste; // Remplace la liste des figures par celle chargé "liste"
        paintComponent(this.getGraphics()); // Affiche les figures chargées
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < listOfFigure.size(); i++) { // Parcours les éléments de la liste listOfFigure
            listOfFigure.get(i).draw(g); // Affiche chaque éléments de la "listOfFigure"
        }
    }

    public void resetDrawing(){
        this.listOfFigure.clear();
        paintComponent(this.getGraphics());
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
                // rectangle.draw(g); // Affichage du rectangle directement
                listOfFigure.add(rectangle); // On ajoute ici la figure créée dans la liste de figure
            }
            
            if (nextFigure == "Carre"){
                Square carre = new Square(Math.abs(width),color,origin); // Comme le rectangle
                listOfFigure.add(carre);
            }

            if (nextFigure == "Ellipse"){
                Ellipse ellipse = new Ellipse(Math.abs(width),Math.abs(height),color,origin); // Comme le rectangle
                listOfFigure.add(ellipse);
            }

            if (nextFigure == "Cercle"){
                Circle cercle = new Circle(Math.abs(width),color,origin); // Comme le rectangle
                listOfFigure.add(cercle);
            }
            // System.out.println("Figure :"+nextFigure+" / Couleur :"+color+" / Origine :"+origin);
            paintComponent(this.getGraphics()); // Affichage de tous les éléments dans la liste listOfFigure
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

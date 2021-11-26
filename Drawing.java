import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;

public class Drawing extends JPanel implements MouseInputListener {
    
    public int widthMD,heightMD;
    public Color color;
    public String nextFigure;
    public Point origin, end, origin2;
    public ArrayList<Figure> listOfFigure = new ArrayList<Figure>();
    public ArrayList<Figure> listDragged = new ArrayList<Figure>();
    public ArrayList<Figure> listRestore = new ArrayList<Figure>();

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

    public Point getOrigin() {
        return origin;
    }

    public Point getEnd() {
        return end;
    }

    /**************************************************/
    // Méthode pour annuler une figure créées
    public void deletePreviousFigure() {
        listRestore.add(listOfFigure.get(listOfFigure.size() - 1)); // Ajout du dernier éléments dans une listRestore qui stock les éléments annulées
        listOfFigure.remove(listOfFigure.size() - 1); // suppression du dernier éléments de listOfFigure 
        paintComponent(this.getGraphics()); // Réaffiche les éléments de la liste listOfFigure avec le dernier élément supprimé
        System.out.println(listOfFigure);
    }

    /**************************************************/
    // Méthode pour rétablir une figure annulées
    public void restorePreviousFigure() {
        listOfFigure.add(listRestore.get(listRestore.size() - 1)); // Ajout de la précédentes figures supprimées dans la listOfFigure afin de la faire réapparaitre
        listRestore.remove(listRestore.size() - 1); // Suppréssion de la dernière figure dans listRestore afin de ne garder que les figures annulées dedans, et plus celles restaurés
        paintComponent(this.getGraphics()); // Affiche les figures
        System.out.println(listOfFigure);
    }

    /*************************************************/
    // Méthode d'ouverture du fichier
    public void openFile(ArrayList<Figure> liste){
        this.listOfFigure.clear(); // Supprime toutes les figures qui sont dans la liste listOfFigure au cas ou il y en a d'autre
        this.listRestore.clear(); // Supprime toutes les figures qui sont dans la liste listRestore afin de ne pas interférer avec les précédentes créations
        listOfFigure = liste; // Remplace la liste des figures par celle chargé "liste" lors de l'ouverture du fichier
        paintComponent(this.getGraphics()); // Affiche les figures chargées
    }

    /*************************************************/
    // Méthode d'affichage des composants dans la liste "listOfFigure"
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < listOfFigure.size(); i++) { // Parcours les éléments de la liste listOfFigure
            listOfFigure.get(i).draw(g); // Affiche chaque éléments de la "listOfFigure"
        }
    }

    /*************************************************/
    // Méthode d'affichage des composants dans la liste "listOfFigure"
    public void paintComponentDragged(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < listDragged.size(); i++) { // Parcours les éléments de la liste listOfFigure
            listDragged.get(listDragged.size()-1).draw(g); // Affiche chaque éléments de la "listOfFigure"
            listOfFigure.get(i).draw(g);
        }
    }

    /*************************************************/
    // Méthode de reset des éléments affichés
    public void resetDrawing(){
        this.listOfFigure.clear();
        paintComponent(this.getGraphics());
    }
    
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
    }

    /*************************************************/
    // Actions lors du clic de la souris
    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        origin = new Point(e.getX(),e.getY()); // création d'un point de départ de la souris, le point d'origine
    }

    /*************************************************/
    // Actions lors du relachement de la souris
    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {

        end = new Point(e.getX(),e.getY()); // création d'un point d'arrivée, le point "end"

        int width = end.getX()-origin.getX(); // Création de la variable qui définie la largeur
        int height = end.getY()-origin.getY(); // Création de la variable qui définie la hauteur

        // Création des différents cas possibles (sens d'affichage)
        if ((end.getX()<origin.getX()) && (end.getY()>origin.getY())){origin = new Point(end.getX(),origin.getY());} // Dans le cas ou l'abscisse d'arrivée < que celle de départ, mais que l'ordonnée d'arrivée > à celle de départ => création d'un point d'origine prenant l'abscisse d'arrivée et l'ordonnée de départ
        if ((end.getX()<origin.getX()) && (end.getY()<origin.getY())){origin = end;} // Dans le cas ou l'abscisse d'arrivée < que celle de départ, mais que l'ordonnée d'arrivée < à celle de départ => le point d'arrivée devient le point d'origine
        if ((end.getX()>origin.getX()) && (end.getY()<origin.getY())){origin = new Point(origin.getX(),end.getY());} // Dans le cas ou l'abscisse d'arrivée > que celle de départ, mais que l'ordonnée d'arrivée < à celle de départ => création d'un point d'origine prenant l'abscisse de départ et l'ordonnée d'arrivée

        // Affichage des éléments lors du relachement de la souris, en fonction de la valeur de "nextFigure". Cela créé un objet adéquat de la bonne couleur
        if ((color != null) && (nextFigure != null) && (width != 0)){
            if (nextFigure == "Rectangle"){
                Rectangle rectangle = new Rectangle(Math.abs(width),Math.abs(height),color,origin); // On créé un objet rectangle qui prend comme argument les paramètres de largeur et de hauteur calculé juste au dessus, la couleur et l'origine
                listOfFigure.add(rectangle); // On ajoute ici la figure créée dans la liste de figure
            }
            
            if (nextFigure == "Carre"){
                Square carre = new Square(Math.abs(width),color,origin); // Méthode similaire au rectangle
                listOfFigure.add(carre);
            }

            if (nextFigure == "Ellipse"){
                Ellipse ellipse = new Ellipse(Math.abs(width),Math.abs(height),color,origin); // Méthode similaire au rectangle
                listOfFigure.add(ellipse);
            }

            if (nextFigure == "Cercle"){
                Circle cercle = new Circle(Math.abs(width),color,origin); // Méthode similaire au rectangle
                listOfFigure.add(cercle);
            }
            paintComponent(this.getGraphics()); // Affichage de tous les éléments dans la liste listOfFigure
            System.out.println(listOfFigure); // Vérification du contenu de la listOfFigure avec affichage de cette dernière dans le terminal
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
    
    /*************************************************/
    // Actions lors du déplacement de la souris
    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) { 

        this.widthMD = origin.getX()-e.getX(); // Création de la valeur qui donnera la largeur au dessin temporaire
        this.heightMD = origin.getY()-e.getY(); // Création de la valeur qui donnera la hauteur au dessin temporaire

        // Création des différents cas possibles (sens d'affichage)
        if ((e.getX()<origin.getX()) && (e.getY()<origin.getY())){origin2 = new Point(e.getX(),e.getY());} // Même méthode de raisonnement que dans le mouseRealesed
        if ((e.getX()>origin.getX()) && (e.getY()>origin.getY())){origin2 = origin;}
        if ((e.getX()<origin.getX()) && (e.getY()>origin.getY())){origin2 = new Point(e.getX(),origin.getY());}
        if ((e.getX()>origin.getX()) && (e.getY()<origin.getY())){origin2 = new Point(origin.getX(),e.getY());}

        if ((color != null) && (nextFigure != null)){
            if (nextFigure == "Rectangle"){
                Rectangle rectangle = new Rectangle(Math.abs(widthMD),Math.abs(heightMD),color,origin2); // On créé un objet rectangle qui prend comme argument les paramètres de notre rectangle créé juste avant
                listDragged.add(rectangle); // ajout du rectangle dans la liste "listDragged"
            }
            
            if (nextFigure == "Carre"){
                Square carre = new Square(Math.abs(widthMD),color,origin2); // Comme le rectangle
                listDragged.add(carre); // ajout du carre dans la liste "listDragged"
            }

            if (nextFigure == "Ellipse"){
                Ellipse ellipse = new Ellipse(Math.abs(widthMD),Math.abs(heightMD),color,origin2); // Comme le rectangle
                listDragged.add(ellipse); // ajout de l'ellipse dans la liste "listDragged"
            }

            if (nextFigure == "Cercle"){
                Circle cercle = new Circle(Math.abs(widthMD),color,origin2); // Comme le rectangle
                listDragged.add(cercle); // ajout du cercle dans la liste "listDragged"
            }
        }
        paintComponentDragged(this.getGraphics()); // Affichage du dernier élément dans la liste listDragged, afin d'afficher uniquement l'élément en cours de modification
    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}

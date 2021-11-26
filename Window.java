import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Window extends JFrame {
    public Window(String Title,int x,int y){ // Création du constructeur qui créé une fenêtre

            /*************************************************/ 
            // Création de la structure
            JFrame.setDefaultLookAndFeelDecorated(true);
            JFrame frame = new JFrame(Title);
            JPanel panelButton = new JPanel();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Container contentPanel = this.getContentPane() ;
            
            /*************************************************/ 
            // Création de la barre des menus
            JMenuBar menuBar = new JMenuBar(); // Création de la barre des menus

            /*************************************************/ 
            // Création d'une nouvelle zone de dessin
            Drawing dessin = new Drawing(); // création d'un objet dessin qui va permettre de dessiner les futures formes

            /*************************************************/ 
            // Création du menu Fichier
            JMenu fichierMenu = new JMenu("Fichier"); // Création d'un nouveau menu File
            JMenuItem item = null;

            // Création d'un bouton Nouveau
            item = new JMenuItem("Nouveau"); // Création d'un item Nouveau
                item.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                    public void actionPerformed(ActionEvent e){
                        dessin.resetDrawing();
                    }
                });
            fichierMenu.add(item); // ajout de l'item Nouveau au menu Fichier
            fichierMenu.insertSeparator(1); // Ajout d'un séparateur entre les deux items

            // Création d'un bouton Ouvrir
            JMenuItem itemOpen = new JMenuItem("Ouvrir") ; // Création d'un item Ouvrir
                itemOpen.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                    public void actionPerformed(ActionEvent e){
                        JFileChooser openFile = new JFileChooser("/Users/emilelambolais/Library/Mobile Documents/com~apple~CloudDocs/Documents/01_ENSEA/Cours/2A 2021-2022/01_Cours 2A 2021-2022/Informatique Java/Travaux Dirigés/Projet Java");
                        openFile.showOpenDialog(itemOpen);
                        try{
                            ArrayList<Figure> liste = new ArrayList<Figure>();
                            String nameFile = openFile.getSelectedFile().getAbsolutePath();
                            FileInputStream fis = new FileInputStream(nameFile);
                            ObjectInputStream ois = new ObjectInputStream(fis);

                            int numberOfFigure = ois.readInt();
                            for (int i = 0; i < numberOfFigure; i++) {
                                Figure figure = (Figure) ois.readObject();
                                liste.add(figure);
                            }
                            System.out.println(liste);
                            dessin.openFile(liste);
                            ois.close();
                        }
                        catch (Exception e2){
                           e2.printStackTrace();
                        }
                    }
                });
            fichierMenu.add(itemOpen); // On ajoute l'item Ouvrir dans le menu Fichier

            // Création d'un bouton Sauvegarder
            JMenuItem itemSave = new JMenuItem("Sauvegarder") ; // Création d'un item Sauvegarder
                itemSave.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                    public void actionPerformed(ActionEvent e){
                        JFileChooser saveFile = new JFileChooser("/Users/emilelambolais/Library/Mobile Documents/com~apple~CloudDocs/Documents/01_ENSEA/Cours/2A 2021-2022/01_Cours 2A 2021-2022/Informatique Java/Travaux Dirigés/Projet Java");
                        saveFile.showSaveDialog(itemSave);
                        try{
                            ArrayList<Figure> liste = new ArrayList<Figure>();
                            liste = dessin.getListOfFigure();
                            String nameFile = saveFile.getSelectedFile().getAbsolutePath();
                            FileOutputStream fos = new FileOutputStream(nameFile);
                            ObjectOutputStream oos = new ObjectOutputStream(fos);

                            oos.writeInt(liste.size());
                            for (int i = 0; i < liste.size(); i++) {
                                oos.writeObject(liste.get(i));
                            }
                            // System.out.println(liste);
                            oos.close();
                        }
                        catch (Exception e2){
                           e2.printStackTrace();
                        }
                    }
                });
            itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
            fichierMenu.add(itemSave); // On ajoute l'item Ouvrir dans le menu Fichier
            fichierMenu.insertSeparator(4); // Ajout d'un séparateur entre les deux items
            
            // Création d'un bouton Quitter
            JMenuItem itemQuit = new JMenuItem("Quitter") ; // Création d'un item Quitter
            itemQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
                itemQuit.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                    public void actionPerformed(ActionEvent e){
                        System.exit(0);
                    }
                });
            fichierMenu.add(itemQuit); // On ajoute l'item Ouvrir dans le menu Fichier
            menuBar.add(fichierMenu); // On ajoute du menu Fichier dans la barre de menu

            /*************************************************/
            // Création du menu A Propos
            JMenu aproposMenu = new JMenu("À Propos"); // Création d'un nouveau menu A Propos
            JMenu aproposCreateur = new JMenu("Créateur"); // Création d'un nouveau sous menu Créateur
            JMenuItem buttonCreateur = new JMenuItem("Emile LAMBOLAIS, ENSEA"); // Création d'un bouton créateur pour afficher le nom du créateur du programme
            aproposCreateur.add(buttonCreateur); // ajout de l'item Nouveau au sous menu
            aproposMenu.add(aproposCreateur); // ajout du sous menu au menu A Propos
            menuBar.add(aproposMenu); // On ajoute du menu A propos dans la barre de menu

            /*************************************************/
            // Création du menu Actions
            JMenu actions = new JMenu("Actions"); // Création d'un nouveau menu A Propos

            // Création d'un bouton Annuler
            JMenuItem cancel = new JMenuItem("Annuler");
            cancel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK)); // Raccourcis clavier CTRL A
            cancel.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                    public void actionPerformed(ActionEvent e){
                        dessin.deletePreviousFigure(); // supprime le dernier éléments ajoutés à la liste
                    }
                });
            actions.add(cancel); // ajout du sous menu au menu Actions
            menuBar.add(actions); // On ajoute du menu Actions dans la barre de menu

            // Création d'un bouton Rétablir
            JMenuItem restore = new JMenuItem("Rétablir");
            restore.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK)); // Raccourcis clavier CTRL R
            restore.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                    public void actionPerformed(ActionEvent e){
                        dessin.restorePreviousFigure(); // supprime le dernier éléments ajoutés à la liste
                    }
                });
            actions.add(restore); // ajout du sous menu au menu Actions
            menuBar.add(actions); // On ajoute du menu Actions dans la barre de menu
            
            /*************************************************/
            // Création des boutons
            JButton buttonNoir = new JButton("Noir");
                buttonNoir.setBackground(Color.black); // Couleur du background mise en noir
                buttonNoir.setForeground(Color.white); // Couleur du texte mise en blanche
                buttonNoir.setOpaque(true); // Transparence du bouton mise en opaque
                buttonNoir.setBorderPainted(false); // Suppression des bordures pour afficher correctement la couleur
                buttonNoir.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                    public void actionPerformed(ActionEvent e){
                        dessin.setColor(Color.black); // On donne au dessin actuel la couleur noire
                    }
                });
            JButton buttonRouge = new JButton("Rouge");
                buttonRouge.setBackground(Color.red);
                buttonRouge.setOpaque(true);
                buttonRouge.setBorderPainted(false);
                buttonRouge.addActionListener(new ActionListener(){ 
                    public void actionPerformed(ActionEvent e){
                        dessin.setColor(Color.red);
                    }
                });
            JButton buttonVert = new JButton("Vert");
                buttonVert.setBackground(Color.green);
                buttonVert.setOpaque(true);
                buttonVert.setBorderPainted(false);
                buttonVert.addActionListener(new ActionListener(){ 
                    public void actionPerformed(ActionEvent e){
                        dessin.setColor(Color.green);
                    }
                });
            JButton buttonBleu = new JButton("Bleu");
                buttonBleu.setBackground(Color.blue);
                buttonBleu.setForeground(Color.white);
                buttonBleu.setOpaque(true);
                buttonBleu.setBorderPainted(false);
                buttonBleu.addActionListener(new ActionListener(){ 
                    public void actionPerformed(ActionEvent e){
                        dessin.setColor(Color.blue);
                    }
                });
            JButton buttonEllipse = new JButton("Ellipse");
                buttonEllipse.addActionListener(new ActionListener(){ 
                    public void actionPerformed(ActionEvent e){
                        dessin.setNextFigure("Ellipse"); // On donne au dessin comme prochaine figure l'Ellipse
                    }
                });
            JButton buttonCercle = new JButton("Cercle");
                buttonCercle.addActionListener(new ActionListener(){ 
                    public void actionPerformed(ActionEvent e){
                        dessin.setNextFigure("Cercle"); // On donne au dessin comme prochaine figure le Cercle
                    }
                });
            JButton buttonJaune = new JButton("Jaune");
                buttonJaune.setBackground(Color.yellow);
                buttonJaune.setOpaque(true);
                buttonJaune.setBorderPainted(false);
                buttonJaune.addActionListener(new ActionListener(){ 
                    public void actionPerformed(ActionEvent e){
                        dessin.setColor(Color.yellow);
                    }
                });
            JButton buttonRose = new JButton("Rose");
                buttonRose.setBackground(Color.pink); 
                buttonRose.setOpaque(true);
                buttonRose.setBorderPainted(false);
                buttonRose.addActionListener(new ActionListener(){ 
                    public void actionPerformed(ActionEvent e){
                        dessin.setColor(Color.pink);
                    }
                });
            JButton buttonMagenta = new JButton("Magenta");
                buttonMagenta.setBackground(Color.magenta);
                buttonMagenta.setOpaque(true);
                buttonMagenta.setBorderPainted(false);
                buttonMagenta.addActionListener(new ActionListener(){ 
                    public void actionPerformed(ActionEvent e){
                        dessin.setColor(Color.magenta);
                    }
                });
            JButton buttonOrange = new JButton("Orange");
                buttonOrange.setBackground(Color.orange);
                buttonOrange.setOpaque(true);
                buttonOrange.setBorderPainted(false);
                buttonOrange.addActionListener(new ActionListener(){ 
                    public void actionPerformed(ActionEvent e){
                        dessin.setColor(Color.orange);
                    }
                });
            JButton buttonRectangle = new JButton("Rectangle");
                buttonRectangle.addActionListener(new ActionListener(){ 
                    public void actionPerformed(ActionEvent e){
                        dessin.setNextFigure("Rectangle"); // On donne au dessin comme prochaine figure le Rectangle
                    }
                });
            JButton buttonCarre = new JButton("Carré");
                buttonCarre.addActionListener(new ActionListener(){ 
                    public void actionPerformed(ActionEvent e){
                            dessin.setNextFigure("Carre"); // On donne au dessin comme prochaine figure le Carré
                        }
                });

            /*************************************************/
            // Remplissage du panelButton qui va contenir les éléments boutons avec une grille de 2 par 6
            panelButton.setLayout(new GridLayout(2, 6));
            panelButton.add(buttonNoir);
            panelButton.add(buttonRouge);
            panelButton.add(buttonVert);
            panelButton.add(buttonBleu);
            panelButton.add(buttonEllipse);
            panelButton.add(buttonCercle);
            panelButton.add(buttonJaune);
            panelButton.add(buttonRose);
            panelButton.add(buttonMagenta);
            panelButton.add(buttonOrange);
            panelButton.add(buttonRectangle);
            panelButton.add(buttonCarre);  

            /*************************************************/
            // Ajout des différents élèments dans le contenu
            contentPanel.add(menuBar,  BorderLayout.NORTH); // Ajout de la barre des menus au contentPanel, hierarchiquement en dessous du frame
            contentPanel.add(dessin);
            contentPanel.add(panelButton, BorderLayout.SOUTH); // Ajout du panel contenant les bouttons au contentPanel

            /*************************************************/
            // Ajout du contenu dans la fenêtre visible
            frame.add(contentPanel); // Ajout du contenu du panel dans la fenetre d'affichage
            frame.pack();
            frame.setSize(x,y); // Taille de la fenêtre créée
            frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Window("Paint",800,600);
    }

}

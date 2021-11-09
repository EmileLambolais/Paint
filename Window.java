import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Window extends JFrame {
    public Window(String Title,int x,int y){ // Création du constructeur qui créé une fenêtre

            // Create and set up a frame window
            JFrame.setDefaultLookAndFeelDecorated(true);
            JFrame frame = new JFrame(Title);
            JPanel panelButton = new JPanel();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Container contentPanel = this.getContentPane() ;
            
            // Création de la barre des menus
            JMenuBar menuBar = new JMenuBar(); // Création de la barre des menus

            // Création d'un nouveau dessin
            Drawing dessin = new Drawing(); // création d'un objet dessin qui va permettre de dessiner les futures formes

            // Création du menu Fichier
            JMenu fichierMenu = new JMenu("Fichier"); // Création d'un nouveau menu File
            JMenuItem item = null;
            item = new JMenuItem("Nouveau") ; // Création d'un item Nouveau
                item.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                    public void actionPerformed(ActionEvent e){
                        String nomFile = JOptionPane.showInputDialog(getParent(),"Entrez le nom du nouveau fichier", null);
                            try {
                                File newFile = new File(nomFile);
                                if (newFile.createNewFile()) {
                                    System.out.println("Fichier créé: " + newFile.getName());
                                } 
                                else {
                                    System.out.println("Fichier déjà existant.");
                                }
                            } 
                            catch (IOException p) {
                                System.out.println("Une erreur est apparue.");
                                p.printStackTrace();
                            }
                        }
                    });
            fichierMenu.add(item); // ajout de l'item Nouveau au menu Fichier
            fichierMenu.insertSeparator(1); // Ajout d'un séparateur entre les deux items
            item = new JMenuItem("Ouvrir") ; // Création d'un item Ouvrir
            fichierMenu.add(item); // On ajoute l'item Ouvrir dans le menu Fichier
            JMenuItem itemSave = new JMenuItem("Sauvegarder") ; // Création d'un item Sauvegarder
                itemSave.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                    public void actionPerformed(ActionEvent e){
                        // JFileChooser selectionFichier = new JFileChooser("c:\\users\\emile\\iCloudDrive\\Documents\\01_ENSEA\\Cours\\2A 2021-2022\\01_Cours 2A 2021-2022\\Informatique Java\\Travaux Dirigés\\Projet Java");
                        JFileChooser selectionFichier = new JFileChooser("/Users/emilelambolais/Library/Mobile Documents/com~apple~CloudDocs/Documents/01_ENSEA/Cours/2A 2021-2022/01_Cours 2A 2021-2022/Informatique Java/Travaux Dirigés/Projet Java");
                        selectionFichier.setFileFilter(new FileTypeFilter(".txt", "Text"));
                        int result = selectionFichier.showSaveDialog(itemSave);
                        if (result == JFileChooser.APPROVE_OPTION) {
                            File fileToSave = selectionFichier.getSelectedFile();
                            int i;
                            try{
                                FileWriter fw = new FileWriter(fileToSave.getPath());
                                for (i=0 ; i<dessin.getListOfFigure().size() ; i++){
                                    String content = dessin.getListOfFigure().get(i); // On parcourt tous les éléments de la listOfFigure et on les ajoute à un fichier texte
                                    fw.write(content);
                                }
                                fw.flush();
                                fw.close();
                            }
                            catch (Exception e2){
                                JOptionPane.showMessageDialog(null, e2.getMessage());
                            }
                            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
                        }
                    }
                });
            itemSave.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
            fichierMenu.add(itemSave); // On ajoute l'item Ouvrir dans le menu Fichier
            fichierMenu.insertSeparator(4); // Ajout d'un séparateur entre les deux items
            item = new JMenuItem("Quitter") ; // Création d'un item Quitter
            fichierMenu.add(item); // On ajoute l'item Ouvrir dans le menu Fichier
            menuBar.add(fichierMenu); // On ajoute du menu Fichier dans la barre de menu

            // Création du menu A Propos
            JMenu aproposMenu = new JMenu("À Propos"); // Création d'un nouveau menu A Propos
            JMenu aproposCreateur = new JMenu("Créateur"); // Création d'un nouveau sous menu Créateur
            JButton buttonCreateur = new JButton("Entrer le nom du créateur"); // Création d'un bouton créateur pour renter le nom du créateur du programme
                buttonCreateur.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                        public void actionPerformed(ActionEvent e){
                            String nomCreateur = JOptionPane.showInputDialog(getParent(),"Quel est ton nom ?", null);
                            buttonCreateur.setText(nomCreateur);
                        }
                    });
            aproposCreateur.add(buttonCreateur); // ajout de l'item Nouveau au sous menu
            aproposMenu.add(aproposCreateur); // ajout du sous menu au menu A Propos
            menuBar.add(aproposMenu); // On ajoute du menu A propos dans la barre de menu

            // Création d'un label
            JLabel infoCouleurFigure = new JLabel(".....");
            
            // Création des boutons
            JButton buttonNoir = new JButton("Noir");
                buttonNoir.setBackground(Color.black);
                buttonNoir.setForeground(Color.white);
                buttonNoir.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                    public void actionPerformed(ActionEvent e){
                        dessin.setColor(Color.black); // On donne au dessin actuel la couleur noire
                        infoCouleurFigure.setText("La couleur est "+dessin.getColor()); // Vérification que la couleur est la bonne
                    }
                });
            JButton buttonRouge = new JButton("Rouge");
                buttonRouge.setBackground(Color.red);
                buttonRouge.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                    public void actionPerformed(ActionEvent e){
                        dessin.setColor(Color.red);
                        infoCouleurFigure.setText("La couleur est "+dessin.getColor());
                    }
                });
            JButton buttonVert = new JButton("Vert");
                buttonVert.setBackground(Color.green);
                buttonVert.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                    public void actionPerformed(ActionEvent e){
                        dessin.setColor(Color.green);
                        infoCouleurFigure.setText("La couleur est "+dessin.getColor());
                    }
                });
            JButton buttonBleu = new JButton("Bleu");
                buttonBleu.setBackground(Color.blue);
                buttonBleu.setForeground(Color.white);
                buttonBleu.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                    public void actionPerformed(ActionEvent e){
                        dessin.setColor(Color.blue);
                        infoCouleurFigure.setText("La couleur est "+dessin.getColor());
                    }
                });
            JButton buttonEllipse = new JButton("Ellipse");
                buttonEllipse.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                        public void actionPerformed(ActionEvent e){
                            dessin.setNextFigure("Ellipse");
                            infoCouleurFigure.setText(dessin.getNextFigure());
                        }
                    });
            JButton buttonCercle = new JButton("Cercle");
                buttonCercle.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                            public void actionPerformed(ActionEvent e){
                                dessin.setNextFigure("Cercle");
                                infoCouleurFigure.setText(dessin.getNextFigure());
                            }
                        });
            JButton buttonJaune = new JButton("Jaune");
                buttonJaune.setBackground(Color.yellow);
                buttonJaune.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                    public void actionPerformed(ActionEvent e){
                        dessin.setColor(Color.yellow);
                        infoCouleurFigure.setText("La couleur est "+dessin.getColor());
                    }
                });
            JButton buttonRose = new JButton("Rose");
                buttonRose.setBackground(Color.pink); 
                buttonRose.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                    public void actionPerformed(ActionEvent e){
                        dessin.setColor(Color.pink);
                        infoCouleurFigure.setText("La couleur est "+dessin.getColor());
                    }
                });
            JButton buttonMagenta = new JButton("Magenta");
                buttonMagenta.setBackground(Color.magenta);
                buttonMagenta.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                    public void actionPerformed(ActionEvent e){
                        dessin.setColor(Color.magenta);
                        infoCouleurFigure.setText("La couleur est "+dessin.getColor());
                    }
                });
            JButton buttonOrange = new JButton("Orange");
                buttonOrange.setBackground(Color.orange);
                buttonOrange.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                    public void actionPerformed(ActionEvent e){
                        dessin.setColor(Color.orange);
                        infoCouleurFigure.setText("La couleur est "+dessin.getColor());
                    }
                });
            JButton buttonRectangle = new JButton("Rectangle");
                buttonRectangle.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                        public void actionPerformed(ActionEvent e){
                            dessin.setNextFigure("Rectangle");
                            infoCouleurFigure.setText(dessin.getNextFigure());
                        }
                    });
            JButton buttonCarre = new JButton("Carré");
                buttonCarre.addActionListener(new ActionListener(){ // Ajout d'une écoute d'action, et s'il y a une action alors cela actionne la tache demandée dans le actionPerformed
                            public void actionPerformed(ActionEvent e){
                                dessin.setNextFigure("Carre");
                                infoCouleurFigure.setText(dessin.getNextFigure());
                            }
                        });

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

            // Ajout des différents élèments dans le contenu
            contentPanel.add(menuBar,  BorderLayout.NORTH); // Ajout de la barre des menus au contentPanel, hierarchiquement en dessous du frame
            contentPanel.add(dessin);
            contentPanel.add(panelButton, BorderLayout.SOUTH); // Ajout du panel contenant les bouttons au contentPanel

            // Ajout du contenu dans la fenêtre visible
            frame.add(contentPanel);
            frame.pack();
            frame.setSize(x,y); // Taille de la fenêtre créée
            frame.setVisible(true);

    }

    public static void main(String[] args) {
        Window win = new Window("Paint",800,600);
    }

}

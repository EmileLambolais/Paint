public class Point {

    private int X;
    private int Y;
    public static int totalNumberOfPoint;

    public Point(int X, int Y) { // Création du constructeur qui va permettre de créer tous types de points
        setX(X);
        setY(Y);
        totalNumberOfPoint++;
    }

    public Point() { // Création du constructeur qui va permettre de créer tous types de points
        this.X = 0;
        this.Y = 0;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setX(int x) {
        this.X = x;
    }

    public void setY(int y) {
        this.Y = y;
    }

    public void getTotalNumberOfPoint() {
        System.out.println(totalNumberOfPoint);
    }

    @Override
    public String toString() {
        return "("+X+","+Y+")";
    }
}
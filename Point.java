package tugas;




import tugas.*;

public class Point {
    public float x;
    public float y;
    private float j;//jarak

    public Point(Point p){
        this.x=p.x;
        this.y=p.y;
    }
    public Point (float x, float y){
        this.x = x;
        this.y = y;
    }
    
 //   public Point(double x, double y) {

//    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    public String getKoordinat() {
        return "("+x+","+y+")";
    }
    
    //rumus menghitung jarak
    public float hitJarak(Point t1, Point t2) {
        float dx = t1.x - t2.x;
        float dy = t1.y - t2.y;
        return this.j=(float) Math.sqrt(dx * dx + dy * dy);
        
    }
   
    public Point(Point t1, Point t2) {
        x = (t1.x + t2.x) / 2;
        y = (t1.y + t2.y) / 2;
    }
    public void setJarak(float j){
        this.j=j;
    }
    public float getJarak(){
        return this.j;
    }
}   

    


package tugas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import tugas.*;
import java.util.ArrayList;

/**
 *
 * @author kikis
 */
public class Vertex {
    public ArrayList<Bisector> B=new ArrayList();
    public ArrayList<Point> Nearest = new ArrayList();
    public Point V;
    private boolean using;
    public int i;
    public float jarak;
    public float x,y;
    static Line l1,l2;
    
    public Vertex(Bisector b1, Bisector b2){
        addBisector(b1);
        addBisector(b2);
        l1=b1.getLine();
        l2=b2.getLine();
        if (l1.c=='x'){
            x=l1.b;
            y=l2.a*x+l2.b;
        }
        else if (l2.c=='x'){
            x=l2.b;
            y=l1.a*x+l1.b;
        }
        else {
            x=(l2.b-l1.b)/(l1.a-l2.a);
            y=l1.a*x+l1.b;
        }

        this.x=(float)Math.round(x*100)/100;
        this.y=(float)Math.round(y*100)/100;
        this.V=new Point(x,y);
    }
    public Vertex (Vertex v,Bisector B){
        this.B.add(B);
    }
    public Point getPoint(){
        return this.V;
    }
    public String getVertex(){
        return this.V.getKoordinat();
    }
    
    
    public void addNearestPoint(Point p1, Point p2, Point p3){
        this.Nearest.add(p1);
        this.Nearest.add(p2);
        this.Nearest.add(p3);
    }
    public void setUse(boolean b){
        this.using=b;
    }
    public boolean getUse(){
        return this.using;
    }
    public void addBisector(Bisector B){
        this.B.add(B);
    }
    public void addAllBisector(ArrayList B){
        this.B.addAll(B);
    }
    public ArrayList Bisector(){
        return this.B;
    }
    public String getBisec(){
        String s="";
        for (int i=0;i<B.size();i++){
            s=s+B.get(i).getBisector()+" ";
        }
        return s;
    }
    
}

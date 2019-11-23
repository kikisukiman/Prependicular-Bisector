package tugas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import tugas.*;

/**
 *
 * @author kikis
 */
public class Bisector {
    public Line L;
    public Point P1, P2;
    static float x,y,g; 
    static Point p;
    static float a,b;
    
    public Bisector(Point p1,Point p2){
        this.P1=p1;
        this.P2=p2;
        p=getMidPoint(p1,p2);
        char c='y';
        if ((p1.x!=p2.x) && (p1.y!=p2.y)){
            g=(p2.y - p1.y)/(p2.x-p1.x);
            a=(0-1)/(g);//gradien garis yang tegak lurus
            b=p.y-a*p.x;
            c='y';
        }else if(p1.x==p2.x){
            a=0;
            b=p.y;
            c='y';
        }else if(p1.y==p2.y){
            a=1;
            b=p.x;
            c='x';
        }
        L=new Line(a,b,c);
        this.L=L;    
    }
    private static Point getMidPoint(Point p1,Point p2){
        x=(p2.x+p1.x)/2;
        y=(p2.y+p1.y)/2;
        Point p=new Point(x,y);
        return p;
    }
    
    public Line getLine(){
        return this.L;
    }

       
    public String getBisector(){
        return this.L.getLine();
    }
}

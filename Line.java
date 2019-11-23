package tugas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import tugas.*;

/**
 *
 * @author ASUS-PC
 */
public class Line {
    public float a, b;
    public char c;

    public Line(float a ,float b){
        this.a=a;
        this.b=b;
        this.c='y';
    }
    public Line(float a ,float b,char c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public String getLine(){
        String s;
        if ((a==0)&&(c=='y')){
            s=("y="+b);
        }else if (c=='x'){
            s=("x="+b);
        }else{
            if(b>0){
                s=("y="+a+"x+("+b+")");
            }else if (b==0){
                s=("y="+a+"x");
            }else{
                s=("y="+a+"x-("+((0-1)*b)+")");
            }
        }
        return s;
    }
}

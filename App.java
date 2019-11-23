package tugas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.*;

public class App {
    public static float x,y;
    static int n;

    public static boolean cekIntersection(Line l1, Line l2){
        if (((l1.c=='x')&&(l2.c=='x'))&&(l1.a==l2.a)){
            return false;
        }else if (((l1.c=='y')&&(l2.c=='y'))&&(l1.a==l2.a)){
            return false;
        }else if (l1==l2){
            return false;
        }else
        return true;
    }
    private static double getJarak(Point p1, Point p2){
        double eu= Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+((p1.y-p2.y)*(p1.y-p2.y)));
        return eu;
    }    
    //kNN

    
    

        public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);
                System.out.print("Input Jumlah titik:");
                int n=scan.nextInt();
                ArrayList<Point> P=new ArrayList();
               // Point[] P=new Point[n];
                int i;
                for (i=0;i<=n-1; i++){
                    System.out.print("Input X"+(i+1)+":");
                    int x=scan.nextInt();
                    System.out.print("Input Y"+(i+1)+":");
                    int y=scan.nextInt();
                    P.add(new Point(x,y));
                    System.out.println(P.get(i).getKoordinat());
                }

                System.out.println("Semua Bisector Prependicular:");
                LinkedList<Bisector> B=new LinkedList<Bisector>();
//                Bisector[] B=new Bisector[temp];
                int k=0;
                for (i=0;i<P.size(); i++){
                    for (int j=i+1;j<P.size();j++){
                        B.add(new Bisector(P.get(i),P.get(j)));
                        System.out.println(B.get(k).getBisector()+", Titiknya ["+P.get(i).getKoordinat()+"],["+P.get(j).getKoordinat()+"]");   
                        k++;
                    }
                }
                System.out.println("Semua Vertex:");
                int l=0;
                
                LinkedList <Vertex> V= new LinkedList<Vertex>();
                Vertex ve;
                for(i=0;i<B.size();i++){
                    for(int j=i+1;j<B.size();j++){
                        if ((cekIntersection(B.get(i).getLine(),B.get(j).getLine()))==true){
                            ve=new Vertex(B.get(i),B.get(j));
                            V.add(ve);
                            Vertex vg=V.get(l);
                            System.out.println(vg.getVertex()+", Garis Bisector ["+vg.getBisec()+":"+vg.B+"]");
                            l++;
                    
                        }
                    }    
                }
                //Merge Masih bug
                /*for (i=0; i<V.size();i++){
                    for(int j=0;j<V.size();j++){
                      if(i!=j){
                        if ((V.get(i).getPoint().x==V.get(j).getPoint().x)&&(V.get(i).getPoint().y==V.get(j).getPoint().y)){
                            Set<Bisector> set=new LinkedHashSet<>(V.get(i).Bisector());
                            set.addAll(V.get(j).Bisector());
                            ArrayList<Bisector> combo=new ArrayList<>(set);
                            

                            V.get(i).addAllBisector(combo);
                            V.remove(j);
                        }
                      } 
                    }     
                }
                System.out.println("a");
                for (i=0;i<V.size();i++){
                    System.out.println(V.get(i).getVertex()+";"+V.get(i).getBisec());
                }*/
                System.out.println("Filter");
                
                
                double[] dist=new double[P.size()];
                
                
                for (i=0;i<V.size();i++){
                    //hitung jarak
                    for (int j=0;j<P.size();j++){
                        dist[j]=getJarak(V.get(i).getPoint(),P.get(j));
                    }
                    //sorting
                    Point temp;
                    double jaraktemp;
                    for (k=0;k<P.size();k++){
                        for(l=k+1;l<P.size();l++){
                            if(dist[k]>dist[l]){
                                temp=P.get(k);
                                P.set(k, P.get(l));
                                P.set(l, temp);
                                
                                jaraktemp=dist[k];
                                dist[k]=dist[l];
                                dist[l]=jaraktemp;
                            }
                        }                            
                    }
                    //seleksi
                    if ((dist[0]==dist[2])){
                            V.get(i).setUse(true);
                            V.get(i).addNearestPoint(P.get(0),P.get(1),P.get(2));
                    }
                    
                    //output
                    if (V.get(i).getUse()==true){
                        System.out.println(V.get(i).getVertex()+":"+V.get(i).Nearest);
                    }
                     
                }
                
                
                
   
                
//untuk menginput koordnat random
/*                Point Pc= new Point(xc,yc);
                System.out.println("titik yang ditentukan:"+xc+";"+yc);                
                //untuk memanggil file .csv ke java
                br=new BufferedReader(new FileReader("src/tugas/source/random100k.csv"));
                Point[] P= new Point[100000];
                //untuk array of point
                   while((line=br.readLine())!=null){
                       String[] koordinat=line.split(";");
                       double x=Double.parseDouble(koordinat[0]);
                       double y=Double.parseDouble(koordinat[1]);
                       //menginput masing masing koordinat ke dalam array
                       P[i]= new Point(x,y);
                       //untuk menghitung jarak P yang diinput random dan P yang sudah ada
                       P[i].setJarak(P[i].hitJarak(Pc, P[i]));
                       //pencarian titik terdekat
                       if (temp>P[i].getJarak()){
                           temp=P[i].getJarak();
                           min=i;
                           
                       }
                       //pencarian titik terjauh
                          if (temp2<P[i].getJarak()){
                           temp2=P[i].getJarak();
                           max=i;
                          }
                          i++;
                       
                 
                   }
                   System.out.println("titik terdekat "+P[min].getKoordinat());
                   System.out.println("titik terjauh "+P[max].getKoordinat());
                   //penampilan waktu proses program
                   double finish = System.currentTimeMillis();
            System.out.println("waktu pemrosesan program: "+(finish-start)+" milisecond");
*/ 
        
        
        }       
}

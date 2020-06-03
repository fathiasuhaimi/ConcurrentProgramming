/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreadgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author HP
 */
public class MultiThreadGame {
public static List <coordinate> points;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MultiThreadGame obj = new MultiThreadGame();
            Scanner scanner = new Scanner(System.in);
        
             System.out.println("Please enter number of threads : ");
             int t = scanner.nextInt();
             
             System.out.println("Please enter number of random points (Must be higher than number of threads) : ");
             int n = scanner.nextInt();
             
             while (n < t){
                 System.out.println("Please enter a number higher than number of threads");
                 n = scanner.nextInt();
             }
             
             System.out.println("Please enter number of seconds : ");
             int m = scanner.nextInt();
             
              MultiThreadGame.points = createPoints(n);
              System.out.println();
              //System.out.println("coordinates" + obj.selectPoints(points, 2)); 
              selectPoints(points,2);
              //test(points);
    }
    
    public static List<coordinate> createPoints (int n){
                int minx , miny;
                minx = miny = 0;
                int maxx, maxy ;
                maxx = maxy = 1000;
                
            List<coordinate> example = new ArrayList<coordinate>();
            for (int i = 0; i<n; i++){
                
                example.add(new coordinate(ThreadLocalRandom.current().nextDouble(minx, maxx), ThreadLocalRandom.current().nextDouble(miny, maxy)));
                
            }
            
            System.out.println("The random coordinates are: ");
            for (coordinate i : example){
                 System.out.println(i);
            }
            
            return example;
    
    }
    
    public static List<coordinate> selectPoints (List<coordinate> list, int num){
        Random rand = new Random();
        
        List<coordinate> newList = new ArrayList<coordinate>();
        
        for (int i = 0; i < num; i++){
            int randomIndex = rand.nextInt(list.size()); 
            newList.add(list.get(randomIndex)); 
            list.remove(randomIndex); 
        }
        System.out.println("Edges are formed between these coordinates : ");
            for (coordinate i : newList){
                  System.out.println("Point : " + i.toString() + " ");
            }
            
            
         return newList; 
}
    public static void test (List<coordinate> name){
        System.out.println("Test : ");
            for (coordinate i : name){
                System.out.println(i);
             }
    }
    
}

class coordinate {

    public double x,y;
   
    public coordinate (double x, double y){
        this.x = x;
        this.y = y;
    }
    
    @Override
   public String toString() {
        return Double.toString(x) + " , " +Double.toString(y);
       
   }
  
  
 // Point location = new Point(randomx, randomy);
}

class paircoordinate {

    public double x1,x2,y1,y2;
    
    public paircoordinate (double x1, double y1, double x2, double y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        
    }
    
    @Override
   public String toString() {
        return "First : " + Double.toString(x1) + " , " +Double.toString(y1) + 
                "Second : " + Double.toString(x2) + " , " +Double.toString(y2);
       
   }
}

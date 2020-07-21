/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinder;

import java.util.ArrayList;
/**
 *
 * @author jenandblake
 */
public class PathFinder {

    static ArrayList<Integer> paths = new ArrayList<Integer>();
    //static ArrayList<Integer> temporary = new ArrayList<Integer>();
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0, 0}, 
                       {0, 1, 1, 0},
                       {0, 1, 1, 0},
                       {0, 0, 0, 0},
                       {1, 2, 1, 1}};
        
        int[] Pos = {1,0};
        
        paths.add(1);
        
        check(Pos, arr, 1);
        for(int k = 1; k < paths.size() - 1; k+=2){
            System.out.println(paths.get(k+1) + ", " + paths.get(k));
        }
        //System.out.println(paths.get(1).get(0));
        //System.out.println(paths.size());
        
    }
    
    private static void check(int[] Pos, int[][] array, int iterations){
        
        int[] temp = new int[2];
        int[][] arrays = array.clone();
        int i = 0;
        
        paths.add((iterations*2) - 1, Pos[0]);
        paths.add(iterations*2, Pos[1]);
        
            
        if(arrays[Pos[1]][Pos[0]] == 2){
            System.out.println("end");
            //paths.clear();
            paths.add(-1);
            paths.add(-1);
        }
        
        if(arrays[Pos[1]][Pos[0]] != 2){
            arrays[Pos[1]][Pos[0]] = 1;
        }
        
        if(Pos[0] + 1 <= arrays[Pos[1]].length - 1 && arrays[Pos[1]][Pos[0] + 1] != 1){
            i = 1;
            temp[1] = Pos[1];
            temp[0] = Pos[0] + 1;
            System.out.println("Right " + iterations);
            
            check(temp, arrays, iterations + 1);
        }
        
        if(Pos[0] - 1 >= 0 && arrays[Pos[1]][Pos[0]-1] != 1){
            i = 1;
            temp[1] = Pos[1];
            temp[0] = Pos[0] - 1;
            System.out.println("Left " + iterations);
            
            check(temp, arrays, iterations + 1);
        }
                        
        if(Pos[1] + 1 <= arrays.length-1 && arrays[Pos[1] + 1][Pos[0]] != 1){
            i = 1;
            temp[0] = Pos[0];
            temp[1] = Pos[1] + 1;
            System.out.println("Down " + iterations);
            
            check(temp, arrays, iterations + 1);
        }
        
        if(Pos[1] - 1 >= 0 && arrays[Pos[1]-1][Pos[0]] != 1){
            i = 1;
            temp[0] = Pos[0];
            temp[1] = Pos[1] - 1;
            System.out.println("Up " + iterations);
            
            check(temp, arrays, iterations + 1);
            
        }
        
        arrays[Pos[1]][Pos[0]] = 0;
        
        if(i == 0 && arrays[Pos[1]][Pos[0]] != 2){
        }
    }
    
    
    public static ArrayList SAD(ArrayList list){
        int i = 0;
        for(i = list.size()-1; i >= 0; i--){
            if((int)list.get(i) == -1){
                i++;
                System.out.println("in");
                break;
            }
            System.out.println(i);
        }
        while(i < list.size()-1){
            list.remove(i);
            i++;
        }
        return list;
    }
    
}

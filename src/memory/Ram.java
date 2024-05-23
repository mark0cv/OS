package memory;

import java.net.Socket;
import java.util.Arrays;

public class Ram {
    private static final int TOTAL_CAPACITY=128;
    private static final int EMPTY=-1;
    private static int[] ram=new int[TOTAL_CAPACITY];
    private static int occupied=0;

    private static void initialize(){
        Arrays.fill(ram,EMPTY);
    }

    public static boolean writeAtPosition(int index,int value){
        if(isOccupied(index))
            return false;
        ram[index]=value;
        occupied++;
        return true;
    }
    public static boolean removeSequence(int start,int size){
        if(size+start>TOTAL_CAPACITY)
            return false;

        long occupiedCellCount=Arrays.stream(ram,start,start+size)
                .filter(u->u!=EMPTY)
                .count();
        if(occupiedCellCount==0){
            Arrays.fill(ram,start,start+start,EMPTY);
            occupied-=size;
            return true;
        }
        return false;
    }
    public static boolean writeSequence(int start,int[] data){
        if(start+data.length>TOTAL_CAPACITY)
            return false;
        for (int i =start; i <data.length +start; i++) {
            if(!isOccupied(i)){
                writeAtPosition(i,data[i-start]);
            }else{
                return false;
            }
        }
        return true;
    }
    public static int readAtPosition(int i){
        return ram[i];
    }
    public static boolean clearPosition(int i){
        if(isOccupied(i)){
            ram[i]=EMPTY;
            occupied--;
            return true;
        }
        return false;
    }
    public static void printRamMemory(){
        if(occupied==0){
            System.out.println("Ram memory isn't occupied.");
        }else{
            System.out.println("Ram memory:");
            StringBuilder sb=new StringBuilder();
            for (int i = 0; i < TOTAL_CAPACITY; i++) {
                sb.append(ram[i]).append("\t");
                if((i+1)%10==0){
                    sb.append("\n");
                }
            }
            System.out.println(sb.toString());
        }
    }
    public static boolean isOccupied(int i){return ram[i]!=EMPTY;}
    public static int getOccupiedSpace(){
        return occupied;
    }
    public static int getFreeSpace(){
        return TOTAL_CAPACITY-occupied;
    }
    public static int getTotalCapacity(){
        return TOTAL_CAPACITY;
    }
}

package memory;

import java.util.ArrayList;

public class PartitionMemory {
    private int[] data;
    private int positionInMemory=-1;
    private int size;
    private Process process;
    private static ArrayList<PartitionMemory>allPartitions=new ArrayList<>();
    private static final int PARTITION_SIZE=64;
    private static final int TOTAL_PARTITIONS=10;

    static {
        for (int i = 0; i < TOTAL_PARTITIONS; i++) {
            allPartitions.add(new PartitionMemory(PARTITION_SIZE));
        }
    }
    private PartitionMemory(int size){
        this.size=size;
        this.data=new int[size];
    }


    public boolean isFree(){
        return process==null;
    }
    public int getSize(){
        return size;
    }

    public Process getProcess() {
        return process;
    }

    public int[] getData() {
        return data;
    }

    public int getPositionInMemory() {
        return positionInMemory;
    }

    public void setPositionInMemory(int positionInMemory) {
        this.positionInMemory = positionInMemory;
    }
}

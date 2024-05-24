package memory;

import osKernel.SystemProcess;

import java.util.ArrayList;

public class PartitionMemory {
    private int[] data;
    private int positionInMemory=-1;
    private int size;
    private SystemProcess process;
    private static ArrayList<PartitionMemory>allPartitions=new ArrayList<>();
    private static final int PARTITION_SIZE=64;
    private static final int TOTAL_PARTITIONS=10;

    public PartitionMemory(SystemProcess process){
        this.process=process;
        size=process.getInstructions().size();
        data=new int[size];
        for (int i = 0; i < size; i++) {
            String temp=process.getInstructions().get(i);
            data[i]=Integer.parseInt(temp,2);
        }
        allPartitions.add(this);

    }
    public PartitionMemory(int data[]){this.data=data;}

    public static void initialize(){allPartitions=new ArrayList<>();}

    public static PartitionMemory getPartitionByAddress(int address){
        for (PartitionMemory partitionMemory:allPartitions){
            if(partitionMemory.getPositionInMemory()==address)
                return partitionMemory;
        }
        return null;
    }
    public static PartitionMemory getPartitionByProcess(SystemProcess process){
        for (PartitionMemory partitionMemory:allPartitions){
            if(partitionMemory.getProcess().equals(process))
                return partitionMemory;
        }
        return null;
    }

    public int getSize(){
        return size;
    }

    public SystemProcess getProcess() {
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

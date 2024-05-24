package memory;

import java.util.ArrayList;

public class SecondaryMemory {

    private static int size;
    private static Block[] blocks;
    private static int numberOfBlocks;
    public static ArrayList<MemoryFile>files;

    public SecondaryMemory(){
        size=2048;
        numberOfBlocks=size/Block.getSIZE();
        blocks=new Block[numberOfBlocks];
        for (int i = 0; i <numberOfBlocks; i++) {
            Block newBlock=new Block(i);
            blocks[i]=newBlock;
        }
        files=new ArrayList<>();
    }
    public void storeFile(MemoryFile file){
        int remainingBytes=file.getSize()%Block.getSIZE();

        int numOfBlocks;

        if(remainingBytes==0){
            numOfBlocks=file.getSize()/Block.getSIZE();
        }else{
            numOfBlocks=(file.getSize()-remainingBytes+Block.getSIZE())/Block.getSIZE();
        }
        if(numberOfFreeBlocks()>=numOfBlocks){
            int counter=0;
            Pointer first=null;
            for (int i = 0; i < numOfBlocks; i++) {
                if(!blocks[i].isAllocated()){
                    blocks[i].setAllocated(true);
                    blocks[i].setContent(MemoryFile.getPartialContent(counter));
                    if(counter==0){
                        first=new Pointer(blocks[i]);
                        file.setStart(first);
                        counter++;
                    }else{
                        Pointer secound=new Pointer(blocks[i]);
                        first.next=secound;
                        first=secound;
                        counter++;
                        if(counter==numOfBlocks){
                            file.setLength(counter);
                            files.add(file);
                            return;
                        }
                    }
                }
            }
        }else{
            System.out.println("No enough free space...");
        }
    }

    public String readFile(MemoryFile file){
        String read="";
        Pointer pointer=file.getStart();
        byte[] content=pointer.block.getContent();
        for (byte b:content){
            read+=(char)b;
        }
        while (pointer.next!=null){
            pointer=pointer.next;
            content=pointer.block.getContent();
            for(byte b:content)
                read+=(char)b;
        }
        return read;
    }
    public void deleteFile(MemoryFile file){
        if(!files.contains(file)){
            System.out.println("File is not in the secondary memory.");
        }else{
            Pointer pointer=file.getStart();
            file.setStart(null);
            pointer.block.setAllocated(false);
            pointer.block.setContent(null);
            while (pointer.next!=null){
                Pointer temp=pointer;
                pointer=pointer.next;
                temp.next=null;
                pointer.block.setAllocated(false);
            }
        }
        files.remove(file);
    }

    private static int numberOfFreeBlocks(){
        int counter=0;
        for (int i = 0; i < numberOfBlocks; i++) {
            if(!blocks[i].isAllocated())
                counter++;
        }
        return counter;
    }
    protected static class Pointer{
        private Block block;
        private Pointer next;

        private Pointer(Block block){
            this.block=block;
            this.next=null;
        }
        public String toString(){
            String s="";
            s+=block;
            return s;
        }
    }
}

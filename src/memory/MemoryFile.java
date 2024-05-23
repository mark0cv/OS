package memory;

import memory.Disk.Pointer;
public class MemoryFile {
    private String name;
    private Pointer start;
    private int size; //size of file in secondary memory(disk)

    private int length; //number of blocks
    private static byte[] fileContent=new byte[0];

    public MemoryFile(String name,byte[] content){
        this.name=name;
        fileContent=content;
        size=fileContent.length;
    }
    public static byte[] getPartialContent(int index){
        byte[] part=new byte[Block.getSIZE()];

        int counter=0;
        for (int i=index*Block.getSIZE(); i< fileContent.length; i++){
            part[counter]=fileContent[i];
            if(counter==Block.getSIZE()-1)
                break;
            counter++;
        }
        while (counter<Block.getSIZE()-1){
            byte[] b=" ".getBytes();
            part[counter]=b[0];
            counter++;
        }

        return part;
    }

    public Pointer getStart() {
        return start;
    }

    public void setStart(Pointer start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static byte[] getFileContent() {
        return fileContent;
    }

    public static void setFileContent(byte[] fileContent) {
        MemoryFile.fileContent = fileContent;
    }
}

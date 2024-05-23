package memory;

public class Block {
    private static final int SIZE=4;
    private byte[] content=new byte[SIZE];
    private final int adress;
    private boolean allocated;

    public Block(int adress){
        this.adress=adress;
    }

    public byte[] getContent() {
        return content;
    }

    public static int getSIZE() {
        return SIZE;
    }

    public int getAdress() {
        return adress;
    }

    public boolean isAllocated() {
        return allocated;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public void setAllocated(boolean allocated) {
        this.allocated = allocated;
    }

    @Override
    public String toString() {
        return "Block adress: "+adress+" allocated: "+isAllocated();
    }
}

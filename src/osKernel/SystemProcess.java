package osKernel;

import memory.PartitionMemory;

import java.nio.file.Path;
import java.util.ArrayList;

public class SystemProcess {
    private int id;
    private String name;
    private Path filePath;
    private ExecutionState state;
    private ArrayList<String>instructions;
    private int size;
    private int startAdress;
    private int pc=-1;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Path getFilePath() {
        return filePath;
    }
}

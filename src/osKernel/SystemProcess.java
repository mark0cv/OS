package systemController;

public class SystemProcess {
    private String name;
    private int id;
    private ExecutionState state;
    private int counter;

    public SystemProcess(String name,int id,ExecutionState state, int counter){
        this.name=name;
        this.id=id;
        this.state=state;
        this.counter=counter;
    }

}

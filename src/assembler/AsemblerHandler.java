package assembler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AsemblerHandler {

    public static void readInstructions(String filePath) {

        List<String> asmFileLines = null;

        try {
            asmFileLines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            System.err.println("Error reading ASM file: " + e.getMessage());
            System.exit(1);
        }

        for (String line : asmFileLines) {
            executeInstruction(line);
        }
    }

    private static void executeInstruction(String instruction) {
        String[] arr = instruction.split(" ");
        OperationType operation = OperationType.fromString(arr[0]);

        switch (operation) {
            case ADD:
                Operations.addValues();
                break;
            case SUBTRACT:
                Operations.subtractValues();
                break;
            case MULTIPLY:
                Operations.multiplyValues();
                break;
            case DIVIDE:
                Operations.divideValues();
                break;
            case PUSH:
                Operations.pushToStack(arr[1]);
                break;
            case POP:
                String val = Operations.popFromStack();
                System.out.println(val);
                break;
            case INCREMENT:
                Operations.incrementValue();
                break;
            case DECREMENT:
                Operations.decrementValue();
                break;
        }
    }
}

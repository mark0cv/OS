package fileSystem;

import javafx.scene.control.TreeItem;
import operatingSystem.OS;
import osKernel.SystemProcess;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSystem {
    private static File rootFolder;
    private static File currentFolder;
    private TreeItem<File>treeItem;

    public FileSystem(File path){
        rootFolder=path;
        currentFolder=rootFolder;
        treeItem=new TreeItem<>(rootFolder);
        createTree(treeItem);
    }
    public void createTree(TreeItem<File> rootItem){
        try (DirectoryStream<Path>directoryStream= Files.newDirectoryStream(rootItem.getValue().toPath())){
            for(Path path:directoryStream){
                TreeItem<File> newItem=new TreeItem<>(path.toFile());
                newItem.setExpanded(false);
                rootItem.getChildren().add(newItem);
                if(Files.isDirectory(path)){
                    createTree(newItem);
                }else{
                    //todo ucitaj fajlove u sekundarnu memoriju, disk.
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public TreeItem<File> getTreeItem() {
        treeItem=new TreeItem<>(currentFolder);
        createTree(treeItem);
        return treeItem;
    }
    public static void listFiles(){
        System.out.println("Content of: "+currentFolder.getName());
        System.out.println("Type\tName\t\t\tSize");
        for (TreeItem<File>file:OS.tree.getTreeItem().getChildren()){
            byte[] contentOfFile=null;
            try {
                if(!file.getValue().isDirectory())
                    contentOfFile=Files.readAllBytes(file.getValue().toPath());
            }catch (IOException e){
                e.printStackTrace();
            }
            if(file.getValue().isDirectory()){
                System.out.println("Folder \t"+file.getValue().getName());
            }else{
                System.out.print("File \t"+file.getValue().getName());
                if(file.getValue().getName().length()<16){
                    System.out.print("\t\t"+contentOfFile.length+" B");
                }else{
                    System.out.print("\t"+contentOfFile.length+" B");
                }
            }
        }
    }
    public static void makeDirectory(String directory){
        File folder=new File(currentFolder+"\\"+directory);
        if(!folder.exists()){
            folder.mkdir();
        }
    }
    public static void deleteDirectory(String directory){
        for(TreeItem<File>file:OS.tree.getTreeItem().getChildren()){
            if(file.getValue().getName().equals(directory) && file.getValue().isDirectory())
                file.getValue().delete();
        }
    }
    public static void createFile(SystemProcess process){
        String name=process.getName().substring(0,process.getName().indexOf('.'))+"_output";
        File newFile=new File(process.getFilePath().getParent()+"\\"+name+".txt");
        try {
            newFile.createNewFile();
            FileWriter fw=new FileWriter(newFile);
            fw.write("Tezultat izvrsavanja: ");
            fw.close();
        }catch (IOException e){
            System.out.println("Error while creating file");
        }
    }
    public static void deleteFile(String name){
        for (TreeItem<File>file: OS.tree.getTreeItem().getChildren()){
            if(file.getValue().getName().equals(name) && !file.getValue().isDirectory()){
                file.getValue().delete();
            }
            //todo if(OS.memory.contains(name))
        }
    }

    public static File getCurrentFolder() {
        return currentFolder;
    }
    public static void renameDirectory(String oldName,String newName){
        for(TreeItem<File>file:OS.tree.getTreeItem().getChildren()){
            if(file.getValue().getName().equals(oldName) && file.getValue().isDirectory())
                file.getValue().renameTo(new File(currentFolder.getAbsolutePath()+"\\"+newName));
        }
    }
}

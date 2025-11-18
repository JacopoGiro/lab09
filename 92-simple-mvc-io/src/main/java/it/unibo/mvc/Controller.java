package it.unibo.mvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import javax.swing.JOptionPane;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    File currentFile = new File(System.getProperty("user.dir") + File.separator + "output.txt");

    public void setFile(final File file){
        currentFile = file;
    }

    public File getFile(){
        return currentFile;
    }

    public String getPath(){
        return currentFile.getAbsolutePath();
    }

    public void writeString(final String str){
        try(final PrintStream ps = new PrintStream(currentFile)){
            ps.print(str);
        }catch(FileNotFoundException e){
            e.printStackTrace(); // NOPMD
        }
    }
}

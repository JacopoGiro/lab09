package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public final class Controller {
    private File currentFile = new File(System.getProperty("user.dir") + File.separator + "output.txt");

    /**
     * set the current file to the new one passed.
     * 
     * @param file the new file is to be set
     */
    public void setFile(final File file) {
        currentFile = file;
    }

    /**
     * getter for the current file.
     * 
     * @return the current file
     */
    public File getFile() {
        return currentFile;
    }

    /**
     * get the absolute path of the current file.
     * 
     * @return the absolute path of the current file
     */
    public String getPath() {
        return currentFile.getAbsolutePath();
    }

    /**
     * write the passed string onto the current file.
     * 
     * @param str the string that is to be written on the current file
     */
    public void writeString(final String str) {
        try (PrintStream ps = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            ps.print(str);
        } catch (final IOException e) {
            e.printStackTrace(); // NOPMD
        }
    }
}

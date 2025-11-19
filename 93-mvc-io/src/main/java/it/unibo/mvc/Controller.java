package it.unibo.mvc;

import java.util.List;

/**
 * controller interface.
 */
public interface Controller {
    /**
     * sets the current String to the new one passed.
     * 
     * @param str the String that is to be set as current String
     */
    void setString(String str);

    /**
     * simple getter for the current String.
     * 
     * @return the current String
     */
    String getString();

    /**
     * getter for the history of the past printed strings.
     * 
     * @return the history of the printed strings in the form of a List<String>
     */
    List<String> getHistory();

    /**
     * print the current string and saves it in the history.
     * 
     * @throws IllegalStateException in case the current string is unset
     */
    void printString();
}

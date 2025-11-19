package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * simple implementation of the Controller class.
 */
public final class SimpleController implements Controller {

    private String currentString;
    private final List<String> historyStrings = new ArrayList<>();

    @Override
    public void setString(final String str) {
        if (str == null) {
            return;
        }
        currentString = str;
    }

    @Override
    public String getString() {
        return currentString;
    }

    @Override
    public List<String> getHistory() {
        return List.copyOf(historyStrings);
    }

    @Override
    public void printString() {
        if (currentString == null) {
            throw new IllegalStateException(
                "you cannot call the printString method until you have set currentString"
            );
        }
        historyStrings.add(currentString);
        System.out.println(currentString); // NOPMD
    }
}

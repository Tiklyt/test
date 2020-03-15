package esi.g52816.model;

/**
 *
 * @author user
 */
public interface Command {

    /**
     * execute the command
     */
    void execute();

    /**
     * unexecute the command;
     */
    void unexecute();
    
    
    
    boolean  canExecute();
}

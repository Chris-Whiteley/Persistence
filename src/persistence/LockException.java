/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

/**
 *
 * @author Chris Whiteley
 */
public class LockException extends RuntimeException {

    public LockException(String msg) {
        super(msg);
    }
}

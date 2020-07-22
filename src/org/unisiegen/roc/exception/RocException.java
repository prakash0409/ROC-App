/* 
 * Institute of Knowledge Based Systems and Knowledge Management,
 * Department of Electrical Engineering and Computer Science,
 * Faculty of Science and Technology, University of Siegen, Germany
 * Winter Semester 2015/16  © 2015-2016 | All right reserved for University of Siegen
 */
package org.unisiegen.roc.exception;

/**
 * @author RebellionPC
 *
 */
public class RocException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public RocException() {
    }

    /**
     * 
     * @param message 
     */
    public RocException(String message) {
        super(message);
    }

    /**
     * 
     * @param throwable 
     */
    public RocException(Throwable throwable) {
        super(throwable);
    }

    /**
     * 
     * @param message
     * @param throwable 
     */
    public RocException(String message, Throwable throwable) {
        super(message, throwable);
    }

}

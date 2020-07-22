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
public class DaoException extends RocException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public DaoException() {
    }

    /**
     * @param message
     * @param throwable
     */
    public DaoException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * @param message
     */
    public DaoException(String message) {
        super(message);
    }

    /**
     * @param throwable
     */
    public DaoException(Throwable throwable) {
        super(throwable);
    }

}

/**
 *
 */
package org.unisiegen.roc.dao;

import java.util.ResourceBundle;

import org.unisiegen.roc.exception.DaoException;

/**
 * @author RebellionPC
 *
 */
public class DaoFactory {

    private static String rocDao;

    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("org.unisiegen.roc.dao.DaoConfig");
        rocDao = resourceBundle.getString("rocDao");
    }

    public static RocDao getRocDaoInstance() throws DaoException {
        try {
            return (RocDao) Class.forName(rocDao).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new DaoException(e.getMessage(), e);
        }
    }
}

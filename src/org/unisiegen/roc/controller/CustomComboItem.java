/* 
 * Institute of Knowledge Based Systems and Knowledge Management,
 * Department of Electrical Engineering and Computer Science,
 * Faculty of Science and Technology, University of Siegen, Germany
 * Winter Semester 2015/16  © 2015-2016 | All right reserved for University of Siegen
 */
package org.unisiegen.roc.controller;

import java.util.Objects;

/**
 * Class for proper configuration of drop down items.
 * @author Pratik
 */
public class CustomComboItem {

    private String key;
    private int value;

    public CustomComboItem(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.key);
        hash = 67 * hash + this.value;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CustomComboItem other = (CustomComboItem) obj;
        if (!Objects.equals(this.key, other.key)) {
            return false;
        }
        if (this.value != other.value) {
            return false;
        }
        return true;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.key;
    }

}

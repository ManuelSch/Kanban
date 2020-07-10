package com.manuelsch.simplekanban.utils;

import java.util.UUID;

public class Validation {

    public static boolean isUUID(String string) {
        try {
            UUID.fromString(string);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}

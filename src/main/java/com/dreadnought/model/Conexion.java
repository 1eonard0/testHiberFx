
package com.dreadnought.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Conexion {
    private static final String PERSISTENCE_UNIT_NAME = "com.dreadnought_testHiberFx_jar_1.0-SNAPSHOTPU";
    private static EntityManagerFactory emf;
    
    public static EntityManagerFactory getEntityManagerFactory(){
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return emf;
    }
}


package com.dreadnought.testhiberfx;

import com.dreadnought.model.Conexion;
import com.dreadnought.model.Person;
import com.dreadnought.model.jpaController.PersonJpaController;
import com.dreadnought.model.jpaController.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PersonController {
    PersonJpaController controller = new PersonJpaController(Conexion.getEntityManagerFactory());
    
    public void crearPerson(Person person){
        controller.create(person);
    }
    
    public List<Person> getPeople(){
        return controller.findPersonEntities();
    }
    
    public Person getPerson(String name){
        List<Person> people = controller.findPersonEntities();
        for (Person person : people) {
            if (person.getName().toLowerCase().equals(name.toLowerCase())) {
                return person;
            }
        }
        return null;
    }
    
    public Person deletePerson(String name){
        Person p = getPerson(name);
        if (p != null) {
            try {
                controller.destroy(p.getId());
                return p;
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}

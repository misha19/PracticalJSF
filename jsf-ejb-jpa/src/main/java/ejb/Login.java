package ejb;

import jpa.Person;
import jpa.Teacher;
import jsf.PersonBean;

import javax.ejb.EJB;

public class Login {

    public Login(){

    }
    String email;
    Teacher teacher;
    Student student;
    Admin  admin;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String processLogin(){
        String navigation = null;
        teacher= (Teacher) Teacher.findTeacher(email);

        if(teacher !=null) {
            navigation = ""
        }
    }
}

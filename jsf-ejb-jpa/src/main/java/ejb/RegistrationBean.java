package ejb;

import jpa.Teacher;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.sql.Timestamp;

@Stateful(name = "Registration" , mappedName = "ServiceIntegration-EJB-Registration")
public class RegistrationBean implements RegistrationLocal{
    @PersistenceContext(unitName = "CourseAppUnit-JTA",
    type = PersistenceContextType.EXTENDED)
    private EntityManager em;
    private Teacher teacher;

    @EJB
    private TeacherFacadeBean teacherFacade;
    @EJB
    private RegisterProcessFacadeBean registerProcessFacade;
    public Teacher getTeacher(){
        return teacher;
    }

    public void addCourseItem(Course course, int quantity){
        RegisterItem registerItem= new RegisterItem(quantity, course);
        teacher.addRegisterItem(registerItem);
    }

    public void addCourseItem(Course course){
        RegisterItem registerItem = new RegisterItem();
        registerItem.setQuantity(20);
        course = em.find(Course.class, course.getId());
        registerItem.setCourse(course);
        registerItem.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        teacher.addRegisterItem(registerItem);
    }

    public void removeCourseItem(RegisterItem registerItem){
        teacher.removeRegisterItem(registerItem)
    }
}

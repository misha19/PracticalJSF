/*
package ejb;

import jpa.Teacher;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.CountDownLatch;

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
        teacher.removeRegisterItem(registerItem);
    }

    public void addRegisterItemsTemporarily(){
        List<Teacher> teachers = em.createNamedQuery("findAllCourse").getResultList();
        for(Teacher teacher:teachers){
            final RegisterItem registerItem= new RegisterItem();
            cartItem.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            RegisterItem.setQuantity(20);
            RegisterItem.addCartItem(cartItem);

        }
    }
    public Teacher findTeacher(String email){
        teacher = teacherFacade.getTeacherFindByEmail(email);
        return teacher;
    }

    public String sendOrderToOPC(){
        String result= null;
        try{
            orderProcessFacade.processOrder(teacher);
            result= "Your order has been submitted- You will be notified about the status via the email";


        }catch (Exception ex){
            ex.printStackTrace();
            result= "An error occured while processing your order. Please contact the school registration unit.";
        }
        return result;

    }

    public <T> T persistEntity(T entity){
        em.persist(entity);
        return entity;
    }

    public <T> T mergeEntity(T entity){
        return em.merge(entity);

    }

    public void removeRegisterItem(RegisterItem registerItem){
        registerItem = em.find(RegisterItem.class, registerItem.getId());
        em.remove(registerItem);
    }

    public void removeCourse(Course course){
        course= em.find(Course.class, course.getId());
        em.remove(course);
    }
    */
/**
     * select object from Course
     *//*


    public List<Course> getCourseFindAll(){
        return em.createNamedQuery("Course.findAll", Course.class).getResultList();
    }

    public List<Course> getCourseFindByYear(Integer year){
        return em.createNamedQuery("Course.findByYear", Course.class).setParameter("year",year).getResultList();
    }

    public List<Course> getCourseFindByCourseName(String courseName){
        return em.createNamedQuery("Course.findByCourseName",Course.class).setParameter("courseName", courseName).getResultList();

    }


}
*/

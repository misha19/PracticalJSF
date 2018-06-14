package ejb;

import jpa.Teacher;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless(name = "TeacherFacade", mappedName = "ServiceIntegration-ejb-TeacherFacade")
public class TeacherFacadeBean {
    
    @PersistenceContext(unitName = "Persistence-unit")
    private EntityManager em;
    
    public <T> T persistEntity(T entity){
        em.persist(entity);
        return entity;
    }
    
    public <T> T mergeEntity(T entity){
        return em.merge(entity);
    }
    
    public void removeTeacher(Teacher teacher){
        teacher = em.find(Teacher.class,teacher.getTeacherID());
        em.remove(teacher);
    }

    /**
     * <code>select o from Teacher o</code>
     */
    
    public List<Teacher> getTeacherFindAll(){
        return em.createNamedQuery("Teacher.findAll", Teacher.class).getResultList();
    }
    
    public Teacher getTeacherFindById(Integer id){
        return em.find(Teacher.class,id);
    }

    /**
     * <code>select o from Teacher o where o.email= :email</code>
     */
    
    public Teacher getTeacherFindByEmail(String email){
        return em.createNamedQuery("Teacher.findByEmail", Teacher.class).
                setParameter("email",email).
                getSingleResult();
    }
    
    public Teacher registerTeacher(Teacher teacher){
        return persistEntity(teacher);
    }



}

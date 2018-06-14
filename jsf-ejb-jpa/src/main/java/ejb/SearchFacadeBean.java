package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless(name = "SearchFacade", mappedName = "ServiceIntegration-EJB-SearchFacade")
public class SearchFacadeBean {

    @PersistenceContext(unitName = "CourseAppUnit-JTA")
    private EntityManager em;

    public Object queryByRange(String jpqlStmt, int firstResult, int maxResults){

        Query query = em.createQuery(jpqlStmt);
        if(firstResult > 0 ){
            query = query.setFirstResult(firstResult);

        }
        if(maxResults > 0 ) {
            query = query.setMaxResults(maxResults);
        }

        return query.getResultList();


    }

    public <T> T persistEntity(T entity){
        em.persist(entity);
        return entity;
    }

    public <T> T mergeEntity(T entity){
        return em.merge(entity);
    }

    public void removeCourse(Course course){
        course = em.find(Course.class, Course.getId());
        em.remove(Course);
    }

    /**
     * select object from Course
     */

    public List<Course> getCourseFindAll() {
        return em.createNamedQuery("Course.findAll" , Course.class).getResultList();
    }

    public List<Course> getCourseFindByYear(Integer year){
        return em.createNamedQuery("Course.findByYear", Course.class).setParameter("year", year).getResultList();
    }

     public List<Course> getCourseFindBySubject(String name) {
        return em.createNamedQuery("Course.findbySubject", Course.class).setParameter("subject", subject).getResultList();


     }




}

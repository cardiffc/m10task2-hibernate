import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session skillboxDbSession =  getSession();
        CriteriaBuilder builder = skillboxDbSession.getCriteriaBuilder();

        //В отдельном методе получаем все покупки
        List<Purchase> purchaseList = getPurchaselist(builder,skillboxDbSession);

        Transaction fillNewTable = skillboxDbSession.beginTransaction();

        purchaseList.forEach(purchase -> {
            // Для каждой покупки получаем ID студента

            CriteriaQuery<Student> queryStudent = builder.createQuery(Student.class);
            Root<Student> studentRoot = queryStudent.from(Student.class);
            queryStudent.select(studentRoot).where(builder.equal(studentRoot.get("name"), purchase.getStudentName()));
            Student student = skillboxDbSession.createQuery(queryStudent).getSingleResult();
            int studentId = student.getId();

            // Для каждой покупки получаем ID курса

            CriteriaQuery<Course> queryCourse = builder.createQuery(Course.class);
            Root<Course> courseRoot = queryCourse.from(Course.class);
            queryCourse.select(courseRoot).where(builder.equal(courseRoot.get("name"), purchase.getCourseName()));
            Course course = skillboxDbSession.createQuery(queryCourse).getSingleResult();
            int courseId = course.getId();

            StudentsCourses currentRecord = new StudentsCourses();
            currentRecord.setStudentId(studentId);
            currentRecord.setCourseId(courseId);
            skillboxDbSession.save(currentRecord);
        });
        fillNewTable.commit();
        skillboxDbSession.close();
    }
    private static Session getSession ()
    {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        return session;
    }
    private static List<Purchase> getPurchaselist (CriteriaBuilder builder, Session session)
    {
        CriteriaQuery<Purchase> query = builder.createQuery(Purchase.class);
        Root<Purchase> root = query.from(Purchase.class);
        query.select(root);
        List<Purchase> purchaseList = session.createQuery(query).getResultList();
        return purchaseList;
    }
}

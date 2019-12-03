import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {

        Session skillboxDbSession =  getSession();

        Course course = skillboxDbSession.get(Course.class, 1);
        System.out.println(course.getName());

        Teacher teacher = skillboxDbSession.get(Teacher.class, 1);

        System.out.println("Teacher name: " + teacher.getName() + " Teacher age: " + teacher.getAge()
                    + " Teacher salary: " + teacher.getSalary());

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

}

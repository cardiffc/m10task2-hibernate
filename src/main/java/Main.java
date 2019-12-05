import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session skillboxDbSession =  getSession();

        Course course = skillboxDbSession.get(Course.class, 1);
       // System.out.println(course.getName());
        Course newCourse = skillboxDbSession.get(Course.class,1);
        Student newStudent = skillboxDbSession.get(Student.class, 1);
        String name = newCourse.getTeacher().getName();
       // System.out.println(name);
       // System.out.println("Student: " + newStudent.getRegistrationDate());
        List<Student> courseStudents = newCourse.getStudents();

      //  Date date = "2018-05-17 00:00:00";
        EmbKey key1 = new EmbKey("Жариков Афанасий","Веб-разработчик c 0 до PRO");
        Purchase test = skillboxDbSession.get(Purchase.class, key1);

        System.out.println(test.getPrice());


//        Transaction sbTransaction = skillboxDbSession.beginTransaction();

  //      sbTransaction.commit();
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

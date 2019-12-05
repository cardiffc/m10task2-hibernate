import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session skillboxDbSession =  getSession();

        Course newCourse = skillboxDbSession.get(Course.class, 1);
        String courseTeacherName = newCourse.getTeacher().getName();
        List<Student> courseStudents = newCourse.getStudents();
        Student newStudent = skillboxDbSession.get(Student.class, 1);
        Teacher newTeacher = skillboxDbSession.get(Teacher.class, 1);
        EmbKeyForPurchase keyForPurchase = new EmbKeyForPurchase("Фуриков Эрнст", "Мобильный разработчик с нуля");
        Purchase newPurchase = skillboxDbSession.get(Purchase.class, keyForPurchase);
        int price = newPurchase.getPrice();
        EmbKeyForSubs keyForSubs = new EmbKeyForSubs(2,1);
        Subscription newSubscription = skillboxDbSession.get(Subscription.class,keyForSubs);
        Date subsDate = newSubscription.getSubsciptionDate();

        //Проверим получение данных кроме коллекции студентов
        System.out.println("CourseTeacherName=" + courseTeacherName + "\n" + "newStudentName=" + newStudent.getName() + "\n"
        + "newTeacherName=" + newTeacher.getName() + "\n" + "newPurchasePrice=" + price + "\n" + "newSubscriptionDate=" + subsDate);


        // Проверим коллекцию студентов
        courseStudents.forEach(student -> System.out.println(student.getName()));


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

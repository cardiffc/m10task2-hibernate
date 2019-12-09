import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.w3c.dom.ls.LSOutput;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session skillboxDbSession =  getSession();

        List<Purchase> purchaseList = getPurchaselist(skillboxDbSession);

        purchaseList.forEach(purchase -> System.out.println(purchase.getCourseName() + " / " + purchase.getStudentName()));

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
    private static List<Purchase> getPurchaselist (Session session)
    {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Purchase> query = builder.createQuery(Purchase.class);
        Root<Purchase> root = query.from(Purchase.class);
        query.select(root);
        List<Purchase> purchaseList = session.createQuery(query).getResultList();

        return purchaseList;
    }

}

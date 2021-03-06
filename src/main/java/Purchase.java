/**
 *  У данной сущности составныи ключем будет одновременно student_name и course_name, т.к. такого совпадения более одного в
 *  таблице быть не может (студент купил конкретный курс только 1 раз. Иное - странно :)
 *  Составной ключ определяется в классе EmbKeyForPurchase
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@IdClass(EmbKeyForPurchase.class)
@Table(name = "PurchaseList")
public class Purchase implements Serializable {
    @Id
    @Column(name = "student_name")
    private String studentName;
    @Id
    @Column(name = "course_name")
    private String courseName;
    private int price;

    @Id
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }


}

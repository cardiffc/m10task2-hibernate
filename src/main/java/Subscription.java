/**
 * У данной сущности составныи ключем будет одновременно student_id и course_id, т.к. такого совпадения более одного в
 * таблице быть не может (студент подписался на конкретный курс только 1 раз. Иное - странно :)
 * Составной ключ определяется в классе EmbKeyForSubs
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@IdClass(EmbKeyForSubs.class)
@Table(name = "Subscriptions")
public class Subscription implements Serializable {
    @Id
    private Student student;
    @Id
    private Course course;
    @Column(name = "subscription_date")
    private Date subsciptionDate;

    public Student getStudent() {
        return student;
    }

    public void setStudentId(Student studentId) {
        this.student = studentId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getSubsciptionDate() {
        return subsciptionDate;
    }

    public void setSubsciptionDate(Date subsciptionDate) {
        this.subsciptionDate = subsciptionDate;
    }




}

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
    @Column(name = "student_id")
    private int studentId;
    @Id
    @Column(name = "course_id")
    private int courseId;
    @Column(name = "subscription_date")
    private Date subsciptionDate;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getSubsciptionDate() {
        return subsciptionDate;
    }

    public void setSubsciptionDate(Date subsciptionDate) {
        this.subsciptionDate = subsciptionDate;
    }




}

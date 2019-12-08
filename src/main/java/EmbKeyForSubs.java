import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import java.io.Serializable;

public class EmbKeyForSubs implements Serializable {
    @OneToOne (cascade = CascadeType.ALL)
    protected Student student;
    @OneToOne (cascade = CascadeType.ALL)
    protected Course course;

    public EmbKeyForSubs (Student student, Course courseId) {
        this.student = student;
        this.course = courseId;
    }


}

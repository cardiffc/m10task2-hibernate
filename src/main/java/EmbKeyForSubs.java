import java.io.Serializable;

public class EmbKeyForSubs implements Serializable {
    protected int studentId;
    protected int courseId;

    public EmbKeyForSubs (int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }


}

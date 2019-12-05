import java.io.Serializable;
public class EmbKey implements Serializable {
    protected String studentName;
    protected String courseName;

    public EmbKey() {}

    public EmbKey (String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;
    }

}

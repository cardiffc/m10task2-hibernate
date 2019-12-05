import java.io.Serializable;
public class EmbKeyForPurchase implements Serializable {
    protected String studentName;
    protected String courseName;

    public EmbKeyForPurchase(String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;

    }

}

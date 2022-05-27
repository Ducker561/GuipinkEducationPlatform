package Domain;

public class TakeCourse {
    private String uid;
    private int cid;

    public TakeCourse(String uid, int cid) {
        this.uid = uid;
        this.cid = cid;
    }

    public TakeCourse() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}

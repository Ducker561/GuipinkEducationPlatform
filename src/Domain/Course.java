package Domain;

public class Course {
    private int cid;
    private String cName;
    private String cInfo;
    private int cLast;

    public Course(int cid, String cName, String cInfo, int cLast) {
        this.cid = cid;
        this.cName = cName;
        this.cInfo = cInfo;
        this.cLast = cLast;
    }

    public Course() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcInfo() {
        return cInfo;
    }

    public void setcInfo(String cInfo) {
        this.cInfo = cInfo;
    }

    public int getcLast() {
        return cLast;
    }

    public void setcLast(int cLast) {
        this.cLast = cLast;
    }
}

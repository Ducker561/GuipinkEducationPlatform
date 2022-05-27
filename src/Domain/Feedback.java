package Domain;

public class Feedback {
    private int fid;
    private String uid;
    private String email;
    private String msg;

    public Feedback() {
    }

    public Feedback(int fid, String uid, String email, String msg) {
        this.fid = fid;
        this.uid = uid;
        this.email = email;
        this.msg = msg;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

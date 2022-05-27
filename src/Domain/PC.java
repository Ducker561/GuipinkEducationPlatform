package Domain;

public class PC {
    private String pid;
    private String uid;
    private String pass;

    public PC(String pid, String uid, String pass) {
        this.pid = pid;
        this.uid = uid;
        this.pass = pass;
    }

    public PC() {
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

package Domain;

public class User {
    private String uid;
    private String pwd;
    private String uName;
    private String uSex;
    private String uAge;
    private String uTel;
    private String uType;
    private int uScore;

    public User(String uid, String pwd, String uName, String uSex, String uAge, String uTel, String uType, int uScore) {
        this.uid = uid;
        this.pwd = pwd;
        this.uName = uName;
        this.uSex = uSex;
        this.uAge = uAge;
        this.uTel = uTel;
        this.uType = uType;
        this.uScore = uScore;
    }


    public User() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    public String getuAge() {
        return uAge;
    }

    public void setuAge(String uAge) {
        this.uAge = uAge;
    }

    public String getuTel() {
        return uTel;
    }

    public void setuTel(String uTel) {
        this.uTel = uTel;
    }

    public String getuType() {
        return uType;
    }

    public void setuType(String uType) {
        this.uType = uType;
    }

    public int getuScore() {
        return uScore;
    }

    public void setuScore(int uScore) {
        this.uScore = uScore;
    }
}

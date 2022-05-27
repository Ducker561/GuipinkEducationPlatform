package Domain;

public class Verification {
    private String uid;
    private String teacherPass;

    public Verification() {
    }

    public Verification(String uid, String teacherPass) {
        this.uid = uid;
        this.teacherPass = teacherPass;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTeacherPass() {
        return teacherPass;
    }

    public void setTeacherPass(String teacherPass) {
        this.teacherPass = teacherPass;
    }
}

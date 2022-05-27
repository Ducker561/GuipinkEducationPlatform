package Domain;

public class Comment {
    private int commentid;
    private String uid;
    private String commentContent;
    private String commentTime;

    public Comment() {
    }

    public Comment(int commentid, String uid, String commentContent, String commentTime) {
        this.commentid = commentid;
        this.uid = uid;
        this.commentContent = commentContent;
        this.commentTime = commentTime;
    }

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }
}

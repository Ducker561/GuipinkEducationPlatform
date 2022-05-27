package Domain;

public class Goods {
    private int gid;
    private String gHref;
    private int gPrice;

    public Goods() {
    }

    public Goods(int gid, String gHref, int gPrice) {
        this.gid = gid;
        this.gHref = gHref;
        this.gPrice = gPrice;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getgHref() {
        return gHref;
    }

    public void setgHref(String gHref) {
        this.gHref = gHref;
    }

    public int getgPrice() {
        return gPrice;
    }

    public void setgPrice(int gPrice) {
        this.gPrice = gPrice;
    }
}

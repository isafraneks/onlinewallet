package lv.javaguru.java2.domain;

/**
 * Created by ingsaf on 28/03/17.
 */
public class Trnln {
    private long idTrn;
    private long lnTrn;
    private long idAccount;
    private double dr;
    private double cr;

    public long getIdTrn() {
        return idTrn;
    }

    public void setIdTrn(long idTrn) {
        this.idTrn = idTrn;
    }

    public long getLnTrn() {
        return lnTrn;
    }

    public void setLnTrn(long lnTrn) {
        this.lnTrn = lnTrn;
    }

    public long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(long idAccount) {
        this.idAccount = idAccount;
    }

    public double getDr() {
        return dr;
    }

    public void setDr(double dr) {
        this.dr = dr;
    }

    public double getCr() {
        return cr;
    }

    public void setCr(double cr) {
        this.cr = cr;
    }
}

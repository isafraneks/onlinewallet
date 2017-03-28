package lv.javaguru.java2.domain;

import java.util.Date;

/**
 * Created by ingsaf on 28/03/17.
 */
public class Trn {
    private long idTrn;
    private Date dt;
    private String sts;
    private String rem;

    public long getIdTrn() {
        return idTrn;
    }

    public void setIdTrn(long idTrn) {
        this.idTrn = idTrn;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public String getRem() {
        return rem;
    }

    public void setRem(String rem) {
        this.rem = rem;
    }

}

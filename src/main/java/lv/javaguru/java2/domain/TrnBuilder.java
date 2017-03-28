package lv.javaguru.java2.domain;

import java.util.Date;
/**
 * Created by ingsaf on 28/03/17.
 */
public class TrnBuilder {

    private Date dt;
    private String sts;
    private String rem;

    private TrnBuilder() { }

    public static TrnBuilder createTrn() {
        return new TrnBuilder();
    }

    public Trn build() {
        Trn trn = new Trn();
        trn.setDt(dt);
        trn.setSts(sts);
        trn.setRem(rem);

        return trn;
    }

    public TrnBuilder withDt(Date dt) {
        this.dt = dt;
        return this;
    }

    public TrnBuilder withSts(String sts) {
        this.sts = sts;
        return this;
    }

    public TrnBuilder withRem(String rem) {
        this.rem = rem;
        return this;
    }
}

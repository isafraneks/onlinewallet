package lv.javaguru.java2.domain;

/**
 * Created by ingsaf on 28/03/17.
 */
public class TrnlnBuilder {

    private long idTrn;
    private long lnTrn;
    private long idAccount;
    private double dr;
    private double cr;

    private TrnlnBuilder() { }

    public static TrnlnBuilder createTrnln() {
        return new TrnlnBuilder();
    }

    public Trnln build() {
        Trnln trnln = new Trnln();
        trnln.setIdTrn(idTrn);
        trnln.setLnTrn(lnTrn);
        trnln.setIdAccount(idAccount);
        trnln.setDr(dr);
        trnln.setCr(cr);

        return trnln;
    }

    public TrnlnBuilder withIdTrn(long idTrn) {
        this.idTrn = idTrn;
        return this;
    }

    public TrnlnBuilder withIdAccount(long idAccount) {
        this.idAccount = idAccount;
        return this;
    }

    public TrnlnBuilder withLnTrn(long lnTrn) {
        this.lnTrn = lnTrn;
        return this;
    }

    public TrnlnBuilder withSum(double sum) {
        if (sum > 0) this.cr = sum;
        else this.dr = - sum;
        return this;
    }

}

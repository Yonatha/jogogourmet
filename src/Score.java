public class Score {

    protected Integer bom;
    protected Integer otimo;

    public Score() {
        this.bom = 0;
        this.otimo = 0;
    }

    public Integer getBom() {
        return bom;
    }

    public void setBom(Integer bom) {
        this.bom = bom;
    }

    public Integer getOtimo() {
        return otimo;
    }

    public void setOtimo(Integer otimo) {
        this.otimo = otimo;
    }

    public Integer getTotal() {
        return this.bom + this.otimo;
    }
}
public class Prato implements Comparable<Prato> {

    protected String nome;
    protected Boolean massa;
    protected Score score;

    public Prato() {
        this.score = new Score();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getMassa() {
        return massa;
    }

    public void setMassa(Boolean massa) {
        this.massa = massa;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public void incrementarScore(String gosto) {
        Score scoreAtual = this.getScore();
        if(gosto.equals(Constantes.BOM.gettexto())){
            scoreAtual.setBom(scoreAtual.getBom() + 1);
        } else if(gosto.equals(Constantes.OTIMO.gettexto())){
            scoreAtual.setOtimo(scoreAtual.getOtimo() + 2);
        }
    }

    public void decrementarScore(String gosto) {
        Score scoreAtual = this.getScore();
        if(gosto.equals(Constantes.OTIMO.gettexto())){
            scoreAtual.setBom(scoreAtual.getBom() - 1);
        } else if(gosto.equals(Constantes.BOM.gettexto())){
            scoreAtual.setOtimo(scoreAtual.getOtimo() - 1);
        }
    }

    @Override
    public int compareTo(Prato o) {
        return 0;
    }
}
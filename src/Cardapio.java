import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Cardapio {
    Map<String, Prato> cardapio = new HashMap<String, Prato>();

    public Cardapio() {

        Prato p1 = new Prato();
        p1.setNome("Lasanha");
        p1.setMassa(true);

        Prato p2 = new Prato();
        p2.setNome("Bolo de Chocolate");
        p2.setMassa(false);

        this.cardapio.put(p1.getNome(), p1);
        this.cardapio.put(p2.getNome(), p2);
    }

    public Prato getPrato(String prato) {
        return cardapio.get(prato);
    }

    public Map<String, Prato> ler() {
        return this.cardapio;
    }

    public Map<String, Prato> ler(Boolean tipo) {
        Map<String, Prato> pratos = new HashMap<String, Prato>();
        for (String x : cardapio.keySet()) {
            Prato prato = this.getPrato(x);
            if (prato.getMassa().equals(tipo)) {
                //System.out.println(prato.getNome());
                pratos.put(prato.getNome(), prato);
            }
        }
        return pratos;
    }

    public void adicionarPrato(String pratoNome, Prato prato) {
        this.cardapio.put(pratoNome, prato);
    }

    protected Prato getRandomPrato(Map<String, Prato> c) {
        Random generator = new Random();
        Prato[] values = c.values().toArray(new Prato[0]);
        Prato randomValue = values[generator.nextInt(values.length)];
        return randomValue;
    }

    /**
     * Ordena o cardápio pelo score de cada prato
     *
     * @return
     */
    public void orderCardapio() {
        cardapio.entrySet().stream()
                .sorted(Map.Entry.<String, Prato>comparingByValue().reversed())
                .limit(1);
    }
}



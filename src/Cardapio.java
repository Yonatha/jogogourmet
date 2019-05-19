import java.util.*;

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

    protected Prato getRandomPrato2(Map<String, Prato> c) {
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

    public Prato getRandomPrato() {
        Map<Integer, Prato> unsortMap = new HashMap<>();
        for (Map.Entry<String, Prato> entry : this.cardapio.entrySet()) {
            unsortMap.put(entry.getValue().getScore().getTotal(), entry.getValue());
        }
        Map<Integer, Prato> treeMap = new TreeMap<>(
                new Comparator<Integer>() {

                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo(o1);
                    }

                });
        treeMap.putAll(unsortMap);

        return treeMap.entrySet().stream().findFirst().get().getValue();
    }
    public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {

            Prato x = (Prato) entry.getValue();

            System.out.println("Key : " + entry.getKey()
                    + " Value : " + x.getNome());
        }
    }
}



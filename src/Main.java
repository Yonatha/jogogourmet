import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import javax.swing.*;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String APP_TITLE = "Jogo Gourmet";
        Cardapio cardapio = new Cardapio();

        Boolean playAgain = true;
        while (playAgain){

            JOptionPane.showMessageDialog(null, Constantes.PENSE.gettexto());
            int opMassa = JOptionPane.showConfirmDialog(null, Constantes.ISMASSA.gettexto(), APP_TITLE, JOptionPane.YES_NO_OPTION);
            Boolean massa = false;
            if (opMassa == JOptionPane.YES_OPTION) {
                massa = true;
            }
            Map<String, Prato> cardapioAtual = cardapio.ler(massa);
            Prato pratoSugerido = cardapio.getRandomPrato();
            int optPratoSugerido = JOptionPane.showConfirmDialog(null, Constantes.QUESTION_SUGGESTED.gettexto()  + pratoSugerido.getNome(), APP_TITLE, JOptionPane.YES_NO_OPTION);
            if (optPratoSugerido == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, Constantes.I_GOT_IT.gettexto());
                pratoSugerido.incrementarScore(Constantes.BOM.gettexto());
            } else {
                String nomePrato = JOptionPane.showInputDialog(Constantes.WHAT_PLATE.gettexto());
                String gosto = JOptionPane.showInputDialog(nomePrato + " é _________ mas " + pratoSugerido.getNome() +" não.").toLowerCase();

                // Verifica se o prato informado já existia no cardápio
                if(cardapioAtual.containsKey(nomePrato)){
                    Prato pratoEncontrado = cardapioAtual.get(nomePrato);
                    pratoEncontrado.incrementarScore(gosto);
                } else {
                    Prato prato = new Prato();
                    prato.setNome(nomePrato);
                    prato.setMassa(massa);
                    prato.incrementarScore(gosto);
                    cardapio.adicionarPrato(prato.getNome(), prato);
                }

                pratoSugerido.decrementarScore(gosto);
            }

            cardapio.orderCardapio();

            Integer continuar = JOptionPane.showConfirmDialog(null, Constantes.PLAY_AGAIN.gettexto(), APP_TITLE, JOptionPane.YES_NO_OPTION);
            if(continuar == JOptionPane.YES_OPTION){
                playAgain = true;
            } else {
                playAgain = false;
            }
        }
        System.exit(0);
    }
}
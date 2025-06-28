package principal;

import javax.swing.*;
import java.nio.file.*;
import java.io.IOException;

public class TelaHabilidades extends JFrame {

    private JTextArea textArea;

    public TelaHabilidades(String classe) {
        setTitle("Habilidades da Classe: " + classe);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);              // Quebra de linha automática
        textArea.setWrapStyleWord(true);         // Quebra por palavras

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Sem rolagem horizontal
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Apenas vertical

        add(scrollPane);

        carregarArquivoDaClasse(classe);
    }

    private void carregarArquivoDaClasse(String classe) {
        String caminho = "classes/" + classe + ".txt";

        try {
            String conteudo = Files.readString(Paths.get(caminho));
            textArea.setText(conteudo);
        } catch (IOException e) {
            textArea.setText("Erro ao carregar habilidades da classe '" + classe + "'.\n" + e.getMessage());
        }
    }
}


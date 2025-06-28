package principal;

import javax.swing.*;
import java.nio.file.*;
import java.io.IOException;

public class TelaAspectos extends JFrame {

    private JTextArea textArea;

    public TelaAspectos(String nomePasta) {
        setTitle("Aspectos de: " + nomePasta);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);

        carregarArquivosDaPasta(nomePasta);
    }

    private void carregarArquivosDaPasta(String nomePasta) {
        String caminhoBase = "Percursos/" + nomePasta + "/";
        StringBuilder conteudoCompleto = new StringBuilder();

        // Lista dos 6 arquivos esperados
        String[] nomesArquivos = {
            "aspecto1.txt",
            "aspecto2.txt",
            "aspecto3.txt",
            "aspecto4.txt",
            "aspecto5.txt",
            "aspecto6.txt"
        };

        for (String nomeArquivo : nomesArquivos) {
            Path caminhoArquivo = Paths.get(caminhoBase + nomeArquivo);
            try {
                String conteudo = Files.readString(caminhoArquivo);
               
                conteudoCompleto.append(conteudo).append("\n\n");
            } catch (IOException e) {
                conteudoCompleto.append("Erro ao ler ").append(nomeArquivo).append(": ").append(e.getMessage()).append("\n\n");
            }
        }

        textArea.setText(conteudoCompleto.toString());
    }
}

package principal;

import javax.swing.*;
//import java.awt.*;
import java.io.*;

public class telaInicialSelecao extends javax.swing.JFrame {

    private DefaultListModel<String> modeloLista;
    private JList<String> listaPersonagens;

    /**
     * Creates new form telaIncialSelecao
     */
    public telaInicialSelecao() {
        initComponents();
        carregarPersonagens();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaPersonagens = new javax.swing.JList<>();
        btnAbrir = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCriar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Seleção de Personagem");
        setSize(500, 400);
        setLocationRelativeTo(null);

        modeloLista = new DefaultListModel<>();
        listaPersonagens.setModel(modeloLista);
        listaPersonagens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listaPersonagens);

        btnAbrir.setText("Abrir Ficha");
        btnExcluir.setText("Excluir");
        btnCriar.setText("Criar Novo Personagem");

        btnAbrir.addActionListener(evt -> abrirFicha());
        btnExcluir.addActionListener(evt -> excluirPersonagem());
        btnCriar.addActionListener(evt -> criarNovoPersonagem());

        // Layout usando GroupLayout, mantendo estilo NetBeans
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAbrir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCriar, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAbrir)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCriar))
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        //pack();
    }// </editor-fold>                        

    private void carregarPersonagens() {
        File arquivo = new File("personagens.txt");
        modeloLista.clear();
        if (!arquivo.exists()) {
            JOptionPane.showMessageDialog(this, "Arquivo personagens.txt não encontrado.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                modeloLista.addElement(linha.trim());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao ler personagens.txt");
        }
    }

    private void abrirFicha() {
        String selecionado = listaPersonagens.getSelectedValue();
        if (selecionado != null) {
            JOptionPane.showMessageDialog(this, "Abrir ficha: " + selecionado);
            // Aqui você vai chamar a outra tela para abrir a ficha do personagem
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um personagem.");
        }
    }

    private void excluirPersonagem() {
        String selecionado = listaPersonagens.getSelectedValue();
        if (selecionado != null) {
            int confirm = JOptionPane.showConfirmDialog(this, 
                    "Deseja excluir o personagem " + selecionado + "?", 
                    "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                excluirDoArquivo(selecionado);
                carregarPersonagens();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um personagem.");
        }
    }

    private void excluirDoArquivo(String nome) {
        File arquivo = new File("personagens.txt");
        File temp = new File("temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo));
             BufferedWriter writer = new BufferedWriter(new FileWriter(temp))) {

            String linha;
            while ((linha = reader.readLine()) != null) {
                if (!linha.trim().equals(nome)) {
                    writer.write(linha);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir personagem.");
            return;
        }

        if (!arquivo.delete() || !temp.renameTo(arquivo)) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar arquivo personagens.txt");
        }

        // Também pode-se excluir a ficha do personagem, se quiser:
        File ficha = new File("personagensP/" + nome + ".txt");
        if (ficha.exists()) {
            ficha.delete();
        }
    }

    private void criarNovoPersonagem() {
        new CriarPersonagem1().setVisible(true);
        this.dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaInicialSelecao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaInicialSelecao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaInicialSelecao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaInicialSelecao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new telaInicialSelecao().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnCriar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}

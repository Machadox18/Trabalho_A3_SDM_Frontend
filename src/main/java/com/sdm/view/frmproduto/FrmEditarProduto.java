package com.sdm.view.frmproduto;

import com.sdm.cliente.RMICliente;
import com.sdm.model.Categoria;
import com.sdm.model.Produto;
import com.sdm.server.RemoteCategoria;
import com.sdm.server.RemoteProduto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Master
 */
public class FrmEditarProduto extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmEditarProduto.class.getName());


    public FrmEditarProduto() {
        initComponents();
        carregarProdutos();
        carregarCategorias();
    }

    private java.util.List<Categoria> listaCategorias;  // armazena as categorias vindas do servidor
    
    private void carregarProdutos() {
        try {
            // Chamar o serviço remoto
            com.sdm.server.RemoteProduto service = RMICliente.getProdutoService();

            java.util.ArrayList<com.sdm.model.Produto> lista = service.listar();

            // Obter o modelo da tabela
            DefaultTableModel model = (DefaultTableModel) JTableProduto.getModel();
            model.setRowCount(0); // limpar tabela

            // Preencher
            for (com.sdm.model.Produto p : lista) {

                String categoriaNome = 
                    (p.getCategoria() != null ? p.getCategoria().getNome() : "Sem categoria");

                model.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getPrecoUnitario(),
                    p.getUnidade(),
                    p.getQuantidadeEstoque(),
                    p.getQuantidadeMinima(),
                    p.getQuantidadeMaxima(),
                    categoriaNome
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao carregar produtos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    
    private void carregarCategorias() {
        try {
            JCBCategoria.removeAllItems();
            JCBCategoria.addItem("Selecionar");

            RemoteCategoria service = RMICliente.getCategoriaService();
            listaCategorias = service.listar();

            for (Categoria c : listaCategorias) {
                JCBCategoria.addItem(c.getNome());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao carregar categorias: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private int getCategoriaIdSelecionada() {
        String categoriaNome = JCBCategoria.getSelectedItem().toString();

        for (Categoria c : listaCategorias) {
            if (c.getNome().equals(categoriaNome)) {
                return c.getId();
            }
        }

        return -1; // não encontrado (ou está em "Selecionar")
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableProduto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JTFNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTFPreco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JCBUnidade = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        JTFAtual = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JTFMinima = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        JTFMaxima = new javax.swing.JTextField();
        JBSair = new javax.swing.JButton();
        JBApagar = new javax.swing.JButton();
        JBAlterar = new javax.swing.JButton();
        JCBCategoria = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        JTableProduto.setBackground(new java.awt.Color(0, 0, 0));
        JTableProduto.setForeground(new java.awt.Color(204, 204, 255));
        JTableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Preço por unidade", "Tipo da unidade", "Quantidade atual", "Quantidade  mínima", "Quantidade máxima", "Categoria"
            }
        ));
        JTableProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableProduto);

        jLabel1.setFont(new java.awt.Font("Source Serif Pro", 1, 15)); // NOI18N
        jLabel1.setText("Nome:");

        JTFNome.setBackground(new java.awt.Color(0, 0, 0));
        JTFNome.setForeground(new java.awt.Color(204, 204, 255));
        JTFNome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        JTFNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNomeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Source Serif Pro", 1, 15)); // NOI18N
        jLabel2.setText("Preço por unidade:");

        JTFPreco.setBackground(new java.awt.Color(0, 0, 0));
        JTFPreco.setForeground(new java.awt.Color(204, 204, 255));
        JTFPreco.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        jLabel4.setFont(new java.awt.Font("Source Serif Pro", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tipo da unidade:");

        JCBUnidade.setBackground(new java.awt.Color(0, 0, 0));
        JCBUnidade.setFont(new java.awt.Font("Source Serif Pro", 1, 12)); // NOI18N
        JCBUnidade.setForeground(new java.awt.Color(204, 204, 255));
        JCBUnidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Kg", "g", "L", "ml" }));
        JCBUnidade.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        jLabel5.setFont(new java.awt.Font("Source Serif Pro", 1, 15)); // NOI18N
        jLabel5.setText("Quantidade atual em estoque:");

        JTFAtual.setBackground(new java.awt.Color(0, 0, 0));
        JTFAtual.setForeground(new java.awt.Color(204, 204, 255));
        JTFAtual.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        jLabel6.setFont(new java.awt.Font("Source Serif Pro", 1, 15)); // NOI18N
        jLabel6.setText("Quantidade mínima em estoque:");

        JTFMinima.setBackground(new java.awt.Color(0, 0, 0));
        JTFMinima.setForeground(new java.awt.Color(204, 204, 255));
        JTFMinima.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        jLabel7.setFont(new java.awt.Font("Source Serif Pro", 1, 15)); // NOI18N
        jLabel7.setText("Quantidade máxima em estoque: ");

        JTFMaxima.setBackground(new java.awt.Color(0, 0, 0));
        JTFMaxima.setForeground(new java.awt.Color(204, 204, 255));
        JTFMaxima.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        JTFMaxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFMaximaActionPerformed(evt);
            }
        });

        JBSair.setBackground(new java.awt.Color(0, 0, 0));
        JBSair.setFont(new java.awt.Font("Source Serif Pro", 1, 15)); // NOI18N
        JBSair.setForeground(new java.awt.Color(204, 204, 255));
        JBSair.setText("Sair");
        JBSair.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        JBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSairActionPerformed(evt);
            }
        });

        JBApagar.setBackground(new java.awt.Color(0, 0, 0));
        JBApagar.setFont(new java.awt.Font("Source Serif Pro", 1, 15)); // NOI18N
        JBApagar.setForeground(new java.awt.Color(204, 204, 255));
        JBApagar.setText("Apagar");
        JBApagar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        JBApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBApagarActionPerformed(evt);
            }
        });

        JBAlterar.setBackground(new java.awt.Color(0, 0, 0));
        JBAlterar.setFont(new java.awt.Font("Source Serif Pro", 1, 15)); // NOI18N
        JBAlterar.setForeground(new java.awt.Color(204, 204, 255));
        JBAlterar.setText("Alterar");
        JBAlterar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        JBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAlterarActionPerformed(evt);
            }
        });

        JCBCategoria.setBackground(new java.awt.Color(0, 0, 0));
        JCBCategoria.setFont(new java.awt.Font("Source Serif Pro", 1, 12)); // NOI18N
        JCBCategoria.setForeground(new java.awt.Color(204, 204, 255));
        JCBCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar" }));
        JCBCategoria.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        jLabel8.setFont(new java.awt.Font("Source Serif Pro", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Categoria");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(JTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JTFPreco))
                .addGap(172, 172, 172)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(JTFMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 136, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(JCBUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(137, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(JBApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(JBAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(340, 340, 340))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCBUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addGap(19, 19, 19)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JTFMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JBApagar)
                            .addComponent(JBSair)
                            .addComponent(JBAlterar))
                        .addGap(23, 23, 23))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTFMaximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFMaximaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFMaximaActionPerformed

    private void JTFNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFNomeActionPerformed

    private void JBApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBApagarActionPerformed
        try {
            int linha = JTableProduto.getSelectedRow();

            if (linha < 0) {
                JOptionPane.showMessageDialog(this, 
                    "Selecione um produto na tabela!", 
                    "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Pega o ID da primeira coluna da linha selecionada
            int idProduto = (int) JTableProduto.getValueAt(linha, 0);

            int confirmar = JOptionPane.showConfirmDialog(this,
                    "Deseja realmente apagar este produto?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION);

            if (confirmar != JOptionPane.YES_OPTION) {
                return; // usuário cancelou
            }

            // Chama o serviço RMI
            RemoteProduto service = RMICliente.getProdutoService();
            boolean sucesso = service.deletar(idProduto);

            if (sucesso) {
                JOptionPane.showMessageDialog(this,
                        "Produto removido com sucesso!",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);

                // Recarrega a tabela após excluir
                carregarProdutos();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Erro ao remover produto!",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Erro ao apagar produto: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBApagarActionPerformed

    private void JBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_JBSairActionPerformed

    private void JBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAlterarActionPerformed
        try {
            int linha = JTableProduto.getSelectedRow();

            if (linha < 0) {
                JOptionPane.showMessageDialog(this, 
                    "Selecione um produto na tabela!");
                return;
            }

            // ID vem da tabela
            int idProduto = Integer.parseInt(JTableProduto.getValueAt(linha, 0).toString());

            // Coletar valores da interface
            String nome = JTFNome.getText();
            double preco = Double.parseDouble(JTFPreco.getText());
            String unidade = JCBUnidade.getSelectedItem().toString();
            int qtdAtual = Integer.parseInt(JTFAtual.getText());
            int qtdMin = Integer.parseInt(JTFMinima.getText());
            int qtdMax = Integer.parseInt(JTFMaxima.getText());

            // Obter ID da categoria selecionada
            int categoriaId = getCategoriaIdSelecionada();
            if (categoriaId == -1) {
                JOptionPane.showMessageDialog(this, 
                    "Selecione uma categoria válida!");
                return;
            }

            // Criar objeto Produto atualizado
            Produto p = new Produto();
            p.setId(idProduto);
            p.setNome(nome);
            p.setPrecoUnitario(preco);
            p.setUnidade(unidade);
            p.setQuantidadeEstoque(qtdAtual);
            p.setQuantidadeMinima(qtdMin);
            p.setQuantidadeMaxima(qtdMax);
            Categoria c = new Categoria();
            c.setId(categoriaId);
            p.setCategoria(c);

            // Enviar para o servidor via RMI
            RemoteProduto service = RMICliente.getProdutoService();
            service.atualizar(p);

            JOptionPane.showMessageDialog(this, 
                "Produto alterado com sucesso!");

            // Recarregar tabela
            carregarProdutos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao alterar: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_JBAlterarActionPerformed

    private void JTableProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableProdutoMouseClicked
        int row = JTableProduto.getSelectedRow();
        if (row < 0) return;

        // preencher campos normais
        JTFNome.setText(JTableProduto.getValueAt(row, 1).toString());
        JTFPreco.setText(JTableProduto.getValueAt(row, 2).toString());
        JCBUnidade.setSelectedItem(JTableProduto.getValueAt(row, 3).toString());
        JTFAtual.setText(JTableProduto.getValueAt(row, 4).toString());
        JTFMinima.setText(JTableProduto.getValueAt(row, 5).toString());
        JTFMaxima.setText(JTableProduto.getValueAt(row, 6).toString());

        // pegar nome da categoria mostrado na tabela
        String categoriaNome = JTableProduto.getValueAt(row, 7).toString();
        JCBCategoria.setSelectedItem(categoriaNome);
    }//GEN-LAST:event_JTableProdutoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmEditarProduto().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAlterar;
    private javax.swing.JButton JBApagar;
    private javax.swing.JButton JBSair;
    private javax.swing.JComboBox<String> JCBCategoria;
    private javax.swing.JComboBox<String> JCBUnidade;
    private javax.swing.JTextField JTFAtual;
    private javax.swing.JTextField JTFMaxima;
    private javax.swing.JTextField JTFMinima;
    private javax.swing.JTextField JTFNome;
    private javax.swing.JTextField JTFPreco;
    private javax.swing.JTable JTableProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
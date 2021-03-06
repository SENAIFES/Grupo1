/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import br.senai.dao.ListaDAO;
import br.senai.dao.TarefaDAO;
import br.senai.entity.Lista;
import br.senai.entity.Tarefa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author monique_s
 */
public class TelaPrincipal extends javax.swing.JFrame {

    JDialog jDialogEdit = new JDialog();
    ListaDAO listaDAO = new ListaDAO();
    Lista lista = new Lista();

    public TelaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        atualizarLista();
        atualizarTabela();

    }

    private void atualizarLista() {
        cbLista.removeAllItems();
        List<Lista> listaTarefa = listaDAO.listarTodos();
        for (Lista lista : listaTarefa) {
            cbLista.addItem(lista);
        }

        if (cbLista.getSelectedIndex() == -1) {
            btnAlterarLista.setEnabled(false);
            btnExcluirLista.setEnabled(false);
        } else {
            btnAlterarLista.setEnabled(true);
            btnExcluirLista.setEnabled(true);
        }
    }
    private Tarefa tarefa = new Tarefa();
    private TarefaDAO tarefaDAO = new TarefaDAO();

    //Lista listaSelecionada = new Lista();
    private void atualizarTabela() {
        if (cbLista.getSelectedIndex() == -1) {
            btnAddTarefa.setEnabled(false);
            btnAlterarTarefa.setEnabled(false);
            btnExcluirTarefa.setEnabled(false);
        } else {
            btnAddTarefa.setEnabled(true);
            btnAlterarTarefa.setEnabled(true);
            btnExcluirTarefa.setEnabled(true);
        }

        TarefaDAO tarefaDAO = new TarefaDAO();
        TarefaTableModel ttm = new TarefaTableModel();
        lista = ((Lista) cbLista.getSelectedItem());
        if (lista != null) {
            ttm.setLista(tarefaDAO.getTarefasByLista(lista));
        } else {
            ttm.setLista(new ArrayList<>());
        }
        tbTarefa.setModel(ttm);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTarefa = new javax.swing.JTable();
        btnAddTarefa = new javax.swing.JButton();
        btnAlterarTarefa = new javax.swing.JButton();
        btnExcluirTarefa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cbLista = new javax.swing.JComboBox();
        btnAddLista = new javax.swing.JButton();
        btnAlterarLista = new javax.swing.JButton();
        btnExcluirLista = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Tarefas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tarefa"));

        tbTarefa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Descrição", "Prazo", "Feito"
            }
        ));
        jScrollPane1.setViewportView(tbTarefa);

        btnAddTarefa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Create.png"))); // NOI18N
        btnAddTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTarefaActionPerformed(evt);
            }
        });

        btnAlterarTarefa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Modify.png"))); // NOI18N
        btnAlterarTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarTarefaActionPerformed(evt);
            }
        });

        btnExcluirTarefa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Trash.png"))); // NOI18N
        btnExcluirTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirTarefaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlterarTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluirTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAlterarTarefa)
                    .addComponent(btnExcluirTarefa)
                    .addComponent(btnAddTarefa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista"));

        cbLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbListaActionPerformed(evt);
            }
        });

        btnAddLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Create.png"))); // NOI18N
        btnAddLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddListaActionPerformed(evt);
            }
        });

        btnAlterarLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Modify.png"))); // NOI18N
        btnAlterarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarListaActionPerformed(evt);
            }
        });

        btnExcluirLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Trash.png"))); // NOI18N
        btnExcluirLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbLista, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddLista, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAlterarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluirLista, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcluirLista)
                    .addComponent(btnAddLista)
                    .addComponent(cbLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterarLista))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddListaActionPerformed

        Lista l = new Lista();
        TelaLista tela = new TelaLista(this, true, l);
        atualizarLista();
        // tela.setVisible(true);
    }//GEN-LAST:event_btnAddListaActionPerformed

    private void btnAddTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTarefaActionPerformed
        lista = ((Lista) cbLista.getSelectedItem());
        TelaTarefa tela = new TelaTarefa(this, true, lista);

        tela.setVisible(true);

        atualizarTabela();


    }//GEN-LAST:event_btnAddTarefaActionPerformed

    private void btnAlterarTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarTarefaActionPerformed
        TarefaTableModel tarefaTM = (TarefaTableModel) tbTarefa.getModel();
        tarefa = (Tarefa) tarefaTM.getLista().get(tbTarefa.getSelectedRow());

        TelaTarefa tela = new TelaTarefa(this, true, tarefa);
        tela.setVisible(true);
        atualizarTabela();


    }//GEN-LAST:event_btnAlterarTarefaActionPerformed

    private void btnAlterarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarListaActionPerformed
        lista = ((Lista) cbLista.getSelectedItem());

        TelaLista tela = new TelaLista(this, true, lista);
        atualizarLista();
    }//GEN-LAST:event_btnAlterarListaActionPerformed

    private void btnExcluirTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirTarefaActionPerformed
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja excluir a tarefa?", "Excluir", JOptionPane.YES_NO_OPTION);
        if (resposta == 0) {
            TarefaTableModel tarefaTM = (TarefaTableModel) tbTarefa.getModel();
            tarefa = (Tarefa) tarefaTM.getLista().get(tbTarefa.getSelectedRow());
            tarefaDAO.delete(tarefa.getIdTarefa());
            JOptionPane.showMessageDialog(this, "Excluído com sucesso.");
            atualizarTabela();
        }


    }//GEN-LAST:event_btnExcluirTarefaActionPerformed

    private void btnExcluirListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirListaActionPerformed

        int resposta = JOptionPane.showConfirmDialog(this, "Deseja excluir a lista?\nTodas as tarefas também serão excluídas.", "Excluir", JOptionPane.YES_NO_OPTION);
        if (resposta == 0) {
            lista = ((Lista) cbLista.getSelectedItem());
            listaDAO.delete(lista.getId());
            JOptionPane.showMessageDialog(this, "Excluído com sucesso.");
            atualizarLista();
        }

    }//GEN-LAST:event_btnExcluirListaActionPerformed

    private void cbListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbListaActionPerformed
        atualizarTabela();

    }//GEN-LAST:event_cbListaActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    public JButton getBtnAddTarefa() {
        return btnAddTarefa;
    }

    public JButton getBtnAlterarTarefa() {
        return btnAlterarTarefa;
    }

    public JButton getBtnExcluirTarefa() {
        return btnExcluirTarefa;
    }

    public JTable getTbTarefa() {
        return tbTarefa;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddLista;
    private javax.swing.JButton btnAddTarefa;
    private javax.swing.JButton btnAlterarLista;
    private javax.swing.JButton btnAlterarTarefa;
    private javax.swing.JButton btnExcluirLista;
    private javax.swing.JButton btnExcluirTarefa;
    private javax.swing.JComboBox cbLista;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbTarefa;
    // End of variables declaration//GEN-END:variables
}

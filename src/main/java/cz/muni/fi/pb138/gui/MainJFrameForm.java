/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138.gui;

import cz.muni.fi.pb138.odssearch.OdsSearch;
import cz.muni.fi.pb138.odssearch.QueryItem;
import org.odftoolkit.simple.SpreadsheetDocument;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


// TODO: CheckboxActionPerformed - block other checkboxes when regex is selected ()
// TODO: Implement thread for searching

/**
 *
 * @author Ladislav Otoupal (422520), Tom� �evc� (422519)
 */
public class MainJFrameForm extends javax.swing.JFrame {

    private static final String BORDER_TITLE = "Search string in file: ";
    
    private String filePath;
    private String fileNameTitle;
    
    /**
     * Creates new form MainJFrameForm
     */
    public MainJFrameForm() {
        initComponents();
        filePath = null;
        fileNameTitle = "No selected file";
        
        setBorderTitle();
    }

    /**
     * Method set title in first panel
     */
    private void setBorderTitle() {
        String titleString = BORDER_TITLE + fileNameTitle;
        TitledBorder title = BorderFactory.createTitledBorder(titleString);
        searchStringPanel.setBorder(title);
    }
    
    /**
     * Class for filtering ods files in file chooser
     */
    class MyCustomFilter extends javax.swing.filechooser.FileFilter {
        @Override
        public boolean accept(File file) {
            // Allow only directories, or files with ".txt" extension
            return file.isDirectory() || file.getAbsolutePath().endsWith(".ods");
        }
        @Override
        public String getDescription() {
            // This description will be displayed in the dialog,
            // hard-coded = ugly, should be done via I18N
            return "Open documents (*.ods)";
        }
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        searchStringPanel = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        searchLabel = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        caseSensitiveCheckBox = new javax.swing.JCheckBox();
        exactMatchCheckBox = new javax.swing.JCheckBox();
        regexMatchCheckBox = new javax.swing.JCheckBox();
        instantSearchCheckBox = new javax.swing.JCheckBox();
        findedDataPanel = new javax.swing.JPanel();
        findedDataScrollPane = new javax.swing.JScrollPane();
        findedDataTable = new javax.swing.JTable();
        MenuBar = new javax.swing.JMenuBar();
        Menu = new javax.swing.JMenu();
        chooseFileMenuItem = new javax.swing.JMenuItem();
        exitProgramMenuItem = new javax.swing.JMenuItem();

        fileChooser.setFileFilter(new MyCustomFilter());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ODS Search");

        searchStringPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Search string"));

        searchLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        searchLabel.setText("Search: ");

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        caseSensitiveCheckBox.setText("Case sensitive");
        caseSensitiveCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caseSensitiveCheckBoxActionPerformed(evt);
            }
        });

        exactMatchCheckBox.setText("Exact match");
        exactMatchCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exactMatchCheckBoxActionPerformed(evt);
            }
        });

        regexMatchCheckBox.setText("Regex match");
        regexMatchCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regexMatchCheckBoxActionPerformed(evt);
            }
        });

        instantSearchCheckBox.setText("Instant search");
        instantSearchCheckBox.setEnabled(false);

        javax.swing.GroupLayout searchStringPanelLayout = new javax.swing.GroupLayout(searchStringPanel);
        searchStringPanel.setLayout(searchStringPanelLayout);
        searchStringPanelLayout.setHorizontalGroup(
            searchStringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchStringPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(searchStringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(searchStringPanelLayout.createSequentialGroup()
                        .addComponent(searchLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(searchStringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(caseSensitiveCheckBox)
                    .addComponent(exactMatchCheckBox)
                    .addComponent(regexMatchCheckBox)
                    .addComponent(instantSearchCheckBox))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        searchStringPanelLayout.setVerticalGroup(
            searchStringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchStringPanelLayout.createSequentialGroup()
                .addGroup(searchStringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchStringPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(searchStringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchStringPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(caseSensitiveCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exactMatchCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(regexMatchCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(instantSearchCheckBox)))
                .addGap(39, 39, 39))
        );

        findedDataPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Finded data"));

        findedDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Table", "Cell value", "Column name", "Column number", "Row number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        findedDataScrollPane.setViewportView(findedDataTable);
        if (findedDataTable.getColumnModel().getColumnCount() > 0) {
            findedDataTable.getColumnModel().getColumn(3).setMinWidth(100);
            findedDataTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            findedDataTable.getColumnModel().getColumn(3).setMaxWidth(100);
            findedDataTable.getColumnModel().getColumn(4).setMinWidth(100);
            findedDataTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            findedDataTable.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        javax.swing.GroupLayout findedDataPanelLayout = new javax.swing.GroupLayout(findedDataPanel);
        findedDataPanel.setLayout(findedDataPanelLayout);
        findedDataPanelLayout.setHorizontalGroup(
            findedDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(findedDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(findedDataScrollPane)
                .addContainerGap())
        );
        findedDataPanelLayout.setVerticalGroup(
            findedDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(findedDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(findedDataScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );

        Menu.setText("File");

        chooseFileMenuItem.setText("Choose file");
        chooseFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileMenuItemActionPerformed(evt);
            }
        });
        Menu.add(chooseFileMenuItem);

        exitProgramMenuItem.setText("Exit");
        exitProgramMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitProgramMenuItemActionPerformed(evt);
            }
        });
        Menu.add(exitProgramMenuItem);

        MenuBar.add(Menu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchStringPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(findedDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(searchStringPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(findedDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Event for choosing file
     * @param evt event argument
     */
    private void chooseFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileMenuItemActionPerformed
        int retValue = fileChooser.showOpenDialog(this);
        
        if (retValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                filePath = file.getCanonicalPath();
                fileNameTitle = file.getName();
            } catch (IOException ex) {
                filePath = null;
                fileNameTitle = "Problem accessing file: " + file.getName();
            }
        } else {
            filePath = null;
            fileNameTitle = "The File access canceled by user";        
        }
    setBorderTitle();
    }//GEN-LAST:event_chooseFileMenuItemActionPerformed

    /**
     * Event for exiting application
     * @param evt event argument
     */
    private void exitProgramMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitProgramMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitProgramMenuItemActionPerformed

    /**
     * Event for start searching by clicking search button 
     * @param evt event argument
     */
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        if (filePath == null) {
            fileNameTitle = "The file has not been selected yet";
            setBorderTitle();
            return;
        }
      
        if (searchTextField.getText().length() > 1) {
            try {
                SpreadsheetDocument document = SpreadsheetDocument.loadDocument(filePath);
                OdsSearch ods = new OdsSearch(document, caseSensitiveCheckBox.isSelected(), exactMatchCheckBox.isSelected(), regexMatchCheckBox.isSelected());
                
                List<QueryItem> items = ods.search(searchTextField.getText());
                
                DefaultTableModel model = (DefaultTableModel) findedDataTable.getModel();
                model.getDataVector().removeAllElements();
                
                if (!items.isEmpty()) {                
                    for (QueryItem item : items) {
                        Object[] row = { item.getTableName(), item.getCellValue(), item.getColumnName()
                                , item.getCol(), item.getRow() };

                        model.addRow(row);
                    }
                
                findedDataTable.setModel(model);
                } else{
                    Object[] row = { null, null, null, null, null };
                    model.addRow(row);
                }                
            } catch (Exception ex) {
                Logger.getLogger(MainJFrameForm.class.getName()).log(Level.SEVERE, null, ex);
            }         
        } else {
            JOptionPane.showMessageDialog(null, "Please enter atleast two characters.");                       
        }            
    }//GEN-LAST:event_searchButtonActionPerformed

    private void exactMatchCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exactMatchCheckBoxActionPerformed
        if(exactMatchCheckBox.isSelected()){
            caseSensitiveCheckBox.setEnabled(false);
            caseSensitiveCheckBox.setSelected(false);
            regexMatchCheckBox.setEnabled(false);
            regexMatchCheckBox.setSelected(false);
        }else{
            caseSensitiveCheckBox.setEnabled(true);
            regexMatchCheckBox.setEnabled(true);
        }
    }//GEN-LAST:event_exactMatchCheckBoxActionPerformed

    private void caseSensitiveCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caseSensitiveCheckBoxActionPerformed
        if(caseSensitiveCheckBox.isSelected()){
            exactMatchCheckBox.setEnabled(false);
            exactMatchCheckBox.setSelected(false);
            regexMatchCheckBox.setEnabled(false);
            regexMatchCheckBox.setSelected(false);
        }else{
            exactMatchCheckBox.setEnabled(true);
            regexMatchCheckBox.setEnabled(true);
        }
    }//GEN-LAST:event_caseSensitiveCheckBoxActionPerformed

    private void regexMatchCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regexMatchCheckBoxActionPerformed
        if(regexMatchCheckBox.isSelected()){
            caseSensitiveCheckBox.setEnabled(false);
            caseSensitiveCheckBox.setSelected(false);
            exactMatchCheckBox.setEnabled(false);
            exactMatchCheckBox.setSelected(false);
        }else{
            caseSensitiveCheckBox.setEnabled(true);
            exactMatchCheckBox.setEnabled(true);
        }
    }//GEN-LAST:event_regexMatchCheckBoxActionPerformed

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
            java.util.logging.Logger.getLogger(MainJFrameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrameForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Menu;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JCheckBox caseSensitiveCheckBox;
    private javax.swing.JMenuItem chooseFileMenuItem;
    private javax.swing.JCheckBox exactMatchCheckBox;
    private javax.swing.JMenuItem exitProgramMenuItem;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JPanel findedDataPanel;
    private javax.swing.JScrollPane findedDataScrollPane;
    private javax.swing.JTable findedDataTable;
    private javax.swing.JCheckBox instantSearchCheckBox;
    private javax.swing.JCheckBox regexMatchCheckBox;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JPanel searchStringPanel;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables
}

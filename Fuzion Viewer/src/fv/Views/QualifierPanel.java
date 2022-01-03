package fv.Views;

import fv.controllers.Controller;

public class QualifierPanel extends javax.swing.JPanel {

    MainFrame parent;
    Controller controller;
    

    public QualifierPanel(MainFrame parent, Controller controller) {
        initComponents();
        this.parent = parent;
        this.controller = controller;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMainQualifier = new javax.swing.JPanel();
        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        tpnlMainQualifier = new javax.swing.JTabbedPane();
        pnlCodesList = new javax.swing.JPanel();
        pnlFilterCodes = new javax.swing.JPanel();
        lblLookForCodes = new javax.swing.JLabel();
        txtLookForCodes = new javax.swing.JTextField();
        btnClearSearchCodes = new javax.swing.JButton();
        pnlTableCodes = new javax.swing.JPanel();
        spnlDataCodes = new javax.swing.JScrollPane();
        tblDataCodes = new javax.swing.JTable();
        pnlModifiersList = new javax.swing.JPanel();
        pnlFilterModifiers = new javax.swing.JPanel();
        lblLookForModifiers = new javax.swing.JLabel();
        txtLookForModifiers = new javax.swing.JTextField();
        btnClearSearchModifiers = new javax.swing.JButton();
        pnlTableModifiers = new javax.swing.JPanel();
        spnlDataModifiers = new javax.swing.JScrollPane();
        tblDataModifiers = new javax.swing.JTable();
        pnlLocationsList = new javax.swing.JPanel();
        pnlFilterLocations = new javax.swing.JPanel();
        lblLookForLocations = new javax.swing.JLabel();
        txtLookForLocations = new javax.swing.JTextField();
        btnClearSearchLocations = new javax.swing.JButton();
        pnlTableLocations = new javax.swing.JPanel();
        spnlDataLocations = new javax.swing.JScrollPane();
        tblDataLocations = new javax.swing.JTable();
        pnlATALevelsList = new javax.swing.JPanel();
        pnlFilterTherapist3 = new javax.swing.JPanel();
        lblLookForATA = new javax.swing.JLabel();
        txtLookForATA = new javax.swing.JTextField();
        btnClearSearchATA = new javax.swing.JButton();
        pnlTableListATA = new javax.swing.JPanel();
        spnlDataATA = new javax.swing.JScrollPane();
        tblDataATA = new javax.swing.JTable();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(153, 153, 153));
        lblTitle.setText("Qualifiers");

        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/document_add.png"))); // NOI18N
        btnCreate.setText("New");

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/document_edit.png"))); // NOI18N
        btnUpdate.setText("Save");

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/document_delete.png"))); // NOI18N
        btnDelete.setText("Delete");

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/printer.png"))); // NOI18N
        btnPrint.setText("Print");

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCreate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addContainerGap())
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPrint)
                        .addComponent(btnDelete)
                        .addComponent(btnUpdate)
                        .addComponent(btnCreate)
                        .addComponent(btnClose))
                    .addComponent(lblTitle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTitle.getAccessibleContext().setAccessibleName("Qualifiers");
        lblTitle.getAccessibleContext().setAccessibleDescription("");

        tpnlMainQualifier.setMinimumSize(new java.awt.Dimension(0, 0));
        tpnlMainQualifier.setPreferredSize(new java.awt.Dimension(0, 0));

        pnlFilterCodes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlFilterCodes.setPreferredSize(new java.awt.Dimension(460, 59));

        lblLookForCodes.setText("Look For:");

        btnClearSearchCodes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/broom.png"))); // NOI18N
        btnClearSearchCodes.setText("Clear");

        javax.swing.GroupLayout pnlFilterCodesLayout = new javax.swing.GroupLayout(pnlFilterCodes);
        pnlFilterCodes.setLayout(pnlFilterCodesLayout);
        pnlFilterCodesLayout.setHorizontalGroup(
            pnlFilterCodesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilterCodesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLookForCodes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLookForCodes, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearSearchCodes)
                .addContainerGap(221, Short.MAX_VALUE))
        );
        pnlFilterCodesLayout.setVerticalGroup(
            pnlFilterCodesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFilterCodesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFilterCodesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnClearSearchCodes)
                    .addComponent(txtLookForCodes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLookForCodes))
                .addContainerGap())
        );

        tblDataCodes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDataCodes.setFillsViewportHeight(true);
        tblDataCodes.setMinimumSize(new java.awt.Dimension(0, 0));
        tblDataCodes.setName(""); // NOI18N
        tblDataCodes.setPreferredSize(new java.awt.Dimension(0, 0));
        spnlDataCodes.setViewportView(tblDataCodes);

        javax.swing.GroupLayout pnlTableCodesLayout = new javax.swing.GroupLayout(pnlTableCodes);
        pnlTableCodes.setLayout(pnlTableCodesLayout);
        pnlTableCodesLayout.setHorizontalGroup(
            pnlTableCodesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spnlDataCodes)
        );
        pnlTableCodesLayout.setVerticalGroup(
            pnlTableCodesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableCodesLayout.createSequentialGroup()
                .addComponent(spnlDataCodes, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pnlCodesListLayout = new javax.swing.GroupLayout(pnlCodesList);
        pnlCodesList.setLayout(pnlCodesListLayout);
        pnlCodesListLayout.setHorizontalGroup(
            pnlCodesListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFilterCodes, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
            .addComponent(pnlTableCodes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCodesListLayout.setVerticalGroup(
            pnlCodesListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCodesListLayout.createSequentialGroup()
                .addComponent(pnlFilterCodes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTableCodes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tpnlMainQualifier.addTab("Codes", pnlCodesList);

        pnlFilterModifiers.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlFilterModifiers.setPreferredSize(new java.awt.Dimension(460, 59));

        lblLookForModifiers.setText("Look For:");

        btnClearSearchModifiers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/broom.png"))); // NOI18N
        btnClearSearchModifiers.setText("Clear");

        javax.swing.GroupLayout pnlFilterModifiersLayout = new javax.swing.GroupLayout(pnlFilterModifiers);
        pnlFilterModifiers.setLayout(pnlFilterModifiersLayout);
        pnlFilterModifiersLayout.setHorizontalGroup(
            pnlFilterModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilterModifiersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLookForModifiers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLookForModifiers, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearSearchModifiers)
                .addContainerGap(221, Short.MAX_VALUE))
        );
        pnlFilterModifiersLayout.setVerticalGroup(
            pnlFilterModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFilterModifiersLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFilterModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnClearSearchModifiers)
                    .addComponent(txtLookForModifiers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLookForModifiers))
                .addContainerGap())
        );

        tblDataModifiers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDataModifiers.setFillsViewportHeight(true);
        tblDataModifiers.setMinimumSize(new java.awt.Dimension(0, 0));
        tblDataModifiers.setName(""); // NOI18N
        tblDataModifiers.setPreferredSize(new java.awt.Dimension(0, 0));
        spnlDataModifiers.setViewportView(tblDataModifiers);

        javax.swing.GroupLayout pnlTableModifiersLayout = new javax.swing.GroupLayout(pnlTableModifiers);
        pnlTableModifiers.setLayout(pnlTableModifiersLayout);
        pnlTableModifiersLayout.setHorizontalGroup(
            pnlTableModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spnlDataModifiers)
        );
        pnlTableModifiersLayout.setVerticalGroup(
            pnlTableModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableModifiersLayout.createSequentialGroup()
                .addComponent(spnlDataModifiers, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pnlModifiersListLayout = new javax.swing.GroupLayout(pnlModifiersList);
        pnlModifiersList.setLayout(pnlModifiersListLayout);
        pnlModifiersListLayout.setHorizontalGroup(
            pnlModifiersListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFilterModifiers, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
            .addComponent(pnlTableModifiers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlModifiersListLayout.setVerticalGroup(
            pnlModifiersListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlModifiersListLayout.createSequentialGroup()
                .addComponent(pnlFilterModifiers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTableModifiers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tpnlMainQualifier.addTab("Modifiers", pnlModifiersList);

        pnlFilterLocations.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlFilterLocations.setPreferredSize(new java.awt.Dimension(460, 59));

        lblLookForLocations.setText("Look For:");

        btnClearSearchLocations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/broom.png"))); // NOI18N
        btnClearSearchLocations.setText("Clear");

        javax.swing.GroupLayout pnlFilterLocationsLayout = new javax.swing.GroupLayout(pnlFilterLocations);
        pnlFilterLocations.setLayout(pnlFilterLocationsLayout);
        pnlFilterLocationsLayout.setHorizontalGroup(
            pnlFilterLocationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilterLocationsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLookForLocations)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLookForLocations, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearSearchLocations)
                .addContainerGap(221, Short.MAX_VALUE))
        );
        pnlFilterLocationsLayout.setVerticalGroup(
            pnlFilterLocationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFilterLocationsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFilterLocationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnClearSearchLocations)
                    .addComponent(txtLookForLocations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLookForLocations))
                .addContainerGap())
        );

        tblDataLocations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDataLocations.setFillsViewportHeight(true);
        tblDataLocations.setMinimumSize(new java.awt.Dimension(0, 0));
        tblDataLocations.setName(""); // NOI18N
        tblDataLocations.setPreferredSize(new java.awt.Dimension(0, 0));
        spnlDataLocations.setViewportView(tblDataLocations);

        javax.swing.GroupLayout pnlTableLocationsLayout = new javax.swing.GroupLayout(pnlTableLocations);
        pnlTableLocations.setLayout(pnlTableLocationsLayout);
        pnlTableLocationsLayout.setHorizontalGroup(
            pnlTableLocationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spnlDataLocations)
        );
        pnlTableLocationsLayout.setVerticalGroup(
            pnlTableLocationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLocationsLayout.createSequentialGroup()
                .addComponent(spnlDataLocations, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pnlLocationsListLayout = new javax.swing.GroupLayout(pnlLocationsList);
        pnlLocationsList.setLayout(pnlLocationsListLayout);
        pnlLocationsListLayout.setHorizontalGroup(
            pnlLocationsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFilterLocations, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
            .addComponent(pnlTableLocations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlLocationsListLayout.setVerticalGroup(
            pnlLocationsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLocationsListLayout.createSequentialGroup()
                .addComponent(pnlFilterLocations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTableLocations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tpnlMainQualifier.addTab("Locations", pnlLocationsList);

        pnlFilterTherapist3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlFilterTherapist3.setPreferredSize(new java.awt.Dimension(460, 59));

        lblLookForATA.setText("Look For:");

        btnClearSearchATA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/broom.png"))); // NOI18N
        btnClearSearchATA.setText("Clear");

        javax.swing.GroupLayout pnlFilterTherapist3Layout = new javax.swing.GroupLayout(pnlFilterTherapist3);
        pnlFilterTherapist3.setLayout(pnlFilterTherapist3Layout);
        pnlFilterTherapist3Layout.setHorizontalGroup(
            pnlFilterTherapist3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilterTherapist3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLookForATA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLookForATA, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearSearchATA)
                .addContainerGap(221, Short.MAX_VALUE))
        );
        pnlFilterTherapist3Layout.setVerticalGroup(
            pnlFilterTherapist3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFilterTherapist3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFilterTherapist3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnClearSearchATA)
                    .addComponent(txtLookForATA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLookForATA))
                .addContainerGap())
        );

        tblDataATA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDataATA.setFillsViewportHeight(true);
        tblDataATA.setMinimumSize(new java.awt.Dimension(0, 0));
        tblDataATA.setName(""); // NOI18N
        tblDataATA.setPreferredSize(new java.awt.Dimension(0, 0));
        spnlDataATA.setViewportView(tblDataATA);

        javax.swing.GroupLayout pnlTableListATALayout = new javax.swing.GroupLayout(pnlTableListATA);
        pnlTableListATA.setLayout(pnlTableListATALayout);
        pnlTableListATALayout.setHorizontalGroup(
            pnlTableListATALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spnlDataATA)
        );
        pnlTableListATALayout.setVerticalGroup(
            pnlTableListATALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableListATALayout.createSequentialGroup()
                .addComponent(spnlDataATA, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pnlATALevelsListLayout = new javax.swing.GroupLayout(pnlATALevelsList);
        pnlATALevelsList.setLayout(pnlATALevelsListLayout);
        pnlATALevelsListLayout.setHorizontalGroup(
            pnlATALevelsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFilterTherapist3, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
            .addComponent(pnlTableListATA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlATALevelsListLayout.setVerticalGroup(
            pnlATALevelsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlATALevelsListLayout.createSequentialGroup()
                .addComponent(pnlFilterTherapist3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTableListATA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tpnlMainQualifier.addTab("ATA Levels", pnlATALevelsList);

        javax.swing.GroupLayout pnlMainQualifierLayout = new javax.swing.GroupLayout(pnlMainQualifier);
        pnlMainQualifier.setLayout(pnlMainQualifierLayout);
        pnlMainQualifierLayout.setHorizontalGroup(
            pnlMainQualifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tpnlMainQualifier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMainQualifierLayout.setVerticalGroup(
            pnlMainQualifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainQualifierLayout.createSequentialGroup()
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpnlMainQualifier, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
        );

        add(pnlMainQualifier);
    }// </editor-fold>//GEN-END:initComponents

    // Hide Therapist Panel and go to Home Panel
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        setVisible(false);
        parent.goBackHome();
    }//GEN-LAST:event_btnCloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearSearchATA;
    private javax.swing.JButton btnClearSearchCodes;
    private javax.swing.JButton btnClearSearchLocations;
    private javax.swing.JButton btnClearSearchModifiers;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel lblLookForATA;
    private javax.swing.JLabel lblLookForCodes;
    private javax.swing.JLabel lblLookForLocations;
    private javax.swing.JLabel lblLookForModifiers;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlATALevelsList;
    private javax.swing.JPanel pnlCodesList;
    private javax.swing.JPanel pnlFilterCodes;
    private javax.swing.JPanel pnlFilterLocations;
    private javax.swing.JPanel pnlFilterModifiers;
    private javax.swing.JPanel pnlFilterTherapist3;
    private javax.swing.JPanel pnlLocationsList;
    private javax.swing.JPanel pnlMainQualifier;
    private javax.swing.JPanel pnlModifiersList;
    private javax.swing.JPanel pnlTableCodes;
    private javax.swing.JPanel pnlTableListATA;
    private javax.swing.JPanel pnlTableLocations;
    private javax.swing.JPanel pnlTableModifiers;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JScrollPane spnlDataATA;
    private javax.swing.JScrollPane spnlDataCodes;
    private javax.swing.JScrollPane spnlDataLocations;
    private javax.swing.JScrollPane spnlDataModifiers;
    private javax.swing.JTable tblDataATA;
    private javax.swing.JTable tblDataCodes;
    private javax.swing.JTable tblDataLocations;
    private javax.swing.JTable tblDataModifiers;
    private javax.swing.JTabbedPane tpnlMainQualifier;
    private javax.swing.JTextField txtLookForATA;
    private javax.swing.JTextField txtLookForCodes;
    private javax.swing.JTextField txtLookForLocations;
    private javax.swing.JTextField txtLookForModifiers;
    // End of variables declaration//GEN-END:variables
}
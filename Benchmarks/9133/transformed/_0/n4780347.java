class n4780347 {
	public FlatFileFrame() {
        super("Specify Your Flat File Data");
        try {
            Class VPXgziUH = this.getStorageTransferAgentClass();
            if (VPXgziUH == null) {
                throw new RuntimeException("Transfer agent class can not be null.");
            }
            Class[] VGKsVfbI = new Class[] { RepositoryStorage.class };
            Constructor F4GpakUd = VPXgziUH.getConstructor(VGKsVfbI);
            Object[] Ed9dVbIC = new Object[] { this };
            this.transferAgent = (RepositoryStorageTransferAgent) F4GpakUd.newInstance(Ed9dVbIC);
        } catch (Exception FQdyD2Da) {
            throw new RuntimeException("Unable to instantiate transfer agent.", FQdyD2Da);
        }
        this.fmtlistener = new FormatTableModelListener();
        this.map = new HashMap();
        this.NoCallbackChangeMode = false;
        this.setSize(new Dimension(1000, 400));
        this.setLayout(new GridLayout(1, 1));
        this.Config = new FlatFileToolsConfig();
        this.Config.initialize();
        this.connectionHandler = new RepositoryConnectionHandler(this.Config);
        this.Connection = (FlatFileStorageConnectivity) this.connectionHandler.getConnection("default");
        this.Prefs = new FlatFileToolsPrefs();
        this.Prefs.initialize();
        SimpleDateFormat X7w8j5eH = new SimpleDateFormat("yyyy-MM-dd");
        String aGs8NGXI = X7w8j5eH.format(new Date());
        this.createdOnText = new JTextField(aGs8NGXI);
        this.createdByText = new JTextField(this.Prefs.getConfigValue("createdby"));
        this.reposListeners = new Vector();
        this.removeFormatButton = new JButton("Remove");
        this.previewPanel = new DataSetPanel(new DataSet());
        this.previewPanel.setEditable(false);
        this.chooser = new JFileChooser();
        this.chooser.setMultiSelectionEnabled(true);
        this.enabledRadio = new JRadioButton("Enabled:");
        this.enabledRadio.setSelected(true);
        this.editPrefsButton = new JButton("Preferences...");
        this.editPrefsButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ebJVN3fP) {
                System.out.println("Making visible");
                prefsEditor.setVisible(true);
            }
        });
        this.commentTextArea = new JTextArea(20, 8);
        this.commentTextArea.setText("No comment.");
        this.commentTextArea.setToolTipText("A detailed (possibly formatted) description including guidance to future developers of this set.");
        this.iconServer = new IconServer();
        this.iconServer.setConfigFile(this.Prefs.getConfigValue("default", "iconmapfile"));
        this.nicknameText = new IconifiedDomainNameTextField(new FlatFileFindNameDialog(Config, iconServer), this.iconServer);
        this.nicknameText.setPreferredSize(new Dimension(200, 25));
        this.nicknameText.setText(this.Prefs.getConfigValue("default", "domainname") + ".");
        this.nicknameText.setNameTextToolTipText("Right click to search the database.");
        this.uploadButton = new JButton("Upload");
        this.uploadButton.setToolTipText("Uploads current state to repository.");
        this.uploadButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent q4NTP9YX) {
                System.out.println("Trying to upload flat file spec...");
                try {
                    String xKvB1C1T = getNickname();
                    int KMtOkDtM = xKvB1C1T.lastIndexOf('.');
                    String PjDZv4x8 = "";
                    String Jkki8gJ5 = "";
                    String zCXWErYW = Prefs.getConfigValue("default", "domainname");
                    if (KMtOkDtM > 0) {
                        PjDZv4x8 = xKvB1C1T.substring(0, KMtOkDtM);
                        Jkki8gJ5 = xKvB1C1T.substring(KMtOkDtM + 1, xKvB1C1T.length());
                    } else {
                        Jkki8gJ5 = xKvB1C1T;
                    }
                    Jkki8gJ5 = Jkki8gJ5.trim();
                    if (Jkki8gJ5.equals("")) {
                        JOptionPane.showMessageDialog(null, "Cowardly refusing to upload with an empty flat file name...");
                        return;
                    }
                    if (!PjDZv4x8.equals(zCXWErYW)) {
                        int J2GArGcD = JOptionPane.showConfirmDialog(null, "If you are not the original author, you may wish to switch the current domain name " + PjDZv4x8 + " to \nyour domain name " + zCXWErYW + ".  Would you like to do this?\n (If you'll be using this domain often, you may want to set it in your preferences.)", "Potential WWW name-space clash!", JOptionPane.YES_NO_CANCEL_OPTION);
                        if (J2GArGcD == JOptionPane.YES_OPTION) {
                            setNickname(zCXWErYW + "." + Jkki8gJ5);
                            executeTransfer();
                        }
                        if (J2GArGcD == JOptionPane.NO_OPTION) {
                            executeTransfer();
                        }
                    } else {
                        executeTransfer();
                    }
                } catch (Exception BBDOHacK) {
                    throw new RuntimeException("Problem uploading storage.", BBDOHacK);
                }
            }
        });
        this.repositoryView = new JButton("default");
        this.repositoryView.addActionListener(new ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent tm3Y8R80) {
                repositoryEditor.setCurrentRepository(repositoryView.getText());
                repositoryEditor.setVisible(true);
            }
        });
        this.prefsEditor = new PrefsConfigFrame(this.Prefs);
        this.prefsEditor.setVisible(false);
        this.prefsEditor.addCloseListener(new ActionListener() {

            public void actionPerformed(ActionEvent YpFKFpZW) {
                prefsEditor.setVisible(false);
            }
        });
        this.prefsEditor.addSelectListener(new ActionListener() {

            public void actionPerformed(ActionEvent Vvnz77Ry) {
                prefsEditor.setVisible(false);
            }
        });
        this.repositoryEditor = new ReposConfigFrame(this.Config);
        this.repositoryEditor.setVisible(false);
        this.repositoryEditor.addSelectListener(new SelectListener());
        this.repositoryEditor.addCloseListener(new CloseListener());
        this.addSources = new JButton("Source from file...");
        this.preview = new JButton("Preview");
        this.leastcolumn = new JSpinner();
        this.columns2show = new JSpinner();
        this.leastrow = new JSpinner();
        this.rows2show = new JSpinner();
        int boSESJUx = 10;
        JLabel QHCHAo8Q = new JLabel("File Source");
        this.flatfilesource = new JTextField();
        this.flatfilesource.setPreferredSize(new Dimension(200, 25));
        this.flatfilesource.setMinimumSize(new Dimension(200, 25));
        this.flatfilesource.setMaximumSize(new Dimension(200, 25));
        this.isURLButton = new JRadioButton("URL");
        Box u3cxYc8x = Box.createVerticalBox();
        Box vQ2t8ZyF = Box.createHorizontalBox();
        vQ2t8ZyF.add(this.addSources);
        vQ2t8ZyF.add(QHCHAo8Q);
        vQ2t8ZyF.add(this.flatfilesource);
        vQ2t8ZyF.add(this.isURLButton);
        vQ2t8ZyF.add(this.preview);
        u3cxYc8x.add(vQ2t8ZyF);
        Box YcAIyaso = Box.createVerticalBox();
        Box lmVYmNPj = Box.createVerticalBox();
        JLabel AeAEChl9;
        Box gFC04bYP;
        gFC04bYP = Box.createHorizontalBox();
        AeAEChl9 = new JLabel("Pre-Header Lines:");
        this.preheaderlines = new JSpinner();
        gFC04bYP.add(AeAEChl9);
        gFC04bYP.add(this.preheaderlines);
        lmVYmNPj.add(gFC04bYP);
        this.preheaderlines.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent uOdWOut6) {
                int rLdiHQY0 = fileselector.getSelectedRow();
                if (rLdiHQY0 >= 0) {
                    String wZmCqWD1 = (String) sourcemodel.getValueAt(rLdiHQY0, 0);
                    if (wZmCqWD1 != null) {
                        updateDetailsFor(wZmCqWD1);
                    }
                }
            }
        });
        gFC04bYP = Box.createHorizontalBox();
        AeAEChl9 = new JLabel("Has Header Line:");
        this.hasHeaderLineBox = new JCheckBox();
        gFC04bYP.add(AeAEChl9);
        gFC04bYP.add(this.hasHeaderLineBox);
        lmVYmNPj.add(gFC04bYP);
        this.hasHeaderLineBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent SF3K18eE) {
                int fmvGTaVS = fileselector.getSelectedRow();
                if (fmvGTaVS >= 0) {
                    String pbV5d01n = (String) sourcemodel.getValueAt(fmvGTaVS, 0);
                    if (pbV5d01n != null) {
                        pbV5d01n = pbV5d01n.trim();
                        if ((pbV5d01n != null) && (pbV5d01n.length() > 0)) {
                            updateDetailsFor(pbV5d01n);
                        }
                    }
                }
            }
        });
        gFC04bYP = Box.createHorizontalBox();
        AeAEChl9 = new JLabel("Post-Header Lines:");
        this.postheaderlines = new JSpinner();
        gFC04bYP.add(AeAEChl9);
        gFC04bYP.add(this.postheaderlines);
        lmVYmNPj.add(gFC04bYP);
        this.postheaderlines.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent Dr1dqXxZ) {
                int AS8b758o = fileselector.getSelectedRow();
                if (AS8b758o >= 0) {
                    String bb1aYY7w = (String) sourcemodel.getValueAt(AS8b758o, 0);
                    if (bb1aYY7w != null) {
                        bb1aYY7w = bb1aYY7w.trim();
                        if ((bb1aYY7w != null) && (bb1aYY7w.length() > 0)) {
                            updateDetailsFor(bb1aYY7w);
                        }
                    }
                }
            }
        });
        gFC04bYP = Box.createHorizontalBox();
        AeAEChl9 = new JLabel("Format:");
        gFC04bYP.add(AeAEChl9);
        this.singleFormatText = new JTextField("%s");
        gFC04bYP.add(this.singleFormatText);
        gFC04bYP.add(new JLabel("Repeat"));
        this.repeatFormatNumber = new JSpinner();
        this.repeatFormatNumber.setValue(new Integer(1));
        gFC04bYP.add(this.repeatFormatNumber);
        this.addFormatButton = new JButton("Add");
        gFC04bYP.add(this.addFormatButton);
        this.removeFormatButton = new JButton("Remove");
        gFC04bYP.add(this.removeFormatButton);
        lmVYmNPj.add(gFC04bYP);
        gFC04bYP = Box.createHorizontalBox();
        AeAEChl9 = new JLabel("Column Format:");
        this.formatmodel = new FormatTableModel();
        this.formatTable = new JTable(this.formatmodel);
        this.formatmodel.addTableModelListener(this.fmtlistener);
        JTable dhMAHBVX = this.formatTable.getTableHeader().getTable();
        this.formatTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane W6JuHkFC = new JScrollPane(this.formatTable);
        W6JuHkFC.setPreferredSize(new Dimension(200, 100));
        gFC04bYP.add(AeAEChl9);
        gFC04bYP.add(W6JuHkFC);
        lmVYmNPj.add(gFC04bYP);
        gFC04bYP = Box.createHorizontalBox();
        AeAEChl9 = new JLabel("Field Delimiter:");
        this.fieldDelimiter = new JTextField("\\t");
        this.fieldDelimiter.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent eRznH3V3) {
                int yWqt9Iaw = fileselector.getSelectedRow();
                if (yWqt9Iaw >= 0) {
                    String cw5kYm27 = (String) sourcemodel.getValueAt(yWqt9Iaw, 0);
                    if (cw5kYm27 != null) {
                        cw5kYm27 = cw5kYm27.trim();
                        if ((cw5kYm27 != null) && (cw5kYm27.length() > 0)) {
                            updateDetailsFor(cw5kYm27);
                        }
                    }
                }
            }
        });
        gFC04bYP.add(AeAEChl9);
        gFC04bYP.add(this.fieldDelimiter);
        this.inferButton = new JButton("Infer");
        this.inferButton.setEnabled(false);
        gFC04bYP.add(this.inferButton);
        lmVYmNPj.add(gFC04bYP);
        gFC04bYP = Box.createHorizontalBox();
        AeAEChl9 = new JLabel("Record Delimiter:");
        this.recordDelimiter = new JTextField("\\n");
        this.recordDelimiter.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent FMlUb9Wa) {
                int upCaiDU0 = fileselector.getSelectedRow();
                if (upCaiDU0 >= 0) {
                    String HBne3fww = (String) sourcemodel.getValueAt(upCaiDU0, 0);
                    if (HBne3fww != null) {
                        HBne3fww = HBne3fww.trim();
                        if ((HBne3fww != null) && (HBne3fww.length() > 0)) {
                            updateDetailsFor(HBne3fww);
                        }
                    }
                }
            }
        });
        gFC04bYP.add(AeAEChl9);
        gFC04bYP.add(this.recordDelimiter);
        lmVYmNPj.add(gFC04bYP);
        lmVYmNPj.add(Box.createVerticalGlue());
        lmVYmNPj.add(Box.createVerticalGlue());
        YcAIyaso.add(vQ2t8ZyF);
        YcAIyaso.add(lmVYmNPj);
        YcAIyaso.add(previewPanel);
        this.addFormatButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent EPM4FtBK) {
                String RGD1d1QG = singleFormatText.getText();
                Integer hxHEoiCR = (Integer) repeatFormatNumber.getValue();
                Vector t6ubRKPv = formatmodel.getFormatParts();
                int QYk0tlaC = formatTable.getSelectedColumn();
                if (QYk0tlaC < 0) {
                    QYk0tlaC = formatTable.getColumnCount() - 1;
                }
                for (int gRR3vBBW = 1; gRR3vBBW <= hxHEoiCR.intValue(); gRR3vBBW++) {
                    t6ubRKPv.insertElementAt(RGD1d1QG, QYk0tlaC);
                }
                formatmodel.setFormatParts(t6ubRKPv);
                updateFormatTable();
                int Z5zPFJxJ = fileselector.getSelectedRow();
                if ((Z5zPFJxJ < sourcemodel.getRowCount()) && (Z5zPFJxJ >= 0)) {
                    String jTIySMwA = (String) sourcemodel.getValueAt(Z5zPFJxJ, 0);
                    jTIySMwA = jTIySMwA.trim();
                    if (jTIySMwA != null) {
                        jTIySMwA = jTIySMwA.trim();
                        if ((jTIySMwA != null) && (jTIySMwA.length() > 0)) {
                            updateDetailsFor(jTIySMwA);
                        }
                    }
                }
            }
        });
        this.removeFormatButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent x0H3T0QD) {
                int Ukk8iQ6W = formatTable.getSelectedColumn();
                if (Ukk8iQ6W < 0) {
                    return;
                }
                Vector Fo5UoECu = formatmodel.getFormatParts();
                if (Fo5UoECu.size() == 1) {
                    throw new RuntimeException("At least one format column is required.");
                }
                Fo5UoECu.removeElementAt(Ukk8iQ6W);
                formatmodel.setFormatParts(Fo5UoECu);
                updateFormatTable();
                int YUYBj9TR = fileselector.getSelectedRow();
                if ((YUYBj9TR < sourcemodel.getRowCount()) && (YUYBj9TR >= 0)) {
                    String ksFCBTVt = (String) sourcemodel.getValueAt(YUYBj9TR, 0);
                    ksFCBTVt = ksFCBTVt.trim();
                    if (ksFCBTVt != null) {
                        ksFCBTVt = ksFCBTVt.trim();
                        if ((ksFCBTVt != null) && (ksFCBTVt.length() > 0)) {
                            updateDetailsFor(ksFCBTVt);
                        }
                    }
                }
                System.out.println("The new Column count after remove is " + formatmodel.getColumnCount());
            }
        });
        this.inferButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ZHpY0K2F) {
                int OWDZnKb2 = fileselector.getSelectedRow();
                int r3FicIBZ = 0;
                String YMqZ50N2 = (String) sourcemodel.getValueAt(0, 0);
                Boolean SfKzieyn = (Boolean) sourcemodel.getValueAt(0, 1);
                BufferedReader XuY9APT4 = null;
                File eBnxOxQU = null;
                DataInputStream qzk51jsb = null;
                if (SfKzieyn.booleanValue()) {
                    try {
                        URL rU7eUR4y = new URL(YMqZ50N2);
                        qzk51jsb = new DataInputStream(rU7eUR4y.openStream());
                        System.out.println("READY TO READ FROM URL:" + rU7eUR4y);
                    } catch (Exception w5tNeTqD) {
                        throw new RuntimeException("Problem constructing URI for " + YMqZ50N2 + ".", w5tNeTqD);
                    }
                } else {
                    eBnxOxQU = new File(YMqZ50N2);
                    if (!eBnxOxQU.exists()) {
                        throw new RuntimeException("The file named '" + YMqZ50N2 + "' does not exist.");
                    }
                    FileInputStream trrE8Ar4 = null;
                    try {
                        trrE8Ar4 = new FileInputStream(YMqZ50N2);
                        qzk51jsb = new DataInputStream(trrE8Ar4);
                    } catch (Exception z7ra7f72) {
                        throw new RuntimeException("Problem creating FileInputStream for " + YMqZ50N2 + ".", z7ra7f72);
                    }
                }
                XuY9APT4 = new BufferedReader(new InputStreamReader(qzk51jsb));
                JTable asYz1WYl = formatTable.getTableHeader().getTable();
                try {
                    String ZHfo7pY5;
                    int KAXMygiv = 0;
                    int G0y7alBA = ((Integer) preheaderlines.getValue()).intValue();
                    int gRt9n8xg = ((Integer) postheaderlines.getValue()).intValue();
                    int k9tCOrhu = 0;
                    boolean UVbqjFWR = false;
                    if (hasHeaderLineBox.isSelected()) {
                        UVbqjFWR = true;
                    }
                    if (UVbqjFWR) {
                        k9tCOrhu = 1;
                    }
                    String sQYh1K20 = fieldDelimiter.getText();
                    while ((ZHfo7pY5 = XuY9APT4.readLine()) != null) {
                        if (KAXMygiv <= (G0y7alBA + k9tCOrhu + gRt9n8xg)) {
                            System.out.println(ZHfo7pY5);
                        } else {
                            String[] ZH2sr6Mj = ZHfo7pY5.split(sQYh1K20);
                            System.out.println("The number of potential columns is " + ZH2sr6Mj.length);
                            String ZYWD32MR = "";
                            while (formatTable.getColumnCount() > ZH2sr6Mj.length) {
                                TableColumn BOFufkpB = formatTable.getColumnModel().getColumn(0);
                                formatTable.removeColumn(BOFufkpB);
                            }
                            for (int sfbWjXhS = 0; sfbWjXhS < ZH2sr6Mj.length; sfbWjXhS++) {
                                String lRPXChx0 = "";
                                try {
                                    Double vLLx0BuJ = new Double(ZH2sr6Mj[sfbWjXhS]);
                                    lRPXChx0 = "%f";
                                } catch (Exception nmyQBgzh) {
                                    lRPXChx0 = "%s";
                                }
                                ZYWD32MR = ZYWD32MR + lRPXChx0;
                                formatTable.setValueAt(lRPXChx0, 0, sfbWjXhS);
                            }
                            System.out.println("The potential format is " + ZYWD32MR);
                            formatmodel.setFormat(ZYWD32MR);
                            break;
                        }
                        KAXMygiv++;
                    }
                    qzk51jsb.close();
                } catch (Exception UF57bh92) {
                    throw new RuntimeException("Problem reading single line from file.", UF57bh92);
                }
                for (int XETsqAzm = 0; XETsqAzm < formatTable.getColumnCount(); XETsqAzm++) {
                    asYz1WYl.getColumnModel().getColumn(XETsqAzm).setHeaderValue("" + (XETsqAzm + 1));
                }
                formatTable.repaint();
            }
        });
        Box HsE84s7m = Box.createHorizontalBox();
        HsE84s7m.add(YcAIyaso);
        Box i9kXu0zt = Box.createVerticalBox();
        Box nWy5bG8t = Box.createHorizontalBox();
        nWy5bG8t.add(this.editPrefsButton);
        gFC04bYP = Box.createHorizontalBox();
        AeAEChl9 = new JLabel("Created On:");
        gFC04bYP.add(AeAEChl9);
        this.createdOnText.setPreferredSize(new Dimension(50, 25));
        gFC04bYP.add(this.createdOnText);
        nWy5bG8t.add(gFC04bYP);
        gFC04bYP = Box.createHorizontalBox();
        AeAEChl9 = new JLabel("Created By:");
        gFC04bYP.add(AeAEChl9);
        this.createdByText.setPreferredSize(new Dimension(50, 25));
        gFC04bYP.add(this.createdByText);
        nWy5bG8t.add(gFC04bYP);
        nWy5bG8t.add(this.uploadButton);
        nWy5bG8t.add(this.repositoryView);
        nWy5bG8t.add(this.nicknameText);
        nWy5bG8t.add(this.enabledRadio);
        i9kXu0zt.add(nWy5bG8t);
        gFC04bYP = Box.createHorizontalBox();
        AeAEChl9 = new JLabel("Comment:");
        gFC04bYP.add(AeAEChl9);
        gFC04bYP.add(new JScrollPane(this.commentTextArea));
        i9kXu0zt.add(gFC04bYP);
        i9kXu0zt.add(HsE84s7m);
        i9kXu0zt.add(previewPanel);
        this.add(i9kXu0zt);
        this.addSources.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent YFxktVNO) {
                int O0mnEc90 = chooser.showOpenDialog(null);
                File[] OS76z2PO = null;
                if (O0mnEc90 == JFileChooser.APPROVE_OPTION) {
                    OS76z2PO = chooser.getSelectedFiles();
                    if (OS76z2PO.length > 10) {
                        ((DefaultTableModel) sourcemodel).setRowCount(OS76z2PO.length);
                    } else {
                        ((DefaultTableModel) sourcemodel).setRowCount(10);
                    }
                    for (int Z7KrSTL3 = 0; Z7KrSTL3 < OS76z2PO.length; Z7KrSTL3++) {
                        sourcemodel.setValueAt(OS76z2PO[Z7KrSTL3].getAbsolutePath(), Z7KrSTL3, 0);
                    }
                }
                if (anyNonEmptySources()) {
                    allowFormatParsing(true);
                } else {
                    allowFormatParsing(false);
                }
            }
        });
        this.preview.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent JK6rZDug) {
                FlatFileDOM[] iry6oUaQ = new FlatFileDOM[map.size()];
                int vebkKaNA = 0;
                for (int cbqcl6Yu = 0; cbqcl6Yu < sourcemodel.getRowCount(); cbqcl6Yu++) {
                    String jyVuF3fh = (String) sourcemodel.getValueAt(cbqcl6Yu, 0);
                    if (map.containsKey(jyVuF3fh)) {
                        iry6oUaQ[vebkKaNA] = (FlatFileDOM) map.get(jyVuF3fh);
                        vebkKaNA++;
                    }
                }
                Vector oliWZdOW = null;
                Vector wXfahq2H = null;
                for (int srkBkfnL = 0; srkBkfnL < iry6oUaQ.length; srkBkfnL++) {
                    DataSetReader tOfe4PZq = new DataSetReader(iry6oUaQ[srkBkfnL]);
                    int hzBDYeKm = tOfe4PZq.determineRowCount();
                    iry6oUaQ[srkBkfnL].setRowCount(hzBDYeKm);
                    if (srkBkfnL == 0) {
                        oliWZdOW = tOfe4PZq.getHeaders();
                        wXfahq2H = tOfe4PZq.getTypes();
                    }
                    System.out.println("The number of rows is=" + hzBDYeKm);
                }
                System.out.println("Creating flatfileset");
                FlatFileSet qN7BrWdA = new FlatFileSet(iry6oUaQ);
                System.out.println("Finished sorting!!!");
                for (int piFv0k8B = 0; piFv0k8B < oliWZdOW.size(); piFv0k8B++) {
                    qN7BrWdA.addColumn((String) oliWZdOW.get(piFv0k8B), (Class) wXfahq2H.get(piFv0k8B));
                }
                System.out.println("Number of headers is=" + oliWZdOW.size());
                System.out.println("The dataset rc is " + qN7BrWdA.getRowCount());
                System.out.println("The dataset cc is " + qN7BrWdA.getColumnCount());
                previewPanel.setDataSet(qN7BrWdA);
                previewPanel.setVerticalScrollIntermittant(true);
                previewPanel.setHorizontalScrollIntermittant(true);
                previewPanel.setEditable(false);
                if (anyNonEmptySources()) {
                    allowFormatParsing(true);
                } else {
                    allowFormatParsing(false);
                }
            }
        });
        allowFormatParsing(false);
        this.formatTable.repaint();
    }

}
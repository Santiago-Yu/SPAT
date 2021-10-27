class n4780347 {
	public FlatFileFrame() {
        super("Specify Your Flat File Data");
        try {
            Class transferAgentClass = this.getStorageTransferAgentClass();
            if (transferAgentClass == null) {
                throw new RuntimeException("Transfer agent class can not be null.");
            }
            Class[] parameterTypes = new Class[] { RepositoryStorage.class };
            Constructor constr = transferAgentClass.getConstructor(parameterTypes);
            Object[] actualValues = new Object[] { this };
            this.transferAgent = (RepositoryStorageTransferAgent) constr.newInstance(actualValues);
        } catch (Exception err) {
            throw new RuntimeException("Unable to instantiate transfer agent.", err);
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
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formatted_date = formatter.format(new Date());
        this.createdOnText = new JTextField(formatted_date);
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

            public void actionPerformed(ActionEvent ev) {
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

            public void actionPerformed(ActionEvent ev) {
                System.out.println("Trying to upload flat file spec...");
                try {
                    String expname = getNickname();
                    int split = expname.lastIndexOf('.');
                    String domain = "";
                    String name = "";
                    String usersdomain = Prefs.getConfigValue("default", "domainname");
                    if (split > 0) {
                        domain = expname.substring(0, split);
                        name = expname.substring(split + 1, expname.length());
                    } else {
                        name = expname;
                    }
                    name = name.trim();
                    if (name.equals("")) {
                        JOptionPane.showMessageDialog(null, "Cowardly refusing to upload with an empty flat file name...");
                        return;
                    }
                    if (!domain.equals(usersdomain)) {
                        int s = JOptionPane.showConfirmDialog(null, "If you are not the original author, you may wish to switch the current domain name " + domain + " to \nyour domain name " + usersdomain + ".  Would you like to do this?\n (If you'll be using this domain often, you may want to set it in your preferences.)", "Potential WWW name-space clash!", JOptionPane.YES_NO_CANCEL_OPTION);
                        if (s == JOptionPane.YES_OPTION) {
                            setNickname(usersdomain + "." + name);
                            executeTransfer();
                        }
                        if (s == JOptionPane.NO_OPTION) {
                            executeTransfer();
                        }
                    } else {
                        executeTransfer();
                    }
                } catch (Exception err) {
                    throw new RuntimeException("Problem uploading storage.", err);
                }
            }
        });
        this.repositoryView = new JButton("default");
        this.repositoryView.addActionListener(new ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent e) {
                repositoryEditor.setCurrentRepository(repositoryView.getText());
                repositoryEditor.setVisible(true);
            }
        });
        this.prefsEditor = new PrefsConfigFrame(this.Prefs);
        this.prefsEditor.setVisible(false);
        this.prefsEditor.addCloseListener(new ActionListener() {

            public void actionPerformed(ActionEvent ev) {
                prefsEditor.setVisible(false);
            }
        });
        this.prefsEditor.addSelectListener(new ActionListener() {

            public void actionPerformed(ActionEvent ev) {
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
        int rowCount = 10;
        JLabel sourceLabel = new JLabel("File Source");
        this.flatfilesource = new JTextField();
        this.flatfilesource.setPreferredSize(new Dimension(200, 25));
        this.flatfilesource.setMinimumSize(new Dimension(200, 25));
        this.flatfilesource.setMaximumSize(new Dimension(200, 25));
        this.isURLButton = new JRadioButton("URL");
        Box scrollBox = Box.createVerticalBox();
        Box srcBox = Box.createHorizontalBox();
        srcBox.add(this.addSources);
        srcBox.add(sourceLabel);
        srcBox.add(this.flatfilesource);
        srcBox.add(this.isURLButton);
        srcBox.add(this.preview);
        scrollBox.add(srcBox);
        Box detailsPanel = Box.createVerticalBox();
        Box detailsBox = Box.createVerticalBox();
        JLabel label;
        Box jointBox;
        jointBox = Box.createHorizontalBox();
        label = new JLabel("Pre-Header Lines:");
        this.preheaderlines = new JSpinner();
        jointBox.add(label);
        jointBox.add(this.preheaderlines);
        detailsBox.add(jointBox);
        this.preheaderlines.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent ev) {
                int selectedRow = fileselector.getSelectedRow();
                if (selectedRow >= 0) {
                    String fn = (String) sourcemodel.getValueAt(selectedRow, 0);
                    if (fn != null) {
                        updateDetailsFor(fn);
                    }
                }
            }
        });
        jointBox = Box.createHorizontalBox();
        label = new JLabel("Has Header Line:");
        this.hasHeaderLineBox = new JCheckBox();
        jointBox.add(label);
        jointBox.add(this.hasHeaderLineBox);
        detailsBox.add(jointBox);
        this.hasHeaderLineBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ev) {
                int selectedRow = fileselector.getSelectedRow();
                if (selectedRow >= 0) {
                    String fn = (String) sourcemodel.getValueAt(selectedRow, 0);
                    if (fn != null) {
                        fn = fn.trim();
                        boolean ndzrqgA0 = fn != null;
						if ((ndzrqgA0) && (fn.length() > 0)) {
                            updateDetailsFor(fn);
                        }
                    }
                }
            }
        });
        jointBox = Box.createHorizontalBox();
        label = new JLabel("Post-Header Lines:");
        this.postheaderlines = new JSpinner();
        jointBox.add(label);
        jointBox.add(this.postheaderlines);
        detailsBox.add(jointBox);
        this.postheaderlines.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent ev) {
                int selectedRow = fileselector.getSelectedRow();
                if (selectedRow >= 0) {
                    String fn = (String) sourcemodel.getValueAt(selectedRow, 0);
                    if (fn != null) {
                        fn = fn.trim();
                        boolean CrFjWFA0 = fn != null;
						if ((CrFjWFA0) && (fn.length() > 0)) {
                            updateDetailsFor(fn);
                        }
                    }
                }
            }
        });
        jointBox = Box.createHorizontalBox();
        label = new JLabel("Format:");
        jointBox.add(label);
        this.singleFormatText = new JTextField("%s");
        jointBox.add(this.singleFormatText);
        jointBox.add(new JLabel("Repeat"));
        this.repeatFormatNumber = new JSpinner();
        this.repeatFormatNumber.setValue(new Integer(1));
        jointBox.add(this.repeatFormatNumber);
        this.addFormatButton = new JButton("Add");
        jointBox.add(this.addFormatButton);
        this.removeFormatButton = new JButton("Remove");
        jointBox.add(this.removeFormatButton);
        detailsBox.add(jointBox);
        jointBox = Box.createHorizontalBox();
        label = new JLabel("Column Format:");
        this.formatmodel = new FormatTableModel();
        this.formatTable = new JTable(this.formatmodel);
        this.formatmodel.addTableModelListener(this.fmtlistener);
        JTable hdrTable = this.formatTable.getTableHeader().getTable();
        this.formatTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane fsp = new JScrollPane(this.formatTable);
        fsp.setPreferredSize(new Dimension(200, 100));
        jointBox.add(label);
        jointBox.add(fsp);
        detailsBox.add(jointBox);
        jointBox = Box.createHorizontalBox();
        label = new JLabel("Field Delimiter:");
        this.fieldDelimiter = new JTextField("\\t");
        this.fieldDelimiter.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ev) {
                int selectedRow = fileselector.getSelectedRow();
                if (selectedRow >= 0) {
                    String fn = (String) sourcemodel.getValueAt(selectedRow, 0);
                    if (fn != null) {
                        fn = fn.trim();
                        boolean h7Cegwqx = fn != null;
						if ((h7Cegwqx) && (fn.length() > 0)) {
                            updateDetailsFor(fn);
                        }
                    }
                }
            }
        });
        jointBox.add(label);
        jointBox.add(this.fieldDelimiter);
        this.inferButton = new JButton("Infer");
        this.inferButton.setEnabled(false);
        jointBox.add(this.inferButton);
        detailsBox.add(jointBox);
        jointBox = Box.createHorizontalBox();
        label = new JLabel("Record Delimiter:");
        this.recordDelimiter = new JTextField("\\n");
        this.recordDelimiter.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ev) {
                int selectedRow = fileselector.getSelectedRow();
                if (selectedRow >= 0) {
                    String fn = (String) sourcemodel.getValueAt(selectedRow, 0);
                    if (fn != null) {
                        fn = fn.trim();
                        boolean SV9QQbww = fn != null;
						if ((SV9QQbww) && (fn.length() > 0)) {
                            updateDetailsFor(fn);
                        }
                    }
                }
            }
        });
        jointBox.add(label);
        jointBox.add(this.recordDelimiter);
        detailsBox.add(jointBox);
        detailsBox.add(Box.createVerticalGlue());
        detailsBox.add(Box.createVerticalGlue());
        detailsPanel.add(srcBox);
        detailsPanel.add(detailsBox);
        detailsPanel.add(previewPanel);
        this.addFormatButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ev) {
                String fmt2rep = singleFormatText.getText();
                Integer rep = (Integer) repeatFormatNumber.getValue();
                Vector fmtparts = formatmodel.getFormatParts();
                int selectedCol = formatTable.getSelectedColumn();
                if (selectedCol < 0) {
                    selectedCol = formatTable.getColumnCount() - 1;
                }
                for (int r = 1; r <= rep.intValue(); r++) {
                    fmtparts.insertElementAt(fmt2rep, selectedCol);
                }
                formatmodel.setFormatParts(fmtparts);
                updateFormatTable();
                int selectedRow = fileselector.getSelectedRow();
                boolean VFu4aXRh = selectedRow >= 0;
				if ((selectedRow < sourcemodel.getRowCount()) && (VFu4aXRh)) {
                    String fn = (String) sourcemodel.getValueAt(selectedRow, 0);
                    fn = fn.trim();
                    if (fn != null) {
                        fn = fn.trim();
                        boolean mQjAbLqF = fn != null;
						if ((mQjAbLqF) && (fn.length() > 0)) {
                            updateDetailsFor(fn);
                        }
                    }
                }
            }
        });
        this.removeFormatButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ev) {
                int selectedCol = formatTable.getSelectedColumn();
                if (selectedCol < 0) {
                    return;
                }
                Vector parts = formatmodel.getFormatParts();
                if (parts.size() == 1) {
                    throw new RuntimeException("At least one format column is required.");
                }
                parts.removeElementAt(selectedCol);
                formatmodel.setFormatParts(parts);
                updateFormatTable();
                int selectedRow = fileselector.getSelectedRow();
                boolean fQQe0YQD = selectedRow >= 0;
				if ((selectedRow < sourcemodel.getRowCount()) && (fQQe0YQD)) {
                    String fn = (String) sourcemodel.getValueAt(selectedRow, 0);
                    fn = fn.trim();
                    if (fn != null) {
                        fn = fn.trim();
                        boolean JqbKZ156 = fn != null;
						if ((JqbKZ156) && (fn.length() > 0)) {
                            updateDetailsFor(fn);
                        }
                    }
                }
                System.out.println("The new Column count after remove is " + formatmodel.getColumnCount());
            }
        });
        this.inferButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ev) {
                int row = fileselector.getSelectedRow();
                int col = 0;
                String filename = (String) sourcemodel.getValueAt(0, 0);
                Boolean isURL = (Boolean) sourcemodel.getValueAt(0, 1);
                BufferedReader br = null;
                File file = null;
                DataInputStream in = null;
                if (isURL.booleanValue()) {
                    try {
                        URL url2goto = new URL(filename);
                        in = new DataInputStream(url2goto.openStream());
                        System.out.println("READY TO READ FROM URL:" + url2goto);
                    } catch (Exception err) {
                        throw new RuntimeException("Problem constructing URI for " + filename + ".", err);
                    }
                } else {
                    file = new File(filename);
                    if (!file.exists()) {
                        throw new RuntimeException("The file named '" + filename + "' does not exist.");
                    }
                    FileInputStream fstream = null;
                    try {
                        fstream = new FileInputStream(filename);
                        in = new DataInputStream(fstream);
                    } catch (Exception err) {
                        throw new RuntimeException("Problem creating FileInputStream for " + filename + ".", err);
                    }
                }
                br = new BufferedReader(new InputStreamReader(in));
                JTable hdrTable = formatTable.getTableHeader().getTable();
                try {
                    String strLine;
                    int line = 0;
                    int ignorePreHdrLines = ((Integer) preheaderlines.getValue()).intValue();
                    int ignorePostHdrLines = ((Integer) postheaderlines.getValue()).intValue();
                    int numhdr = 0;
                    boolean hasHeaderLine = false;
                    if (hasHeaderLineBox.isSelected()) {
                        hasHeaderLine = true;
                    }
                    if (hasHeaderLine) {
                        numhdr = 1;
                    }
                    String FD = fieldDelimiter.getText();
                    while ((strLine = br.readLine()) != null) {
                        int WtSukP9l = ignorePreHdrLines + numhdr + ignorePostHdrLines;
						if (line <= (WtSukP9l)) {
                            System.out.println(strLine);
                        } else {
                            String[] putative_cols = strLine.split(FD);
                            System.out.println("The number of potential columns is " + putative_cols.length);
                            String FMT = "";
                            while (formatTable.getColumnCount() > putative_cols.length) {
                                TableColumn tcol = formatTable.getColumnModel().getColumn(0);
                                formatTable.removeColumn(tcol);
                            }
                            for (int i = 0; i < putative_cols.length; i++) {
                                String fmt = "";
                                try {
                                    Double dummy = new Double(putative_cols[i]);
                                    fmt = "%f";
                                } catch (Exception err) {
                                    fmt = "%s";
                                }
                                FMT = FMT + fmt;
                                formatTable.setValueAt(fmt, 0, i);
                            }
                            System.out.println("The potential format is " + FMT);
                            formatmodel.setFormat(FMT);
                            break;
                        }
                        line++;
                    }
                    in.close();
                } catch (Exception err) {
                    throw new RuntimeException("Problem reading single line from file.", err);
                }
                for (int j = 0; j < formatTable.getColumnCount(); j++) {
                    int Z6W0gwsQ = j + 1;
					hdrTable.getColumnModel().getColumn(j).setHeaderValue("" + (Z6W0gwsQ));
                }
                formatTable.repaint();
            }
        });
        Box topbox = Box.createHorizontalBox();
        topbox.add(detailsPanel);
        Box mainbox = Box.createVerticalBox();
        Box setBox = Box.createHorizontalBox();
        setBox.add(this.editPrefsButton);
        jointBox = Box.createHorizontalBox();
        label = new JLabel("Created On:");
        jointBox.add(label);
        this.createdOnText.setPreferredSize(new Dimension(50, 25));
        jointBox.add(this.createdOnText);
        setBox.add(jointBox);
        jointBox = Box.createHorizontalBox();
        label = new JLabel("Created By:");
        jointBox.add(label);
        this.createdByText.setPreferredSize(new Dimension(50, 25));
        jointBox.add(this.createdByText);
        setBox.add(jointBox);
        setBox.add(this.uploadButton);
        setBox.add(this.repositoryView);
        setBox.add(this.nicknameText);
        setBox.add(this.enabledRadio);
        mainbox.add(setBox);
        jointBox = Box.createHorizontalBox();
        label = new JLabel("Comment:");
        jointBox.add(label);
        jointBox.add(new JScrollPane(this.commentTextArea));
        mainbox.add(jointBox);
        mainbox.add(topbox);
        mainbox.add(previewPanel);
        this.add(mainbox);
        this.addSources.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ev) {
                int option = chooser.showOpenDialog(null);
                File[] files = null;
                if (option == JFileChooser.APPROVE_OPTION) {
                    files = chooser.getSelectedFiles();
                    if (files.length > 10) {
                        ((DefaultTableModel) sourcemodel).setRowCount(files.length);
                    } else {
                        ((DefaultTableModel) sourcemodel).setRowCount(10);
                    }
                    for (int i = 0; i < files.length; i++) {
                        sourcemodel.setValueAt(files[i].getAbsolutePath(), i, 0);
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

            public void actionPerformed(ActionEvent ev) {
                FlatFileDOM[] filespecs = new FlatFileDOM[map.size()];
                int k = 0;
                for (int j = 0; j < sourcemodel.getRowCount(); j++) {
                    String fn = (String) sourcemodel.getValueAt(j, 0);
                    if (map.containsKey(fn)) {
                        filespecs[k] = (FlatFileDOM) map.get(fn);
                        k++;
                    }
                }
                Vector hdrs = null;
                Vector types = null;
                for (int j = 0; j < filespecs.length; j++) {
                    DataSetReader rdr = new DataSetReader(filespecs[j]);
                    int rc = rdr.determineRowCount();
                    filespecs[j].setRowCount(rc);
                    if (j == 0) {
                        hdrs = rdr.getHeaders();
                        types = rdr.getTypes();
                    }
                    System.out.println("The number of rows is=" + rc);
                }
                System.out.println("Creating flatfileset");
                FlatFileSet dataset = new FlatFileSet(filespecs);
                System.out.println("Finished sorting!!!");
                for (int j = 0; j < hdrs.size(); j++) {
                    dataset.addColumn((String) hdrs.get(j), (Class) types.get(j));
                }
                System.out.println("Number of headers is=" + hdrs.size());
                System.out.println("The dataset rc is " + dataset.getRowCount());
                System.out.println("The dataset cc is " + dataset.getColumnCount());
                previewPanel.setDataSet(dataset);
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
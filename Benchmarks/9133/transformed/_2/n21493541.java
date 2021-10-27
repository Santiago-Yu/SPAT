class n21493541 {
	public UpdaterView(SingleFrameApplication app, String[] args) {
        super(app);
        if (args.length != 3) {
            System.out.println("Args must be passed.");
            System.exit(1);
        } else {
            currentVersion = Double.parseDouble(args[0]);
            currentDBVersion = Double.parseDouble(args[1]);
            dbAdmin = args[2].equals("true") ? true : false;
        }
        initComponents();
        try {
            URL url = new URL(BASE_URL + "version.txt");
            InputStream in = url.openStream();
            BufferedInputStream buffIn = new BufferedInputStream(in);
            String tmp = "";
            int data = buffIn.read();
            for (; data != -1;) {
				tmp = tmp.concat(Character.toString((char) data));
				data = buffIn.read();
			}
            String[] versionEntries = tmp.split("\n");
            if (versionEntries.length > 0) {
                String[] components = versionEntries[0].split(":");
                if (dbAdmin || Double.parseDouble(components[4]) == currentDBVersion) {
                    byteCount = Integer.parseInt(components[2]);
                    lblCurrent.setText(new Double(currentVersion).toString());
                    lblLatest.setText(components[0]);
                    latestVersionNum = Double.parseDouble(components[0]);
                    lblNotes.setText("<html>" + components[1]);
                    md5Hash = components[3];
                    latestDBVersion = Double.parseDouble(components[4]);
                    upgradeURL = components[5];
                    progressBar.setMaximum(byteCount);
                    if (dbAdmin && Double.parseDouble(components[4]) > currentDBVersion) {
                        schemaUpdatesNeeded = true;
                        schemaChanges.addFirst(latestDBVersion);
                        double lastVersion = latestDBVersion;
                        for (int i = 1; i < versionEntries.length; i++) {
                            components = versionEntries[i].split(":");
                            double nextVers = Double.parseDouble(components[4]);
                            if (nextVers != currentDBVersion) {
                                if (lastVersion != nextVers) {
                                    schemaChanges.addFirst(nextVers);
                                    lastVersion = nextVers;
                                }
                            } else {
                                schemaChanges.addFirst(currentDBVersion);
                                break;
                            }
                        }
                    }
                } else {
                    for (int i = 1; i < versionEntries.length; i++) {
                        components = versionEntries[i].split(":");
                        if (Double.parseDouble(components[4]) == currentDBVersion) {
                            byteCount = Integer.parseInt(components[2]);
                            lblCurrent.setText(new Double(currentVersion).toString());
                            lblLatest.setText(components[0]);
                            latestVersionNum = Double.parseDouble(components[0]);
                            lblNotes.setText("<html>" + components[1]);
                            md5Hash = components[3];
                            latestDBVersion = Double.parseDouble(components[4]);
                            upgradeURL = components[5];
                            progressBar.setMaximum(byteCount);
                            schemaUpdatesNeeded = true;
                            break;
                        }
                    }
                }
            } else {
                throw new InvalidUpdateFileFormatException("File Format is Wrong.");
            }
            if (latestVersionNum == currentVersion) {
                if (schemaUpdatesNeeded) {
                    javax.swing.JOptionPane.showMessageDialog(super.getComponent(), "Updates are available but they require database changes.  Please contact your system administrator to perform the upgrade.", "Myopa Updater", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(super.getComponent(), "No Updates are available - your software is up to date!", "Myopa Updater", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
                System.exit(0);
            } else {
                jButton1.setEnabled(true);
            }
        } catch (InvalidUpdateFileFormatException e) {
        } catch (MalformedURLException e) {
            System.out.println("EXCP " + e);
        } catch (IOException io) {
            System.out.println("IO" + io);
        }
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {

            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String) (evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer) (evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

}
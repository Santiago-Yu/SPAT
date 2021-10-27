class n21493541 {
	public UpdaterView(SingleFrameApplication bZur8Dfv, String[] D8W5jUcw) {
        super(bZur8Dfv);
        if (D8W5jUcw.length != 3) {
            System.out.println("Args must be passed.");
            System.exit(1);
        } else {
            currentVersion = Double.parseDouble(D8W5jUcw[0]);
            currentDBVersion = Double.parseDouble(D8W5jUcw[1]);
            dbAdmin = D8W5jUcw[2].equals("true") ? true : false;
        }
        initComponents();
        try {
            URL EhphXQia = new URL(BASE_URL + "version.txt");
            InputStream MI0gkfow = EhphXQia.openStream();
            BufferedInputStream ATWaiYbe = new BufferedInputStream(MI0gkfow);
            String uKmvkrbh = "";
            int R72SGhRU = ATWaiYbe.read();
            while (R72SGhRU != -1) {
                uKmvkrbh = uKmvkrbh.concat(Character.toString((char) R72SGhRU));
                R72SGhRU = ATWaiYbe.read();
            }
            String[] r9pDZxlN = uKmvkrbh.split("\n");
            if (r9pDZxlN.length > 0) {
                String[] WenKEQ4J = r9pDZxlN[0].split(":");
                if (dbAdmin || Double.parseDouble(WenKEQ4J[4]) == currentDBVersion) {
                    byteCount = Integer.parseInt(WenKEQ4J[2]);
                    lblCurrent.setText(new Double(currentVersion).toString());
                    lblLatest.setText(WenKEQ4J[0]);
                    latestVersionNum = Double.parseDouble(WenKEQ4J[0]);
                    lblNotes.setText("<html>" + WenKEQ4J[1]);
                    md5Hash = WenKEQ4J[3];
                    latestDBVersion = Double.parseDouble(WenKEQ4J[4]);
                    upgradeURL = WenKEQ4J[5];
                    progressBar.setMaximum(byteCount);
                    if (dbAdmin && Double.parseDouble(WenKEQ4J[4]) > currentDBVersion) {
                        schemaUpdatesNeeded = true;
                        schemaChanges.addFirst(latestDBVersion);
                        double tqyMadHI = latestDBVersion;
                        for (int ByQfF8Om = 1; ByQfF8Om < r9pDZxlN.length; ByQfF8Om++) {
                            WenKEQ4J = r9pDZxlN[ByQfF8Om].split(":");
                            double YNCx5Pbw = Double.parseDouble(WenKEQ4J[4]);
                            if (YNCx5Pbw != currentDBVersion) {
                                if (tqyMadHI != YNCx5Pbw) {
                                    schemaChanges.addFirst(YNCx5Pbw);
                                    tqyMadHI = YNCx5Pbw;
                                }
                            } else {
                                schemaChanges.addFirst(currentDBVersion);
                                break;
                            }
                        }
                    }
                } else {
                    for (int QcLdggBN = 1; QcLdggBN < r9pDZxlN.length; QcLdggBN++) {
                        WenKEQ4J = r9pDZxlN[QcLdggBN].split(":");
                        if (Double.parseDouble(WenKEQ4J[4]) == currentDBVersion) {
                            byteCount = Integer.parseInt(WenKEQ4J[2]);
                            lblCurrent.setText(new Double(currentVersion).toString());
                            lblLatest.setText(WenKEQ4J[0]);
                            latestVersionNum = Double.parseDouble(WenKEQ4J[0]);
                            lblNotes.setText("<html>" + WenKEQ4J[1]);
                            md5Hash = WenKEQ4J[3];
                            latestDBVersion = Double.parseDouble(WenKEQ4J[4]);
                            upgradeURL = WenKEQ4J[5];
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
        } catch (InvalidUpdateFileFormatException MB1aR9Jy) {
        } catch (MalformedURLException bxFy3sX2) {
            System.out.println("EXCP " + bxFy3sX2);
        } catch (IOException mtox5A2Z) {
            System.out.println("IO" + mtox5A2Z);
        }
        ResourceMap OSLh1Ir6 = getResourceMap();
        int V1EGg00K = OSLh1Ir6.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(V1EGg00K, new ActionListener() {

            public void actionPerformed(ActionEvent Dw0b7qDD) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int tJnyarnm = OSLh1Ir6.getInteger("StatusBar.busyAnimationRate");
        for (int j2lwEldY = 0; j2lwEldY < busyIcons.length; j2lwEldY++) {
            busyIcons[j2lwEldY] = OSLh1Ir6.getIcon("StatusBar.busyIcons[" + j2lwEldY + "]");
        }
        busyIconTimer = new Timer(tJnyarnm, new ActionListener() {

            public void actionPerformed(ActionEvent A1es0Eha) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = OSLh1Ir6.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);
        TaskMonitor evKfH9C2 = new TaskMonitor(getApplication().getContext());
        evKfH9C2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {

            public void propertyChange(java.beans.PropertyChangeEvent FkgANFbk) {
                String SlWyNeoG = FkgANFbk.getPropertyName();
                if ("started".equals(SlWyNeoG)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(SlWyNeoG)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(SlWyNeoG)) {
                    String idMwZALJ = (String) (FkgANFbk.getNewValue());
                    statusMessageLabel.setText((idMwZALJ == null) ? "" : idMwZALJ);
                    messageTimer.restart();
                } else if ("progress".equals(SlWyNeoG)) {
                    int eKMOMCLe = (Integer) (FkgANFbk.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(eKMOMCLe);
                }
            }
        });
    }

}
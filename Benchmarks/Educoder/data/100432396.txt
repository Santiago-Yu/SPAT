    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        boolean askRestart = false;
        if (cmd == null) return;
        if (cmd.equals("GRAPHVIZ")) {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new fi.kaila.suku.util.SettingFilter("exe"));
            chooser.setDialogTitle("Open exe file");
            if (chooser.showOpenDialog(owner) != JFileChooser.APPROVE_OPTION) {
                Suku.kontroller.putPref(owner, "GRAPHVIZ", "");
                graphVizPath.setText("");
                owner.mToolsAuxGraphviz.setEnabled(false);
                return;
            }
            File f = chooser.getSelectedFile();
            if (f == null) {
                return;
            }
            String filename = f.getAbsolutePath();
            if (filename == null || filename.isEmpty()) {
                Suku.kontroller.putPref(owner, "GRAPHVIZ", "");
                graphVizPath.setText("");
                owner.mToolsAuxGraphviz.setEnabled(false);
                return;
            }
            Suku.kontroller.putPref(owner, "GRAPHVIZ", filename);
            graphVizPath.setText(filename);
            owner.mToolsAuxGraphviz.setEnabled(true);
        }
        if (cmd.equals("IMAGEMAGICK")) {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new fi.kaila.suku.util.SettingFilter("exe"));
            chooser.setDialogTitle("Open exe file");
            if (chooser.showOpenDialog(owner) != JFileChooser.APPROVE_OPTION) {
                Suku.kontroller.putPref(owner, "IMAGEMAGICK", "");
                imageMagickPath.setText("");
                return;
            }
            File f = chooser.getSelectedFile();
            if (f == null) {
                return;
            }
            String filename = f.getAbsolutePath();
            if (filename == null || filename.isEmpty()) {
                Suku.kontroller.putPref(owner, "IMAGEMAGICK", "");
                imageMagickPath.setText("");
                return;
            }
            Suku.kontroller.putPref(owner, "IMAGEMAGICK", filename);
            imageMagickPath.setText(filename);
        }
        if (cmd.equals("FINFAMILY.XLS")) {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new fi.kaila.suku.util.SettingFilter("xls"));
            chooser.setDialogTitle("Open xls file");
            if (chooser.showOpenDialog(owner) != JFileChooser.APPROVE_OPTION) {
                Suku.kontroller.putPref(owner, "FINFAMILY.XLS", "");
                excelPath.setText("");
                return;
            }
            File f = chooser.getSelectedFile();
            if (f == null) {
                return;
            }
            String filename = f.getAbsolutePath();
            if (filename == null || filename.isEmpty()) {
                Suku.kontroller.putPref(owner, "FINFAMILY.XLS", "");
                excelPath.setText("");
                return;
            }
            Suku.kontroller.putPref(owner, "FINFAMILY.XLS", filename);
            excelPath.setText(filename);
            missingKeys = checkForMissingNames(filename);
        }
        if (cmd.equals(Resurses.OK)) {
            String newPath = Suku.kontroller.getPref(owner, "FINFAMILY.XLS", "");
            if (!newPath.equals(exPath)) {
                askRestart = true;
                Suku.setFinFamilyXls(newPath);
            }
            String input = (String) serverUrl.getSelectedItem();
            if (input == null) {
                input = "";
            }
            if (input.isEmpty()) {
                Suku.kontroller.putPref(owner, "SERVERURL", "");
                if (!originUrl.isEmpty()) {
                    askRestart = true;
                }
            } else {
                URL url;
                String resp = null;
                try {
                    url = new URL(input + "SukuServlet");
                    HttpURLConnection uc = (HttpURLConnection) url.openConnection();
                    int resu = uc.getResponseCode();
                    if (resu == 200) {
                        byte buff[] = new byte[1024];
                        InputStream in = uc.getInputStream();
                        int len = in.read(buff);
                        resp = new String(buff, 0, len);
                        uc.disconnect();
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                if (resp != null && resp.toLowerCase().startsWith("finfamily")) {
                    Suku.kontroller.putPref(owner, "SERVERURL", input);
                    if (!input.equals(originUrl)) {
                        askRestart = true;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, Resurses.getString("SERVER_ERROR"), Resurses.getString(Resurses.SUKU), JOptionPane.ERROR_MESSAGE);
                }
            }
            int newLoca = loca.getSelectedIndex();
            Suku.kontroller.putPref(owner, Resurses.LOCALE, locas[newLoca]);
            if (!originLanguage.equals(locas[newLoca])) {
                askRestart = true;
            }
            int newLang = repolang.getSelectedIndex();
            if (newLang >= 0) {
                Suku.kontroller.putPref(owner, Resurses.REPOLANG, Suku.getRepoLanguage(newLang, true));
                Resurses.setLanguage(Suku.getRepoLanguage(newLang, true));
            }
            int imageScaler = imageScaling.getSelectedIndex();
            Suku.kontroller.putPref(owner, "SCALE_IMAGE", "" + imageScaler);
            owner.setImageScalerIndex(imageScaler);
            int seleId = defaultCountryCode.getSelectedIndex();
            if (seleId >= 0) {
                selectedCc = ccodes[seleId];
            }
            try {
                Resurses.setDefaultCountry(selectedCc);
            } catch (SukuException e1) {
                owner.setStatus(e1.getMessage());
            }
            int newDateIndex = dateFormat.getSelectedIndex();
            Suku.kontroller.putPref(owner, Resurses.DATEFORMAT, dateCodes[newDateIndex]);
            Resurses.setDateFormat(dateCodes[newDateIndex]);
            Utils.resetSukuModel();
            boolean openStreetMap = useOpenStreetMap.isSelected();
            Suku.kontroller.putPref(owner, "USE_OPEN_STREETMAP", "" + openStreetMap);
            String fntSize = dbFontSize.getText();
            Suku.kontroller.putPref(owner, "DB_VIEW_FONTSIZE", fntSize);
            String lf = lfNames[lookAndFeel.getSelectedIndex()];
            Suku.kontroller.putPref(owner, "LOOK_AND_FEEL", lf);
            int lfIdx = -1;
            for (int i = 0; i < lafInfo.length; i++) {
                if (lafInfo[i].getName().equalsIgnoreCase(lf)) {
                    lfIdx = i;
                    break;
                }
            }
            try {
                if (lfIdx < 0) {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } else {
                    UIManager.setLookAndFeel(lafInfo[lfIdx].getClassName());
                }
                SwingUtilities.updateComponentTreeUI(owner);
            } catch (Exception e1) {
                logger.log(Level.WARNING, "look_and_feel", e1);
            }
            setVisible(false);
            if (askRestart) {
                if (missingKeys != null && !missingKeys.isEmpty()) {
                    SukuPad pad = new SukuPad(this, missingKeys);
                    pad.setVisible(true);
                }
                JOptionPane.showMessageDialog(this, Resurses.getString("RESTART_FINFAMILY"), Resurses.getString(Resurses.SUKU), JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

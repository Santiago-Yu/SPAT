class n14868224 {
	Library(MainFrame csaJ6zoX, boolean olb9h8gA, String bBWjqReS, String ACsE8l29) throws Exception {
        mainFrame = csaJ6zoX;
        trackMap = new HashMap<String, LibraryTrack>();
        trackVec = new Vector<LibraryTrack>();
        String ZxalaXf2 = null;
        File YBjIJEWg = null;
        String FrpLcgG5 = "";
        String[] h43vMt1S = templateDesc;
        boolean UEyhT8Ov = mainFrame.library != null;
        int jN4EKHTD;
        if (!olb9h8gA) {
            ZxalaXf2 = mainFrame.name + ".jampal";
            YBjIJEWg = new File(ZxalaXf2);
        }
        if (UEyhT8Ov) {
            h43vMt1S = new String[templateDesc.length + 1];
            h43vMt1S[0] = "Copy of Current Library";
            for (jN4EKHTD = 0; jN4EKHTD < templateDesc.length; jN4EKHTD++) {
                h43vMt1S[jN4EKHTD + 1] = templateDesc[jN4EKHTD];
            }
        }
        boolean gmuLXrsR = false;
        if (olb9h8gA) {
            if (bBWjqReS == null) {
                Object qdAOYn6d = JOptionPane.showInputDialog(mainFrame.frame, "Please select a template.", "Select Type of Library", JOptionPane.WARNING_MESSAGE, null, h43vMt1S, null);
                if (qdAOYn6d == null) return;
                bBWjqReS = (String) qdAOYn6d;
            }
            for (jN4EKHTD = 0; jN4EKHTD < h43vMt1S.length && !h43vMt1S[jN4EKHTD].equals(bBWjqReS); jN4EKHTD++) ;
            if (UEyhT8Ov) jN4EKHTD--;
            boolean AxpXOhqL = false;
            BufferedReader mgiJWWGf;
            if (jN4EKHTD == -1) {
                mgiJWWGf = new BufferedReader(new FileReader(mainFrame.name + ".jampal"));
                gmuLXrsR = true;
                AxpXOhqL = (mainFrame.library.attributes.libraryType == 'P');
            } else {
                mgiJWWGf = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("pgbennett/jampal/" + templateNames[jN4EKHTD])));
                AxpXOhqL = ("playlist.jampal".equals(templateNames[jN4EKHTD]));
            }
            if (ACsE8l29 == null) {
                JFileChooser E0qScNue = new JFileChooser();
                E0qScNue.setDialogTitle("Create New Library File");
                String HDjzIJHw = null;
                if (mainFrame.name != null) {
                    File J9NtYj5M = new File(mainFrame.name);
                    HDjzIJHw = J9NtYj5M.getParent();
                    if (HDjzIJHw == null) HDjzIJHw = ".";
                }
                if (HDjzIJHw == null) HDjzIJHw = Jampal.jampalDirectory;
                if (HDjzIJHw != null) E0qScNue.setCurrentDirectory(new File(HDjzIJHw));
                E0qScNue.setFileSelectionMode(JFileChooser.FILES_ONLY);
                E0qScNue.setMultiSelectionEnabled(false);
                Mp3FileFilter RkYgshTF = new Mp3FileFilter();
                RkYgshTF.setExtension("jampal", "Jampal library files");
                E0qScNue.addChoosableFileFilter(RkYgshTF);
                E0qScNue.setAcceptAllFileFilterUsed(false);
                E0qScNue.setFileFilter(RkYgshTF);
                E0qScNue.setDialogType(JFileChooser.SAVE_DIALOG);
                int yTUk2lTm = E0qScNue.showSaveDialog(mainFrame.frame);
                if (yTUk2lTm == E0qScNue.APPROVE_OPTION) {
                    YBjIJEWg = E0qScNue.getSelectedFile();
                    ZxalaXf2 = YBjIJEWg.getPath();
                    if (!ZxalaXf2.toLowerCase().endsWith(".jampal")) {
                        ZxalaXf2 = ZxalaXf2 + ".jampal";
                        YBjIJEWg = new File(ZxalaXf2);
                    }
                } else return;
            } else {
                ZxalaXf2 = ACsE8l29;
                YBjIJEWg = new File(ZxalaXf2);
            }
            if (YBjIJEWg.exists()) {
                if (JOptionPane.showConfirmDialog(mainFrame.frame, "File " + ZxalaXf2 + " already exists. Do you want to overwrite it ?", "Warning", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;
            }
            PrintWriter WxXb6jUJ = new PrintWriter(new FileOutputStream(YBjIJEWg));
            String opjMtulH = YBjIJEWg.getName();
            opjMtulH = opjMtulH.substring(0, opjMtulH.length() - 7);
            for (; ; ) {
                String aMNCLHCN = mgiJWWGf.readLine();
                if (aMNCLHCN == null) break;
                if (AxpXOhqL && aMNCLHCN.startsWith("playlist=")) {
                    aMNCLHCN = "playlist=" + opjMtulH;
                }
                if (aMNCLHCN.startsWith("libraryname=")) {
                    aMNCLHCN = "libraryname=" + opjMtulH + ".jmp";
                }
                WxXb6jUJ.println(aMNCLHCN);
            }
            mgiJWWGf.close();
            WxXb6jUJ.close();
            if (!AxpXOhqL && !gmuLXrsR) {
                String vG07mSMS = YBjIJEWg.getParent() + File.separator + "playlist.jampal";
                File VdGfl1M5 = new File(vG07mSMS);
                if (!VdGfl1M5.exists()) {
                    mgiJWWGf = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("pgbennett/jampal/playlist.jampal")));
                    WxXb6jUJ = new PrintWriter(new FileOutputStream(VdGfl1M5));
                    for (; ; ) {
                        String YGNsJWfq = mgiJWWGf.readLine();
                        if (YGNsJWfq == null) break;
                        WxXb6jUJ.println(YGNsJWfq);
                    }
                    mgiJWWGf.close();
                    WxXb6jUJ.close();
                }
            }
        }
        if (ZxalaXf2 != null) attributes = new LibraryAttributes(ZxalaXf2);
        insertBefore = -1;
    }

}
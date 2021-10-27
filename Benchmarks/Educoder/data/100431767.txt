    public static void checkForUpgrade(Event event) throws Exception {
        ((Component) UiUtil.findComponent("downloadUpgrade")).setVisible(false);
        ((Component) UiUtil.findComponent("applyUpgrade")).setVisible(false);
        ((Component) UiUtil.findComponent("restartRequiredHbox")).setVisible(false);
        ((Component) UiUtil.findComponent("restartRequiredAlert")).setVisible(false);
        new Command("DELETE FROM TBLINSTALLATION WHERE STATUS<>'APPLIED'").executeNonQuery();
        String clientAppliedVersion = new Command("SELECT MAX(VERSION) FROM TBLINSTALLATION WHERE STATUS='APPLIED'").executeScalarAsString();
        if (NullStatus.isNull(clientAppliedVersion)) {
            clientAppliedVersion = "20050101";
        }
        String macquery = "";
        String clientMAC = "";
        String clientUNITID = UiUtil.getUNITUID();
        ArrayList<String> macList = getMacList();
        for (int i = 0; i < macList.size(); i++) {
            clientMAC += macList.get(i) + ",";
            macquery += "'" + macList.get(i) + "'";
            if (i < macList.size() - 1) {
                macquery += ",";
            }
        }
        URL urlLICENSEQUERY = new URL("http://www.tegsoft.com/Tobe/forms/TobeOS/upgrade/upgrade_current.jsp?tegsoftCLIENTVERSION=" + clientAppliedVersion + "&tegsoftCLIENTUNITID=" + clientUNITID + "&tegsoftCLIENTMAC=" + clientMAC + "&tegsoftCOMMAND=LICENSEQUERY");
        URLConnection urlConnection = urlLICENSEQUERY.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String commingList = "";
        String line;
        while ((line = in.readLine()) != null) {
            commingList += line;
        }
        in.close();
        String licenseArray[] = commingList.split("</ROW>");
        if (licenseArray.length > 0) {
            String fields[] = licenseArray[0].split("</FLD>");
            String STATUS = fields[0];
            String ERRORMSG = fields[1];
            if ("FAIL".equals(STATUS)) {
                if ("NOUNITID".equals(ERRORMSG)) {
                    UiUtil.showMessage(MessageType.ERROR, MessageUtil.getMessage(Upgrade.class, Messages.upgrade_1));
                    return;
                }
                if ("NOCUSTOMER".equals(ERRORMSG)) {
                    UiUtil.showMessage(MessageType.ERROR, MessageUtil.getMessage(Upgrade.class, Messages.upgrade_1));
                    return;
                }
                if ("NOVALIDLICENSE".equals(ERRORMSG)) {
                    UiUtil.showMessage(MessageType.ERROR, MessageUtil.getMessage(Upgrade.class, Messages.upgrade_2));
                    return;
                }
                UiUtil.showMessage(MessageType.ERROR, MessageUtil.getMessage(Upgrade.class, Messages.upgrade_3));
                return;
            }
        }
        Dataset TBLLICENSE = new Dataset("TBLLICENSE", "TBLLICENSE");
        Command command = new Command("DELETE FROM TBLLICENSE WHERE UNITUID={UNITUID} AND (NOTES IN (");
        command.append(macquery);
        command.append(") OR NOTES IS NULL) ");
        command.executeNonQuery();
        for (int i = 1; i < licenseArray.length; i++) {
            String fields[] = licenseArray[i].split("</FLD>");
            String LICTYPE = fields[0];
            String UNIQUEKEY = fields[1];
            String LICKEY = fields[2];
            DataRow dataRow = TBLLICENSE.addNewDataRow();
            dataRow.set("LICENSENAME", LICTYPE);
            dataRow.set("LICENSE", LICKEY);
            dataRow.set("NOTES", UNIQUEKEY);
            TBLLICENSE.save();
        }
        URL url = new URL("http://www.tegsoft.com/Tobe/forms/TobeOS/upgrade/upgrade_current.jsp?tegsoftCLIENTVERSION=" + clientAppliedVersion + "&tegsoftCLIENTUNITID=" + clientUNITID + "&tegsoftCLIENTMAC=" + clientMAC);
        urlConnection = url.openConnection();
        in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String upgradeList = "";
        while ((line = in.readLine()) != null) {
            upgradeList += line;
        }
        in.close();
        Dataset TBLINSTALLATION = new Dataset("TBLINSTALLATION", "TBLINSTALLATION");
        String upgrades[] = upgradeList.split("</ROW>");
        if (upgrades.length > 0) {
            String fields[] = upgrades[0].split("</FLD>");
            String STATUS = fields[0];
            String ERRORMSG = fields[1];
            if ("FAIL".equals(STATUS)) {
                if ("NOUNITID".equals(ERRORMSG)) {
                    UiUtil.showMessage(MessageType.ERROR, MessageUtil.getMessage(Upgrade.class, Messages.upgrade_1));
                    return;
                }
                if ("NOCUSTOMER".equals(ERRORMSG)) {
                    UiUtil.showMessage(MessageType.ERROR, MessageUtil.getMessage(Upgrade.class, Messages.upgrade_1));
                    return;
                }
                if ("NOVALIDLICENSE".equals(ERRORMSG)) {
                    UiUtil.showMessage(MessageType.ERROR, MessageUtil.getMessage(Upgrade.class, Messages.upgrade_2));
                    return;
                }
                UiUtil.showMessage(MessageType.ERROR, MessageUtil.getMessage(Upgrade.class, Messages.upgrade_3));
                return;
            }
        }
        boolean restartRequired = false;
        boolean updateAvailable = false;
        for (int i = 1; i < upgrades.length; i++) {
            String fields[] = upgrades[i].split("</FLD>");
            String VERSION = fields[0];
            String ORDERID = fields[1];
            String UPGRADETYPE = fields[2];
            String DESCRIPTION = fields[3];
            String STATUS = "UNAPPLIED";
            String PRDNAME = "TegsoftCC";
            if ("TEGSOFTJARS".equals(UPGRADETYPE) || "TOBEJARS".equals(UPGRADETYPE) || "ALLJARS".equals(UPGRADETYPE) || "CONFIGASTERISK".equals(UPGRADETYPE)) {
                restartRequired = true;
            }
            DataRow dataRow = TBLINSTALLATION.addNewDataRow();
            dataRow.set("ORDERID", ORDERID);
            dataRow.set("PRDNAME", PRDNAME);
            dataRow.set("UPGRADETYPE", UPGRADETYPE);
            dataRow.set("VERSION", VERSION);
            dataRow.set("STATUS", STATUS);
            dataRow.set("DESCRIPTION", DESCRIPTION);
            TBLINSTALLATION.save();
            updateAvailable = true;
        }
        UiUtil.getDataset("TBLINSTALLATION").reFill();
        if (restartRequired) {
            ((Component) UiUtil.findComponent("restartRequiredHbox")).setVisible(true);
            ((Component) UiUtil.findComponent("restartRequiredAlert")).setVisible(true);
        }
        if (updateAvailable) {
            ((Component) UiUtil.findComponent("downloadUpgrade")).setVisible(true);
            UiUtil.showMessage(MessageType.INFO, MessageUtil.getMessage(Upgrade.class, Messages.upgrade_4));
        } else {
            UiUtil.showMessage(MessageType.INFO, MessageUtil.getMessage(Upgrade.class, Messages.upgrade_5));
        }
    }

class n10540676 {
	public static void checkForUpgrade(Event iO3o4RQ1) throws Exception {
		((Component) UiUtil.findComponent("downloadUpgrade")).setVisible(false);
		((Component) UiUtil.findComponent("applyUpgrade")).setVisible(false);
		((Component) UiUtil.findComponent("restartRequiredHbox")).setVisible(false);
		((Component) UiUtil.findComponent("restartRequiredAlert")).setVisible(false);
		new Command("DELETE FROM TBLINSTALLATION WHERE STATUS<>'APPLIED'").executeNonQuery();
		String BksIiR2V = new Command("SELECT MAX(VERSION) FROM TBLINSTALLATION WHERE STATUS='APPLIED'")
				.executeScalarAsString();
		if (NullStatus.isNull(BksIiR2V)) {
			BksIiR2V = "20050101";
		}
		String KNKTn5TN = "";
		String j9hYzXCi = "";
		String ozDgIZ54 = UiUtil.getUNITUID();
		ArrayList<String> QDscJmIa = getMacList();
		for (int cZDzWWaj = 0; cZDzWWaj < QDscJmIa.size(); cZDzWWaj++) {
			j9hYzXCi += QDscJmIa.get(cZDzWWaj) + ",";
			KNKTn5TN += "'" + QDscJmIa.get(cZDzWWaj) + "'";
			if (cZDzWWaj < QDscJmIa.size() - 1) {
				KNKTn5TN += ",";
			}
		}
		URL F33rKWVU = new URL(
				"http://www.tegsoft.com/Tobe/forms/TobeOS/upgrade/upgrade_current.jsp?tegsoftCLIENTVERSION=" + BksIiR2V
						+ "&tegsoftCLIENTUNITID=" + ozDgIZ54 + "&tegsoftCLIENTMAC=" + j9hYzXCi
						+ "&tegsoftCOMMAND=LICENSEQUERY");
		URLConnection RwWKSM6q = F33rKWVU.openConnection();
		BufferedReader iNw6CKAS = new BufferedReader(new InputStreamReader(RwWKSM6q.getInputStream()));
		String eux1Zpk3 = "";
		String AMmR784m;
		while ((AMmR784m = iNw6CKAS.readLine()) != null) {
			eux1Zpk3 += AMmR784m;
		}
		iNw6CKAS.close();
		String IjB7uBZa[] = eux1Zpk3.split("</ROW>");
		if (IjB7uBZa.length > 0) {
			String KVnWmhO6[] = IjB7uBZa[0].split("</FLD>");
			String kXUiP5n3 = KVnWmhO6[0];
			String EeXqp1He = KVnWmhO6[1];
			if ("FAIL".equals(kXUiP5n3)) {
				if ("NOUNITID".equals(EeXqp1He)) {
					UiUtil.showMessage(MessageType.ERROR, MessageUtil.getMessage(Upgrade.class, Messages.upgrade_1));
					return;
				}
				if ("NOCUSTOMER".equals(EeXqp1He)) {
					UiUtil.showMessage(MessageType.ERROR, MessageUtil.getMessage(Upgrade.class, Messages.upgrade_1));
					return;
				}
				if ("NOVALIDLICENSE".equals(EeXqp1He)) {
					UiUtil.showMessage(MessageType.ERROR, MessageUtil.getMessage(Upgrade.class, Messages.upgrade_2));
					return;
				}
				UiUtil.showMessage(MessageType.ERROR, MessageUtil.getMessage(Upgrade.class, Messages.upgrade_3));
				return;
			}
		}
		Dataset qaeA7Ti3 = new Dataset("TBLLICENSE", "TBLLICENSE");
		Command toZvplAo = new Command("DELETE FROM TBLLICENSE WHERE UNITUID={UNITUID} AND (NOTES IN (");
		toZvplAo.append(KNKTn5TN);
		toZvplAo.append(") OR NOTES IS NULL) ");
		toZvplAo.executeNonQuery();
		for (int MBkWBCxz = 1; MBkWBCxz < IjB7uBZa.length; MBkWBCxz++) {
			String Br4gb4Pb[] = IjB7uBZa[MBkWBCxz].split("</FLD>");
			String Rhv4ekqA = Br4gb4Pb[0];
			String GxTSIh1N = Br4gb4Pb[1];
			String Rkv3qJ3C = Br4gb4Pb[2];
			DataRow hJp3twQQ = qaeA7Ti3.addNewDataRow();
			hJp3twQQ.set("LICENSENAME", Rhv4ekqA);
			hJp3twQQ.set("LICENSE", Rkv3qJ3C);
			hJp3twQQ.set("NOTES", GxTSIh1N);
			qaeA7Ti3.save();
		}
		URL F5X0AT0t = new URL(
				"http://www.tegsoft.com/Tobe/forms/TobeOS/upgrade/upgrade_current.jsp?tegsoftCLIENTVERSION=" + BksIiR2V
						+ "&tegsoftCLIENTUNITID=" + ozDgIZ54 + "&tegsoftCLIENTMAC=" + j9hYzXCi);
		RwWKSM6q = F5X0AT0t.openConnection();
		iNw6CKAS = new BufferedReader(new InputStreamReader(RwWKSM6q.getInputStream()));
		String k3Eb1Mgh = "";
		while ((AMmR784m = iNw6CKAS.readLine()) != null) {
			k3Eb1Mgh += AMmR784m;
		}
		iNw6CKAS.close();
		Dataset BNYr82Ee = new Dataset("TBLINSTALLATION", "TBLINSTALLATION");
		String MQ9Z74WH[] = k3Eb1Mgh.split("</ROW>");
		if (MQ9Z74WH.length > 0) {
			String BfZFroLk[] = MQ9Z74WH[0].split("</FLD>");
			String fhDiwWXb = BfZFroLk[0];
			String SKfla2cu = BfZFroLk[1];
			if ("FAIL".equals(fhDiwWXb)) {
				if ("NOUNITID".equals(SKfla2cu)) {
					UiUtil.showMessage(MessageType.ERROR, MessageUtil.getMessage(Upgrade.class, Messages.upgrade_1));
					return;
				}
				if ("NOCUSTOMER".equals(SKfla2cu)) {
					UiUtil.showMessage(MessageType.ERROR, MessageUtil.getMessage(Upgrade.class, Messages.upgrade_1));
					return;
				}
				if ("NOVALIDLICENSE".equals(SKfla2cu)) {
					UiUtil.showMessage(MessageType.ERROR, MessageUtil.getMessage(Upgrade.class, Messages.upgrade_2));
					return;
				}
				UiUtil.showMessage(MessageType.ERROR, MessageUtil.getMessage(Upgrade.class, Messages.upgrade_3));
				return;
			}
		}
		boolean N7d1iGjX = false;
		boolean WLQZbGLU = false;
		for (int qaplbc9N = 1; qaplbc9N < MQ9Z74WH.length; qaplbc9N++) {
			String gwr2AwCR[] = MQ9Z74WH[qaplbc9N].split("</FLD>");
			String MJH2MZ51 = gwr2AwCR[0];
			String BVzxcBZ7 = gwr2AwCR[1];
			String jZxvLz5S = gwr2AwCR[2];
			String P6bvM9V1 = gwr2AwCR[3];
			String kbTjlmqn = "UNAPPLIED";
			String LQKcvxZL = "TegsoftCC";
			if ("TEGSOFTJARS".equals(jZxvLz5S) || "TOBEJARS".equals(jZxvLz5S) || "ALLJARS".equals(jZxvLz5S)
					|| "CONFIGASTERISK".equals(jZxvLz5S)) {
				N7d1iGjX = true;
			}
			DataRow URlblBR6 = BNYr82Ee.addNewDataRow();
			URlblBR6.set("ORDERID", BVzxcBZ7);
			URlblBR6.set("PRDNAME", LQKcvxZL);
			URlblBR6.set("UPGRADETYPE", jZxvLz5S);
			URlblBR6.set("VERSION", MJH2MZ51);
			URlblBR6.set("STATUS", kbTjlmqn);
			URlblBR6.set("DESCRIPTION", P6bvM9V1);
			BNYr82Ee.save();
			WLQZbGLU = true;
		}
		UiUtil.getDataset("TBLINSTALLATION").reFill();
		if (N7d1iGjX) {
			((Component) UiUtil.findComponent("restartRequiredHbox")).setVisible(true);
			((Component) UiUtil.findComponent("restartRequiredAlert")).setVisible(true);
		}
		if (WLQZbGLU) {
			((Component) UiUtil.findComponent("downloadUpgrade")).setVisible(true);
			UiUtil.showMessage(MessageType.INFO, MessageUtil.getMessage(Upgrade.class, Messages.upgrade_4));
		} else {
			UiUtil.showMessage(MessageType.INFO, MessageUtil.getMessage(Upgrade.class, Messages.upgrade_5));
		}
	}

}
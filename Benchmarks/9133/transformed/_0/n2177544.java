class n2177544 {
	public static boolean makeBackup(File J1pep4Rj, String FQwMJgKc, String zFO3uyWZ, String aq8tJBrk,
			boolean SiThp4wJ) {
		boolean yg6JklhE = false;
		String[] hbE9wx98;
		hbE9wx98 = J1pep4Rj.list();
		File EsMXLKFG = new File(zFO3uyWZ + System.getProperty("file.separator") + aq8tJBrk);
		if (!EsMXLKFG.isDirectory()) {
			EsMXLKFG.mkdir();
		}
		;
		Date LhKADjWZ = new Date();
		long gBCuaMdz = LhKADjWZ.getTime();
		EsMXLKFG.setLastModified(gBCuaMdz);
		try {
			for (int y14FxuqH = 0; y14FxuqH < hbE9wx98.length; y14FxuqH++) {
				File rUXNQaZX = new File(J1pep4Rj, hbE9wx98[y14FxuqH]);
				File WmEDYpVs = new File(hbE9wx98[y14FxuqH]);
				if (rUXNQaZX.isDirectory()) {
				} else if (rUXNQaZX.getName().endsWith("saving")) {
				} else {
					if (rUXNQaZX.canRead()) {
						String zD3LIoy0 = EsMXLKFG + System.getProperty("file.separator") + WmEDYpVs;
						String rvY6P5Tx = FQwMJgKc + System.getProperty("file.separator") + WmEDYpVs;
						FileInputStream jGQCFzcs = new FileInputStream(rvY6P5Tx);
						FileOutputStream aXqlXNR9 = new FileOutputStream(zD3LIoy0);
						int Q6MEnDap;
						while ((Q6MEnDap = jGQCFzcs.read()) != -1)
							aXqlXNR9.write(Q6MEnDap);
						jGQCFzcs.close();
						aXqlXNR9.close();
					} else {
						System.out.println(rUXNQaZX.getName() + " is LOCKED!");
						while (!rUXNQaZX.canRead()) {
						}
						String y6TFcURL = EsMXLKFG + System.getProperty("file.separator") + WmEDYpVs;
						String sZNsvQdh = FQwMJgKc + System.getProperty("file.separator") + WmEDYpVs;
						FileInputStream j7GCAfyS = new FileInputStream(sZNsvQdh);
						FileOutputStream ICxd6Nuj = new FileOutputStream(y6TFcURL);
						int Gwa7di4w;
						while ((Gwa7di4w = j7GCAfyS.read()) != -1)
							ICxd6Nuj.write(Gwa7di4w);
						j7GCAfyS.close();
						ICxd6Nuj.close();
					}
				}
			}
			yg6JklhE = true;
		} catch (Exception dAc1fsr0) {
			yg6JklhE = false;
			dAc1fsr0.printStackTrace();
		}
		if (SiThp4wJ) {
			Display Bxn82Zrw = View.getDisplay();
			if (Bxn82Zrw != null || !Bxn82Zrw.isDisposed()) {
				View.getDisplay().syncExec(new Runnable() {

					public void run() {
						Tab4.redrawBackupTable();
					}
				});
			}
			return yg6JklhE;
		} else {
			View.getDisplay().syncExec(new Runnable() {

				public void run() {
					StatusBoxUtils.mainStatusAdd(" Backup Complete", 1);
					View.getPluginInterface().getPluginconfig().setPluginParameter("Azcvsupdater_last_backup",
							Time.getCurrentTime(View.getPluginInterface().getPluginconfig()
									.getPluginBooleanParameter("MilitaryTime")));
					Tab4.lastBackupTime = View.getPluginInterface().getPluginconfig()
							.getPluginStringParameter("Azcvsupdater_last_backup");
					if (Tab4.lastbackupValue != null || !Tab4.lastbackupValue.isDisposed()) {
						Tab4.lastbackupValue.setText("Last backup: " + Tab4.lastBackupTime);
					}
					Tab4.redrawBackupTable();
					Tab6Utils.refreshLists();
				}
			});
			return yg6JklhE;
		}
	}

}
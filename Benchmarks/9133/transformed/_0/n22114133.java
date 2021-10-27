class n22114133 {
	@Override
	public void actionPerformed(ActionEvent lUricSVl) {
		String RHvSO8Sn = lUricSVl.getActionCommand();
		boolean OISY4phV = false;
		if (RHvSO8Sn == null)
			return;
		if (RHvSO8Sn.equals("GRAPHVIZ")) {
			JFileChooser Hepv8IFJ = new JFileChooser();
			Hepv8IFJ.setFileFilter(new fi.kaila.suku.util.SettingFilter("exe"));
			Hepv8IFJ.setDialogTitle("Open exe file");
			if (Hepv8IFJ.showOpenDialog(owner) != JFileChooser.APPROVE_OPTION) {
				Suku.kontroller.putPref(owner, "GRAPHVIZ", "");
				graphVizPath.setText("");
				owner.mToolsAuxGraphviz.setEnabled(false);
				return;
			}
			File UkhkMfhq = Hepv8IFJ.getSelectedFile();
			if (UkhkMfhq == null) {
				return;
			}
			String UuVT4Ar1 = UkhkMfhq.getAbsolutePath();
			if (UuVT4Ar1 == null || UuVT4Ar1.isEmpty()) {
				Suku.kontroller.putPref(owner, "GRAPHVIZ", "");
				graphVizPath.setText("");
				owner.mToolsAuxGraphviz.setEnabled(false);
				return;
			}
			Suku.kontroller.putPref(owner, "GRAPHVIZ", UuVT4Ar1);
			graphVizPath.setText(UuVT4Ar1);
			owner.mToolsAuxGraphviz.setEnabled(true);
		}
		if (RHvSO8Sn.equals("IMAGEMAGICK")) {
			JFileChooser wkZ0te53 = new JFileChooser();
			wkZ0te53.setFileFilter(new fi.kaila.suku.util.SettingFilter("exe"));
			wkZ0te53.setDialogTitle("Open exe file");
			if (wkZ0te53.showOpenDialog(owner) != JFileChooser.APPROVE_OPTION) {
				Suku.kontroller.putPref(owner, "IMAGEMAGICK", "");
				imageMagickPath.setText("");
				return;
			}
			File LxB10HoR = wkZ0te53.getSelectedFile();
			if (LxB10HoR == null) {
				return;
			}
			String kODo2Rii = LxB10HoR.getAbsolutePath();
			if (kODo2Rii == null || kODo2Rii.isEmpty()) {
				Suku.kontroller.putPref(owner, "IMAGEMAGICK", "");
				imageMagickPath.setText("");
				return;
			}
			Suku.kontroller.putPref(owner, "IMAGEMAGICK", kODo2Rii);
			imageMagickPath.setText(kODo2Rii);
		}
		if (RHvSO8Sn.equals("FINFAMILY.XLS")) {
			JFileChooser uKLi5K1O = new JFileChooser();
			uKLi5K1O.setFileFilter(new fi.kaila.suku.util.SettingFilter("xls"));
			uKLi5K1O.setDialogTitle("Open xls file");
			if (uKLi5K1O.showOpenDialog(owner) != JFileChooser.APPROVE_OPTION) {
				Suku.kontroller.putPref(owner, "FINFAMILY.XLS", "");
				excelPath.setText("");
				return;
			}
			File SXTGWm9U = uKLi5K1O.getSelectedFile();
			if (SXTGWm9U == null) {
				return;
			}
			String fnmXxZOO = SXTGWm9U.getAbsolutePath();
			if (fnmXxZOO == null || fnmXxZOO.isEmpty()) {
				Suku.kontroller.putPref(owner, "FINFAMILY.XLS", "");
				excelPath.setText("");
				return;
			}
			Suku.kontroller.putPref(owner, "FINFAMILY.XLS", fnmXxZOO);
			excelPath.setText(fnmXxZOO);
			missingKeys = checkForMissingNames(fnmXxZOO);
		}
		if (RHvSO8Sn.equals(Resurses.OK)) {
			String PimikgZL = Suku.kontroller.getPref(owner, "FINFAMILY.XLS", "");
			if (!PimikgZL.equals(exPath)) {
				OISY4phV = true;
				Suku.setFinFamilyXls(PimikgZL);
			}
			String ImL1AMpW = (String) serverUrl.getSelectedItem();
			if (ImL1AMpW == null) {
				ImL1AMpW = "";
			}
			if (ImL1AMpW.isEmpty()) {
				Suku.kontroller.putPref(owner, "SERVERURL", "");
				if (!originUrl.isEmpty()) {
					OISY4phV = true;
				}
			} else {
				URL j6Re9WGB;
				String C0jyktCu = null;
				try {
					j6Re9WGB = new URL(ImL1AMpW + "SukuServlet");
					HttpURLConnection W77yhiJD = (HttpURLConnection) j6Re9WGB.openConnection();
					int yoRBLk0F = W77yhiJD.getResponseCode();
					if (yoRBLk0F == 200) {
						byte U05MjOU5[] = new byte[1024];
						InputStream Cek5z8B5 = W77yhiJD.getInputStream();
						int FIVpzzZJ = Cek5z8B5.read(U05MjOU5);
						C0jyktCu = new String(U05MjOU5, 0, FIVpzzZJ);
						W77yhiJD.disconnect();
					}
				} catch (Exception NJc6EtEs) {
					NJc6EtEs.printStackTrace();
				}
				if (C0jyktCu != null && C0jyktCu.toLowerCase().startsWith("finfamily")) {
					Suku.kontroller.putPref(owner, "SERVERURL", ImL1AMpW);
					if (!ImL1AMpW.equals(originUrl)) {
						OISY4phV = true;
					}
				} else {
					JOptionPane.showMessageDialog(this, Resurses.getString("SERVER_ERROR"),
							Resurses.getString(Resurses.SUKU), JOptionPane.ERROR_MESSAGE);
				}
			}
			int C9bu0tsI = loca.getSelectedIndex();
			Suku.kontroller.putPref(owner, Resurses.LOCALE, locas[C9bu0tsI]);
			if (!originLanguage.equals(locas[C9bu0tsI])) {
				OISY4phV = true;
			}
			int mvRrBuLt = repolang.getSelectedIndex();
			if (mvRrBuLt >= 0) {
				Suku.kontroller.putPref(owner, Resurses.REPOLANG, Suku.getRepoLanguage(mvRrBuLt, true));
				Resurses.setLanguage(Suku.getRepoLanguage(mvRrBuLt, true));
			}
			int KjgPkxvH = imageScaling.getSelectedIndex();
			Suku.kontroller.putPref(owner, "SCALE_IMAGE", "" + KjgPkxvH);
			owner.setImageScalerIndex(KjgPkxvH);
			int dXfBij6x = defaultCountryCode.getSelectedIndex();
			if (dXfBij6x >= 0) {
				selectedCc = ccodes[dXfBij6x];
			}
			try {
				Resurses.setDefaultCountry(selectedCc);
			} catch (SukuException GqRsjhPk) {
				owner.setStatus(GqRsjhPk.getMessage());
			}
			int arvqErXw = dateFormat.getSelectedIndex();
			Suku.kontroller.putPref(owner, Resurses.DATEFORMAT, dateCodes[arvqErXw]);
			Resurses.setDateFormat(dateCodes[arvqErXw]);
			Utils.resetSukuModel();
			boolean YplHgEL1 = useOpenStreetMap.isSelected();
			Suku.kontroller.putPref(owner, "USE_OPEN_STREETMAP", "" + YplHgEL1);
			String YeDJCXlJ = dbFontSize.getText();
			Suku.kontroller.putPref(owner, "DB_VIEW_FONTSIZE", YeDJCXlJ);
			String rHCL5aBT = lfNames[lookAndFeel.getSelectedIndex()];
			Suku.kontroller.putPref(owner, "LOOK_AND_FEEL", rHCL5aBT);
			int TPTyc6Z6 = -1;
			for (int trlqhIIc = 0; trlqhIIc < lafInfo.length; trlqhIIc++) {
				if (lafInfo[trlqhIIc].getName().equalsIgnoreCase(rHCL5aBT)) {
					TPTyc6Z6 = trlqhIIc;
					break;
				}
			}
			try {
				if (TPTyc6Z6 < 0) {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} else {
					UIManager.setLookAndFeel(lafInfo[TPTyc6Z6].getClassName());
				}
				SwingUtilities.updateComponentTreeUI(owner);
			} catch (Exception OmMhiwv7) {
				logger.log(Level.WARNING, "look_and_feel", OmMhiwv7);
			}
			setVisible(false);
			if (OISY4phV) {
				if (missingKeys != null && !missingKeys.isEmpty()) {
					SukuPad ssvZ0Hfd = new SukuPad(this, missingKeys);
					ssvZ0Hfd.setVisible(true);
				}
				JOptionPane.showMessageDialog(this, Resurses.getString("RESTART_FINFAMILY"),
						Resurses.getString(Resurses.SUKU), JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

}
class n8352956 {
	void IconmenuItem5_actionPerformed(ActionEvent ygSHI0HT) {
		JFileChooser k9lgVWVO = new JFileChooser();
		String pNcgNfUA = "";
		if (getPath() != null && !getPath().equals("")) {
			k9lgVWVO.setCurrentDirectory(new File(getPath()));
			k9lgVWVO.setSelectedFile(new File(getPath()));
		}
		if (JFileChooser.APPROVE_OPTION == k9lgVWVO.showOpenDialog(this.getFatherFrame())) {
			setPath(k9lgVWVO.getSelectedFile().getPath());
			pNcgNfUA = k9lgVWVO.getSelectedFile().separator;
			File KbqlneS3 = new File("." + pNcgNfUA + "images");
			if (!KbqlneS3.exists()) {
				KbqlneS3.mkdir();
			}
			int IMzc9FRw = getPath().lastIndexOf(pNcgNfUA);
			String K9Ts9aX8 = getPath().substring(IMzc9FRw);
			String PYflzgxK = KbqlneS3 + K9Ts9aX8;
			try {
				File S5ER3YUM = new File(getPath());
				File fm7H0SUl = new File(PYflzgxK);
				if (!S5ER3YUM.getCanonicalPath().equals(fm7H0SUl.getCanonicalPath())) {
					FileInputStream fcMfVhuU = new FileInputStream(S5ER3YUM);
					FileOutputStream QUXPxYHT = new FileOutputStream(fm7H0SUl);
					int veCdHi5E;
					while ((veCdHi5E = fcMfVhuU.read()) != -1)
						QUXPxYHT.write(veCdHi5E);
					fcMfVhuU.close();
					QUXPxYHT.close();
				}
			} catch (Exception jtU6y19Y) {
				jtU6y19Y.printStackTrace();
				LogHandler.log(jtU6y19Y.getMessage(), Level.INFO, "LOG_MSG", isLoggingEnabled());
				JOptionPane.showMessageDialog(null,
						jtU6y19Y.getMessage().substring(0,
								Math.min(jtU6y19Y.getMessage().length(), getFatherPanel().MAX_DIALOG_MSG_SZ)) + "-"
								+ getClass(),
						"", JOptionPane.ERROR_MESSAGE);
			}
			setPath(PYflzgxK);
			if (getDefaultPath() == null || getDefaultPath().equals("")) {
				String pVFR9Mol = "E' stata selezionata un'immagine da associare all'IconShape, ma non e' "
						+ "stata selezionata ancora nessun'immagine di default. Imposto quella scelta anche come "
						+ "immagine di default?";
				if (JOptionPane.showConfirmDialog(null,
						pVFR9Mol.substring(0, Math.min(pVFR9Mol.length(), getFatherPanel().MAX_DIALOG_MSG_SZ)),
						"choose one", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					setDefaultPath(PYflzgxK);
					createDefaultImage();
				}
			}
			createImage();
		}
	}

}
class n8352957 {
	void IconmenuItem6_actionPerformed(ActionEvent S8CfrGTS) {
		JFileChooser GTt8yOKI = new JFileChooser();
		String iBCdbqsa = "";
		if (JFileChooser.APPROVE_OPTION == GTt8yOKI.showOpenDialog(this.getFatherFrame())) {
			setDefaultPath(GTt8yOKI.getSelectedFile().getPath());
			iBCdbqsa = GTt8yOKI.getSelectedFile().separator;
			File v7nrT9ru = new File("." + iBCdbqsa + "images");
			if (!v7nrT9ru.exists()) {
				v7nrT9ru.mkdir();
			}
			int GBPy7oGr = getDefaultPath().lastIndexOf(iBCdbqsa);
			String b7YQE4Lf = getDefaultPath().substring(GBPy7oGr);
			String Mq5DVovC = v7nrT9ru + b7YQE4Lf;
			try {
				File eZSBS6YB = new File(getDefaultPath());
				File j4d9GjIH = new File(Mq5DVovC);
				FileInputStream LWBGOlW0 = new FileInputStream(eZSBS6YB);
				FileOutputStream ihvJes2S = new FileOutputStream(j4d9GjIH);
				int pW6AFadW;
				while ((pW6AFadW = LWBGOlW0.read()) != -1)
					ihvJes2S.write(pW6AFadW);
				LWBGOlW0.close();
				ihvJes2S.close();
			} catch (Exception uuNHljYL) {
				uuNHljYL.printStackTrace();
				LogHandler.log(uuNHljYL.getMessage(), Level.INFO, "LOG_MSG", isLoggingEnabled());
				JOptionPane.showMessageDialog(null,
						uuNHljYL.getMessage().substring(0,
								Math.min(uuNHljYL.getMessage().length(), getFatherPanel().MAX_DIALOG_MSG_SZ)) + "-"
								+ getClass(),
						"", JOptionPane.ERROR_MESSAGE);
			}
			setDefaultPath(Mq5DVovC);
			createDefaultImage();
		}
	}

}
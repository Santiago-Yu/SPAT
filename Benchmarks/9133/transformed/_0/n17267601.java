class n17267601 {
	public void setBckImg(String U0pDlDf0) {
		try {
			File jYxYIPS3 = new File(getPath());
			File cPqWvBjH = new File(U0pDlDf0);
			if (!jYxYIPS3.getCanonicalPath().equals(cPqWvBjH.getCanonicalPath())) {
				FileInputStream b13UAUTY = new FileInputStream(jYxYIPS3);
				FileOutputStream qY5WTJLb = null;
				try {
					qY5WTJLb = new FileOutputStream(cPqWvBjH);
				} catch (FileNotFoundException Q2LAskPc) {
					Q2LAskPc.printStackTrace();
					JOptionPane.showMessageDialog(null,
							Q2LAskPc.getMessage().substring(0,
									Math.min(Q2LAskPc.getMessage().length(), drawPanel.MAX_DIALOG_MSG_SZ)) + "-"
									+ getClass(),
							"Set Bck Img", JOptionPane.ERROR_MESSAGE);
				}
				int KWeIJ0tF;
				if (qY5WTJLb != null) {
					while ((KWeIJ0tF = b13UAUTY.read()) != -1)
						qY5WTJLb.write(KWeIJ0tF);
					qY5WTJLb.close();
				}
				b13UAUTY.close();
			}
		} catch (Exception BshYbyXR) {
			BshYbyXR.printStackTrace();
			LogHandler.log(BshYbyXR.getMessage(), Level.INFO, "LOG_MSG", isLoggingEnabled());
			JOptionPane.showMessageDialog(null,
					BshYbyXR.getMessage().substring(0,
							Math.min(BshYbyXR.getMessage().length(), drawPanel.MAX_DIALOG_MSG_SZ)) + "-" + getClass(),
					"Set Bck Img", JOptionPane.ERROR_MESSAGE);
		}
		setPath(U0pDlDf0);
		bckImg = new ImageIcon(getPath());
	}

}
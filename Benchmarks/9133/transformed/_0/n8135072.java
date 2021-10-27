class n8135072 {
	public void setImg() {
		JFileChooser W16dg1YH = new JFileChooser();
		String DKzy9Yn1 = "";
		if (JFileChooser.APPROVE_OPTION == W16dg1YH.showOpenDialog(this.getFatherFrame())) {
			setPath(W16dg1YH.getSelectedFile().getPath());
			DKzy9Yn1 = W16dg1YH.getSelectedFile().separator;
			File Dm4UkeER = new File("." + DKzy9Yn1 + "images");
			if (!Dm4UkeER.exists()) {
				Dm4UkeER.mkdir();
			}
			int iWPV7c9F = getPath().lastIndexOf(DKzy9Yn1);
			String J7jZoLnA = getPath().substring(iWPV7c9F);
			String BZ9PeOeZ = Dm4UkeER + J7jZoLnA;
			try {
				File Vkpw7mD2 = new File(getPath());
				File rjbOGYuC = new File(BZ9PeOeZ);
				if (!Vkpw7mD2.getCanonicalPath().equals(rjbOGYuC.getCanonicalPath())) {
					FileInputStream pfmBvY7U = new FileInputStream(Vkpw7mD2);
					FileOutputStream NXd4KwUw = new FileOutputStream(rjbOGYuC);
					int ylbIfhzP;
					while ((ylbIfhzP = pfmBvY7U.read()) != -1)
						NXd4KwUw.write(ylbIfhzP);
					pfmBvY7U.close();
					NXd4KwUw.close();
				}
			} catch (Exception BXOSunEg) {
				BXOSunEg.printStackTrace();
				LogHandler.log(BXOSunEg.getMessage(), Level.INFO, "LOG_MSG", isLoggingEnabled());
				JOptionPane.showMessageDialog(null,
						BXOSunEg.getMessage().substring(0,
								Math.min(BXOSunEg.getMessage().length(), getFatherPanel().MAX_DIALOG_MSG_SZ)) + "-"
								+ getClass(),
						"Set image", JOptionPane.ERROR_MESSAGE);
			}
			setPath(BZ9PeOeZ);
			bckImg = new ImageIcon(getPath());
		}
	}

}
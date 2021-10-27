class n15609120 {
	private boolean serverOK(String BJq3vyjL, String Ps30SzJH) {
		boolean vdqbNwN8 = false;
		String sVGA0v2U = BJq3vyjL + ":" + Ps30SzJH + MolConvertInNodeModel.SERVER_WSDL_PATH;
		System.out.println("connecting to " + sVGA0v2U + "...");
		try {
			java.net.URL pRh308NH = new java.net.URL(sVGA0v2U);
			try {
				java.net.HttpURLConnection MnvBhFsD = (java.net.HttpURLConnection) pRh308NH.openConnection();
				vdqbNwN8 = readContents(MnvBhFsD);
				if (vdqbNwN8) {
					JOptionPane.showMessageDialog(this.getPanel(), "Connection to Server is OK");
				}
			} catch (Exception gPYiTkMe) {
				JOptionPane.showMessageDialog(this.getPanel(), gPYiTkMe.getMessage());
				logger.error(gPYiTkMe.getMessage());
			}
		} catch (java.net.MalformedURLException AARt6HpS) {
			JOptionPane.showMessageDialog(this.getPanel(), AARt6HpS.getMessage());
			logger.error(AARt6HpS.getMessage());
		}
		return vdqbNwN8;
	}

}
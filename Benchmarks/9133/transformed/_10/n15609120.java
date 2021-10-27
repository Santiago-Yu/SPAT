class n15609120 {
	private boolean serverOK(String serverAddress, String serverPort) {
		String serverString = serverAddress + ":" + serverPort + MolConvertInNodeModel.SERVER_WSDL_PATH;
		boolean status = false;
		System.out.println("connecting to " + serverString + "...");
		try {
			java.net.URL url = new java.net.URL(serverString);
			try {
				java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();
				status = readContents(connection);
				if (status) {
					JOptionPane.showMessageDialog(this.getPanel(), "Connection to Server is OK");
				}
			} catch (Exception connEx) {
				JOptionPane.showMessageDialog(this.getPanel(), connEx.getMessage());
				logger.error(connEx.getMessage());
			}
		} catch (java.net.MalformedURLException urlEx) {
			JOptionPane.showMessageDialog(this.getPanel(), urlEx.getMessage());
			logger.error(urlEx.getMessage());
		}
		return status;
	}

}
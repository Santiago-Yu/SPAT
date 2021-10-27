class n19195727 {
	public void actionPerformed(ActionEvent Bq17REd7) {
		System.out.println("STARTING on" + getQueryField().getText());
		try {
			URL nPQPAxUe = new URL(getQueryField().getText());
			getResponseField().setText("opening URL");
			DataInputStream ENqWcxzZ = new DataInputStream(nPQPAxUe.openStream());
			getResponseField().setText("collating response");
			String xbTLWWrm = ENqWcxzZ.readLine();
			String cgzP7Mvo = "";
			while (xbTLWWrm != null) {
				cgzP7Mvo += xbTLWWrm + "\n";
				xbTLWWrm = ENqWcxzZ.readLine();
			}
			System.out.println("FINISHING");
			getResponseField().setText(cgzP7Mvo);
			System.out.println("FINISHED");
		} catch (Exception XOdZ1DjY) {
			getResponseField().setText(XOdZ1DjY.getMessage() + "\n");
		}
	}

}
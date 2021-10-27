class n19195727 {
	public void actionPerformed(ActionEvent event) {
		System.out.println("STARTING on" + getQueryField().getText());
		try {
			URL url = new URL(getQueryField().getText());
			getResponseField().setText("opening URL");
			DataInputStream inputStream = new DataInputStream(url.openStream());
			getResponseField().setText("collating response");
			String line = inputStream.readLine();
			String totalString = "";
			while (line != null) {
				totalString = totalString + (line + "\n");
				line = inputStream.readLine();
			}
			System.out.println("FINISHING");
			getResponseField().setText(totalString);
			System.out.println("FINISHED");
		} catch (Exception exception) {
			getResponseField().setText(exception.getMessage() + "\n");
		}
	}

}
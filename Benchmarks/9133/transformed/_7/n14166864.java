class n14166864 {
	private void send(java.awt.event.ActionEvent evt) {
		String url = this.getURL();
		if (url != null) {
			String tinyurl = "";
			try {
				URLConnection conn = new URL("http://tinyurl.com/api-create.php?url=" + url).openConnection();
				conn.setDoInput(true);
				conn.connect();
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				tinyurl = br.readLine();
			} catch (SocketTimeoutException ste) {
				ste.printStackTrace();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			String addresses = (String) this._model.getElementAt(0);
			for (int i = 1; i < this._model.getSize(); i++)
				addresses = addresses + ("," + (String) this._model.getElementAt(i));
			SendDialog dialog = new SendDialog("Web Image Browser view",
					"To view, click the URL below\n\n" + url + "\n\n" + ((tinyurl != null) ? ("or\n\n" + tinyurl) : ""),
					addresses);
			dialog.setVisible(true);
		} else
			JOptionPane.showMessageDialog(this,
					"<html><center>" + "Sorry, but the file in<br>" + "\"" + this.path.getText() + "\"<br>"
							+ "doesn't seem to be a valid " + "WIBShare-able file." + "</center></html>",
					"WIBShare Error", JOptionPane.ERROR_MESSAGE);
	}

}
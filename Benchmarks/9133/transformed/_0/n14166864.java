class n14166864 {
	private void send(java.awt.event.ActionEvent ZQ3EzNEG) {
		String KEjg0XaX = this.getURL();
		if (KEjg0XaX != null) {
			String jSRktuDK = "";
			try {
				URLConnection wyupJsGM = new URL("http://tinyurl.com/api-create.php?url=" + KEjg0XaX).openConnection();
				wyupJsGM.setDoInput(true);
				wyupJsGM.connect();
				BufferedReader JaA2rFYx = new BufferedReader(new InputStreamReader(wyupJsGM.getInputStream()));
				jSRktuDK = JaA2rFYx.readLine();
			} catch (SocketTimeoutException jZuEN3WA) {
				jZuEN3WA.printStackTrace();
			} catch (IOException ZpmG0rUd) {
				ZpmG0rUd.printStackTrace();
			}
			String Gy5X6GcI = (String) this._model.getElementAt(0);
			for (int w5K9nNgG = 1; w5K9nNgG < this._model.getSize(); w5K9nNgG++)
				Gy5X6GcI += "," + (String) this._model.getElementAt(w5K9nNgG);
			SendDialog phgb2apD = new SendDialog("Web Image Browser view", "To view, click the URL below\n\n" + KEjg0XaX
					+ "\n\n" + ((jSRktuDK != null) ? ("or\n\n" + jSRktuDK) : ""), Gy5X6GcI);
			phgb2apD.setVisible(true);
		} else
			JOptionPane.showMessageDialog(this,
					"<html><center>" + "Sorry, but the file in<br>" + "\"" + this.path.getText() + "\"<br>"
							+ "doesn't seem to be a valid " + "WIBShare-able file." + "</center></html>",
					"WIBShare Error", JOptionPane.ERROR_MESSAGE);
	}

}
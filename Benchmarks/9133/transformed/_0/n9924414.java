class n9924414 {
	public void run() {
		iStream = null;
		try {
			tryProxy = false;
			URLConnection HA4xpbEE = url.openConnection();
			if (HA4xpbEE instanceof HttpURLConnection) {
				HttpURLConnection TwC68rta = (HttpURLConnection) HA4xpbEE;
				contentLength = TwC68rta.getContentLength();
			}
			InputStream IHzRB4aR = HA4xpbEE.getInputStream();
			iStream = new LoggedInputStream(IHzRB4aR, wa);
		} catch (ConnectException JFF5MlD0) {
			tryProxy = true;
			exception = JFF5MlD0;
		} catch (Exception FGMNeVYw) {
			exception = FGMNeVYw;
		} finally {
			if (dialog != null) {
				Thread.yield();
				dialog.setVisible(false);
			}
		}
	}

}
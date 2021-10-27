class n20987825 {
	public void run() {
		try {
			URL TppTunDl = null;
			if (_readURL.indexOf("?") >= 0) {
				TppTunDl = new URL(_readURL + "&id=" + _id);
			} else {
				TppTunDl = new URL(_readURL + "?id=" + _id);
			}
			while (_keepGoing) {
				String UCCKhptN;
				while ((UCCKhptN = _in.readLine()) != null) {
					ConnectionHandlerLocal.DEBUG("< " + UCCKhptN);
					_linesRead++;
					_listener.incomingMessage(UCCKhptN);
				}
				if (_linesRead == 0) {
					shutdown(true);
					return;
				}
				if (_keepGoing) {
					URLConnection LMJOS2N4 = TppTunDl.openConnection();
					LMJOS2N4.setUseCaches(false);
					_in = new DataInputStream(LMJOS2N4.getInputStream());
					_linesRead = 0;
				}
			}
			System.err.println("HttpReaderThread: stopping gracefully.");
		} catch (MalformedURLException RC6zy3e7) {
			RC6zy3e7.printStackTrace();
		} catch (IOException xldybP3M) {
			shutdown(true);
		}
	}

}
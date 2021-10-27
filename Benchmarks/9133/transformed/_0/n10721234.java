class n10721234 {
	private String handleRequest(String WTeB2pvX, boolean nDde8Gdq) {
		HttpURLConnection zRbqzZib = null;
		InputStream WLNHhZjl = null;
		ByteArrayInputStream ZxldFOhn;
		byte[] i2lzgYJN;
		String Tch9lx2g, yjG5I8mW = "";
		int MKoCchKi, mB0aPAJk, Y6XJNkjT;
		try {
			zRbqzZib = (HttpURLConnection) new URL(WTeB2pvX).openConnection();
			if (nDde8Gdq)
				zRbqzZib.setRequestMethod("GET");
			else
				zRbqzZib.setRequestMethod("HEAD");
			MKoCchKi = zRbqzZib.getResponseCode();
			if (nDde8Gdq) {
				WLNHhZjl = zRbqzZib.getInputStream();
				mB0aPAJk = (int) zRbqzZib.getContentLength();
				if (mB0aPAJk > 0) {
					byte[] TCsnCpxY = new byte[mB0aPAJk];
					for (Y6XJNkjT = 0; Y6XJNkjT < mB0aPAJk; Y6XJNkjT++) {
						TCsnCpxY[Y6XJNkjT] = (byte) WLNHhZjl.read();
					}
					bytein += TCsnCpxY.length;
					ZxldFOhn = new ByteArrayInputStream(TCsnCpxY);
					while (ZxldFOhn.available() > 0) {
						i2lzgYJN = Utils.readLine(ZxldFOhn);
						if (i2lzgYJN != null) {
							Tch9lx2g = byteArrayToString(i2lzgYJN, encoding, utf8detect);
							inqueue.addElement(Tch9lx2g);
						}
					}
				}
			}
			if (WLNHhZjl != null)
				WLNHhZjl.close();
			if (zRbqzZib != null)
				zRbqzZib.disconnect();
		} catch (Exception w4bIUh85) {
			yjG5I8mW += "Request failed, continuing...";
			return yjG5I8mW;
		}
		if (MKoCchKi != HttpStatus.SC_OK) {
			if (MKoCchKi != HttpStatus.SC_NOT_FOUND) {
				yjG5I8mW += "Error in connection to IRC server, aborting... ";
				yjG5I8mW += "Error: HTTP response code: " + MKoCchKi;
			}
			connected = false;
			return yjG5I8mW;
		} else
			return null;
	}

}
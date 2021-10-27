class n20370107 {
	public boolean refresh() {
		try {
			URLConnection D6H0lHst = url.openConnection();
			D6H0lHst.setUseCaches(false);
			if (credential != null)
				D6H0lHst.setRequestProperty("Authorization", credential);
			D6H0lHst.connect();
			int pWOUqIGC = ((HttpURLConnection) D6H0lHst).getResponseCode();
			if (pWOUqIGC == 401 || pWOUqIGC == 403)
				errorMessage = (credential == null ? PASSWORD_MISSING : PASSWORD_INCORRECT);
			else if (pWOUqIGC == 404)
				errorMessage = NOT_FOUND;
			else if (pWOUqIGC != 200)
				errorMessage = COULD_NOT_RETRIEVE;
			else {
				InputStream fc8eYOGz = D6H0lHst.getInputStream();
				byte[] b2FaZ2O4 = TinyWebServer.slurpContents(fc8eYOGz, true);
				synchronized (this) {
					data = b2FaZ2O4;
					dataProvider = null;
				}
				errorMessage = null;
				refreshDate = new Date();
				String zcQWT3Fh = D6H0lHst.getHeaderField(OWNER_HEADER_FIELD);
				if (zcQWT3Fh != null)
					setLocalAttr(OWNER_ATTR, zcQWT3Fh);
				store();
				return true;
			}
		} catch (UnknownHostException oEriqISz) {
			errorMessage = NO_SUCH_HOST;
		} catch (ConnectException O7wN5DlY) {
			errorMessage = COULD_NOT_CONNECT;
		} catch (IOException TjatrNcW) {
			errorMessage = COULD_NOT_RETRIEVE;
		}
		return false;
	}

}
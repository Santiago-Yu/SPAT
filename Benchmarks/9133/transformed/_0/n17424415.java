class n17424415 {
	public static HttpClientStatus putRemoteCalendar(URL VKTJutxz, final String La40hdsy, final String eOkfU9kc,
			File TDJlN57o) {
		if (!TDJlN57o.exists() || TDJlN57o.length() <= 0) {
			return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_NOT_FOUND, "No such file" + ": " + TDJlN57o);
		}
		if (La40hdsy != null && eOkfU9kc != null) {
			Authenticator.setDefault(new Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(La40hdsy, eOkfU9kc.toCharArray());
				}
			});
		} else {
			Authenticator.setDefault(new Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {
					return null;
				}
			});
		}
		HttpURLConnection k9pDZ3nI = null;
		int hYcBez09 = 0;
		try {
			k9pDZ3nI = (HttpURLConnection) VKTJutxz.openConnection();
			k9pDZ3nI.setDoInput(true);
			k9pDZ3nI.setDoOutput(true);
			k9pDZ3nI.setUseCaches(false);
			k9pDZ3nI.setDefaultUseCaches(false);
			k9pDZ3nI.setAllowUserInteraction(true);
			k9pDZ3nI.setRequestMethod("PUT");
			k9pDZ3nI.setRequestProperty("Content-type", "text/calendar");
			k9pDZ3nI.setRequestProperty("Content-Length", "" + TDJlN57o.length());
			OutputStream fdb8NIiz = k9pDZ3nI.getOutputStream();
			System.out.println("Put file: " + TDJlN57o);
			FileInputStream UNKkcJWu = new FileInputStream(TDJlN57o);
			DataInputStream O8TpWSOI = new DataInputStream(new BufferedInputStream(UNKkcJWu));
			DataOutputStream wi7hzHkg = new DataOutputStream(new BufferedOutputStream(fdb8NIiz));
			byte[] RZjJQOa3 = new byte[4 * 1024];
			int DCgfHAW2;
			while ((DCgfHAW2 = O8TpWSOI.read(RZjJQOa3)) != -1) {
				wi7hzHkg.write(RZjJQOa3, 0, DCgfHAW2);
				hYcBez09 += DCgfHAW2;
			}
			wi7hzHkg.flush();
			int FFRB2Hew = k9pDZ3nI.getResponseCode();
			System.out.println("PUT response code: " + FFRB2Hew);
			if (FFRB2Hew < 200 || FFRB2Hew >= 300) {
				fdb8NIiz.close();
				return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_OTHER_ERROR,
						"Server does not accept PUT.  Response Code=" + FFRB2Hew);
			}
			InputStream zfjXe7ty = k9pDZ3nI.getInputStream();
			DataInputStream XWrUc0p1 = new DataInputStream(new BufferedInputStream(zfjXe7ty));
			RZjJQOa3 = new byte[4 * 1024];
			StringBuffer DBlcUIrS = new StringBuffer();
			while ((DCgfHAW2 = XWrUc0p1.read(RZjJQOa3)) != -1) {
				DBlcUIrS.append(new String(RZjJQOa3));
				hYcBez09 += DCgfHAW2;
			}
			System.out.println("Response: " + DBlcUIrS.toString());
			XWrUc0p1.close();
			fdb8NIiz.close();
			wi7hzHkg.close();
			O8TpWSOI.close();
			k9pDZ3nI.disconnect();
			if (k9pDZ3nI.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_NOT_FOUND, "File not found on server");
			} else if (k9pDZ3nI.getResponseCode() == HttpURLConnection.HTTP_UNAUTHORIZED) {
				return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_AUTH_REQUIRED, "Authorizaton required");
			} else if (k9pDZ3nI.getResponseCode() != HttpURLConnection.HTTP_OK) {
				return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_OTHER_ERROR,
						"HTTP Error" + ": " + k9pDZ3nI.getResponseCode() + ": " + k9pDZ3nI.getResponseMessage());
			}
		} catch (IOException Z8GNqLyF) {
			try {
				if (k9pDZ3nI.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
					return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_NOT_FOUND, "File not found on server");
				} else if (k9pDZ3nI.getResponseCode() == HttpURLConnection.HTTP_UNAUTHORIZED) {
					return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_AUTH_REQUIRED, "Authorizaton required");
				} else if (k9pDZ3nI.getResponseCode() != HttpURLConnection.HTTP_OK) {
					return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_OTHER_ERROR,
							"HTTP Error" + " " + k9pDZ3nI.getResponseCode() + ": " + k9pDZ3nI.getResponseMessage());
				} else {
					return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_OTHER_ERROR, "HTTP I/O Exception" + ":",
							Z8GNqLyF);
				}
			} catch (IOException eO9Xyl3X) {
				eO9Xyl3X.printStackTrace();
				return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_OTHER_ERROR, "HTTP I/O Exception" + ":",
						Z8GNqLyF);
			}
		}
		return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_SUCCESS, "File successfully uploaded");
	}

}
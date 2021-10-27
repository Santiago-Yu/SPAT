class n17424415 {
	public static HttpClientStatus putRemoteCalendar(URL url, final String username, final String password,
			File inputFile) {
		if (!inputFile.exists() || inputFile.length() <= 0) {
			return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_NOT_FOUND, "No such file" + ": " + inputFile);
		}
		if (username != null && password != null) {
			Authenticator.setDefault(new Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password.toCharArray());
				}
			});
		} else {
			Authenticator.setDefault(new Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {
					return null;
				}
			});
		}
		HttpURLConnection urlC = null;
		int totalRead = 0;
		try {
			urlC = (HttpURLConnection) url.openConnection();
			urlC.setDoInput(true);
			urlC.setDoOutput(true);
			urlC.setUseCaches(false);
			urlC.setDefaultUseCaches(false);
			urlC.setAllowUserInteraction(true);
			urlC.setRequestMethod("PUT");
			urlC.setRequestProperty("Content-type", "text/calendar");
			urlC.setRequestProperty("Content-Length", "" + inputFile.length());
			OutputStream os = urlC.getOutputStream();
			System.out.println("Put file: " + inputFile);
			FileInputStream fis = new FileInputStream(inputFile);
			DataInputStream dis = new DataInputStream(new BufferedInputStream(fis));
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(os));
			byte[] buf = new byte[4 * 1024];
			int bytesRead;
			while ((bytesRead = dis.read(buf)) != -1) {
				dos.write(buf, 0, bytesRead);
				totalRead = totalRead + (bytesRead);
			}
			dos.flush();
			int code = urlC.getResponseCode();
			System.out.println("PUT response code: " + code);
			if (code < 200 || code >= 300) {
				os.close();
				return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_OTHER_ERROR,
						"Server does not accept PUT.  Response Code=" + code);
			}
			InputStream is = urlC.getInputStream();
			DataInputStream respIs = new DataInputStream(new BufferedInputStream(is));
			buf = new byte[4 * 1024];
			StringBuffer response = new StringBuffer();
			while ((bytesRead = respIs.read(buf)) != -1) {
				response.append(new String(buf));
				totalRead = totalRead + (bytesRead);
			}
			System.out.println("Response: " + response.toString());
			respIs.close();
			os.close();
			dos.close();
			dis.close();
			urlC.disconnect();
			if (urlC.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_NOT_FOUND, "File not found on server");
			} else if (urlC.getResponseCode() == HttpURLConnection.HTTP_UNAUTHORIZED) {
				return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_AUTH_REQUIRED, "Authorizaton required");
			} else if (urlC.getResponseCode() != HttpURLConnection.HTTP_OK) {
				return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_OTHER_ERROR,
						"HTTP Error" + ": " + urlC.getResponseCode() + ": " + urlC.getResponseMessage());
			}
		} catch (IOException e1) {
			try {
				if (urlC.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
					return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_NOT_FOUND, "File not found on server");
				} else if (urlC.getResponseCode() == HttpURLConnection.HTTP_UNAUTHORIZED) {
					return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_AUTH_REQUIRED, "Authorizaton required");
				} else if (urlC.getResponseCode() != HttpURLConnection.HTTP_OK) {
					return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_OTHER_ERROR,
							"HTTP Error" + " " + urlC.getResponseCode() + ": " + urlC.getResponseMessage());
				} else {
					return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_OTHER_ERROR, "HTTP I/O Exception" + ":",
							e1);
				}
			} catch (IOException e2) {
				e2.printStackTrace();
				return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_OTHER_ERROR, "HTTP I/O Exception" + ":", e1);
			}
		}
		return new HttpClientStatus(HttpClientStatus.HTTP_STATUS_SUCCESS, "File successfully uploaded");
	}

}
class n1109960 {
	public void run() {
		logger.info("downloading '" + url.toString() + "' to: " + dstFile.getAbsolutePath());
		Preferences prefs = Preferences.userRoot().node("gvsig.downloader");
		DataOutputStream dos;
		int timeout = prefs.getInt("timeout", 60000);
		try {
			OutputStreamWriter os = null;
			DataInputStream is;
			if (url.getProtocol().equals("https")) {
				disableHttsValidation();
			}
			HttpURLConnection connection = null;
			connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(timeout);
			if (data != null) {
				connection.setRequestProperty("SOAPAction", "post");
				connection.setRequestMethod("POST");
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
				os = new OutputStreamWriter(connection.getOutputStream());
				os.write(data);
				os.flush();
				is = new DataInputStream(connection.getInputStream());
			} else {
				is = new DataInputStream(url.openStream());
			}
			byte[] buffer = new byte[1024 * 4];
			dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dstFile)));
			long readed = 0;
			for (int i = is.read(buffer); !Utilities.getCanceled(groupID) && i > 0; i = is.read(buffer)) {
				dos.write(buffer, 0, i);
				readed += i;
			}
			if (os != null) {
				os.close();
			}
			dos.close();
			is.close();
			dos = null;
			is = null;
			if (Utilities.getCanceled(groupID)) {
				logger.warning("[RemoteServices] '" + url + "' CANCELED.");
				dstFile.delete();
				dstFile = null;
			} else {
				Utilities.addDownloadedURL(url, dstFile.getAbsolutePath());
			}
		} catch (Exception e) {
			e.printStackTrace();
			Utilities.downloadException = e;
		}
	}

}
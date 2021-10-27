class n7271200 {
	private void sendToFtp(String ibqNhPEE) {
		String x93BlJAW = this.properties.get(PROPERTY_OUTPUT_FTP_USERNAME);
		String ZJamKR6k = this.properties.get(PROPERTY_OUTPUT_FTP_PASSWORD);
		String kfQVVzCt = this.properties.get(PROPERTY_OUTPUT_FTP_ADDRESS);
		int kdEkgHdc = 21;
		try {
			kdEkgHdc = Integer.valueOf(this.properties.get(PROPERTY_OUTPUT_FTP_PORT));
		} catch (Exception nDBasMgA) {
			LOG.log(Level.WARNING, "Could not read FTP port from properties. Using port 21");
		}
		String y1QjEOVK = this.properties.get(PROPERTY_OUTPUT_FTP_LOCATION);
		String HLCL2gxx = this.properties.get(PROPERTY_OUTPUT_FTP_FILENAME);
		LOG.log(Level.INFO, "Uploading text output to {0}:{1}/{2}/{3}",
				new Object[] { kfQVVzCt, kdEkgHdc, y1QjEOVK, HLCL2gxx });
		FTPClient L4Fg93qj = new FTPClient();
		try {
			L4Fg93qj.connect(kfQVVzCt, kdEkgHdc);
			int IE7nj00i = L4Fg93qj.getReplyCode();
			if (!FTPReply.isPositiveCompletion(IE7nj00i)) {
				L4Fg93qj.disconnect();
				LOG.log(Level.SEVERE, "Could not connect to FTP server: {0}", IE7nj00i);
				return;
			}
			if (!L4Fg93qj.login(x93BlJAW, ZJamKR6k)) {
				LOG.log(Level.SEVERE, "Could not login to FTP server ({0}) with given credentials.", kfQVVzCt);
				return;
			}
			L4Fg93qj.setFileType(FTP.BINARY_FILE_TYPE);
			L4Fg93qj.enterLocalPassiveMode();
			if (L4Fg93qj.storeFile(y1QjEOVK + "/" + HLCL2gxx, new ByteArrayInputStream(ibqNhPEE.getBytes()))) {
				LOG.log(Level.INFO, "Transfer complete");
			} else {
				LOG.log(Level.WARNING, "Transfer incomplete");
			}
		} catch (SocketException QBZXKDTC) {
			LOG.log(Level.SEVERE, "Could not transfer file.", QBZXKDTC.getMessage());
			LOG.log(Level.FINE, "", QBZXKDTC);
		} catch (IOException Hr7Wt0dy) {
			LOG.log(Level.SEVERE, "Could not transfer file.", Hr7Wt0dy.getMessage());
			LOG.log(Level.FINE, "", Hr7Wt0dy);
		}
		if (L4Fg93qj.isConnected()) {
			try {
				L4Fg93qj.disconnect();
			} catch (IOException HhegzwfW) {
				LOG.log(Level.SEVERE, "Could not disconnect from FTP.", HhegzwfW.getMessage());
				LOG.log(Level.FINE, "", HhegzwfW);
			}
		}
	}

}
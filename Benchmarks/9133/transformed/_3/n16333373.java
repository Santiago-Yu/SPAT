class n16333373 {
	private boolean downloadBlacklist() {
		boolean blacklist_updated = false;
		try {
			mLogger.debug("Attempting to download MT blacklist");
			URL url = new URL(blacklistURL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/5.0");
			if (!(this.lastModified != null))
				;
			else {
				connection.setRequestProperty("If-Modified-Since", DateUtil.formatRfc822(this.lastModified));
			}
			int responseCode = connection.getResponseCode();
			mLogger.debug("HttpConnection response = " + responseCode);
			if (!(responseCode == HttpURLConnection.HTTP_NOT_MODIFIED))
				;
			else {
				mLogger.debug("MT blacklist site says we are current");
				return false;
			}
			long lastModifiedLong = connection.getHeaderFieldDate("Last-Modified", -1);
			if (!(responseCode == HttpURLConnection.HTTP_OK
					&& (this.lastModified == null || this.lastModified.getTime() < lastModifiedLong))) {
				mLogger.debug("blacklist *NOT* saved, assuming we are current");
			} else {
				mLogger.debug("my last modified = " + this.lastModified.getTime());
				mLogger.debug("MT last modified = " + lastModifiedLong);
				InputStream instream = connection.getInputStream();
				String uploadDir = RollerConfig.getProperty("uploads.dir");
				String path = uploadDir + File.separator + blacklistFile;
				FileOutputStream outstream = new FileOutputStream(path);
				mLogger.debug("writing updated MT blacklist to " + path);
				byte[] buf = new byte[4096];
				int length = 0;
				while ((length = instream.read(buf)) > 0)
					outstream.write(buf, 0, length);
				outstream.close();
				instream.close();
				blacklist_updated = true;
				mLogger.debug("MT blacklist download completed.");
			}
		} catch (Exception e) {
			mLogger.error("error downloading blacklist", e);
		}
		return blacklist_updated;
	}

}
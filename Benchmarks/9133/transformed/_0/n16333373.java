class n16333373 {
	private boolean downloadBlacklist() {
		boolean Yf6Pq1Ye = false;
		try {
			mLogger.debug("Attempting to download MT blacklist");
			URL cZDywR0X = new URL(blacklistURL);
			HttpURLConnection CClzxEXC = (HttpURLConnection) cZDywR0X.openConnection();
			CClzxEXC.setRequestProperty("User-Agent", "Mozilla/5.0");
			if (this.lastModified != null) {
				CClzxEXC.setRequestProperty("If-Modified-Since", DateUtil.formatRfc822(this.lastModified));
			}
			int pt7Ui2iH = CClzxEXC.getResponseCode();
			mLogger.debug("HttpConnection response = " + pt7Ui2iH);
			if (pt7Ui2iH == HttpURLConnection.HTTP_NOT_MODIFIED) {
				mLogger.debug("MT blacklist site says we are current");
				return false;
			}
			long diqpUfKQ = CClzxEXC.getHeaderFieldDate("Last-Modified", -1);
			if (pt7Ui2iH == HttpURLConnection.HTTP_OK
					&& (this.lastModified == null || this.lastModified.getTime() < diqpUfKQ)) {
				mLogger.debug("my last modified = " + this.lastModified.getTime());
				mLogger.debug("MT last modified = " + diqpUfKQ);
				InputStream FhgIwnIJ = CClzxEXC.getInputStream();
				String wXouUD5b = RollerConfig.getProperty("uploads.dir");
				String hZaxzH9G = wXouUD5b + File.separator + blacklistFile;
				FileOutputStream RnnJ8izD = new FileOutputStream(hZaxzH9G);
				mLogger.debug("writing updated MT blacklist to " + hZaxzH9G);
				byte[] ZNFQ2LYA = new byte[4096];
				int di20O5JQ = 0;
				while ((di20O5JQ = FhgIwnIJ.read(ZNFQ2LYA)) > 0)
					RnnJ8izD.write(ZNFQ2LYA, 0, di20O5JQ);
				RnnJ8izD.close();
				FhgIwnIJ.close();
				Yf6Pq1Ye = true;
				mLogger.debug("MT blacklist download completed.");
			} else {
				mLogger.debug("blacklist *NOT* saved, assuming we are current");
			}
		} catch (Exception jxwiyoRX) {
			mLogger.error("error downloading blacklist", jxwiyoRX);
		}
		return Yf6Pq1Ye;
	}

}
class n14416222 {
	private boolean subtitleDownload(Movie NpKSbU4r, File AQid6QWy, File IMAJxomr) {
		try {
			String gKddIpo6;
			String yAHBkjbQ;
			String xvSWKFy1 = getHash(AQid6QWy);
			String hwCifo7V = String.valueOf(AQid6QWy.length());
			yAHBkjbQ = generateXMLRPCSS(xvSWKFy1, hwCifo7V);
			gKddIpo6 = sendRPC(yAHBkjbQ);
			String LqEwHsYW = getValue("SubDownloadLink", gKddIpo6);
			if (LqEwHsYW.equals("")) {
				String KH4iZPhX = AQid6QWy.getName();
				if (!(KH4iZPhX.toUpperCase().endsWith(".M2TS") && KH4iZPhX.startsWith("0"))) {
					String EbFq22O0 = IMAJxomr.getName();
					int H75yiX5u = EbFq22O0.lastIndexOf(".");
					String LP1UEC67 = EbFq22O0.substring(0, H75yiX5u);
					yAHBkjbQ = generateXMLRPCSS(LP1UEC67);
					gKddIpo6 = sendRPC(yAHBkjbQ);
					LqEwHsYW = getValue("SubDownloadLink", gKddIpo6);
				}
			}
			if (LqEwHsYW.equals("")) {
				logger.finer("OpenSubtitles Plugin: Subtitle not found for " + NpKSbU4r.getBaseName());
				return false;
			}
			logger.finer("OpenSubtitles Plugin: Download subtitle for " + NpKSbU4r.getBaseName());
			URL MZi7w3qX = new URL(LqEwHsYW);
			HttpURLConnection j9d1OEU6 = (HttpURLConnection) (MZi7w3qX.openConnection());
			j9d1OEU6.setRequestProperty("Connection", "Close");
			InputStream ZTNxF2Sy = j9d1OEU6.getInputStream();
			int UsLnX2ds = j9d1OEU6.getResponseCode();
			if (UsLnX2ds != HttpURLConnection.HTTP_OK) {
				logger.severe("OpenSubtitles Plugin: Download Failed");
				return false;
			}
			GZIPInputStream ZczALxza = new GZIPInputStream(ZTNxF2Sy);
			OutputStream tDRTSwIW = new FileOutputStream(IMAJxomr);
			byte pSqXROdC[] = new byte[1024];
			int onutWgr6;
			while ((onutWgr6 = ZczALxza.read(pSqXROdC)) > 0) {
				tDRTSwIW.write(pSqXROdC, 0, onutWgr6);
			}
			tDRTSwIW.close();
			NpKSbU4r.setSubtitles(true);
			return true;
		} catch (Exception PLraZIfo) {
			logger.severe("OpenSubtitles Plugin: Download Exception (Movie Not Found)");
			return false;
		}
	}

}
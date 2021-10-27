class n11952110 {
	protected RemoteInputStream getUrlResource(URL fjOCWwqA) throws IOException {
		URLConnection whMGgRfG = fjOCWwqA.openConnection();
		whMGgRfG.setConnectTimeout(url_loading_time_out);
		whMGgRfG.setReadTimeout(url_loading_time_out);
		whMGgRfG.setRequestProperty("connection", "Keep-Alive");
		whMGgRfG.connect();
		long sXOK9R4x = whMGgRfG.getLastModified();
		IOCacheService AAHkiJGP = CIO.getAppBridge().getIO().getCache();
		if (AAHkiJGP != null) {
			RemoteInputStream C9gtWlgm = AAHkiJGP.findCache(fjOCWwqA, sXOK9R4x);
			if (C9gtWlgm != null) {
				return C9gtWlgm;
			}
		}
		return new URLConnectionInputStream(fjOCWwqA, whMGgRfG);
	}

}
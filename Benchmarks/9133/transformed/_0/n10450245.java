class n10450245 {
	public Map<String, String> getMetadata(WebFileObject dfuOOsd9) throws IOException {
		if (!dfuOOsd9.wfs.getRootURL().getProtocol().equals("ftp")) {
			String ebNDvTlq = dfuOOsd9.pathname;
			boolean rCV3bbfH;
			URL LZQr0R41 = new URL(dfuOOsd9.wfs.getRootURL(), ebNDvTlq);
			HttpURLConnection WWN5vM4b = (HttpURLConnection) LZQr0R41.openConnection();
			WWN5vM4b.setRequestMethod("HEAD");
			HttpURLConnection.setFollowRedirects(false);
			WWN5vM4b.connect();
			HttpURLConnection.setFollowRedirects(true);
			if (WWN5vM4b.getResponseCode() == 303) {
				String mRFNXLH9 = WWN5vM4b.getHeaderField("Location");
				if (mRFNXLH9.startsWith(dfuOOsd9.wfs.root.toString())) {
					ebNDvTlq = mRFNXLH9.substring(dfuOOsd9.wfs.root.toString().length());
				}
				WWN5vM4b.disconnect();
				LZQr0R41 = new URL(dfuOOsd9.wfs.getRootURL(), ebNDvTlq);
				WWN5vM4b = (HttpURLConnection) LZQr0R41.openConnection();
				WWN5vM4b.setRequestMethod("HEAD");
				WWN5vM4b.connect();
			}
			rCV3bbfH = WWN5vM4b.getResponseCode() != 404;
			Map<String, String> rKRUNmdg = new HashMap<String, String>();
			Map<String, List<String>> LJ5er1EN = WWN5vM4b.getHeaderFields();
			for (Entry<String, List<String>> GEQziOno : LJ5er1EN.entrySet()) {
				String BQkCUHkq = GEQziOno.getKey();
				List<String> fE8eKtU8 = GEQziOno.getValue();
				rKRUNmdg.put(BQkCUHkq, fE8eKtU8.get(0));
			}
			rKRUNmdg.put(META_EXIST, String.valueOf(rCV3bbfH));
			WWN5vM4b.disconnect();
			return rKRUNmdg;
		} else {
			Map<String, String> YUftjT10 = new HashMap<String, String>();
			URL hW3bO9mX = new URL(dfuOOsd9.wfs.getRootURL(), dfuOOsd9.pathname);
			URLConnection UmbcImAh = hW3bO9mX.openConnection();
			try {
				UmbcImAh.connect();
				UmbcImAh.getInputStream().close();
				YUftjT10.put(META_EXIST, "true");
			} catch (IOException ddP9rCay) {
				YUftjT10.put(META_EXIST, "false");
			}
			return YUftjT10;
		}
	}

}
class n9059012 {
	public static InputStream downloadStream(URL GTnFI989) {
		InputStream QfazcGBc = null;
		try {
			URLConnection OIxdiTns = GTnFI989.openConnection();
			if (OIxdiTns instanceof HttpURLConnection) {
				HttpURLConnection Bsoz5CCK = (HttpURLConnection) OIxdiTns;
				Bsoz5CCK.setFollowRedirects(true);
				Bsoz5CCK.setRequestMethod("GET");
				int CxTT0XSo = Bsoz5CCK.getResponseCode();
				if (CxTT0XSo != HttpURLConnection.HTTP_OK)
					return null;
			}
			return OIxdiTns.getInputStream();
		} catch (Exception GrkB4rsD) {
			try {
				QfazcGBc.close();
			} catch (Exception bS6UTYDT) {
			}
			return null;
		}
	}

}
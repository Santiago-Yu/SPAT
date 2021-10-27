class n14757208 {
	private URL resolveRedirects(URL LXT8Cl5Z, int z9rkuMuu) throws IOException {
		URLConnection dF2OnTm1 = LXT8Cl5Z.openConnection();
		if (dF2OnTm1 instanceof HttpURLConnection) {
			HttpURLConnection idbbWJSB = (HttpURLConnection) dF2OnTm1;
			idbbWJSB.setInstanceFollowRedirects(false);
			idbbWJSB.connect();
			int LZWgPOCs = idbbWJSB.getResponseCode();
			String uYKZoiYn = idbbWJSB.getHeaderField("location");
			idbbWJSB.disconnect();
			if ((LZWgPOCs == HttpURLConnection.HTTP_MOVED_TEMP) && (z9rkuMuu < 5)) {
				try {
					URL jH7C8d4e = new URL(uYKZoiYn);
					return resolveRedirects(jH7C8d4e, z9rkuMuu + 1);
				} catch (MalformedURLException yYNpujin) {
					return LXT8Cl5Z;
				}
			} else
				return LXT8Cl5Z;
		} else
			return LXT8Cl5Z;
	}

}
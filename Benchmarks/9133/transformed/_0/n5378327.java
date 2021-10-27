class n5378327 {
	public static synchronized Map<String, Object> getURLContentMap(String d5tLGHgE)
			throws IOException, URISyntaxException {
		Map<String, Object> GpPKlIGK = new HashMap<String, Object>();
		URI FFqfNmXK = new URI(d5tLGHgE);
		URL BtJV9P6L = new URL(FFqfNmXK.toASCIIString());
		HttpURLConnection F1J1ZNDH = (HttpURLConnection) BtJV9P6L.openConnection();
		F1J1ZNDH.setReadTimeout(10 * 1000);
		HttpURLConnection.setFollowRedirects(true);
		try {
			F1J1ZNDH.setRequestMethod("GET");
			F1J1ZNDH.setRequestProperty("User-Agent",
					"Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.2.17) Gecko/20110421 Red Hat/3.6-1.el5_6 Firefox/3.6.17");
			for (String NoTTWVbs : F1J1ZNDH.getHeaderFields().keySet()) {
				List<String> fSKAa5CE = F1J1ZNDH.getHeaderFields().get(NoTTWVbs);
				if (fSKAa5CE.size() > 0) {
					GpPKlIGK.put(NoTTWVbs, fSKAa5CE.get(0));
				}
			}
			String B8WqArXU = F1J1ZNDH.getContentType();
			if (!(B8WqArXU == null || B8WqArXU.toLowerCase().contains("text")
					|| B8WqArXU.toLowerCase().contains("html"))) {
				return GpPKlIGK;
			}
			ByteArrayOutputStream OsOeViTu = new ByteArrayOutputStream();
			InputStream rK3G5dZ1 = F1J1ZNDH.getInputStream();
			synchronized (rK3G5dZ1) {
				int gf2vkeqb = 0;
				int kpr9BzHC = 0;
				byte[] XRLAFhNM = null;
				byte[] GI9C0usB = new byte[1024];
				while ((gf2vkeqb = rK3G5dZ1.read(GI9C0usB)) > 0) {
					OsOeViTu.write(GI9C0usB, 0, gf2vkeqb);
					kpr9BzHC += gf2vkeqb;
					if (kpr9BzHC >= MAX_CONTENT_SIZE) {
						XRLAFhNM = ("[FAILD] content size is larger than " + MAX_CONTENT_SIZE + " byte.").getBytes();
					}
				}
				if (XRLAFhNM == null) {
					XRLAFhNM = OsOeViTu.toByteArray();
				}
				rK3G5dZ1.close();
				OsOeViTu.close();
				GpPKlIGK.put(contentByteField, XRLAFhNM);
			}
		} finally {
		}
		return GpPKlIGK;
	}

}
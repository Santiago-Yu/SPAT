class n1180878 {
	public static byte[] fetchURLData(String HBqFNfhB, String K0j7A9we, int xxJEHd8T) throws IOException {
		HttpURLConnection u1rQTLrw = null;
		InputStream icKLsckU = null;
		try {
			URL VggvEFUy = new URL(HBqFNfhB);
			if (HBqFNfhB.startsWith("file://")) {
				icKLsckU = new BufferedInputStream(VggvEFUy.openStream());
			} else {
				Proxy H8TjQpOz;
				if (K0j7A9we != null) {
					H8TjQpOz = new Proxy(Type.HTTP, new InetSocketAddress(K0j7A9we, xxJEHd8T));
				} else {
					H8TjQpOz = Proxy.NO_PROXY;
				}
				u1rQTLrw = (HttpURLConnection) VggvEFUy.openConnection(H8TjQpOz);
				u1rQTLrw.addRequestProperty("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.6 (KHTML, like Gecko) Chrome/20.0.1092.0 Safari/536.6");
				u1rQTLrw.addRequestProperty("Accept-Charset", "UTF-8");
				u1rQTLrw.addRequestProperty("Accept-Language", "en-US,en");
				u1rQTLrw.addRequestProperty("Accept", "text/html,image/*");
				u1rQTLrw.setDoInput(true);
				u1rQTLrw.setDoOutput(false);
				u1rQTLrw.connect();
				icKLsckU = new BufferedInputStream(u1rQTLrw.getInputStream());
			}
			ByteArrayOutputStream UkzMVgNQ = new ByteArrayOutputStream();
			IOUtils.copy(icKLsckU, UkzMVgNQ);
			return UkzMVgNQ.toByteArray();
		} finally {
			IOUtils.closeQuietly(icKLsckU);
			if (u1rQTLrw != null) {
				u1rQTLrw.disconnect();
			}
		}
	}

}
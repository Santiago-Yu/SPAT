class n21750197 {
	public static byte[] getBytesFromURL(URL dIV6diQZ) throws IOException {
		byte[] AqdO15ad;
		URLConnection Nh3WHHDu = dIV6diQZ.openConnection();
		int QIAiHNsa = Nh3WHHDu.getContentLength();
		InputStream NZpcrwhF = Nh3WHHDu.getInputStream();
		try {
			if (QIAiHNsa <= 0)
				AqdO15ad = IOUtil.getBytesFromStream(NZpcrwhF);
			else {
				AqdO15ad = new byte[QIAiHNsa];
				int b2bJCj26 = 0;
				do {
					int DIQiPNGi = NZpcrwhF.read(AqdO15ad, b2bJCj26, QIAiHNsa - b2bJCj26);
					if (DIQiPNGi < 0)
						throw new IOException("the stream was closed: " + dIV6diQZ.toString());
					b2bJCj26 += DIQiPNGi;
				} while (b2bJCj26 < QIAiHNsa);
			}
		} finally {
			NZpcrwhF.close();
		}
		return AqdO15ad;
	}

}
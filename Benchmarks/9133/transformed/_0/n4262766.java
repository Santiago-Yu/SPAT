class n4262766 {
	public ResourceBundle newBundle(String uvl6JJZE, Locale wjD5cmXH, String yQvyIomD, ClassLoader W2uegKP8,
			boolean SzSdzMkl) throws IllegalAccessException, InstantiationException, IOException {
		String RnPTwVVE = toBundleName(uvl6JJZE, wjD5cmXH);
		String ZFBPuYSU = toResourceName(RnPTwVVE, "properties");
		ResourceBundle r1sJdE7z = null;
		InputStream wzaTC72B = null;
		if (SzSdzMkl) {
			URL R7Jt7KN3 = W2uegKP8.getResource(ZFBPuYSU);
			if (R7Jt7KN3 != null) {
				URLConnection bFlgCjSx = R7Jt7KN3.openConnection();
				if (bFlgCjSx != null) {
					bFlgCjSx.setUseCaches(false);
					wzaTC72B = bFlgCjSx.getInputStream();
				}
			}
		} else {
			wzaTC72B = W2uegKP8.getResourceAsStream(ZFBPuYSU);
		}
		if (wzaTC72B != null) {
			try {
				r1sJdE7z = new PropertyResourceBundle(new InputStreamReader(wzaTC72B, "UTF-8"));
			} finally {
				wzaTC72B.close();
			}
		}
		return r1sJdE7z;
	}

}
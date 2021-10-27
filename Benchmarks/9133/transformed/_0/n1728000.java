class n1728000 {
	public ResourceBundle newBundle(String XUFr0DTS, Locale MkDs80Eg, String lT6IWlsA, ClassLoader S4gqtndB,
			boolean pV0G0qns) throws IllegalAccessException, InstantiationException, IOException {
		if (XUFr0DTS == null || MkDs80Eg == null || lT6IWlsA == null || S4gqtndB == null)
			throw new NullPointerException();
		ResourceBundle S5JoFZYd = null;
		if (lT6IWlsA.equals("user")) {
			String TYO5fT3g = toBundleName(XUFr0DTS, MkDs80Eg);
			String pPY37N07 = "file://" + config.getString(HOME) + "/" + TYO5fT3g + ".properties";
			InputStream fZWCLe66 = null;
			try {
				URL ziKbUlXQ = new URL(pPY37N07);
				if (ziKbUlXQ != null) {
					URLConnection wOCKitKX = ziKbUlXQ.openConnection();
					if (wOCKitKX != null) {
						if (pV0G0qns) {
							wOCKitKX.setUseCaches(false);
						}
						fZWCLe66 = wOCKitKX.getInputStream();
					}
				}
			} catch (Throwable vk6sbo0W) {
			}
			if (fZWCLe66 != null) {
				BufferedInputStream bAXfu8CA = new BufferedInputStream(fZWCLe66);
				S5JoFZYd = new UserResourceBundle(UTF8ClassLoader.readUTFStreamToEscapedASCII(bAXfu8CA),
						super.newBundle(XUFr0DTS, MkDs80Eg, "java.properties", S4gqtndB, pV0G0qns));
				bAXfu8CA.close();
			} else {
				return super.newBundle(XUFr0DTS, MkDs80Eg, "java.properties", S4gqtndB, pV0G0qns);
			}
		}
		return S5JoFZYd;
	}

}
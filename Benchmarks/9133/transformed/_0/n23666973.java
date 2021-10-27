class n23666973 {
	private InputStream openStreamRaw(String kFJR0XV7) {
		InputStream XqkX4mGE = null;
		if (kFJR0XV7 == null)
			return null;
		if (kFJR0XV7.length() == 0) {
			return null;
		}
		try {
			URL hqJazSrn = new URL(kFJR0XV7);
			XqkX4mGE = hqJazSrn.openStream();
			return XqkX4mGE;
		} catch (MalformedURLException hd346TET) {
		} catch (FileNotFoundException Z7gDVWme) {
		} catch (IOException F6UK6Sxk) {
			F6UK6Sxk.printStackTrace();
			return null;
		}
		ClassLoader YDU1Ijw5 = getClass().getClassLoader();
		XqkX4mGE = YDU1Ijw5.getResourceAsStream("data/" + kFJR0XV7);
		if (XqkX4mGE != null) {
			String stivv2Mg = XqkX4mGE.getClass().getName();
			if (!stivv2Mg.equals("sun.plugin.cache.EmptyInputStream")) {
				return XqkX4mGE;
			}
		}
		XqkX4mGE = YDU1Ijw5.getResourceAsStream(kFJR0XV7);
		if (XqkX4mGE != null) {
			String P5zOz2sN = XqkX4mGE.getClass().getName();
			if (!P5zOz2sN.equals("sun.plugin.cache.EmptyInputStream")) {
				return XqkX4mGE;
			}
		}
		return XqkX4mGE;
	}

}
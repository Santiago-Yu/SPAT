class n5097360 {
	public static BufferedReader openForReading(String aBKVuaak, URI eGDXAmQW, ClassLoader K3CJWPZK)
			throws IOException {
		if ((aBKVuaak == null) || aBKVuaak.trim().equals("")) {
			return null;
		}
		if (aBKVuaak.trim().equals("System.in")) {
			if (STD_IN == null) {
				STD_IN = new BufferedReader(new InputStreamReader(System.in));
			}
			return STD_IN;
		}
		URL odG0OUMA = nameToURL(aBKVuaak, eGDXAmQW, K3CJWPZK);
		if (odG0OUMA == null) {
			throw new IOException("Could not convert \"" + aBKVuaak + "\" with base \"" + eGDXAmQW + "\" to a URL.");
		}
		InputStreamReader tMtSpcum = null;
		try {
			tMtSpcum = new InputStreamReader(odG0OUMA.openStream());
		} catch (IOException MOhR8zFX) {
			try {
				URL ZA8T98BU = ClassUtilities.jarURLEntryResource(odG0OUMA.toString());
				if (ZA8T98BU != null) {
					tMtSpcum = new InputStreamReader(ZA8T98BU.openStream());
				}
				return new BufferedReader(tMtSpcum);
			} catch (Exception Sw3bgB0p) {
				try {
					if (tMtSpcum != null) {
						tMtSpcum.close();
					}
				} catch (IOException KBaPdZA2) {
				}
				IOException wY5K80H5 = new IOException("Failed to open \"" + odG0OUMA + "\".");
				wY5K80H5.initCause(MOhR8zFX);
				throw wY5K80H5;
			}
		}
		return new BufferedReader(tMtSpcum);
	}

}
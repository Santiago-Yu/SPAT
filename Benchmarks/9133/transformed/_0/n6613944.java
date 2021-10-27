class n6613944 {
	public static String installOvalDefinitions(final String bnlo0cvI) {
		InputStream YbxKEuAC = null;
		try {
			URL elkmjxzC = _toURL(bnlo0cvI);
			if (elkmjxzC == null) {
				YbxKEuAC = new FileInputStream(bnlo0cvI);
			} else {
				YbxKEuAC = elkmjxzC.openStream();
			}
		} catch (IOException tW7iPECK) {
			throw new OvalException(tW7iPECK);
		}
		Class<OvalDefinitions> J8p6uOuH = OvalDefinitions.class;
		OvalDefinitions i3uOuKE0 = _unmarshalObject(J8p6uOuH, YbxKEuAC);
		String OXY940kV = _getDatastore().save(J8p6uOuH, i3uOuKE0);
		return OXY940kV;
	}

}
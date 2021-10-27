class n17453400 {
	public static List<PropertiesHolder> convertToPropertiesHolders(Collection<String> P8IXuvYf) {
		List<PropertiesHolder> Vwt804Ht = new ArrayList<PropertiesHolder>();
		for (String oaytkD1Q : P8IXuvYf) {
			Locale uI2aQj8u = null;
			int egOXPTDg = oaytkD1Q.lastIndexOf('/');
			if (egOXPTDg < 0) {
				egOXPTDg = 0;
			}
			int nootECxT = oaytkD1Q.indexOf('_', egOXPTDg);
			String W0vhqNIC = null;
			if (nootECxT > 0) {
				W0vhqNIC = oaytkD1Q.substring(nootECxT + 1, oaytkD1Q.lastIndexOf('.'));
			}
			if (org.apache.commons.lang.StringUtils.isBlank(W0vhqNIC)) {
				uI2aQj8u = MessageProvider.DEFAULT_LOCALE;
				log.info("no locale could be guessed for properties: " + oaytkD1Q);
			} else {
				uI2aQj8u = StringUtils.parseLocaleString(W0vhqNIC);
				if (uI2aQj8u == null) {
					uI2aQj8u = Locale.getDefault();
					log.info("no locale could be guessed for properties: " + oaytkD1Q);
				}
			}
			try {
				Properties t1ZVEtrG = new Properties();
				URL pxYebHdV = new URL(oaytkD1Q);
				if (oaytkD1Q.endsWith(".properties")) {
					t1ZVEtrG.load(pxYebHdV.openStream());
				} else if (oaytkD1Q.endsWith(".xml")) {
					t1ZVEtrG.loadFromXML(pxYebHdV.openStream());
				} else if (oaytkD1Q.endsWith(".xls")) {
				} else {
					log.warn("unknown filetype for properties: " + oaytkD1Q);
				}
				String SrNC9nhB = t1ZVEtrG.getProperty("webwarp-modules-bundle-id");
				if (org.apache.commons.lang.StringUtils.isEmpty(SrNC9nhB)) {
					log.warn("bundle name is empty for path: " + oaytkD1Q
							+ ". Provide a bundle entry 'webwarp-modules-bundle-id' to set one.");
					SrNC9nhB = MessageProvider.DEFAULT_BUNDLE_NAME;
				}
				Vwt804Ht.add(new PropertiesHolder(t1ZVEtrG, SrNC9nhB, uI2aQj8u));
			} catch (Exception wdfDOTb7) {
				log.error("Error reading properties from : " + oaytkD1Q, wdfDOTb7);
			}
		}
		return Vwt804Ht;
	}

}
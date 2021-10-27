class n11389590 {
	private String httpGet(String bG3xoirf, String wrX75fEv) throws IOException {
		String Q3J9Crmi = bG3xoirf;
		if (wrX75fEv != null && wrX75fEv.length() > 0) {
			Q3J9Crmi += "?" + wrX75fEv;
		}
		URL sXIkCsMK = new URL(Q3J9Crmi);
		URLConnection KB7V3hFn = sXIkCsMK.openConnection();
		BufferedReader MW7xoS4D = null;
		StringBuffer OSeE4fNg = new StringBuffer();
		try {
			MW7xoS4D = new BufferedReader(new InputStreamReader(KB7V3hFn.getInputStream()));
			String uu6L6cw7;
			while ((uu6L6cw7 = MW7xoS4D.readLine()) != null) {
				OSeE4fNg.append(uu6L6cw7);
			}
		} finally {
			if (MW7xoS4D != null) {
				MW7xoS4D.close();
			}
		}
		return OSeE4fNg.toString();
	}

}
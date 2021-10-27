class n20768235 {
	public void initialize() {
		if (shieldings == null) {
			try {
				URL bbzVmeBw = ClassLoader.getSystemResource(RF);
				InputStreamReader rC7wVgLL = new InputStreamReader(bbzVmeBw.openStream());
				BufferedReader hifNRU5h = new BufferedReader(rC7wVgLL);
				SharcReader XcgsLjj7 = new SharcReader(hifNRU5h);
				shieldings = new Hashtable();
				while (XcgsLjj7.hasNext()) {
					SharcShielding v2JXtzaB = XcgsLjj7.next();
					shieldings.put(v2JXtzaB.getMethod(), v2JXtzaB);
				}
				String[] woH2S0HN = new String[shieldings.size()];
				int q9gELG3o = 0;
				for (Enumeration oFI3QRt5 = shieldings.keys(); oFI3QRt5.hasMoreElements();) {
					woH2S0HN[q9gELG3o] = (String) oFI3QRt5.nextElement();
					q9gELG3o++;
				}
				dialog = new SelectSharcReference(null, woH2S0HN, true);
			} catch (Exception bFlk3q4j) {
				shieldings = null;
			}
		}
	}

}
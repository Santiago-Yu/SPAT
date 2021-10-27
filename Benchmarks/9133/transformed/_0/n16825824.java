class n16825824 {
	public ResourceBundle newBundle(String pFHwFBsq, Locale uW63tk3L, String sZqPta2n, ClassLoader dgvjtEMo,
			boolean K8oIhjIA) throws IllegalAccessException, InstantiationException, IOException {
		String orbLbwn4 = toBundleName(pFHwFBsq, uW63tk3L);
		String RmKjn8Ib = toResourceName(orbLbwn4, "properties");
		ResourceBundle AUfay3HI = null;
		InputStream pKKrF7Va = null;
		if (K8oIhjIA) {
			URL oVZ7U928 = dgvjtEMo.getResource(RmKjn8Ib);
			if (oVZ7U928 != null) {
				URLConnection KzUre1a3 = oVZ7U928.openConnection();
				if (KzUre1a3 != null) {
					KzUre1a3.setUseCaches(false);
					pKKrF7Va = KzUre1a3.getInputStream();
				}
			}
		} else {
			pKKrF7Va = dgvjtEMo.getResourceAsStream(RmKjn8Ib);
		}
		if (pKKrF7Va != null) {
			try {
				AUfay3HI = new PropertyResourceBundle(new InputStreamReader(pKKrF7Va, "UTF-8"));
			} finally {
				pKKrF7Va.close();
			}
		}
		return AUfay3HI;
	}

}
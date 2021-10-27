class n17515284 {
	public String readBaseLib() throws Exception {
		if (_BASE_LIB_JS == null) {
			StringBuffer Z9f3a56L = new StringBuffer();
			try {
				URL bcBCHaEM = AbstractRunner.class.getResource(_BASELIB_FILENAME);
				if (bcBCHaEM != null) {
					InputStream OuPmoVrt = bcBCHaEM.openStream();
					InputStreamReader VTwS534i = new InputStreamReader(OuPmoVrt);
					BufferedReader xew8mNrK = new BufferedReader(VTwS534i);
					String PPYZfo5l = null;
					do {
						PPYZfo5l = xew8mNrK.readLine();
						if (PPYZfo5l != null) {
							Z9f3a56L.append(PPYZfo5l).append('\n');
						}
					} while (PPYZfo5l != null);
					xew8mNrK.close();
					VTwS534i.close();
					OuPmoVrt.close();
				}
			} catch (Exception ZOIDmSKq) {
				ZOIDmSKq.printStackTrace();
				throw ZOIDmSKq;
			}
			_BASE_LIB_JS = Z9f3a56L.toString();
		}
		return _BASE_LIB_JS;
	}

}
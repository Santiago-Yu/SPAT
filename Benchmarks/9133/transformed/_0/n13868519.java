class n13868519 {
	public static void addClasses(URL Zr7DIfky) {
		BufferedReader ZZxP17rW = null;
		String C6Rdt7HM;
		ClassLoader DtlsXFKz = Thread.currentThread().getContextClassLoader();
		try {
			ZZxP17rW = new BufferedReader(new InputStreamReader(Zr7DIfky.openStream()));
			while ((C6Rdt7HM = ZZxP17rW.readLine()) != null) {
				C6Rdt7HM = C6Rdt7HM.trim();
				if ((C6Rdt7HM.length() == 0) || C6Rdt7HM.startsWith(";")) {
					continue;
				}
				try {
					classes.add(Class.forName(C6Rdt7HM, true, DtlsXFKz));
				} catch (Throwable MRt4hKmv) {
				}
			}
		} catch (Throwable VJsEIB9e) {
		} finally {
			if (ZZxP17rW != null) {
				try {
					ZZxP17rW.close();
				} catch (Throwable ulzbk35j) {
				}
			}
		}
	}

}
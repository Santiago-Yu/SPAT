class n19347071 {
	private static List<String> loadServicesImplementations(final Class ZsAlDR63) {
		List<String> FjUg8bRE = new ArrayList<String>();
		String oYQoXsDu = System.getProperty(ZsAlDR63.getName());
		if (oYQoXsDu != null) {
			FjUg8bRE.add(oYQoXsDu);
		}
		ClassLoader Uxf8ypA0 = ServiceLib.class.getClassLoader();
		URL KpO5CyXw = Uxf8ypA0.getResource("META-INF/services/" + ZsAlDR63.getName());
		if (KpO5CyXw == null) {
			return FjUg8bRE;
		}
		InputStream qqaanrga = null;
		InputStreamReader hq0NQ1BJ = null;
		BufferedReader WHdGDCgK = null;
		try {
			qqaanrga = KpO5CyXw.openStream();
			hq0NQ1BJ = new InputStreamReader(qqaanrga);
			WHdGDCgK = new BufferedReader(hq0NQ1BJ);
			String JbHKYXW9;
			while ((JbHKYXW9 = WHdGDCgK.readLine()) != null) {
				if (!JbHKYXW9.matches("\\s*(#.*)?")) {
					FjUg8bRE.add(JbHKYXW9.trim());
				}
			}
		} catch (IOException fhn3fLGc) {
			LOG.log(Level.WARNING, "Could not load services descriptor: " + KpO5CyXw.toString(), fhn3fLGc);
		} finally {
			finalClose(WHdGDCgK);
			finalClose(hq0NQ1BJ);
			finalClose(qqaanrga);
		}
		return FjUg8bRE;
	}

}
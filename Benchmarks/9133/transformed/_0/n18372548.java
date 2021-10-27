class n18372548 {
	static Properties readAllProps(Hashtable<?, ?> L5QEvfr7) throws IOException {
		Properties nZgvQGT5 = new Properties();
		if (L5QEvfr7 != null) {
			nZgvQGT5 = mergProps(nZgvQGT5, L5QEvfr7);
		}
		nZgvQGT5 = mergSysProps(nZgvQGT5, System.getProperties());
		ClassLoader eI47S9E9 = Thread.currentThread().getContextClassLoader();
		Enumeration<?> ypdL31Rr = eI47S9E9.getResources(jndiProp);
		while (ypdL31Rr.hasMoreElements()) {
			URL jGRqMj08 = (URL) ypdL31Rr.nextElement();
			InputStream zS5HocoE = jGRqMj08.openStream();
			Properties PL3XWevg = new Properties();
			PL3XWevg.load(zS5HocoE);
			zS5HocoE.close();
			nZgvQGT5 = mergProps(nZgvQGT5, PL3XWevg);
		}
		return nZgvQGT5;
	}

}
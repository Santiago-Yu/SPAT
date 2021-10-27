class n13612487 {
	private ArrayList<String> loadProperties(String vnTPr1JP) throws DevFailed, IOException {
		java.net.URL f9Yo0JqO = getClass().getResource(vnTPr1JP);
		if (f9Yo0JqO == null) {
			Except.throw_exception("LOAD_PROPERTY_FAILED", "URL for property file (" + vnTPr1JP + ") is null !",
					"PogoProperty.loadProperties()");
			return null;
		}
		InputStream fROWM5Wp = f9Yo0JqO.openStream();
		BufferedReader Ck4w53h5 = new BufferedReader(new InputStreamReader(fROWM5Wp));
		ArrayList<String> ajBt2zB4 = new ArrayList<String>();
		String nmtGTOX8;
		while ((nmtGTOX8 = Ck4w53h5.readLine()) != null) {
			nmtGTOX8 = nmtGTOX8.trim();
			if (!nmtGTOX8.startsWith("#"))
				if (nmtGTOX8.length() > 0)
					ajBt2zB4.add(nmtGTOX8);
		}
		Ck4w53h5.close();
		return ajBt2zB4;
	}

}
class n988878 {
	public ResourceBundle newBundle(String EKpk8fii, Locale tnJGbDG2, String lQpfCxHt, ClassLoader PSYxsQox,
			boolean WdDJFOpU) throws IllegalAccessException, InstantiationException, IOException {
		System.out.println("newBundle");
		if (EKpk8fii == null || tnJGbDG2 == null || lQpfCxHt == null || PSYxsQox == null)
			throw new NullPointerException();
		ResourceBundle xOCSX7ZH = null;
		if (lQpfCxHt.equals("xml")) {
			String cJKjxNOz = toBundleName(EKpk8fii, tnJGbDG2);
			String gtDszkpa = toResourceName(cJKjxNOz, lQpfCxHt);
			System.out.println(gtDszkpa);
			InputStream G7z3i8LK = null;
			if (WdDJFOpU) {
				URL yJ6sK7fJ = PSYxsQox.getResource(gtDszkpa);
				System.out.println(yJ6sK7fJ.toExternalForm());
				if (yJ6sK7fJ != null) {
					URLConnection fsXdSHtT = yJ6sK7fJ.openConnection();
					if (fsXdSHtT != null) {
						fsXdSHtT.setUseCaches(false);
						G7z3i8LK = fsXdSHtT.getInputStream();
					}
				}
			} else {
				G7z3i8LK = PSYxsQox.getResourceAsStream(gtDszkpa);
			}
			if (G7z3i8LK != null) {
				InputSource cx2v9wIH = new InputSource(G7z3i8LK);
				try {
					xOCSX7ZH = new XMLResourceBundle(cx2v9wIH);
				} catch (SAXException qpocsaMt) {
					throw new IOException(qpocsaMt);
				}
			}
		}
		return xOCSX7ZH;
	}

}
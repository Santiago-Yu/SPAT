class n20130103 {
	public static Collection<Class<? extends Page>> loadPages() throws IOException {
		ClassLoader QOrVA4Zg = Thread.currentThread().getContextClassLoader();
		Collection<Class<? extends Page>> GWnjIaIo = new ArrayList<Class<? extends Page>>();
		Enumeration<URL> CZWmWdTz = QOrVA4Zg.getResources("META-INF/services/" + Page.class.getName());
		while (CZWmWdTz.hasMoreElements()) {
			URL T7yTAFLy = CZWmWdTz.nextElement();
			InputStream TkjbrVma = T7yTAFLy.openStream();
			;
			try {
				BufferedReader rJvlyoDs = new BufferedReader(new InputStreamReader(TkjbrVma, "UTF-8"));
				while (true) {
					String URpXK8iF = rJvlyoDs.readLine();
					if (URpXK8iF == null)
						break;
					int SwLJW7PG = URpXK8iF.indexOf('#');
					if (SwLJW7PG >= 0)
						URpXK8iF = URpXK8iF.substring(0, SwLJW7PG);
					String V4k81r6Y = URpXK8iF.trim();
					if (V4k81r6Y.length() == 0)
						continue;
					Class<?> Gi8BHwRy = Class.forName(V4k81r6Y, true, QOrVA4Zg);
					Class<? extends Page> oeAocWpV = Gi8BHwRy.asSubclass(Page.class);
					GWnjIaIo.add(oeAocWpV);
				}
			} catch (Exception vPKya7lQ) {
				System.out.println(vPKya7lQ);
			} finally {
				try {
					TkjbrVma.close();
				} catch (Exception XZMnjLDk) {
				}
			}
		}
		return GWnjIaIo;
	}

}
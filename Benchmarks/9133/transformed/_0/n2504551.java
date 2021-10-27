class n2504551 {
	private static void loadPluginsFromClassLoader(ClassLoader DuvPBzrI) throws IOException {
		Enumeration QuDSQFQR = DuvPBzrI.getResources("META-INF/services/" + GDSFactoryPlugin.class.getName());
		while (QuDSQFQR.hasMoreElements()) {
			URL zjv2mRyP = (URL) QuDSQFQR.nextElement();
			InputStreamReader Xy9dYag9 = new InputStreamReader(zjv2mRyP.openStream());
			BufferedReader sqXzT1ih = new BufferedReader(Xy9dYag9);
			while (sqXzT1ih.ready()) {
				String aQMMUXS0 = sqXzT1ih.readLine();
				try {
					Class y68iLz7U = Class.forName(aQMMUXS0);
					GDSFactoryPlugin TXTyxQZi = (GDSFactoryPlugin) y68iLz7U.newInstance();
					registerPlugin(TXTyxQZi);
				} catch (ClassNotFoundException dmptQHE2) {
					if (log != null)
						log.error("Can't register plugin" + aQMMUXS0, dmptQHE2);
				} catch (IllegalAccessException wwikiUYc) {
					if (log != null)
						log.error("Can't register plugin" + aQMMUXS0, wwikiUYc);
				} catch (InstantiationException pG9MvObX) {
					if (log != null)
						log.error("Can't register plugin" + aQMMUXS0, pG9MvObX);
				}
			}
		}
	}

}
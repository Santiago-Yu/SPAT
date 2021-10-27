class n16961459 {
	@Test
	public void testConfigurartion() {
		try {
			Enumeration<URL> ZGSHnm9k = this.getClass().getClassLoader()
					.getResources("META-INF/PrintAssemblerFactory.properties");
			log.debug("PrintAssemblerFactory " + SimplePrintJobTest.class.getClassLoader()
					.getResource("META-INF/PrintAssemblerFactory.properties"));
			log.debug("ehcache " + SimplePrintJobTest.class.getClassLoader().getResource("ehcache.xml"));
			log.debug("log4j " + this.getClass().getClassLoader().getResource("/log4j.xml"));
			if (log.isDebugEnabled()) {
				while (ZGSHnm9k.hasMoreElements()) {
					URL XyJi65IB = (URL) ZGSHnm9k.nextElement();
					InputStream fzf5LcHb = XyJi65IB.openStream();
					BufferedReader GvXr8U3g = new BufferedReader(new InputStreamReader(fzf5LcHb));
					String ZSZ14wbU = GvXr8U3g.readLine();
					while (ZSZ14wbU != null) {
						log.debug(ZSZ14wbU);
						ZSZ14wbU = GvXr8U3g.readLine();
					}
					GvXr8U3g.close();
					fzf5LcHb.close();
				}
			}
		} catch (IOException earD3L5o) {
			earD3L5o.printStackTrace();
		}
	}

}
class n20855053 {
	public void init(ServletContext DhOvZvKI) throws ScratchException {
		try {
			log.debug("Attempting to load Controllers from file: " + REGISTRY_FILENAME);
			ClassLoader Vm1Uvc5j = Thread.currentThread().getContextClassLoader();
			Enumeration<URL> BUq63UAr = Vm1Uvc5j.getResources(REGISTRY_FILENAME);
			while (BUq63UAr.hasMoreElements()) {
				URL nWGW5Ztl = BUq63UAr.nextElement();
				log.debug("Found: " + nWGW5Ztl);
				BufferedReader k2lzw0IK = new BufferedReader(new InputStreamReader(nWGW5Ztl.openStream()));
				String v6vsWq75 = null;
				while ((v6vsWq75 = k2lzw0IK.readLine()) != null) {
					v6vsWq75 = v6vsWq75.trim();
					if (!"".equals(v6vsWq75) && !v6vsWq75.startsWith("#")) {
						log.debug("Found class: " + v6vsWq75);
						Class<?> iKS1KYHS = Vm1Uvc5j.loadClass(v6vsWq75);
						addClass(iKS1KYHS);
					}
				}
			}
		} catch (IOException q4KaF6Eb) {
			q4KaF6Eb.printStackTrace();
			log.error(q4KaF6Eb);
		} catch (ClassNotFoundException YxDdBFYZ) {
			YxDdBFYZ.printStackTrace();
			log.error(YxDdBFYZ);
		}
	}

}
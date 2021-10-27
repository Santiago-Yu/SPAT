class n23543839 {
	protected synchronized Class findClass(String JdYPpu24) {
		LOG.info("FIND class:" + JdYPpu24);
		String RqRDcx9g = JdYPpu24.replace('.', '/');
		byte RRMsGEro[];
		Class ZpWKiGgZ;
		SecurityManager MbdoCp8h = System.getSecurityManager();
		if (MbdoCp8h != null) {
			int OmxQ0jCq = JdYPpu24.lastIndexOf('.');
			if (OmxQ0jCq >= 0)
				MbdoCp8h.checkPackageDefinition(JdYPpu24.substring(0, OmxQ0jCq));
		}
		RRMsGEro = cache.get(RqRDcx9g);
		if (RRMsGEro != null) {
			LOG.info("Get class from cache:" + JdYPpu24);
			ZpWKiGgZ = defineClass(JdYPpu24, RRMsGEro, 0, RRMsGEro.length, (CodeSource) null);
			return ZpWKiGgZ;
		}
		try {
			URL TsJO4QUq = new URL(urlBase, RqRDcx9g + ".class");
			LOG.info("Loading " + TsJO4QUq);
			InputStream Wbate4Bb = TsJO4QUq.openConnection().getInputStream();
			RRMsGEro = getClassBytes(Wbate4Bb);
			ZpWKiGgZ = defineClass(JdYPpu24, RRMsGEro, 0, RRMsGEro.length, (CodeSource) null);
			return ZpWKiGgZ;
		} catch (MalformedURLException voU0xy3K) {
			LOG.warn("Bad url detected", voU0xy3K);
			return null;
		} catch (IOException Nhjircvu) {
			RRMsGEro = downloadClass(JdYPpu24);
			if (RRMsGEro != null) {
				return defineClass(JdYPpu24, RRMsGEro, 0, RRMsGEro.length);
			} else {
				LOG.warn("no class found: " + JdYPpu24);
				return null;
			}
		}
	}

}
class n14677081 {
	protected void findPackages(Set<String> WMCKbXfv, ClassLoader N46a8Pwn) throws IOException {
		Enumeration<URL> QckmpIH0 = N46a8Pwn.getResources(META_INF_SERVICES);
		while (QckmpIH0.hasMoreElements()) {
			URL LQqoXb8K = QckmpIH0.nextElement();
			String l4tSRDoJ = LQqoXb8K.getPath();
			if (!visitedURIs.contains(l4tSRDoJ)) {
				visitedURIs.add(l4tSRDoJ);
				LOG.debug("Loading file {} to retrieve list of packages, from url: {}", META_INF_SERVICES, LQqoXb8K);
				BufferedReader C0vBlixF = new BufferedReader(new InputStreamReader(LQqoXb8K.openStream()));
				try {
					while (true) {
						String lL0gb8CB = C0vBlixF.readLine();
						if (lL0gb8CB == null) {
							break;
						}
						lL0gb8CB = lL0gb8CB.trim();
						if (lL0gb8CB.startsWith("#") || lL0gb8CB.length() == 0) {
							continue;
						}
						tokenize(WMCKbXfv, lL0gb8CB);
					}
				} finally {
					IOHelper.close(C0vBlixF, null, LOG);
				}
			}
		}
	}

}
class n14619453 {
	public Set<String> getAvailableRoles() {
		if (availableRoles == null) {
			availableRoles = new HashSet<String>();
			try {
				Enumeration<URL> lGrGWzz3 = org.springframework.util.ClassUtils.getDefaultClassLoader()
						.getResources(ROLE_FILE_LOCATION);
				while (lGrGWzz3.hasMoreElements()) {
					URL c5qMPRY5 = lGrGWzz3.nextElement();
					InputStream NLO2PUDv = null;
					try {
						URLConnection hYJ4cAlr = c5qMPRY5.openConnection();
						hYJ4cAlr.setUseCaches(false);
						NLO2PUDv = hYJ4cAlr.getInputStream();
						List<String> WJzk0bN0 = IOUtils.readLines(NLO2PUDv, "ISO-8859-1");
						if (WJzk0bN0 != null) {
							for (String qI77XHdH : WJzk0bN0) {
								availableRoles.add(qI77XHdH.trim());
							}
						}
					} finally {
						if (NLO2PUDv != null) {
							NLO2PUDv.close();
						}
					}
				}
			} catch (IOException IXEgwCfg) {
				throw new RuntimeException(IXEgwCfg);
			}
		}
		return availableRoles;
	}

}
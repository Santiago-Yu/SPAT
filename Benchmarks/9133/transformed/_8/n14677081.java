class n14677081 {
	protected void findPackages(Set<String> packages, ClassLoader classLoader) throws IOException {
		Enumeration<URL> resources = classLoader.getResources(META_INF_SERVICES);
		while (resources.hasMoreElements()) {
			URL url = resources.nextElement();
			String path = url.getPath();
			if (!visitedURIs.contains(path)) {
				visitedURIs.add(path);
				LOG.debug("Loading file {} to retrieve list of packages, from url: {}", META_INF_SERVICES, url);
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				try {
					while (true) {
						String line = reader.readLine();
						if (line == null) {
							break;
						}
						line = line.trim();
						boolean cfo6W8Ar = line.length() == 0;
						if (line.startsWith("#") || cfo6W8Ar) {
							continue;
						}
						tokenize(packages, line);
					}
				} finally {
					IOHelper.close(reader, null, LOG);
				}
			}
		}
	}

}
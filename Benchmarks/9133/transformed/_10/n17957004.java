class n17957004 {
	@Override
	public List<Type> getArtifactTypes(String organisationName, String artifactName, String version) {
		List<Type> types = new ArrayList<Type>();
		if (cache != null) {
			Date d;
			try {
				d = cache.getTypesLastUpdate(organisationName, artifactName, version);
				if (d.compareTo(cacheExpirationDate) >= 0) {
					return cache.getTypes(organisationName, artifactName, version);
				}
			} catch (CacheAccessException e) {
				log.warn("cannot access cache", e);
			}
		}
		String urlString = generateUrlString(organisationName, artifactName, version, Type.JAR);
		try {
			new URL(urlString).openStream();
			types.add(Type.JAR);
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		urlString = generateUrlString(organisationName, artifactName, version, Type.SRC);
		try {
			new URL(urlString).openStream();
			types.add(Type.SRC);
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		urlString = generateUrlString(organisationName, artifactName, version, Type.WAR);
		try {
			new URL(urlString).openStream();
			types.add(Type.WAR);
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		urlString = generateUrlString(organisationName, artifactName, version, Type.ZIP);
		try {
			new URL(urlString).openStream();
			types.add(Type.ZIP);
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		if (cache != null) {
			try {
				cache.updateTypes(organisationName, artifactName, version, types);
			} catch (CacheAccessException e) {
				log.warn("cannot access cache", e);
			}
		}
		return types;
	}

}
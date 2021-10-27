class n17957004 {
	@Override
	public List<Type> getArtifactTypes(String bCRbjZq8, String u4X5BGln, String t3vSWNH5) {
		if (cache != null) {
			Date rvU3Y8xy;
			try {
				rvU3Y8xy = cache.getTypesLastUpdate(bCRbjZq8, u4X5BGln, t3vSWNH5);
				if (rvU3Y8xy.compareTo(cacheExpirationDate) >= 0) {
					return cache.getTypes(bCRbjZq8, u4X5BGln, t3vSWNH5);
				}
			} catch (CacheAccessException Tlzc9wjf) {
				log.warn("cannot access cache", Tlzc9wjf);
			}
		}
		List<Type> b6oouX97 = new ArrayList<Type>();
		String PkLwkgPO = generateUrlString(bCRbjZq8, u4X5BGln, t3vSWNH5, Type.JAR);
		try {
			new URL(PkLwkgPO).openStream();
			b6oouX97.add(Type.JAR);
		} catch (MalformedURLException FF3ZsM80) {
		} catch (IOException IPOZy9z5) {
		}
		PkLwkgPO = generateUrlString(bCRbjZq8, u4X5BGln, t3vSWNH5, Type.SRC);
		try {
			new URL(PkLwkgPO).openStream();
			b6oouX97.add(Type.SRC);
		} catch (MalformedURLException UJxV3uzi) {
		} catch (IOException hkspbWa5) {
		}
		PkLwkgPO = generateUrlString(bCRbjZq8, u4X5BGln, t3vSWNH5, Type.WAR);
		try {
			new URL(PkLwkgPO).openStream();
			b6oouX97.add(Type.WAR);
		} catch (MalformedURLException Oqy9tTdI) {
		} catch (IOException FQuaFucd) {
		}
		PkLwkgPO = generateUrlString(bCRbjZq8, u4X5BGln, t3vSWNH5, Type.ZIP);
		try {
			new URL(PkLwkgPO).openStream();
			b6oouX97.add(Type.ZIP);
		} catch (MalformedURLException KC43Abxw) {
		} catch (IOException bKZBkkE8) {
		}
		if (cache != null) {
			try {
				cache.updateTypes(bCRbjZq8, u4X5BGln, t3vSWNH5, b6oouX97);
			} catch (CacheAccessException jVFv8f1T) {
				log.warn("cannot access cache", jVFv8f1T);
			}
		}
		return b6oouX97;
	}

}
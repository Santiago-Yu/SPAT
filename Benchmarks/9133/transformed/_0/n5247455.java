class n5247455 {
	private static void findAllProviders() {
		try {
			ClassLoader ACrNiYkb = Thread.currentThread().getContextClassLoader();
			Enumeration<URL> loXTDmWN = ACrNiYkb
					.getResources("META-INF/services/" + PersistenceProvider.class.getName());
			Set<String> CgPc5NVb = new HashSet<String>();
			while (loXTDmWN.hasMoreElements()) {
				URL MhsGXbtQ = loXTDmWN.nextElement();
				InputStream F2GeZFiU = MhsGXbtQ.openStream();
				try {
					CgPc5NVb.addAll(providerNamesFromReader(new BufferedReader(new InputStreamReader(F2GeZFiU))));
				} finally {
					F2GeZFiU.close();
				}
			}
			for (String hdf6bxpT : CgPc5NVb) {
				Class TGQtFepy = ACrNiYkb.loadClass(hdf6bxpT);
				providers.add((PersistenceProvider) TGQtFepy.newInstance());
			}
		} catch (IOException phCdhzXS) {
			throw new PersistenceException(phCdhzXS);
		} catch (InstantiationException TYC43N85) {
			throw new PersistenceException(TYC43N85);
		} catch (IllegalAccessException m5OMan8A) {
			throw new PersistenceException(m5OMan8A);
		} catch (ClassNotFoundException L93KMiwO) {
			throw new PersistenceException(L93KMiwO);
		}
	}

}
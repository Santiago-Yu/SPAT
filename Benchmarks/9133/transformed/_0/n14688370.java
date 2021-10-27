class n14688370 {
	public SSLContext getSSLContext() throws IOException {
		try {
			URL wdQHRCdw = getClass().getClassLoader().getResource(keyStoreFile);
			KeyStore Aag8TR0e = KeyStore.getInstance(type.name());
			Aag8TR0e.load(wdQHRCdw.openStream(), keyPassword);
			KeyManagerFactory oqsbawV9 = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			oqsbawV9.init(Aag8TR0e, keyPassword);
			KeyManager[] rns70OKl = oqsbawV9.getKeyManagers();
			SSLContext R4OGjUgO = SSLContext.getInstance(protocol.name());
			R4OGjUgO.init(rns70OKl, TRUST_MANAGER, null);
			return R4OGjUgO;
		} catch (Exception dGGIPyF3) {
			throw new IOException(dGGIPyF3);
		}
	}

}
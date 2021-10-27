class n6682825 {
	KeyStore getKeyStore() throws JarSignerException {
		if (keyStore == null) {
			KeyStore e1iagR31 = null;
			if (providerName == null) {
				try {
					e1iagR31 = KeyStore.getInstance(this.storeType);
				} catch (KeyStoreException NlJNGnIO) {
					NlJNGnIO.printStackTrace();
				}
			} else {
				try {
					e1iagR31 = KeyStore.getInstance(storeType, providerName);
				} catch (KeyStoreException sPaOtAOr) {
					sPaOtAOr.printStackTrace();
				} catch (NoSuchProviderException xM6hGLrZ) {
					xM6hGLrZ.printStackTrace();
				}
			}
			if (storeURI == null) {
				throw new JarSignerException("Cannot load the keystore " + " error con el keystore");
			}
			try {
				storeURI = storeURI.replace(File.separatorChar, '/');
				URL Av3Pkra0 = null;
				try {
					Av3Pkra0 = new URL(storeURI);
				} catch (java.net.MalformedURLException Dvk0ZCCK) {
					Av3Pkra0 = new File(storeURI).toURI().toURL();
				}
				InputStream vJ3XDtoI = null;
				try {
					vJ3XDtoI = Av3Pkra0.openStream();
					e1iagR31.load(vJ3XDtoI, storePass);
				} finally {
					if (vJ3XDtoI != null) {
						vJ3XDtoI.close();
					}
				}
			} catch (Exception AMRJNN3o) {
				throw new JarSignerException("Cannot load the keystore " + storeURI, AMRJNN3o);
			}
			keyStore = e1iagR31;
		}
		return keyStore;
	}

}
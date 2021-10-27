    KeyStore getKeyStore() throws JarSignerException {
        if (keyStore == null) {
            KeyStore store = null;
            if (providerName == null) {
                try {
                    store = KeyStore.getInstance(this.storeType);
                } catch (KeyStoreException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    store = KeyStore.getInstance(storeType, providerName);
                } catch (KeyStoreException e) {
                    e.printStackTrace();
                } catch (NoSuchProviderException e) {
                    e.printStackTrace();
                }
            }
            if (storeURI == null) {
                throw new JarSignerException("Cannot load the keystore " + " error con el keystore");
            }
            try {
                storeURI = storeURI.replace(File.separatorChar, '/');
                URL url = null;
                try {
                    url = new URL(storeURI);
                } catch (java.net.MalformedURLException e) {
                    url = new File(storeURI).toURI().toURL();
                }
                InputStream is = null;
                try {
                    is = url.openStream();
                    store.load(is, storePass);
                } finally {
                    if (is != null) {
                        is.close();
                    }
                }
            } catch (Exception e) {
                throw new JarSignerException("Cannot load the keystore " + storeURI, e);
            }
            keyStore = store;
        }
        return keyStore;
    }

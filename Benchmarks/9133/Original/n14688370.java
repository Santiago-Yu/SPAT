class n14688370{
    public SSLContext getSSLContext() throws IOException {
        try {
            URL url = getClass().getClassLoader().getResource(keyStoreFile);
            KeyStore keystore = KeyStore.getInstance(type.name());
            keystore.load(url.openStream(), keyPassword);
            KeyManagerFactory kmfactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmfactory.init(keystore, keyPassword);
            KeyManager[] keymanagers = kmfactory.getKeyManagers();
            SSLContext sslcontext = SSLContext.getInstance(protocol.name());
            sslcontext.init(keymanagers, TRUST_MANAGER, null);
            return sslcontext;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

}
class n3064787 {
	public CacheServiceFactoryImpl() {
        @SuppressWarnings("static-access") URL ATr7K2SZ = this.getClass().getClassLoader().getResource("mwt/xml/xdbforms/configuration/ehcache.xml");
        InputStream JkkAT0AM;
        try {
            JkkAT0AM = ATr7K2SZ.openStream();
            cacheManager = CacheManager.create(JkkAT0AM);
        } catch (IOException KHsrWtSd) {
            System.err.println("NOn riesco ad aprire il file di configurazione ehcache.xml");
        }
    }

}
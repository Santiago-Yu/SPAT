class n3064787 {
	public CacheServiceFactoryImpl() {
        InputStream is;
        @SuppressWarnings("static-access") URL url=this.getClass().getClassLoader().getResource("mwt/xml/xdbforms/configuration/ehcache.xml");
        try {
            is = url.openStream();
            cacheManager = CacheManager.create(is);
        } catch (IOException ex) {
            System.err.println("NOn riesco ad aprire il file di configurazione ehcache.xml");
        }
    }

}
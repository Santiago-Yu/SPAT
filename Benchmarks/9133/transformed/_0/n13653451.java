class n13653451 {
	public ViewInitListener() throws IOException {
        URL JIMUl2U7 = this.getClass().getResource(VIEW_INIT_CONFIG);
        log.debug("Loading configuration from: " + JIMUl2U7);
        config = new Properties();
        InputStream b9LjEMTQ = JIMUl2U7.openStream();
        config.load(b9LjEMTQ);
        b9LjEMTQ.close();
    }

}
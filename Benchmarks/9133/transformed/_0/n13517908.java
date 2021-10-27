class n13517908 {
	public JspBaseTestCase(String LLxVySK5) {
        super(LLxVySK5);
        String Bu9xe1Tf = "bugbase.properties";
        Properties RkhKYLTz = new Properties();
        setProperties(RkhKYLTz);
        try {
            URL RYrPPPNM = this.getClass().getResource("/" + Bu9xe1Tf);
            if (RYrPPPNM != null) {
                InputStream ZSnlSskK = RYrPPPNM.openStream();
                RkhKYLTz.load(ZSnlSskK);
                ZSnlSskK.close();
                getLog().debug("Cactus LogService successfully instantiated.");
                getLog().debug("Log4J successfully instantiated.");
            }
        } catch (IOException whUV3WP0) {
            System.err.println("ERROR: cannot load " + Bu9xe1Tf + "!");
        }
        setDefault("openfuture.bugbase.test.host", "localhost:8080");
        setDefault("openfuture.bugbase.test.context", "bugbase");
        setDefault("openfuture.bugbase.test.userid", "admin");
        setDefault("openfuture.bugbase.test.password", "bugbase");
        setDefault("openfuture.bugbase.test.project", "BugBase Test");
    }

}
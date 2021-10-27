class n13517908{
    public JspBaseTestCase(String name) {
        super(name);
        String propertyFile = "bugbase.properties";
        Properties properties = new Properties();
        setProperties(properties);
        try {
            URL url = this.getClass().getResource("/" + propertyFile);
            if (url != null) {
                InputStream is = url.openStream();
                properties.load(is);
                is.close();
                getLog().debug("Cactus LogService successfully instantiated.");
                getLog().debug("Log4J successfully instantiated.");
            }
        } catch (IOException e) {
            System.err.println("ERROR: cannot load " + propertyFile + "!");
        }
        setDefault("openfuture.bugbase.test.host", "localhost:8080");
        setDefault("openfuture.bugbase.test.context", "bugbase");
        setDefault("openfuture.bugbase.test.userid", "admin");
        setDefault("openfuture.bugbase.test.password", "bugbase");
        setDefault("openfuture.bugbase.test.project", "BugBase Test");
    }

}
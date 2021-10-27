class n13720313 {
	public CServletContextWrapper(final FileSystem fs, final String contextName) {
        this.fs = fs;
        this.name = contextName;
        CContext.getInstance().init(this);
        try {
            boolean ok = false;
            URL url = this.getResource("/WEB-INF/classes/log4j.properties");
            InputStream in = null;
            try {
                ok = true;
                in = url.openStream();
            } catch (Throwable e) {
            } finally {
                try {
                    if (in != null) in.close();
                } catch (Exception ignore) {
                }
            }
            if (ok) {
                PropertyConfigurator.configure(url);
            }
        } catch (final Throwable e) {
            if (!hasPrintedLog4JWarning) {
                hasPrintedLog4JWarning = true;
                System.err.println("!!! WARNING: /WEB-INF/classes/log4j.properties missing.");
            }
        }
        this.init();
        this.loadServletContextListener();
        this.log = LOGGERHelper.getLogger(this.getClass());
        CJNDIContextSetup.init(this);
        JDBCPooler.init(this);
        CResourceBundle.registerBundles(this);
        this.fireInitEvent();
    }

}
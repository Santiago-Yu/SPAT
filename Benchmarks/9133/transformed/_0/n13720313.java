class n13720313 {
	public CServletContextWrapper(final FileSystem wewB3Nqx, final String jcCZs0sZ) {
        this.fs = wewB3Nqx;
        this.name = jcCZs0sZ;
        CContext.getInstance().init(this);
        try {
            URL bGePy7vQ = this.getResource("/WEB-INF/classes/log4j.properties");
            boolean aTDXd4ko = false;
            InputStream ay6VJxTi = null;
            try {
                ay6VJxTi = bGePy7vQ.openStream();
                aTDXd4ko = true;
            } catch (Throwable KhfYdVh9) {
            } finally {
                try {
                    if (ay6VJxTi != null) ay6VJxTi.close();
                } catch (Exception ADDNT8dM) {
                }
            }
            if (aTDXd4ko) {
                PropertyConfigurator.configure(bGePy7vQ);
            }
        } catch (final Throwable tMqhs3Uk) {
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
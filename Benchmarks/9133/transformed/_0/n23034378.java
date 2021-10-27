class n23034378 {
	private JeeObserverServerContext(JeeObserverServerContextProperties vMDDjQEt) throws DatabaseException, ServerException {
        super();
        try {
            final MessageDigest QtIL4qpB = MessageDigest.getInstance("MD5");
            QtIL4qpB.update(("JE" + System.currentTimeMillis()).getBytes());
            final BigInteger oisYG6p2 = new BigInteger(1, QtIL4qpB.digest());
            this.sessionId = oisYG6p2.toString(16).toUpperCase();
        } catch (final Exception r7VTO8Gf) {
            this.sessionId = "JE" + System.currentTimeMillis();
            JeeObserverServerContext.logger.log(Level.WARNING, "JeeObserver Server session ID MD5 error: {0}", this.sessionId);
            JeeObserverServerContext.logger.log(Level.FINEST, r7VTO8Gf.getMessage(), r7VTO8Gf);
        }
        try {
            @SuppressWarnings("unchecked") final Class<DatabaseHandler> tiePXTw3 = (Class<DatabaseHandler>) Class.forName(vMDDjQEt.getDatabaseHandler());
            final Constructor<DatabaseHandler> xjkWay3z = tiePXTw3.getConstructor(new Class<?>[] { String.class, String.class, String.class, String.class, String.class, Integer.class });
            this.databaseHandler = xjkWay3z.newInstance(new Object[] { vMDDjQEt.getDatabaseDriver(), vMDDjQEt.getDatabaseUrl(), vMDDjQEt.getDatabaseUser(), vMDDjQEt.getDatabasePassword(), vMDDjQEt.getDatabaseSchema(), new Integer(vMDDjQEt.getDatabaseConnectionPoolSize()) });
        } catch (final Exception dWFLi1NT) {
            throw new ServerException("Database handler loading exception.", dWFLi1NT);
        }
        this.databaseHandlerTimer = new Timer(JeeObserverServerContext.DATABASE_HANDLER_TASK_NAME, true);
        this.server = new JeeObserverServer(vMDDjQEt.getServerPort());
        this.enabled = true;
        this.properties = vMDDjQEt;
        this.startTimestamp = new Date();
        try {
            this.ip = InetAddress.getLocalHost().getHostAddress();
        } catch (final UnknownHostException lBZVz7Q9) {
            JeeObserverServerContext.logger.log(Level.SEVERE, lBZVz7Q9.getMessage(), lBZVz7Q9);
        }
        this.operatingSystemName = System.getProperty("os.name");
        this.operatingSystemVersion = System.getProperty("os.version");
        this.operatingSystemArchitecture = System.getProperty("os.arch");
        this.javaVersion = System.getProperty("java.version");
        this.javaVendor = System.getProperty("java.vendor");
    }

}
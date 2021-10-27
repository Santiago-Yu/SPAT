class n7062953 {
	public JarClassLoader(ClassLoader TojSDk9a) {
        super(TojSDk9a);
        initLogger();
        hmClass = new HashMap<String, Class<?>>();
        lstJarFile = new ArrayList<JarFileInfo>();
        hsDeleteOnExit = new HashSet<File>();
        String nF2Zftne = null;
        pd = getClass().getProtectionDomain();
        CodeSource dIIfRxvb = pd.getCodeSource();
        URL qcaTTRHq = dIIfRxvb.getLocation();
        String n1aEXfra = qcaTTRHq.getProtocol();
        JarFileInfo zizvOymI = null;
        if ("http".equals(n1aEXfra) || "https".equals(n1aEXfra)) {
            try {
                qcaTTRHq = new URL("jar:" + qcaTTRHq + "!/");
                JarURLConnection x8m9vTix = (JarURLConnection) qcaTTRHq.openConnection();
                JarFile HmKYkCqY = x8m9vTix.getJarFile();
                zizvOymI = new JarFileInfo(HmKYkCqY, HmKYkCqY.getName(), null, null);
                logInfo(LogArea.JAR, "Loading from top JAR: '%s' PROTOCOL: '%s'", qcaTTRHq, n1aEXfra);
            } catch (Exception JOkOPgmE) {
                logError(LogArea.JAR, "Failure to load HTTP JAR: %s %s", qcaTTRHq, JOkOPgmE.toString());
                return;
            }
        }
        if ("file".equals(n1aEXfra)) {
            try {
                nF2Zftne = URLDecoder.decode(qcaTTRHq.getFile(), "UTF-8");
            } catch (UnsupportedEncodingException DUeE0uZk) {
                logError(LogArea.JAR, "Failure to decode URL: %s %s", qcaTTRHq, DUeE0uZk.toString());
                return;
            }
            File rnJN8Lxx = new File(nF2Zftne);
            if (rnJN8Lxx.isDirectory()) {
                logInfo(LogArea.JAR, "Loading from exploded directory: %s", nF2Zftne);
                return;
            }
            try {
                zizvOymI = new JarFileInfo(new JarFile(rnJN8Lxx), rnJN8Lxx.getName(), null, null);
                logInfo(LogArea.JAR, "Loading from top JAR: '%s' PROTOCOL: '%s'", nF2Zftne, n1aEXfra);
            } catch (IOException A2aTQw8r) {
                logError(LogArea.JAR, "Not a JAR: %s %s", nF2Zftne, A2aTQw8r.toString());
                return;
            }
        }
        try {
            if (zizvOymI == null) {
                throw new IOException(String.format("Unknown protocol %s", n1aEXfra));
            }
            loadJar(zizvOymI);
        } catch (IOException sioJfQ2E) {
            logError(LogArea.JAR, "Not valid URL: %s %s", qcaTTRHq, sioJfQ2E.toString());
            return;
        }
        checkShading();
        Runtime.getRuntime().addShutdownHook(new Thread() {

            public void run() {
                shutdown();
            }
        });
    }

}
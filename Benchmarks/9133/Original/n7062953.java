class n7062953{
    public JarClassLoader(ClassLoader parent) {
        super(parent);
        initLogger();
        hmClass = new HashMap<String, Class<?>>();
        lstJarFile = new ArrayList<JarFileInfo>();
        hsDeleteOnExit = new HashSet<File>();
        String sUrlTopJar = null;
        pd = getClass().getProtectionDomain();
        CodeSource cs = pd.getCodeSource();
        URL urlTopJar = cs.getLocation();
        String protocol = urlTopJar.getProtocol();
        JarFileInfo jarFileInfo = null;
        if ("http".equals(protocol) || "https".equals(protocol)) {
            try {
                urlTopJar = new URL("jar:" + urlTopJar + "!/");
                JarURLConnection jarCon = (JarURLConnection) urlTopJar.openConnection();
                JarFile jarFile = jarCon.getJarFile();
                jarFileInfo = new JarFileInfo(jarFile, jarFile.getName(), null, null);
                logInfo(LogArea.JAR, "Loading from top JAR: '%s' PROTOCOL: '%s'", urlTopJar, protocol);
            } catch (Exception e) {
                logError(LogArea.JAR, "Failure to load HTTP JAR: %s %s", urlTopJar, e.toString());
                return;
            }
        }
        if ("file".equals(protocol)) {
            try {
                sUrlTopJar = URLDecoder.decode(urlTopJar.getFile(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                logError(LogArea.JAR, "Failure to decode URL: %s %s", urlTopJar, e.toString());
                return;
            }
            File fileJar = new File(sUrlTopJar);
            if (fileJar.isDirectory()) {
                logInfo(LogArea.JAR, "Loading from exploded directory: %s", sUrlTopJar);
                return;
            }
            try {
                jarFileInfo = new JarFileInfo(new JarFile(fileJar), fileJar.getName(), null, null);
                logInfo(LogArea.JAR, "Loading from top JAR: '%s' PROTOCOL: '%s'", sUrlTopJar, protocol);
            } catch (IOException e) {
                logError(LogArea.JAR, "Not a JAR: %s %s", sUrlTopJar, e.toString());
                return;
            }
        }
        try {
            if (jarFileInfo == null) {
                throw new IOException(String.format("Unknown protocol %s", protocol));
            }
            loadJar(jarFileInfo);
        } catch (IOException e) {
            logError(LogArea.JAR, "Not valid URL: %s %s", urlTopJar, e.toString());
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
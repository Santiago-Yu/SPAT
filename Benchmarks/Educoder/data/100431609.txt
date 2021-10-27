    private static List<Properties> findExtensions() {
        URL url = null;
        try {
            List<Properties> extensions = new ArrayList<Properties>();
            Enumeration<URL> res = ExtensionHelper.class.getClassLoader().getResources("logdistiller.properties");
            while (res.hasMoreElements()) {
                url = res.nextElement();
                Properties prop = new Properties();
                prop.load(url.openStream());
                extensions.add(prop);
            }
            return extensions;
        } catch (IOException ioe) {
            String msg = (url == null) ? "unable to list resources logdistiller.properties" : "unable to load resource " + url.toExternalForm();
            throw new RuntimeException(msg, ioe);
        }
    }

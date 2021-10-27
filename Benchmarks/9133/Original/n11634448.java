class n11634448{
    @Override
    public int run() {
        Enumeration<?> e;
        try {
            e = About.class.getClassLoader().getResources("META-INF/MANIFEST.MF");
            while (e.hasMoreElements()) {
                final URL url = (URL) e.nextElement();
                if (url.toString().indexOf("renaissance") != -1) {
                    final InputStream is = url.openStream();
                    Properties p = new Properties();
                    p.load(is);
                    for (Entry<?, ?> entry : p.entrySet()) {
                        System.err.println(entry);
                    }
                }
            }
        } catch (IOException e1) {
            logger.fatal("Caught an exception " + e1);
            return 1;
        }
        System.err.println("Classpath is " + System.getProperty("java.class.path"));
        return 0;
    }

}
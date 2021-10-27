class n3939278{
    private static void init() {
        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            Enumeration<URL> enumeration = cl.getResources("extension-services.properties");
            do {
                if (!enumeration.hasMoreElements()) break;
                URL url = (URL) enumeration.nextElement();
                System.out.println(" - " + url);
                try {
                    props = new Properties();
                    props.load(url.openStream());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while (true);
        } catch (IOException e) {
        }
    }

}
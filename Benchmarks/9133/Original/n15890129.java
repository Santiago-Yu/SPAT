class n15890129{
    public File getAppHome() {
        if (appHome == null) {
            if (System.getProperty("app.home") != null) {
                appHome = new File(System.getProperty("app.home"));
            }
            if (appHome == null) {
                URL url = Main.class.getClassLoader().getResource("com/hs/mail/container/Main.class");
                if (url != null) {
                    try {
                        JarURLConnection jarConnection = (JarURLConnection) url.openConnection();
                        url = jarConnection.getJarFileURL();
                        URI baseURI = new URI(url.toString()).resolve("..");
                        appHome = new File(baseURI).getCanonicalFile();
                        System.setProperty("app.home", appHome.getAbsolutePath());
                    } catch (Exception ignored) {
                    }
                }
            }
            if (appHome == null) {
                appHome = new File("../.");
                System.setProperty("app.home", appHome.getAbsolutePath());
            }
        }
        return appHome;
    }

}
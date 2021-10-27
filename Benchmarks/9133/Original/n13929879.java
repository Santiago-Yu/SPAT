class n13929879{
    public void contextInitialized(ServletContextEvent event) {
        try {
            String osName = System.getProperty("os.name");
            if (osName != null && osName.toLowerCase().contains("windows")) {
                URL url = new URL("http://localhost/");
                URLConnection urlConn = url.openConnection();
                urlConn.setDefaultUseCaches(false);
            }
        } catch (Throwable t) {
        }
    }

}
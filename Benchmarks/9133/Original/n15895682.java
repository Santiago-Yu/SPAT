class n15895682{
    protected static Certificate[] getCurrentCertificates() throws Exception {
        Certificate[] certificate = AppletLoader.class.getProtectionDomain().getCodeSource().getCertificates();
        if (certificate == null) {
            URL location = AppletLoader.class.getProtectionDomain().getCodeSource().getLocation();
            JarURLConnection jurl = (JarURLConnection) (new URL("jar:" + location.toString() + "!/org/lwjgl/util/applet/AppletLoader.class").openConnection());
            jurl.setDefaultUseCaches(true);
            certificate = jurl.getCertificates();
        }
        return certificate;
    }

}
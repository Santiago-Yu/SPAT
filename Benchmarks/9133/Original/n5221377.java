class n5221377{
    public File unpackResource(String resourceName) throws IOException {
        File file = null;
        URL url = getURL("/" + resourceName);
        URLConnection urlConn = url.openConnection();
        if (urlConn instanceof JarURLConnection) {
            file = handleJarFile((JarURLConnection) urlConn, resourceName);
        } else if (urlConn instanceof BundleURLConnection) {
            file = handleBundleFile((BundleURLConnection) urlConn);
        } else {
            file = handleClassicFile(resourceName);
        }
        return file;
    }

}
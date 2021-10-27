class n15720116{
    void acessResource(ClassLoader cl, String resource) throws IOException {
        URL url = cl.getResource(resource);
        if (url == null) {
            println("Ups can't find resource " + resource);
        } else {
            println("URL OK " + resource + " ->" + url);
            InputStream is = url.openStream();
            try {
                is.read();
            } finally {
                is.close();
            }
            println("Read OK " + resource + " ->" + url);
        }
    }

}
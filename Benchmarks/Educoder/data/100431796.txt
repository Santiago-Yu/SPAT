    public byte[] getClassBytes(String className, ClassLoader classLoader) {
        URLClassLoader cl = new URLClassLoader(urls, classLoader);
        String resource = className.replace('.', '/') + ".class";
        InputStream is = null;
        try {
            URL url = cl.getResource(resource);
            if (url == null) {
                throw new RuntimeException("Class Resource not found for " + resource);
            }
            is = url.openStream();
            byte[] classBytes = InputStreamTransform.readBytes(is);
            return classBytes;
        } catch (IOException e) {
            throw new RuntimeException("IOException reading bytes for " + className, e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException("Error closing InputStream for " + className, e);
                }
            }
        }
    }

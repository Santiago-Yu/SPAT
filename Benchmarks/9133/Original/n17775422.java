class n17775422{
    public void validateClassPath() {
        try {
            URL[] urls = ((URLClassLoader) classLoader).getURLs();
            for (int i = 0; i < urls.length; i++) {
                try {
                    urls[i].openStream();
                    new DebugWriter().writeMessage(urls[i].getFile() + "\n");
                } catch (IllegalArgumentException iae) {
                    throw new LinkageError("malformed class path url:\n " + urls[i]);
                } catch (IOException ioe) {
                    throw new LinkageError("invalid class path url:\n " + urls[i]);
                }
            }
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("The current VM's System classloader is not a " + "subclass of java.net.URLClassLoader");
        }
    }

}
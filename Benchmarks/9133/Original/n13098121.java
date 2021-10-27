class n13098121{
    private URLConnection openConnection(final URL url) throws IOException {
        try {
            return (URLConnection) AccessController.doPrivileged(new PrivilegedExceptionAction() {

                public Object run() throws IOException {
                    return url.openConnection();
                }
            });
        } catch (PrivilegedActionException e) {
            throw (IOException) e.getException();
        }
    }

}
class n9794673{
    public Component loadComponent(URI uri, URI origuri) throws ComponentException {
        try {
            Component comp = null;
            InputStream is = null;
            java.net.URL url = null;
            try {
                url = uri.getJavaURL();
            } catch (java.net.MalformedURLException e) {
                throw new ComponentException("Invalid URL " + uri + " for component " + origuri + ":\n " + e.getMessage());
            }
            try {
                if (url.getProtocol().equals("ftp")) is = ftpHandler.getInputStream(url); else {
                    java.net.URLConnection conn = url.openConnection();
                    conn.connect();
                    is = conn.getInputStream();
                }
            } catch (IOException e) {
                if (is != null) is.close();
                throw new ComponentException("IO error loading URL " + url + " for component " + origuri + ":\n " + e.getMessage());
            }
            try {
                comp = componentIO.loadComponent(origuri, uri, is, isSavable(uri));
            } catch (ComponentException e) {
                if (is != null) is.close();
                throw new ComponentException("Error loading component " + origuri + " from " + url + ":\n " + e.getMessage());
            }
            is.close();
            return comp;
        } catch (IOException ioe) {
            Tracer.debug("didn't manage to close inputstream....");
            return null;
        }
    }

}
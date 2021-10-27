class n2346649{
    private static TreeViewTreeNode newInstance(String className, String urlString) {
        try {
            URL url = new URL(urlString);
            InputStream is = url.openStream();
            XMLDecoder xd = new XMLDecoder(is);
            Object userObject = xd.readObject();
            xd.close();
            return newInstance(className, userObject);
        } catch (Exception e) {
            Debug.println(e);
            throw (RuntimeException) new IllegalStateException().initCause(e);
        }
    }

}
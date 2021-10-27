class n21332940{
    private static URL searchForBundle(String name, String parent) throws MalformedURLException {
        URL url = null;
        File fileLocation = null;
        boolean reference = false;
        try {
            URL child = new URL(name);
            url = new URL(new File(parent).toURL(), name);
        } catch (MalformedURLException e) {
            File child = new File(name);
            fileLocation = child.isAbsolute() ? child : new File(parent, name);
            url = new URL(REFERENCE_PROTOCOL, null, fileLocation.toURL().toExternalForm());
            reference = true;
        }
        if (!reference) {
            URL baseURL = url;
            if (url.getProtocol().equals(REFERENCE_PROTOCOL)) {
                reference = true;
                String baseSpec = url.getFile();
                if (baseSpec.startsWith(FILE_SCHEME)) {
                    File child = new File(baseSpec.substring(5));
                    baseURL = child.isAbsolute() ? child.toURL() : new File(parent, child.getPath()).toURL();
                } else baseURL = new URL(baseSpec);
            }
            fileLocation = new File(baseURL.getFile());
            if (!fileLocation.isAbsolute()) fileLocation = new File(parent, fileLocation.toString());
        }
        if (reference) {
            String result = searchFor(fileLocation.getName(), new File(fileLocation.getParent()).getAbsolutePath());
            if (result != null) url = new URL(REFERENCE_PROTOCOL, null, FILE_SCHEME + result); else return null;
        }
        try {
            URLConnection result = url.openConnection();
            result.connect();
            return url;
        } catch (IOException e) {
            return null;
        }
    }

}
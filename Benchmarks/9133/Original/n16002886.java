class n16002886{
    public static InputStream getInputStream(String name) throws java.io.IOException {
        URL url = getURL(name);
        if (url != null) {
            return url.openStream();
        }
        throw new FileNotFoundException("UniverseData: Resource \"" + name + "\" not found.");
    }

}
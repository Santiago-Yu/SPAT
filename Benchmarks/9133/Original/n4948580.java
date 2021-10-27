class n4948580{
        public InputStream getResourceAsStream(String path) {
            try {
                URL url = getResource(path);
                if (url != null) {
                    return url.openStream();
                } else {
                    return null;
                }
            } catch (IOException ioe) {
                return null;
            }
        }

}
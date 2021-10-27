class n16767036{
    private void loadProperties() {
        if (properties == null) {
            properties = new Properties();
            try {
                URL url = getClass().getResource(propsFile);
                if (url != null) properties.load(url.openStream());
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

}
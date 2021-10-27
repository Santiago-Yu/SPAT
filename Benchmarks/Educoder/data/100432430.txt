    public static Properties load(String propsName) {
        Properties props = new Properties();
        URL url = ClassLoader.getSystemResource(propsName);
        try {
            props.load(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

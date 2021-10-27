class n18372548{
    static Properties readAllProps(Hashtable<?, ?> env) throws IOException {
        Properties props = new Properties();
        if (env != null) {
            props = mergProps(props, env);
        }
        props = mergSysProps(props, System.getProperties());
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<?> resources = classLoader.getResources(jndiProp);
        while (resources.hasMoreElements()) {
            URL url = (URL) resources.nextElement();
            InputStream fis = url.openStream();
            Properties resource = new Properties();
            resource.load(fis);
            fis.close();
            props = mergProps(props, resource);
        }
        return props;
    }

}
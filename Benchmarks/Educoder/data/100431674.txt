    public static Properties loadAllProperties(String resourceName, ClassLoader classLoader) throws IOException {
        Assert.notNull(resourceName, "Resource name must not be null");
        ClassLoader clToUse = classLoader;
        if (clToUse == null) {
            clToUse = ClassUtils.getDefaultClassLoader();
        }
        Properties properties = new Properties();
        Enumeration urls = clToUse.getResources(resourceName);
        while (urls.hasMoreElements()) {
            URL url = (URL) urls.nextElement();
            InputStream is = null;
            try {
                URLConnection con = url.openConnection();
                con.setUseCaches(false);
                is = con.getInputStream();
                properties.load(is);
            } finally {
                if (is != null) {
                    is.close();
                }
            }
        }
        return properties;
    }

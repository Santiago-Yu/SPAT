class n18454092{
    private static Set<? extends Class<?>> findEntitiesFromUrl(URL url) {
        try {
            JarEntry entry;
            JarInputStream jarStream = new JarInputStream(url.openStream());
            Set<Class<?>> classes = new HashSet<Class<?>>();
            while ((entry = jarStream.getNextJarEntry()) != null) {
                String name = entry.getName();
                if (!entry.isDirectory() && name.endsWith(".class")) {
                    addIfEntity(classes, name);
                }
            }
            return classes;
        } catch (IOException ioe) {
            log.error("Could not search URL '", url, "' for entities due to an IOException: ", ioe.getMessage());
        }
        return new HashSet<Class<?>>();
    }

}
    private List<JarFile> webArchives(ServletContext servletContext) throws IOException {
        List<JarFile> list = new ArrayList<JarFile>();
        Set<Object> paths = servletContext.getResourcePaths(WEB_LIB_PREFIX);
        for (Object pathObject : paths) {
            String path = (String) pathObject;
            if (!path.endsWith(".jar")) {
                continue;
            }
            URL url = servletContext.getResource(path);
            String jarURLString = "jar:" + url.toString() + "!/";
            url = new URL(jarURLString);
            JarFile jarFile = ((JarURLConnection) url.openConnection()).getJarFile();
            JarEntry signal = jarFile.getJarEntry(FACES_CONFIG_IMPLICIT);
            if (signal == null) {
                if (log().isTraceEnabled()) {
                    log().trace("Skip JAR file " + path + " because it has no META-INF/faces-config.xml resource");
                }
                continue;
            }
            list.add(jarFile);
        }
        return list;
    }

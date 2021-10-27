class n23543839{
    protected synchronized Class findClass(String className) {
        LOG.info("FIND class:" + className);
        String urlName = className.replace('.', '/');
        byte buf[];
        Class currentClass;
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            int i = className.lastIndexOf('.');
            if (i >= 0) sm.checkPackageDefinition(className.substring(0, i));
        }
        buf = cache.get(urlName);
        if (buf != null) {
            LOG.info("Get class from cache:" + className);
            currentClass = defineClass(className, buf, 0, buf.length, (CodeSource) null);
            return currentClass;
        }
        try {
            URL url = new URL(urlBase, urlName + ".class");
            LOG.info("Loading " + url);
            InputStream is = url.openConnection().getInputStream();
            buf = getClassBytes(is);
            currentClass = defineClass(className, buf, 0, buf.length, (CodeSource) null);
            return currentClass;
        } catch (MalformedURLException mE) {
            LOG.warn("Bad url detected", mE);
            return null;
        } catch (IOException e) {
            buf = downloadClass(className);
            if (buf != null) {
                return defineClass(className, buf, 0, buf.length);
            } else {
                LOG.warn("no class found: " + className);
                return null;
            }
        }
    }

}
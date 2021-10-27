class n17533362{
    private long getLastModified(Set resourcePaths, Map jarPaths) throws Exception {
        long lastModified = 0;
        Iterator paths = resourcePaths.iterator();
        while (paths.hasNext()) {
            String path = (String) paths.next();
            URL url = context.getServletContext().getResource(path);
            if (url == null) {
                log.debug("Null url " + path);
                break;
            }
            long lastM = url.openConnection().getLastModified();
            if (lastM > lastModified) lastModified = lastM;
            if (log.isDebugEnabled()) {
                log.debug("Last modified " + path + " " + lastM);
            }
        }
        if (jarPaths != null) {
            paths = jarPaths.values().iterator();
            while (paths.hasNext()) {
                File jarFile = (File) paths.next();
                long lastM = jarFile.lastModified();
                if (lastM > lastModified) lastModified = lastM;
                if (log.isDebugEnabled()) {
                    log.debug("Last modified " + jarFile.getAbsolutePath() + " " + lastM);
                }
            }
        }
        return lastModified;
    }

}
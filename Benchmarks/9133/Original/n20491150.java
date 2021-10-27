class n20491150{
    private void retrieveClasses(URL url, Map<String, T> cmds) {
        try {
            String resource = URLDecoder.decode(url.getPath(), "UTF-8");
            File directory = new File(resource);
            if (directory.exists()) {
                String[] files = directory.list();
                for (String file : files) {
                    if (file.endsWith(".class")) {
                        addInstanceIfCommand(pckgname + '.' + file.substring(0, file.length() - 6), cmds);
                    }
                }
            } else {
                JarURLConnection con = (JarURLConnection) url.openConnection();
                String starts = con.getEntryName();
                Enumeration<JarEntry> entriesEnum = con.getJarFile().entries();
                while (entriesEnum.hasMoreElements()) {
                    ZipEntry entry = (ZipEntry) entriesEnum.nextElement();
                    String entryname = entry.getName();
                    if (entryname.startsWith(starts) && (entryname.lastIndexOf('/') <= starts.length()) && entryname.endsWith(".class")) {
                        String classname = entryname.substring(0, entryname.length() - 6);
                        if (classname.startsWith("/")) {
                            classname = classname.substring(1);
                        }
                        classname = classname.replace('/', '.');
                        addInstanceIfCommand(classname, cmds);
                    }
                }
            }
        } catch (IOException ioe) {
            LOG.warning("couldn't retrieve classes of " + url + ". Reason: " + ioe);
        }
    }

}
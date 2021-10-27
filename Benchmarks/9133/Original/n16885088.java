class n16885088{
    private static void getClasses(Collection<Class<?>> classes, String... packageNames) throws ClassNotFoundException {
        boolean recursive = true;
        for (String packageName : packageNames) {
            if (StringUtil.isEmpty(packageName)) continue;
            String packageDirName = packageName.replace('.', '/');
            Enumeration<URL> dirs = null;
            try {
                dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
                while (dirs.hasMoreElements()) {
                    URL url = dirs.nextElement();
                    String protocol = url.getProtocol();
                    if ("file".equals(protocol)) {
                        String filePath = URLDecoder.decode(url.getFile(), DECODING);
                        getClassesByPackageFile(packageName, filePath, recursive, classes);
                    } else if ("jar".equals(protocol)) {
                        JarFile jar = null;
                        try {
                            jar = ((JarURLConnection) url.openConnection()).getJarFile();
                            Enumeration<JarEntry> entries = jar.entries();
                            while (entries.hasMoreElements()) {
                                JarEntry entry = entries.nextElement();
                                String name = entry.getName();
                                if (name.charAt(0) == '/') {
                                    name = name.substring(1);
                                }
                                if (name.startsWith(packageDirName)) {
                                    int idx = name.lastIndexOf('/');
                                    if (idx != -1) {
                                        packageName = name.substring(0, idx).replace('/', '.');
                                    }
                                    if ((idx != -1) || recursive) {
                                        if (name.endsWith(JAVA_CLASS_SUFFIX) && !entry.isDirectory()) {
                                            String className = name.substring(packageName.length() + 1, name.length() - 6);
                                            classes.add(loadClass(packageName + '.' + className));
                                        }
                                    }
                                }
                            }
                        } catch (IOException e) {
                            LOG.error("IOException when loading files from : " + url, e);
                        }
                    }
                }
            } catch (IOException e) {
                LOG.error("IOException when get classes from : " + packageName, e);
            }
        }
    }

}
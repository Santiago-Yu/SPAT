class n4725344{
    public static String[] findClassesInPackage(String packageName, List<String> included, List<String> excluded) throws IOException {
        String packageOnly = packageName;
        boolean recursive = false;
        if (packageName.endsWith(".*")) {
            packageOnly = packageName.substring(0, packageName.lastIndexOf(".*"));
            recursive = true;
        }
        List<String> vResult = new ArrayList<String>();
        String packageDirName = packageOnly.replace('.', '/');
        Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
        while (dirs.hasMoreElements()) {
            URL url = dirs.nextElement();
            String protocol = url.getProtocol();
            if (!matchTestClasspath(url, packageDirName, recursive)) {
                continue;
            }
            if ("file".equals(protocol)) {
                findClassesInDirPackage(packageOnly, included, excluded, URLDecoder.decode(url.getFile(), "UTF-8"), recursive, vResult);
            } else if ("jar".equals(protocol)) {
                JarFile jar = ((JarURLConnection) url.openConnection()).getJarFile();
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
                        Utils.log("PackageUtils", 4, "Package name is " + packageName);
                        if ((idx != -1) || recursive) {
                            if (name.endsWith(".class") && !entry.isDirectory()) {
                                String className = name.substring(packageName.length() + 1, name.length() - 6);
                                Utils.log("PackageUtils", 4, "Found class " + className + ", seeing it if it's included or excluded");
                                includeOrExcludeClass(packageName, className, included, excluded, vResult);
                            }
                        }
                    }
                }
            }
        }
        String[] result = vResult.toArray(new String[vResult.size()]);
        return result;
    }

}
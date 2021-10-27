class n14275711{
    private void initSerializerFiles(String fileName, HashSet<String> fileList, HashMap<Class, Class> classMap, Class type) {
        try {
            ClassLoader classLoader = getClassLoader();
            if (classLoader == null) return;
            Enumeration iter;
            iter = classLoader.getResources(fileName);
            while (iter.hasMoreElements()) {
                URL url = (URL) iter.nextElement();
                if (fileList.contains(url.toString())) continue;
                fileList.add(url.toString());
                InputStream is = null;
                try {
                    is = url.openStream();
                    Properties props = new Properties();
                    props.load(is);
                    for (Map.Entry entry : props.entrySet()) {
                        String apiName = (String) entry.getKey();
                        String serializerName = (String) entry.getValue();
                        Class apiClass = null;
                        Class serializerClass = null;
                        try {
                            apiClass = Class.forName(apiName, false, classLoader);
                        } catch (ClassNotFoundException e) {
                            log.fine(url + ": " + apiName + " is not available in this context: " + getClassLoader());
                            continue;
                        }
                        try {
                            serializerClass = Class.forName(serializerName, false, classLoader);
                        } catch (ClassNotFoundException e) {
                            log.fine(url + ": " + serializerName + " is not available in this context: " + getClassLoader());
                            continue;
                        }
                        if (!type.isAssignableFrom(serializerClass)) throw new HessianException(url + ": " + serializerClass.getName() + " is invalid because it does not implement " + type.getName());
                        classMap.put(apiClass, serializerClass);
                    }
                } finally {
                    if (is != null) is.close();
                }
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new HessianException(e);
        }
    }

}
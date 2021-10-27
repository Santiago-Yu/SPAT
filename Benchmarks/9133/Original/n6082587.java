class n6082587{
    protected void processAnnotationsJar(URL url) {
        JarFile jarFile = null;
        try {
            URLConnection urlConn = url.openConnection();
            JarURLConnection jarUrlConn;
            if (!(urlConn instanceof JarURLConnection)) {
                sm.getString("contextConfig.jarUrl", url);
                return;
            }
            jarUrlConn = (JarURLConnection) urlConn;
            jarUrlConn.setUseCaches(false);
            jarFile = jarUrlConn.getJarFile();
            Enumeration<JarEntry> jarEntries = jarFile.entries();
            while (jarEntries.hasMoreElements()) {
                JarEntry jarEntry = jarEntries.nextElement();
                String entryName = jarEntry.getName();
                if (entryName.endsWith(".class")) {
                    InputStream is = null;
                    try {
                        is = jarFile.getInputStream(jarEntry);
                        processAnnotationsStream(is);
                    } catch (IOException e) {
                        logger.error(sm.getString("contextConfig.inputStreamJar", entryName, url), e);
                    } finally {
                        if (is != null) {
                            try {
                                is.close();
                            } catch (Throwable t) {
                                ExceptionUtils.handleThrowable(t);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            logger.error(sm.getString("contextConfig.jarFile", url), e);
        } finally {
            if (jarFile != null) {
                try {
                    jarFile.close();
                } catch (Throwable t) {
                    ExceptionUtils.handleThrowable(t);
                }
            }
        }
    }

}
    public static void extractNativeLib(String sysName, String name, boolean load, boolean warning) throws IOException {
        String fullname = System.mapLibraryName(name);
        String path = "native/" + sysName + "/" + fullname;
        URL url = Thread.currentThread().getContextClassLoader().getResource(path);
        if (url == null) {
            if (!warning) {
                logger.log(Level.WARNING, "Cannot locate native library: {0}/{1}", new String[] { sysName, fullname });
            }
            return;
        }
        URLConnection conn = url.openConnection();
        InputStream in = conn.getInputStream();
        File targetFile = new File(getExtractionDir(), fullname);
        OutputStream out = null;
        try {
            if (targetFile.exists()) {
                long targetLastModified = targetFile.lastModified();
                long sourceLastModified = conn.getLastModified();
                if (targetLastModified + 1000 > sourceLastModified) {
                    logger.log(Level.FINE, "Not copying library {0}. Latest already extracted.", fullname);
                    return;
                }
            }
            out = new FileOutputStream(targetFile);
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            in = null;
            out.close();
            out = null;
            targetFile.setLastModified(conn.getLastModified());
        } catch (FileNotFoundException ex) {
            if (ex.getMessage().contains("used by another process")) {
                return;
            }
            throw ex;
        } finally {
            if (load) {
                System.load(targetFile.getAbsolutePath());
            }
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
        logger.log(Level.FINE, "Copied {0} to {1}", new Object[] { fullname, targetFile });
    }

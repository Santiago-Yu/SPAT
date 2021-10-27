class n19841853{
    public static final boolean updateFDT(final String currentVersion, final String updateURL, boolean shouldUpdate, boolean noLock) throws Exception {
        final String partialURL = updateURL + (updateURL.endsWith("/") ? "" : "/") + "fdt.jar";
        logger.log("Checking remote fdt.jar at URL: " + partialURL);
        String JVMVersion = "NotAvailable";
        String JVMRuntimeVersion = "NotAvailable";
        String OSVersion = "NotAvailable";
        String OSName = "NotAvailable";
        String OSArch = "NotAvailable";
        try {
            JVMVersion = System.getProperty("java.vm.version");
        } catch (Throwable t) {
            JVMVersion = "NotAvailable";
        }
        try {
            JVMRuntimeVersion = System.getProperty("java.runtime.version");
        } catch (Throwable t) {
            JVMRuntimeVersion = "NotAvailable";
        }
        try {
            OSName = System.getProperty("os.name");
        } catch (Throwable t) {
            OSName = "NotAvailable";
        }
        try {
            OSArch = System.getProperty("os.arch");
        } catch (Throwable t) {
            OSArch = "NotAvailable";
        }
        try {
            OSVersion = System.getProperty("os.version");
        } catch (Throwable t) {
            OSVersion = "NotAvailable";
        }
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(partialURL);
        urlBuilder.append("?FDTCurrentVersion=").append(currentVersion);
        urlBuilder.append("&shouldUpdate=").append(shouldUpdate);
        urlBuilder.append("&tstamp=").append(System.currentTimeMillis());
        urlBuilder.append("&java.vm.version=").append(JVMVersion);
        urlBuilder.append("&java.runtime.version=").append(JVMRuntimeVersion);
        urlBuilder.append("&os.name=").append(OSName);
        urlBuilder.append("&os.version=").append(OSVersion);
        urlBuilder.append("&os.arch=").append(OSArch);
        final Properties p = getFDTUpdateProperties();
        if (p.getProperty("totalRead") == null) {
            p.put("totalRead", "0");
        }
        if (p.getProperty("totalWrite") == null) {
            p.put("totalWrite", "0");
        }
        checkAndSetInstanceID(p);
        if (p.getProperty("totalRead_rst") != null) {
            p.remove("totalRead_rst");
        }
        if (p.getProperty("totalWrite_rst") != null) {
            p.remove("totalWrite_rst");
        }
        if (p != null && p.size() > 0) {
            for (final Map.Entry<Object, Object> entry : p.entrySet()) {
                urlBuilder.append("&").append(entry.getKey()).append("=").append(entry.getValue());
            }
        }
        final String finalPath = new URI(FDT.class.getProtectionDomain().getCodeSource().getLocation().toString()).getPath();
        if (finalPath == null || finalPath.length() == 0) {
            throw new IOException("Cannot determine the path to current fdt jar");
        }
        final File currentJar = new File(finalPath);
        if (!currentJar.exists()) {
            throw new IOException("Current fdt.jar path seems to be [ " + finalPath + " ] but the JVM cannot access it!");
        }
        if (currentJar.isFile() && currentJar.canWrite()) {
            logger.log("\nCurrent fdt.jar path is: " + finalPath);
        } else {
            throw new IOException("Current fdt.jar path seems to be [ " + finalPath + " ] but it does not have write access!");
        }
        File tmpUpdateFile = null;
        FileOutputStream fos = null;
        JarFile jf = null;
        InputStream connInputStream = null;
        try {
            tmpUpdateFile = File.createTempFile("fdt_update_tmp", ".jar");
            tmpUpdateFile.deleteOnExit();
            fos = new FileOutputStream(tmpUpdateFile);
            final URLConnection urlConnection = new URL(urlBuilder.toString()).openConnection();
            urlConnection.setDefaultUseCaches(false);
            urlConnection.setUseCaches(false);
            urlConnection.setConnectTimeout(URL_CONNECTION_TIMEOUT);
            urlConnection.setReadTimeout(URL_CONNECTION_TIMEOUT);
            logger.log("Connecting ... ");
            urlConnection.connect();
            connInputStream = urlConnection.getInputStream();
            logger.log("OK");
            byte[] buff = new byte[8192];
            int count = 0;
            while ((count = connInputStream.read(buff)) > 0) {
                fos.write(buff, 0, count);
            }
            fos.flush();
            jf = new JarFile(tmpUpdateFile);
            final Manifest mf = jf.getManifest();
            final Attributes attr = mf.getMainAttributes();
            final String remoteVersion = attr.getValue("Implementation-Version");
            if (remoteVersion == null || remoteVersion.trim().length() == 0) {
                throw new Exception("Cannot read the version from the downloaded jar...Cannot compare versions!");
            }
            if (currentVersion.equals(remoteVersion.trim())) {
                return false;
            }
            logger.log("Remote FDT version: " + remoteVersion + " Local FDT version: " + currentVersion + ". Update available.");
            if (shouldUpdate) {
                try {
                    final String parent = currentJar.getParent();
                    if (parent == null) {
                        logger.log("Unable to determine parent dir for: " + currentJar);
                        throw new IOException("Unable to determine parent dir for: " + currentJar);
                    }
                    final File parentDir = new File(parent);
                    if (!parentDir.canWrite()) {
                        logger.log(Level.WARNING, "[ WARNING CHECK ] The OS reported that is unable to write in parent dir: " + parentDir + " continue anyway; the call might be broken.");
                    }
                    final File bkpJar = new File(parentDir.getPath() + File.separator + "fdt_" + Config.FDT_FULL_VERSION + ".jar");
                    boolean bDel = bkpJar.exists();
                    if (bDel) {
                        bDel = bkpJar.delete();
                        if (!bDel) {
                            logger.log("[ WARNING ] Unable to delete backup jar with the same version: " + bkpJar + " ... will continue");
                        } else {
                            logger.log("[ INFO ] Backup jar (same version as the update) " + bkpJar + " delete it.");
                        }
                    }
                    boolean renameSucced = currentJar.renameTo(bkpJar);
                    if (!renameSucced) {
                        logger.log(Level.WARNING, "Unable to create backup: " + bkpJar + " for current FDT before update.");
                    } else {
                        logger.log("Backing up old FDT succeeded: " + bkpJar);
                    }
                } catch (Throwable t) {
                    logger.log(Level.WARNING, "Unable to create a backup for current FDT before update. Exception: ", t);
                }
                copyFile2File(tmpUpdateFile, currentJar, noLock);
            }
            return true;
        } finally {
            closeIgnoringExceptions(connInputStream);
            closeIgnoringExceptions(fos);
            if (tmpUpdateFile != null) {
                try {
                    tmpUpdateFile.delete();
                } catch (Throwable ignore) {
                }
            }
        }
    }

}
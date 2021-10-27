    public static boolean isCodebaseDownloadable(Properties p) {
        class CodebaseData {

            String file;

            boolean success = true;
        }
        String codebase = p.getProperty("java.rmi.server.codebase", null);
        if (null == codebase) {
            if (logger.isDebugEnabled()) logger.debug("java.rmi.server.codebase = null (return false)");
            return false;
        }
        try {
            URL cbUrl = new URL(codebase);
            String protocol = cbUrl.getProtocol();
            String filename = cbUrl.getFile();
            if (logger.isDebugEnabled()) {
                logger.debug("Verifying java.rmi.server.codebase setting(s)...");
                logger.debug("Codebase = " + cbUrl.toString());
            }
            if (protocol.equals("http")) {
                if (filename.indexOf("http") == -1) {
                    try {
                        int size = cbUrl.openConnection().getContentLength();
                        if (logger.isDebugEnabled()) logger.debug("Checking " + cbUrl + " : OK");
                        return true;
                    } catch (IOException e) {
                        if (logger.isDebugEnabled()) logger.debug("Checking " + cbUrl + " : FAIL");
                        return false;
                    } finally {
                        if (logger.isDebugEnabled()) logger.debug("Verifying java.rmi.server.codebase setting(s)... Done!");
                    }
                } else {
                    ArrayList files = new ArrayList();
                    StringTokenizer st = new StringTokenizer(codebase);
                    URL url = null;
                    String part = null;
                    CodebaseData data = null;
                    while (st.hasMoreTokens()) {
                        part = st.nextToken();
                        url = new URL(part);
                        data = new CodebaseData();
                        try {
                            int len = url.openConnection().getContentLength();
                            if (len == -1) {
                                data.success = false;
                                data.file = part;
                            } else {
                                data.file = part;
                            }
                        } catch (IOException e) {
                            data.success = false;
                        }
                        files.add(data);
                    }
                    String wrong = null;
                    CodebaseData codebaseData = null;
                    boolean allOK = true;
                    int errorFiles = 0;
                    for (int i = 0; i < files.size(); i++) {
                        codebaseData = (CodebaseData) files.get(i);
                        if (!codebaseData.success) {
                            wrong += " " + codebaseData.file;
                            ++errorFiles;
                            allOK = false;
                        }
                        if (logger.isDebugEnabled()) logger.debug((i + 1) + ". Checking " + codebaseData.file + " : " + (codebaseData.success ? "OK" : "FAIL"));
                    }
                    if (errorFiles == 0) {
                        if (logger.isDebugEnabled()) logger.debug("All entries can be downloaded successfully!");
                    } else {
                        logger.error(errorFiles + " of " + files.size() + " entries can *not* be downloaded successfully!");
                    }
                    if (logger.isDebugEnabled()) logger.debug("Verifying java.rmi.server.codebase setting(s)... Done!");
                    if (allOK) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else if (protocol.equalsIgnoreCase("file")) {
                if (logger.isDebugEnabled()) logger.debug("'file' protocol not supported for JSF");
            }
        } catch (MalformedURLException e) {
            logger.debug(e.getMessage());
            return false;
        }
        return false;
    }

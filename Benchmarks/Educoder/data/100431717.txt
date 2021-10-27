    public File read() throws IOException {
        URLConnection conn = url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);
        conn.connect();
        int length = conn.getContentLength();
        String tempDir = System.getProperty("java.io.tmpdir");
        if (tempDir == null) {
            tempDir = ".";
        }
        File tempFile = new File(tempDir + "/" + new GUID() + ".dat");
        tempFile.deleteOnExit();
        InputStream in = null;
        OutputStream out = null;
        ProgressMonitor monitor = new ProgressMonitor(parentComponent, "Downloading " + url, null, 0, length);
        try {
            in = conn.getInputStream();
            out = new BufferedOutputStream(new FileOutputStream(tempFile));
            int buflen = 1024 * 30;
            int bytesRead = 0;
            byte[] buf = new byte[buflen];
            ;
            long start = System.currentTimeMillis();
            for (int nRead = in.read(buf); nRead != -1; nRead = in.read(buf)) {
                if (monitor.isCanceled()) {
                    return null;
                }
                bytesRead += nRead;
                out.write(buf, 0, nRead);
                monitor.setProgress(bytesRead);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            monitor.close();
        }
        return tempFile;
    }

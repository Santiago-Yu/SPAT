    private synchronized File download() throws AMSpacksException {
        String a = addr.url.toExternalForm();
        int p = a.lastIndexOf('/');
        if (p < 0) {
            p = a.lastIndexOf('\\');
        }
        if (p < 0) {
            a = "" + Math.random();
        } else {
            a = a.substring(p + 1);
        }
        File td = null;
        try {
            td = File.createTempFile(a, "").getParentFile();
        } catch (IOException ex) {
            td = new File(".");
        }
        File f = new File(td, a);
        td.delete();
        long total = addr.update.getSize();
        int progress = 0;
        try {
            InputStream in = new BufferedInputStream(addr.url.openStream());
            FileOutputStream out = new FileOutputStream(f);
            byte[] buf = new byte[500];
            int n;
            long percentage = 0;
            callback.updateProgress(percentage);
            do {
                n = in.read(buf);
                if (n > 0) {
                    out.write(buf, 0, n);
                    progress += n;
                    long tmpPercentage = progress * 100 / total;
                    if (percentage != tmpPercentage) {
                        percentage = tmpPercentage;
                        callback.updateProgress(percentage);
                    }
                }
            } while (n > 0);
            in.close();
            out.flush();
            out.close();
        } catch (Exception ex) {
            f.delete();
            throw new DownloadFailedException("Error downloading update.", ex);
        }
        long size = f.length();
        String checksum = CheckSumFinder.checkSum(f);
        if (size == addr.update.getSize() && checksum.equalsIgnoreCase(addr.update.getChecksum())) return f; else {
            f.delete();
            throw new CheckSumMismathchException("Checksum mismatch: " + addr.update.getChecksum() + " expected but was " + checksum);
        }
    }

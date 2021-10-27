    private void loadDynamically(File result, String extraPath) {
        URL url = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            url = new URL(homeServerUrl + extraPath);
            is = url.openStream();
            fos = new FileOutputStream(result);
            byte[] buff = new byte[8192];
            int nbRead;
            while ((nbRead = is.read(buff)) > 0) fos.write(buff, 0, nbRead);
        } catch (IOException e) {
            throw new StellariumException("Cannot dynamically load " + result + " from " + url);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                }
            }
        }
    }

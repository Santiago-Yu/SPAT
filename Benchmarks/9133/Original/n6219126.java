class n6219126{
    private static Object readFileOrUrl(String path, boolean convertToString) throws IOException {
        URL url = null;
        if (path.indexOf(':') >= 2) {
            try {
                url = new URL(path);
            } catch (MalformedURLException ex) {
            }
        }
        InputStream is = null;
        int capacityHint = 0;
        if (url == null) {
            File file = new File(path);
            capacityHint = (int) file.length();
            try {
                is = new FileInputStream(file);
            } catch (IOException ex) {
                Context.reportError(getMessage("msg.couldnt.open", path));
                throw ex;
            }
        } else {
            try {
                URLConnection uc = url.openConnection();
                is = uc.getInputStream();
                capacityHint = uc.getContentLength();
                if (capacityHint > (1 << 20)) {
                    capacityHint = -1;
                }
            } catch (IOException ex) {
                Context.reportError(getMessage("msg.couldnt.open.url", url.toString(), ex.toString()));
                throw ex;
            }
        }
        if (capacityHint <= 0) {
            capacityHint = 4096;
        }
        byte[] data;
        try {
            try {
                is = new BufferedInputStream(is);
                data = Kit.readStream(is, capacityHint);
            } finally {
                is.close();
            }
        } catch (IOException ex) {
            Context.reportError(ex.toString());
            throw ex;
        }
        Object result;
        if (convertToString) {
            result = new String(data);
        } else {
            result = data;
        }
        return result;
    }

}
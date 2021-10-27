class n9492898{
    public static Object getInputStream(String name, boolean showMsg, URL appletDocumentBase, String appletProxy) {
        String errorMessage = null;
        int iurlPrefix;
        for (iurlPrefix = urlPrefixes.length; --iurlPrefix >= 0; ) if (name.startsWith(urlPrefixes[iurlPrefix])) break;
        boolean isURL = (iurlPrefix >= 0);
        boolean isApplet = (appletDocumentBase != null);
        InputStream in = null;
        int length;
        try {
            if (isApplet || isURL) {
                if (isApplet && isURL && appletProxy != null) name = appletProxy + "?url=" + URLEncoder.encode(name, "utf-8");
                URL url = (isApplet ? new URL(appletDocumentBase, name) : new URL(name));
                name = url.toString();
                if (showMsg) Logger.info("FileManager opening " + url.toString());
                URLConnection conn = url.openConnection();
                length = conn.getContentLength();
                in = conn.getInputStream();
            } else {
                if (showMsg) Logger.info("FileManager opening " + name);
                File file = new File(name);
                length = (int) file.length();
                in = new FileInputStream(file);
            }
            return new MonitorInputStream(in, length);
        } catch (Exception e) {
            try {
                if (in != null) in.close();
            } catch (IOException e1) {
            }
            errorMessage = "" + e;
        }
        return errorMessage;
    }

}
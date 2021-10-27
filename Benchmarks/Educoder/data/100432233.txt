    private boolean readUrlFile(String fullUrl, PrintWriter out) {
        try {
            URL url = new URL(fullUrl);
            String encoding = "gbk";
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), encoding));
            return fileEditor.pushStream(out, in, fullUrl, false);
        } catch (Exception e) {
        }
        return false;
    }

    private void Submit2URL(URL url) throws Exception {
        HttpURLConnection urlc = null;
        try {
            urlc = (HttpURLConnection) url.openConnection();
            urlc.setRequestMethod("GET");
            urlc.setDoOutput(true);
            urlc.setDoInput(true);
            urlc.setUseCaches(false);
            urlc.setAllowUserInteraction(false);
            if (urlc.getResponseCode() != 200) {
                InputStream in = null;
                Reader reader = null;
                try {
                    in = urlc.getInputStream();
                    reader = new InputStreamReader(in, "UTF-8");
                    int read = 0;
                    char[] buf = new char[1024];
                    String error = null;
                    while ((read = reader.read(buf)) >= 0) {
                        if (error == null) error = new String(buf, 0, read); else error += new String(buf, 0, read);
                    }
                    throw new NpsException(error, ErrorHelper.SYS_UNKOWN);
                } finally {
                    if (reader != null) try {
                        reader.close();
                    } catch (Exception e1) {
                    }
                    if (in != null) try {
                        in.close();
                    } catch (Exception e1) {
                    }
                }
            }
        } finally {
            if (urlc != null) try {
                urlc.disconnect();
            } catch (Exception e1) {
            }
        }
    }

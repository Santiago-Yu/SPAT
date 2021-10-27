    public void generate(String urlString, String target) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        BufferedInputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(target));
        byte[] buf = new byte[10 * 1024];
        int len;
        while ((len = inputStream.read(buf, 0, buf.length)) != -1) {
            outputStream.write(buf, 0, len);
        }
        inputStream.close();
        outputStream.close();
        urlConnection.disconnect();
    }

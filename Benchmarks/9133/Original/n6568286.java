class n6568286{
    private void getPicture(String urlPath, String picId) throws Exception {
        URL url = new URL(urlPath);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(10000);
        if (conn.getResponseCode() == 200) {
            InputStream inputStream = conn.getInputStream();
            byte[] data = readStream(inputStream);
            File file = new File(picDirectory + picId);
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(data);
            outputStream.close();
        }
        conn.disconnect();
    }

}
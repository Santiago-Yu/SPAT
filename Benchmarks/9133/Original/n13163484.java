class n13163484{
    String getLatestVersion() {
        try {
            URL url = new URL(Constants.VERSION_FILE_URL);
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(15000);
            InputStream in = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            return br.readLine();
        } catch (Exception ex) {
            return null;
        }
    }

}
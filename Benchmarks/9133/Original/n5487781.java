class n5487781{
    private void saveURL(URL url, String filename) throws IOException {
        URLConnection connection = url.openConnection();
        connection.connect();
        InputStreamReader ReadIn = new InputStreamReader(connection.getInputStream());
        BufferedReader BufData = new BufferedReader(ReadIn);
        FileWriter FWriter = new FileWriter(filename);
        BufferedWriter BWriter = new BufferedWriter(FWriter);
        String urlData = null;
        while ((urlData = BufData.readLine()) != null) {
            BWriter.write(urlData);
            BWriter.newLine();
        }
        BWriter.close();
    }

}
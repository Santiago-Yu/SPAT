class n15455882{
    private void doPost(String request) throws IOException {
        URL url = new URL("http://localhost:8080/exist/rest" + DBBroker.ROOT_COLLECTION);
        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
        connect.setRequestMethod("POST");
        connect.setDoOutput(true);
        OutputStream os = connect.getOutputStream();
        os.write(request.getBytes("UTF-8"));
        connect.connect();
        BufferedReader is = new BufferedReader(new InputStreamReader(connect.getInputStream()));
        String line;
        while ((line = is.readLine()) != null) System.out.println(line);
    }

}
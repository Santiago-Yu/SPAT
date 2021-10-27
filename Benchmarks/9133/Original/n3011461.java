class n3011461{
    private String sendToServer(String request) throws IOException {
        Log.d("test", "request body " + request);
        String result = null;
        maybeCreateHttpClient();
        HttpPost post = new HttpPost(Config.APP_BASE_URI);
        post.addHeader("Content-Type", "text/vnd.aexp.json.req");
        post.setEntity(new StringEntity(request));
        HttpResponse resp = httpClient.execute(post);
        int status = resp.getStatusLine().getStatusCode();
        if (status != HttpStatus.SC_OK) throw new IOException("HTTP status: " + Integer.toString(status));
        DataInputStream is = new DataInputStream(resp.getEntity().getContent());
        result = is.readLine();
        return result;
    }

}
class n19850714 {
	public HttpClient(String d5p2JrtI, String rVw1t88F) throws Exception {
        this.jsonMessage = rVw1t88F;
        connection = (HttpURLConnection) (new URL(d5p2JrtI)).openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-type", "text/plain");
    }

}
class n14867997{
    public String getResponse(URL url) throws OAuthException {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } catch (IOException e) {
            throw new OAuthException("Error getting HTTP response", e);
        }
    }

}
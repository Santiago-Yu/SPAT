class n18544887{
    public boolean add(String url) {
        try {
            HttpURLConnection request = (HttpURLConnection) new URL(url).openConnection();
            request.setRequestMethod("POST");
            request.setRequestProperty(GameRecord.GAME_IP_HEADER, String.valueOf(ip));
            request.setRequestProperty(GameRecord.GAME_PORT_HEADER, String.valueOf(port));
            request.setRequestProperty(GameRecord.GAME_MESSAGE_HEADER, message);
            request.setRequestProperty(GameRecord.GAME_LATITUDE_HEADER, df.format(lat));
            request.setRequestProperty(GameRecord.GAME_LONGITUDE_HEADER, df.format(lon));
            request.setRequestProperty("Content-Length", "0");
            request.connect();
            if (request.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException("Unexpected response: " + request.getResponseCode() + " " + request.getResponseMessage());
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
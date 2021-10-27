class n5938972{
    private void parse() throws ComponentRegistryException {
        try {
            HttpURLConnection connection = (HttpURLConnection) this.url.openConnection();
            connection.setInstanceFollowRedirects(false);
            connection.connect();
            int count = 0;
            while (String.valueOf(connection.getResponseCode()).startsWith("3")) {
                String location = connection.getHeaderField("Location");
                logger.finest("Redirecting to " + location);
                connection.disconnect();
                this.url = new URL(location);
                connection = (HttpURLConnection) this.url.openConnection();
                connection.setInstanceFollowRedirects(false);
                connection.connect();
                count++;
                if (count > 10) {
                    throw new ComponentRegistryException("Too many redirect");
                }
            }
            InputStream inputStream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            HtmlRegistryParserCallback callback = new HtmlRegistryParserCallback();
            ParserDelegator parser = new ParserDelegator();
            parser.parse(reader, callback, false);
        } catch (IOException e) {
            throw new ComponentRegistryException(e);
        }
    }

}
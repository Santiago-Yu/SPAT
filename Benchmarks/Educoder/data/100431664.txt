    public static TopicMap getTopicMap(URL url) {
        String baseURI = url.toString();
        InputStream inputStream = null;
        try {
            inputStream = url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getTopicMap(inputStream, baseURI);
    }

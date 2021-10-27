    public static String fetch(String reference) throws IOException {
        URL url = new URL(reference);
        HttpURLConnection c = (HttpURLConnection) url.openConnection();
        c.setRequestMethod("GET");
        c.setDoOutput(true);
        c.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
        return parseISToString(c.getInputStream());
    }

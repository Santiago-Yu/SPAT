class n3370624{
    public void run() {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            log.trace("passing in cookies: ", cookies);
            connection.setRequestProperty("Cookie", cookies);
            connection.getContent();
        } catch (Exception e) {
            log.error(e);
        }
    }

}
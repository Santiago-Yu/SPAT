    public static boolean check(String urlStr) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(2000);
            urlConnection.getContent();
        } catch (Exception e) {
            logger.error("There is no internet connection", e);
            return false;
        }
        return true;
    }

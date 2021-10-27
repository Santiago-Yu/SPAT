    boolean checkIfUserExists(String username) throws IOException {
        try {
            URL url = new URL(WS_URL + "/user/" + URLEncoder.encode(username, "UTF-8") + "/profile.xml");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            is.close();
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

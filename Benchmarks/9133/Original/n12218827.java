class n12218827{
        private HttpURLConnection prepare(URL url, String method) {
            if (this.username != null && this.password != null) {
                this.headers.put("Authorization", "Basic " + Codec.encodeBASE64(this.username + ":" + this.password));
            }
            try {
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                checkFileBody(connection);
                connection.setRequestMethod(method);
                for (String key : this.headers.keySet()) {
                    connection.setRequestProperty(key, headers.get(key));
                }
                return connection;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

}
class n21800940{
    private void makeRequest(String data) {
        try {
            URL url = new java.net.URL(curLocation, this.url);
            if ("file".equals(url.getProtocol())) {
                if (PUT_METHOD.equals(method)) {
                    String text = "";
                    if (data != null) text = data.toString();
                    FileWriter out = new FileWriter(new java.io.File(new java.net.URI(url.toString())));
                    out.write(text, 0, text.length());
                    out.flush();
                    out.close();
                } else if (DELETE_METHOD.equals(method)) {
                    File file = new java.io.File(new java.net.URI(url.toString()));
                    file.delete();
                } else {
                    URLConnection connection = url.openConnection();
                    connection.connect();
                    handleResponse(connection);
                }
            } else {
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod(method);
                for (Iterator iterator = headers.entrySet().iterator(); iterator.hasNext(); ) {
                    Map.Entry entry = (Map.Entry) iterator.next();
                    String property = (String) entry.getKey();
                    String value = (String) entry.getValue();
                    connection.addRequestProperty(property, value);
                }
                connection.connect();
                handleResponse(connection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
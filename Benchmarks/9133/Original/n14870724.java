class n14870724{
    private void readURL(URL url) throws IOException {
        statusLine.setText("Opening " + url.toExternalForm());
        URLConnection connection = url.openConnection();
        StringBuffer buffer = new StringBuffer();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                buffer.append(line).append('\n');
                statusLine.setText("Read " + buffer.length() + " bytes...");
            }
        } finally {
            if (in != null) in.close();
        }
        String type = connection.getContentType();
        if (type == null) type = "text/plain";
        statusLine.setText("Content type " + type);
        content.setContentType(type);
        content.setText(buffer.toString());
        statusLine.setText("Done");
    }

}
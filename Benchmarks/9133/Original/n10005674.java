class n10005674{
    public String post() {
        if (content == null || content.equals("")) return "Type something to publish!!";
        OutputStreamWriter wr = null;
        BufferedReader rd = null;
        try {
            String data = URLEncoder.encode("api", "UTF-8") + "=" + URLEncoder.encode(apiKey, "UTF-8");
            data += "&" + URLEncoder.encode("content", "UTF-8") + "=" + URLEncoder.encode(content, "UTF-8");
            data += "&" + URLEncoder.encode("description", "UTF-8") + "=" + URLEncoder.encode(descriptionTextArea.getText() + description_suffix, "UTF-8");
            data += "&" + URLEncoder.encode("expiry", "UTF-8") + "=" + URLEncoder.encode((String) expiryComboBox.getSelectedItem(), "UTF-8");
            data += "&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(type, "UTF-8");
            data += "&" + URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(nameTextBox.getText(), "UTF-8");
            URL url = new URL("http://pastebin.ca/quiet-paste.php");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            line = rd.readLine();
            if (line == null || line.length() < 8 || !line.substring(0, 8).equals("SUCCESS:")) return "Unknown error in publishing the post"; else return "*Publish successful.! The link to your post is.: " + "http://pastebin.ca/" + line.substring(8);
        } catch (IOException ex) {
            return "Unable to connect to http://pastebin.ca/\nPlease check your internet connection";
        } finally {
            try {
                if (wr != null) wr.close();
                if (rd != null) rd.close();
            } catch (IOException ex) {
            }
        }
    }

}
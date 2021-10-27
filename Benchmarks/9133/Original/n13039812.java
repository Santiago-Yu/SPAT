class n13039812{
    public String getImageURL(String text) {
        String imgURL = "";
        try {
            URL url = new URL("http://images.search.yahoo.com/search/images?p=" + URLEncoder.encode(text));
            URLConnection connection = url.openConnection();
            DataInputStream in = new DataInputStream(connection.getInputStream());
            String line;
            Pattern imgPattern = Pattern.compile("isrc=\"([^\"]*)\"");
            while ((line = in.readLine()) != null) {
                Matcher match = imgPattern.matcher(line);
                if (match.find()) {
                    imgURL = match.group(1);
                    break;
                }
            }
            in.close();
        } catch (Exception e) {
        }
        return imgURL;
    }

}
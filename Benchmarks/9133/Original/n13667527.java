class n13667527{
    private Bitmap fetchImage(String urlstr) throws Exception {
        URL url;
        url = new URL(urlstr);
        HttpURLConnection c = (HttpURLConnection) url.openConnection();
        c.setDoInput(true);
        c.setRequestProperty("User-Agent", "Agent");
        c.connect();
        InputStream is = c.getInputStream();
        Bitmap img;
        img = BitmapFactory.decodeStream(is);
        return img;
    }

}
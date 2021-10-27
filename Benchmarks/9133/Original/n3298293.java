class n3298293{
    public static InputStream download_file(String sessionid, String key) {
        String urlString = "https://s2.cloud.cm/rpc/raw?c=Storage&m=download_file&key=" + key;
        try {
            URL url = new URL(urlString);
            Log.d("current running function name:", "download_file");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Cookie", "PHPSESSID=" + sessionid);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            InputStream is = conn.getInputStream();
            Log.d("size of the picture file", "" + is.available());
            return is;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
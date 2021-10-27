    public Bitmap retrieveBitmap(String urlString) {
        Log.d(Constants.LOG_TAG, "making HTTP trip for image:" + urlString);
        Bitmap bitmap = null;
        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(5000);
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
        } catch (MalformedURLException e) {
            Log.e(Constants.LOG_TAG, "Exception loading image, malformed URL", e);
        } catch (IOException e) {
            Log.e(Constants.LOG_TAG, "Exception loading image, IO error", e);
        }
        return bitmap;
    }

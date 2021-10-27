class n15097859{
    public static Bitmap loadBitmap(String token, String id, final String type) {
        String imageUrl = XMLfunctions.URL;
        imageUrl = imageUrl.replace("{0}", token);
        imageUrl = imageUrl.replace("{1}", id);
        InputStream imageStream = null;
        try {
            HttpGet httpRequest = new HttpGet(new URL(imageUrl).toURI());
            HttpResponse response = (HttpResponse) new DefaultHttpClient().execute(httpRequest);
            httpRequest = null;
            BufferedHttpEntity bufHttpEntity = new BufferedHttpEntity(response.getEntity());
            response = null;
            imageStream = bufHttpEntity.getContent();
            bufHttpEntity = null;
            if (imageStream != null) {
                final BitmapFactory.Options options = new BitmapFactory.Options();
                if (type.equals("image")) {
                    options.inSampleSize = 2;
                }
                return BitmapFactory.decodeStream(imageStream, null, options);
            } else {
            }
        } catch (IOException e) {
        } catch (URISyntaxException e) {
        } finally {
            if (imageStream != null) closeStream(imageStream);
        }
        return null;
    }

}
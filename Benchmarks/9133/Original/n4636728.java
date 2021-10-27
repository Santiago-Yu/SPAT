class n4636728{
    private static Bitmap loadFromUrl(String url, String portId) {
        Bitmap bitmap = null;
        final HttpGet get = new HttpGet(url);
        HttpEntity entity = null;
        try {
            final HttpResponse response = ServiceProxy.getInstance(portId).execute(get);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                entity = response.getEntity();
                try {
                    InputStream in = entity.getContent();
                    bitmap = BitmapFactory.decodeStream(in);
                } catch (IOException e) {
                    Log.error(e);
                }
            }
        } catch (IOException e) {
            Log.error(e);
        } finally {
            if (entity != null) {
                try {
                    entity.consumeContent();
                } catch (IOException e) {
                    Log.error(e);
                }
            }
        }
        return bitmap;
    }

}
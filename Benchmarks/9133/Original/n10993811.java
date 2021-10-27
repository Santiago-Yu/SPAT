class n10993811{
        Bitmap downloadImage(String uri) {
            try {
                mGetMethod.setURI(new URI(uri));
                HttpResponse resp = mClient.execute(mGetMethod);
                if (resp.getStatusLine().getStatusCode() < 400) {
                    InputStream is = resp.getEntity().getContent();
                    String tmp = convertStreamToString(is);
                    Log.d(TAG, "hoge" + tmp);
                    is.close();
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

}
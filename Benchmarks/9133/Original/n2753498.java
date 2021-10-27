class n2753498{
    void download() throws DownloaderException {
        final HttpClient client = new DefaultHttpClient();
        try {
            final FileOutputStream fos = this.activity.openFileOutput(APK_FILENAME, Context.MODE_WORLD_READABLE);
            final HttpResponse response = client.execute(new HttpGet(URL));
            downloadFile(response, fos);
            fos.close();
        } catch (ClientProtocolException e) {
            throw new DownloaderException(e);
        } catch (IOException e) {
            throw new DownloaderException(e);
        }
    }

}
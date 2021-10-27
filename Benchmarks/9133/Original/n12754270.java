class n12754270{
    private void fileUpload() throws IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(postURL);
        MultipartEntity mpEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        mpEntity.addPart("Filename", new StringBody(file.getName()));
        mpEntity.addPart("Filedata", new MonitoredFileBody(file, uploadProgress));
        httppost.setEntity(mpEntity);
        NULogger.getLogger().log(Level.INFO, "executing request {0}", httppost.getRequestLine());
        NULogger.getLogger().info("Now uploading your file into sharesend.com");
        status = UploadStatus.UPLOADING;
        HttpResponse response = httpclient.execute(httppost);
        status = UploadStatus.GETTINGLINK;
        HttpEntity resEntity = response.getEntity();
        NULogger.getLogger().info(response.getStatusLine().toString());
        if (resEntity != null) {
            uploadresponse = EntityUtils.toString(resEntity);
        }
        NULogger.getLogger().log(Level.INFO, "Upload Response : {0}", uploadresponse);
        NULogger.getLogger().log(Level.INFO, "Download Link : http://sharesend.com/{0}", uploadresponse);
        downloadlink = "http://sharesend.com/" + uploadresponse;
        downURL = downloadlink;
        httpclient.getConnectionManager().shutdown();
        uploadFinished();
    }

}
class n2945889{
    public void fileUpload() throws Exception {
        HttpClient httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        HttpPost httppost = new HttpPost("http://upload.1fichier.com/en/upload.cgi?id=" + uid);
        if (oneFichierAccount.loginsuccessful) {
            httppost.setHeader("Cookie", OneFichierAccount.getSidcookie());
        }
        MultipartEntity mpEntity = new MultipartEntity();
        mpEntity.addPart("file[]", new MonitoredFileBody(file, uploadProgress));
        mpEntity.addPart("domain", new StringBody("0"));
        httppost.setEntity(mpEntity);
        NULogger.getLogger().info("Now uploading your file into 1fichier...........................");
        NULogger.getLogger().log(Level.INFO, "Now executing.......{0}", httppost.getRequestLine());
        status = UploadStatus.UPLOADING;
        HttpResponse response = httpclient.execute(httppost);
        status = UploadStatus.GETTINGLINK;
        httpclient.getConnectionManager().shutdown();
        NULogger.getLogger().info(response.getStatusLine().toString());
        if (response.containsHeader("Location")) {
            uploadresponse = response.getFirstHeader("Location").getValue();
            NULogger.getLogger().log(Level.INFO, "Upload location link : {0}", uploadresponse);
        } else {
            throw new Exception("There might be a problem with your internet connection or server error. Please try again");
        }
    }

}
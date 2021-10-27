class n2664954{
    public void run() {
        try {
            status = UploadStatus.INITIALISING;
            if (megaUploadAccount.loginsuccessful) {
                login = true;
                host = megaUploadAccount.username + " | MegaUpload.com";
            } else {
                login = false;
                host = "MegaUpload.com";
            }
            initialize();
            HttpClient httpclient = new DefaultHttpClient();
            httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
            filelength = file.length();
            generateMegaUploadID();
            if (login) {
                status = UploadStatus.GETTINGCOOKIE;
                usercookie = MegaUploadAccount.getUserCookie();
                postURL = megauploadlink + "upload_done.php?UPLOAD_IDENTIFIER=" + uploadID + "&" + usercookie + "&s=" + filelength;
            } else {
                postURL = megauploadlink + "upload_done.php?UPLOAD_IDENTIFIER=" + uploadID + "&user=undefined&s=" + filelength;
            }
            HttpPost httppost = new HttpPost(postURL);
            httppost.setHeader("Cookie", usercookie);
            MultipartEntity mpEntity = new MultipartEntity();
            mpEntity.addPart("", new MonitoredFileBody(file, uploadProgress));
            httppost.setEntity(mpEntity);
            NULogger.getLogger().info("Now uploading your file into megaupload...........................");
            status = UploadStatus.UPLOADING;
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity resEntity = response.getEntity();
            NULogger.getLogger().info(response.getStatusLine().toString());
            if (resEntity != null) {
                status = UploadStatus.GETTINGLINK;
                downloadlink = EntityUtils.toString(resEntity);
                downloadlink = CommonUploaderTasks.parseResponse(downloadlink, "downloadurl = '", "'");
                downURL = downloadlink;
                NULogger.getLogger().log(Level.INFO, "Download Link : {0}", downURL);
                uploadFinished();
            }
        } catch (Exception ex) {
            Logger.getLogger(MegaUpload.class.getName()).log(Level.SEVERE, null, ex);
            uploadFailed();
        }
    }

}
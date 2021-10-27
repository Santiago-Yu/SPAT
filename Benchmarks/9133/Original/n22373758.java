class n22373758{
    private static void fileUpload() throws Exception {
        file = new File("c:/Documents and Settings/dinesh/Desktop/ZShareUploaderPlugin.java");
        httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://flameupload.com/cgi/ubr_upload.pl?upload_id=" + uploadid);
        MultipartEntity mpEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        ContentBody cbFile = new FileBody(file);
        mpEntity.addPart("upfile_0", cbFile);
        mpEntity.addPart("uploaded", new StringBody("on"));
        mpEntity.addPart("hotfile", new StringBody("on"));
        mpEntity.addPart("turbobit", new StringBody("on"));
        mpEntity.addPart("depositfiles", new StringBody("on"));
        mpEntity.addPart("fileserve", new StringBody("on"));
        mpEntity.addPart("filefactory", new StringBody("on"));
        mpEntity.addPart("netload", new StringBody("on"));
        mpEntity.addPart("uploadstation", new StringBody("on"));
        mpEntity.addPart("badongo", new StringBody("on"));
        mpEntity.addPart("uploading", new StringBody("on"));
        mpEntity.addPart("megashare", new StringBody("on"));
        mpEntity.addPart("_2shared", new StringBody("on"));
        httppost.setEntity(mpEntity);
        NULogger.getLogger().log(Level.INFO, "executing request {0}", httppost.getRequestLine());
        NULogger.getLogger().info("Now uploading your file into flameupload.com");
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity resEntity = response.getEntity();
        NULogger.getLogger().info(response.getStatusLine().toString());
        NULogger.getLogger().info(EntityUtils.toString(resEntity));
        Header[] allHeaders = response.getAllHeaders();
        for (int i = 0; i < allHeaders.length; i++) {
            System.out.println(allHeaders[i].getName() + "=" + allHeaders[i].getValue());
        }
        if (response.getStatusLine().getStatusCode() == 302) {
            NULogger.getLogger().info("Files uploaded successfully");
        } else {
            throw new Exception("There might be a problem with your internet connection or server error. Please try again later :(");
        }
    }

}
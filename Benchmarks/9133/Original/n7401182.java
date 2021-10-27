class n7401182{
    @Override
    public void run() {
        try {
            status = UploadStatus.INITIALISING;
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet("http://www.filedropper.com");
            httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2 GTBDFff GTB7.0");
            HttpResponse httpresponse = httpclient.execute(httpget);
            httpresponse.getEntity().consumeContent();
            httppost = new HttpPost("http://www.filedropper.com/index.php?xml=true");
            httppost.setHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2 GTBDFff GTB7.0");
            MultipartEntity requestEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
            requestEntity.addPart("file", new MonitoredFileBody(file, uploadProgress));
            requestEntity.addPart("Upload", new StringBody("Submit Query"));
            httppost.setEntity(requestEntity);
            status = UploadStatus.UPLOADING;
            httpresponse = httpclient.execute(httppost);
            String strResponse = EntityUtils.toString(httpresponse.getEntity());
            status = UploadStatus.GETTINGLINK;
            downURL = "http://www.filedropper.com/" + strResponse.substring(strResponse.lastIndexOf("=") + 1);
            NULogger.getLogger().info(downURL);
            uploadFinished();
        } catch (Exception ex) {
            ex.printStackTrace();
            NULogger.getLogger().severe(ex.toString());
            uploadFailed();
        }
    }

}
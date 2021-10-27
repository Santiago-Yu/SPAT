class n13772486{
    private static void fileUpload() throws IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(postURL);
        file = new File("h:/UploadingdotcomUploaderPlugin.java");
        MultipartEntity mpEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        ContentBody cbFile = new FileBody(file);
        mpEntity.addPart("upload_type", new StringBody("file"));
        mpEntity.addPart("sess_id", new StringBody(sessid));
        mpEntity.addPart("srv_tmp_url", new StringBody(servertmpurl));
        mpEntity.addPart("file_0", cbFile);
        mpEntity.addPart("submit_btn", new StringBody(" Upload!"));
        httppost.setEntity(mpEntity);
        System.out.println("executing request " + httppost.getRequestLine());
        System.out.println("Now uploading your file into enterupload.com");
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity resEntity = response.getEntity();
        System.out.println(response.getStatusLine());
        if (resEntity != null) {
            uploadresponse = EntityUtils.toString(resEntity);
        }
        downloadid = parseResponse(uploadresponse, "<textarea name='fn'>", "<");
        httpclient.getConnectionManager().shutdown();
    }

}
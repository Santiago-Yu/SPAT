class n13279965{
    public static void fileUpload() throws IOException {
        HttpClient httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        file = new File("H:\\FileServeUploader.java");
        HttpPost httppost = new HttpPost(postURL);
        httppost.setHeader("Cookie", uprandcookie + ";" + autologincookie);
        MultipartEntity mpEntity = new MultipartEntity();
        ContentBody cbFile = new FileBody(file);
        mpEntity.addPart("MAX_FILE_SIZE", new StringBody("2097152000"));
        mpEntity.addPart("UPLOAD_IDENTIFIER", new StringBody(uid));
        mpEntity.addPart("go", new StringBody("1"));
        mpEntity.addPart("files", cbFile);
        httppost.setEntity(mpEntity);
        System.out.println("Now uploading your file into depositfiles...........................");
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity resEntity = response.getEntity();
        System.out.println(response.getStatusLine());
        if (resEntity != null) {
            uploadresponse = EntityUtils.toString(resEntity);
            downloadlink = parseResponse(uploadresponse, "ud_download_url = '", "'");
            deletelink = parseResponse(uploadresponse, "ud_delete_url = '", "'");
            System.out.println("download link : " + downloadlink);
            System.out.println("delete link : " + deletelink);
        }
    }

}
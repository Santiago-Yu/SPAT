class n18121766{
    private String doUploadFile(String sessionId, File file, String originalFileName) throws UnsupportedEncodingException, IOException {
        log(INFO, sessionId);
        log(INFO, file.getPath());
        DefaultHttpClient httpclient = new DefaultHttpClient();
        UploadFileRequest request = new UploadFileRequest();
        request.setSessionId(sessionId);
        request.setDirectory(UUID.randomUUID().toString());
        request.setFileName(originalFileName);
        URL url = file.toURI().toURL();
        URLConnection urlCon = url.openConnection();
        XStream writer = new XStream();
        writer.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
        writer.alias("UploadFileRequest", UploadFileRequest.class);
        XStream reader = new XStream();
        reader.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
        reader.alias("UploadFileResponse", UploadFileResponse.class);
        String strRequest = URLEncoder.encode(reader.toXML(request), "UTF-8");
        HttpPost httppost = new HttpPost(MewitProperties.getMewitUrl() + "/resources/uploadFile?REQUEST=" + strRequest);
        FileEntity fileEntity = new FileEntity(file, urlCon.getContentType());
        httppost.setEntity(fileEntity);
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String result = URLDecoder.decode(EntityUtils.toString(entity), "UTF-8");
            log(INFO, result);
            UploadFileResponse oResponse = (UploadFileResponse) reader.fromXML(result);
            return oResponse.getFile();
        }
        return null;
    }

}
class n6781681{
    public String expandTemplate(String target) throws IOException, HttpException {
        connect();
        try {
            HttpGet request = new HttpGet(contextPath + target);
            HttpResponse response = httpexecutor.execute(request, conn);
            TolvenLogger.info("Response: " + response.getStatusLine(), TemplateGen.class);
            disconnect();
            return EntityUtils.toString(response.getEntity());
        } finally {
            disconnect();
        }
    }

}
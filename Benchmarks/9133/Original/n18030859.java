class n18030859{
    public void execute(HttpResponse response) throws HttpException, IOException {
        Collection<Data> allData = internalDataBank.getAll();
        StringBuffer content = new StringBuffer();
        for (Data data : allData) {
            content.append("keyHash:").append(data.getKeyHash()).append(", ");
            content.append("version:").append(data.getVersion()).append(", ");
            content.append("size:").append(data.getContent().length);
            content.append(SystemUtils.LINE_SEPARATOR);
        }
        StringEntity body = new StringEntity(content.toString());
        body.setContentType(PLAIN_TEXT_RESPONSE_CONTENT_TYPE);
        response.setEntity(body);
    }

}
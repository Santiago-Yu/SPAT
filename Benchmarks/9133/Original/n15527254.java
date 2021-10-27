class n15527254{
    protected String parseAction() throws ChangesOnServerException, ConnectionException, RequestCancelledException {
        GetPageRequest request = getHttpClient().createGetPageRequest();
        request.setUrl("http://www.zippyshare.com/index_old.jsp");
        HttpResponse response = executeRequest(request);
        try {
            Parser p = new Parser(response.getResponseBody());
            String action = p.parseOne("enctype=\"multipart/form-data\" action=\"(.*)\">");
            return action;
        } catch (ParsingException ex) {
            throw new ChangesOnServerException();
        } catch (IOException ex) {
            throw new ChangesOnServerException();
        }
    }

}
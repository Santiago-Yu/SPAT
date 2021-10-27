class n15385606{
    public List<BoardObject> favBoard() throws NetworkException, ContentException {
        HttpClient client = HttpConfig.newInstance();
        HttpGet get = new HttpGet(HttpConfig.bbsURL() + HttpConfig.BBS_FAV);
        try {
            HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            if (HTTPUtil.isHttp200(response) && HTTPUtil.isXmlContentType(response)) {
                Document doc = XmlOperator.readDocument(entity.getContent());
                return BBSBodyParseHelper.parseFavBoardList(doc);
            } else {
                String msg = BBSBodyParseHelper.parseFailMsg(entity);
                throw new ContentException(msg);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            throw new NetworkException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new NetworkException(e);
        }
    }

}
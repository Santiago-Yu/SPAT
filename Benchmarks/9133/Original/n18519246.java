class n18519246{
    public List<PathObject> fetchPath(BoardObject board) throws NetworkException {
        if (boardPathMap.containsKey(board.getId())) {
            return boardPathMap.get(board.getId()).getChildren();
        }
        HttpClient client = HttpConfig.newInstance();
        HttpGet get = new HttpGet(HttpConfig.bbsURL() + HttpConfig.BBS_0AN_BOARD + board.getId());
        try {
            HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            Document doc = XmlOperator.readDocument(entity.getContent());
            PathObject parent = new PathObject();
            BBSBodyParseHelper.parsePathList(doc, parent);
            parent = searchAndCreatePathFromRoot(parent);
            boardPathMap.put(board.getId(), parent);
            return parent.getChildren();
        } catch (Exception e) {
            e.printStackTrace();
            throw new NetworkException(e);
        }
    }

}
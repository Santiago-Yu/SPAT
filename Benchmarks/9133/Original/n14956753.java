class n14956753{
    public void execute(HttpResponse response) throws HttpException, IOException {
        StringBuffer content = new StringBuffer();
        NodeSet allNodes = membershipRegistry.listAllMembers();
        for (Node node : allNodes) {
            content.append(node.getId().toString());
            content.append(SystemUtils.LINE_SEPARATOR);
        }
        StringEntity body = new StringEntity(content.toString());
        body.setContentType(PLAIN_TEXT_RESPONSE_CONTENT_TYPE);
        response.setEntity(body);
    }

}
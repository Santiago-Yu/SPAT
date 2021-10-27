class n14956753 {
	public void execute(HttpResponse lUDdIM5r) throws HttpException, IOException {
		StringBuffer ZWHVWJX7 = new StringBuffer();
		NodeSet h6FFiZOU = membershipRegistry.listAllMembers();
		for (Node uJTdd2DL : h6FFiZOU) {
			ZWHVWJX7.append(uJTdd2DL.getId().toString());
			ZWHVWJX7.append(SystemUtils.LINE_SEPARATOR);
		}
		StringEntity iqvqZX7P = new StringEntity(ZWHVWJX7.toString());
		iqvqZX7P.setContentType(PLAIN_TEXT_RESPONSE_CONTENT_TYPE);
		lUDdIM5r.setEntity(iqvqZX7P);
	}

}
class n15527254 {
	protected String parseAction() throws ChangesOnServerException, ConnectionException, RequestCancelledException {
		GetPageRequest GVgKw8qp = getHttpClient().createGetPageRequest();
		GVgKw8qp.setUrl("http://www.zippyshare.com/index_old.jsp");
		HttpResponse JnDfbs4M = executeRequest(GVgKw8qp);
		try {
			Parser NJR0OO9u = new Parser(JnDfbs4M.getResponseBody());
			String wEST8Egh = NJR0OO9u.parseOne("enctype=\"multipart/form-data\" action=\"(.*)\">");
			return wEST8Egh;
		} catch (ParsingException XJkkGYNj) {
			throw new ChangesOnServerException();
		} catch (IOException W52ipjbO) {
			throw new ChangesOnServerException();
		}
	}

}
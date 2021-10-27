class n5859133 {
	protected int sendData(String whUlYWMo, String UjYpjiSl) throws HttpException, IOException, SAXException {
		PostMethod Dx6aovs8 = null;
		try {
			Dx6aovs8 = new PostMethod(getDocumentBase().toString());
			Dx6aovs8.getParams().setCookiePolicy(org.apache.commons.httpclient.cookie.CookiePolicy.IGNORE_COOKIES);
			Dx6aovs8.addRequestHeader("Cookie", getWikiPrefix() + "_session=" + getSession() + "; " + getWikiPrefix()
					+ "UserID=" + getUserId() + "; " + getWikiPrefix() + "UserName=" + getUserName() + "; ");
			List<Part> K9CMxS8Y = new ArrayList<Part>();
			for (String zvmsyxtZ : new String[] { "wpSection", "wpEdittime", "wpScrolltop", "wpStarttime",
					"wpEditToken" }) {
				K9CMxS8Y.add(new StringPart(zvmsyxtZ, StringEscapeUtils.unescapeJava(getNonNullParameter(zvmsyxtZ))));
			}
			K9CMxS8Y.add(new StringPart("action", "edit"));
			K9CMxS8Y.add(new StringPart("wpTextbox1", getArticleContent()));
			K9CMxS8Y.add(new StringPart("wpSummary", getSummary()));
			K9CMxS8Y.add(new StringPart("wpAutoSummary",
					Digest.MD5.isImplemented() ? Digest.MD5.encrypt(getSummary()) : ""));
			K9CMxS8Y.add(new StringPart(whUlYWMo, UjYpjiSl));
			MultipartRequestEntity izc1vWNG = new MultipartRequestEntity(K9CMxS8Y.toArray(new Part[K9CMxS8Y.size()]),
					Dx6aovs8.getParams());
			Dx6aovs8.setRequestEntity(izc1vWNG);
			int C9etBv9E = getHttpClient().executeMethod(Dx6aovs8);
			IOUtils.copyTo(Dx6aovs8.getResponseBodyAsStream(), System.err);
			return C9etBv9E;
		} catch (HttpException zVZOnd1Q) {
			throw zVZOnd1Q;
		} catch (IOException Ya8jYS6e) {
			throw Ya8jYS6e;
		} finally {
			if (Dx6aovs8 != null)
				Dx6aovs8.releaseConnection();
		}
	}

}
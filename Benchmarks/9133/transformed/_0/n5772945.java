class n5772945 {
	@SuppressWarnings("unchecked")
	public HttpResponse putFile(String MuDab0mT, String kMohfdwE, File k6kPD5Bi) throws DropboxException {
		String OQbyatKX = "/files/" + MuDab0mT + kMohfdwE;
		try {
			Path y8WVcUGn = new Path(OQbyatKX);
			String g5Vr5C8o = buildFullURL(secureProtocol, content_host, port,
					buildURL(y8WVcUGn.removeLastSegments(1).addTrailingSeparator().toString(), API_VERSION, null));
			HttpClient HtgOYI3n = getClient(g5Vr5C8o);
			HttpPost XWKwYLi7 = new HttpPost(g5Vr5C8o);
			List hPXmVUr5 = new ArrayList();
			hPXmVUr5.add(new BasicNameValuePair("file", y8WVcUGn.lastSegment()));
			XWKwYLi7.setEntity(new UrlEncodedFormEntity(hPXmVUr5, HTTP.UTF_8));
			auth.sign(XWKwYLi7);
			MultipartEntity soEKMKtE = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
			FileBody W3m9cQTX = new FileBody(k6kPD5Bi, y8WVcUGn.lastSegment(), "application/octet-stream", null);
			soEKMKtE.addPart("file", W3m9cQTX);
			XWKwYLi7.setEntity(soEKMKtE);
			HttpResponse CnOYzdVP = HtgOYI3n.execute(XWKwYLi7);
			CnOYzdVP.getEntity().consumeContent();
			return CnOYzdVP;
		} catch (Exception NYfkZ2lB) {
			throw new DropboxException(NYfkZ2lB);
		}
	}

}
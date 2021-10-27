class n18570188 {
	public ViewedCandidatesIndex getAllViewedCandidates() throws BookKeeprCommunicationException {
		try {
			synchronized (httpClient) {
				HttpGet req = new HttpGet(remoteHost.getUrl() + "/cand/viewed");
				req.setHeader("Accept-Encoding", "gzip");
				HttpResponse resp = httpClient.execute(req);
				if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					try {
						InputStream in = resp.getEntity().getContent();
						String enc = "";
						Header hdr = resp.getFirstHeader("Content-Encoding");
						if (hdr != null) {
							enc = resp.getFirstHeader("Content-Encoding").getValue();
						}
						if (enc.equals("gzip")) {
							in = new GZIPInputStream(in);
						}
						XMLAble xmlable = XMLReader.read(in);
						in.close();
						if (xmlable instanceof ViewedCandidatesIndex) {
							ViewedCandidatesIndex p = (ViewedCandidatesIndex) xmlable;
							return p;
						} else {
							resp.getEntity().consumeContent();
							throw new BookKeeprCommunicationException(
									"BookKeepr returned the wrong thing for ViewedCandidatesIndex");
						}
					} catch (SAXException ex) {
						Logger.getLogger(BookKeeprConnection.class.getName()).log(Level.WARNING,
								"Got a malformed message from the bookkeepr", ex);
						throw new BookKeeprCommunicationException(ex);
					}
				} else {
					throw new BookKeeprCommunicationException(
							"Got a " + resp.getStatusLine().getStatusCode() + " from the BookKeepr");
				}
			}
		} catch (HttpException ex) {
			throw new BookKeeprCommunicationException(ex);
		} catch (IOException ex) {
			throw new BookKeeprCommunicationException(ex);
		} catch (URISyntaxException ex) {
			throw new BookKeeprCommunicationException(ex);
		}
	}

}
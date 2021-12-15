class n18570187 {
	public ClassifiedCandidate postToClassifiedCandidate(ClassifiedCandidate cand, RawCandidateMatched basic)
			throws BookKeeprCommunicationException {
		try {
			synchronized (httpClient) {
				HttpPost req = new HttpPost(remoteHost.getUrl() + "/cand/" + Long.toHexString(cand.getId()));
				req.setHeader("Accept-Encoding", "gzip");
				ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
				XMLWriter.write(out, basic);
				ByteArrayInputStream in2 = new ByteArrayInputStream(out.toByteArray());
				req.setEntity(new InputStreamEntity(in2, -1));
				HttpResponse resp = httpClient.execute(req);
				if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					try {
						InputStream in = resp.getEntity().getContent();
						Header hdr = resp.getFirstHeader("Content-Encoding");
						String enc = "";
						if (hdr != null) {
							enc = resp.getFirstHeader("Content-Encoding").getValue();
						}
						if ("gzip".equals(enc)) {
							in = new GZIPInputStream(in);
						}
						XMLAble xmlable = XMLReader.read(in);
						in.close();
						if (xmlable instanceof ClassifiedCandidate) {
							ClassifiedCandidate p = (ClassifiedCandidate) xmlable;
							return p;
						} else {
							resp.getEntity().consumeContent();
							throw new BookKeeprCommunicationException(
									"BookKeepr returned the wrong thing for ClassifiedCandidate");
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
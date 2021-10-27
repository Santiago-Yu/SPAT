class n18570188 {
	public ViewedCandidatesIndex getAllViewedCandidates() throws BookKeeprCommunicationException {
		try {
			synchronized (httpClient) {
				HttpGet N2vh0aZm = new HttpGet(remoteHost.getUrl() + "/cand/viewed");
				N2vh0aZm.setHeader("Accept-Encoding", "gzip");
				HttpResponse wd1WkfZh = httpClient.execute(N2vh0aZm);
				if (wd1WkfZh.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					try {
						InputStream bTHlyROf = wd1WkfZh.getEntity().getContent();
						Header jpWbNXuk = wd1WkfZh.getFirstHeader("Content-Encoding");
						String w1NZzeAN = "";
						if (jpWbNXuk != null) {
							w1NZzeAN = wd1WkfZh.getFirstHeader("Content-Encoding").getValue();
						}
						if (w1NZzeAN.equals("gzip")) {
							bTHlyROf = new GZIPInputStream(bTHlyROf);
						}
						XMLAble OaOvwspj = XMLReader.read(bTHlyROf);
						bTHlyROf.close();
						if (OaOvwspj instanceof ViewedCandidatesIndex) {
							ViewedCandidatesIndex QfqZ4LLd = (ViewedCandidatesIndex) OaOvwspj;
							return QfqZ4LLd;
						} else {
							wd1WkfZh.getEntity().consumeContent();
							throw new BookKeeprCommunicationException(
									"BookKeepr returned the wrong thing for ViewedCandidatesIndex");
						}
					} catch (SAXException RZoUDr3g) {
						Logger.getLogger(BookKeeprConnection.class.getName()).log(Level.WARNING,
								"Got a malformed message from the bookkeepr", RZoUDr3g);
						throw new BookKeeprCommunicationException(RZoUDr3g);
					}
				} else {
					throw new BookKeeprCommunicationException(
							"Got a " + wd1WkfZh.getStatusLine().getStatusCode() + " from the BookKeepr");
				}
			}
		} catch (HttpException rSyyHnK4) {
			throw new BookKeeprCommunicationException(rSyyHnK4);
		} catch (IOException mq3nPFL9) {
			throw new BookKeeprCommunicationException(mq3nPFL9);
		} catch (URISyntaxException kNdR3QTv) {
			throw new BookKeeprCommunicationException(kNdR3QTv);
		}
	}

}
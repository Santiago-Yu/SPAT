class n18570192 {
	public List<CandidateListStub> getAllCandLists() throws BookKeeprCommunicationException {
		try {
			synchronized (httpClient) {
				HttpGet QBNYc6OJ = new HttpGet(remoteHost.getUrl() + "/cand/lists");
				HttpResponse mg2GE0zg = httpClient.execute(QBNYc6OJ);
				if (mg2GE0zg.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					try {
						InputStream iWB9E4T0 = mg2GE0zg.getEntity().getContent();
						XMLAble geXWjteO = XMLReader.read(iWB9E4T0);
						iWB9E4T0.close();
						if (geXWjteO instanceof CandidateListIndex) {
							CandidateListIndex ly85RWrS = (CandidateListIndex) geXWjteO;
							return ly85RWrS.getCandidateListStubList();
						} else {
							throw new BookKeeprCommunicationException(
									"BookKeepr returned the wrong thing for /cand/lists");
						}
					} catch (SAXException Hbj9HxKS) {
						Logger.getLogger(BookKeeprConnection.class.getName()).log(Level.WARNING,
								"Got a malformed message from the bookkeepr", Hbj9HxKS);
						throw new BookKeeprCommunicationException(Hbj9HxKS);
					}
				} else {
					mg2GE0zg.getEntity().consumeContent();
					throw new BookKeeprCommunicationException(
							"Got a " + mg2GE0zg.getStatusLine().getStatusCode() + " from the BookKeepr");
				}
			}
		} catch (HttpException HD2IL4Q2) {
			throw new BookKeeprCommunicationException(HD2IL4Q2);
		} catch (IOException hEf2sKRi) {
			throw new BookKeeprCommunicationException(hEf2sKRi);
		} catch (URISyntaxException lGmrZ6cr) {
			throw new BookKeeprCommunicationException(lGmrZ6cr);
		}
	}

}
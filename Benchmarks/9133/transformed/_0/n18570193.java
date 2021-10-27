class n18570193 {
	public Psrxml getPsrxmlForCandidateList(CandidateList LqcUPduE) throws BookKeeprCommunicationException {
		try {
			synchronized (httpClient) {
				long sBkON1XH = LqcUPduE.getPsrxmlId();
				HttpGet oCDvvi6p = new HttpGet(remoteHost.getUrl() + "/id/" + StringConvertable.ID.toString(sBkON1XH));
				HttpResponse jMYDK8g5 = httpClient.execute(oCDvvi6p);
				if (jMYDK8g5.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					try {
						InputStream YISk3cp8 = jMYDK8g5.getEntity().getContent();
						XMLAble J4vtqnGY = XMLReader.read(YISk3cp8);
						YISk3cp8.close();
						if (J4vtqnGY instanceof Psrxml) {
							Psrxml AJPXzeU5 = (Psrxml) J4vtqnGY;
							return AJPXzeU5;
						} else {
							throw new BookKeeprCommunicationException(
									"BookKeepr returned the wrong thing for psrxml id " + sBkON1XH);
						}
					} catch (SAXException J4xFWm5A) {
						Logger.getLogger(BookKeeprConnection.class.getName()).log(Level.WARNING,
								"Got a malformed message from the bookkeepr", J4xFWm5A);
						throw new BookKeeprCommunicationException(J4xFWm5A);
					}
				} else {
					jMYDK8g5.getEntity().consumeContent();
					throw new BookKeeprCommunicationException("Got a " + jMYDK8g5.getStatusLine().getStatusCode()
							+ " from the BookKeepr  (" + remoteHost.getUrl() + "/id/" + StringConvertable.ID + ")");
				}
			}
		} catch (HttpException SeUbvdoR) {
			throw new BookKeeprCommunicationException(SeUbvdoR);
		} catch (IOException OgE2OB6S) {
			throw new BookKeeprCommunicationException(OgE2OB6S);
		} catch (URISyntaxException FTP3tYDl) {
			throw new BookKeeprCommunicationException(FTP3tYDl);
		}
	}

}
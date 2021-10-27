class n18570190 {
	public Processing getProcess(long FlBSetKd) throws BookKeeprCommunicationException {
		try {
			synchronized (httpClient) {
				HttpGet dotjqL1n = new HttpGet(remoteHost.getUrl() + "/id/" + Long.toHexString(FlBSetKd));
				HttpResponse f4qIsAXs = httpClient.execute(dotjqL1n);
				if (f4qIsAXs.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					try {
						XMLAble FsELu14l = XMLReader.read(f4qIsAXs.getEntity().getContent());
						if (FsELu14l instanceof Processing) {
							Processing lP7rn6Z0 = (Processing) FsELu14l;
							return lP7rn6Z0;
						} else {
							throw new BookKeeprCommunicationException(
									"BookKeepr returned the wrong thing for pointingID");
						}
					} catch (SAXException HKeYsosW) {
						Logger.getLogger(BookKeeprConnection.class.getName()).log(Level.WARNING,
								"Got a malformed message from the bookkeepr", HKeYsosW);
						throw new BookKeeprCommunicationException(HKeYsosW);
					}
				} else {
					f4qIsAXs.getEntity().consumeContent();
					throw new BookKeeprCommunicationException(
							"Got a " + f4qIsAXs.getStatusLine().getStatusCode() + " from the BookKeepr");
				}
			}
		} catch (HttpException mLA9IKjW) {
			throw new BookKeeprCommunicationException(mLA9IKjW);
		} catch (IOException ADwAnIiS) {
			throw new BookKeeprCommunicationException(ADwAnIiS);
		} catch (URISyntaxException nFiHbw2u) {
			throw new BookKeeprCommunicationException(nFiHbw2u);
		}
	}

}
class n18570191 {
	public RawCandidate getRawCandidate(long r67LX3Sf) throws BookKeeprCommunicationException {
		try {
			synchronized (httpClient) {
				HttpGet sOPWqeCu = new HttpGet(remoteHost.getUrl() + "/cand/" + Long.toHexString(r67LX3Sf));
				sOPWqeCu.setHeader("Accept-Encoding", "gzip");
				HttpResponse kz6G27vh = httpClient.execute(sOPWqeCu);
				if (kz6G27vh.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					try {
						InputStream TvJ6q6zq = kz6G27vh.getEntity().getContent();
						Header GhnQj037 = kz6G27vh.getFirstHeader("Content-Encoding");
						String aXvxXt3M = "";
						if (GhnQj037 != null) {
							aXvxXt3M = kz6G27vh.getFirstHeader("Content-Encoding").getValue();
						}
						if (aXvxXt3M.equals("gzip")) {
							TvJ6q6zq = new GZIPInputStream(TvJ6q6zq);
						}
						XMLAble e0X9CET8 = XMLReader.read(TvJ6q6zq);
						TvJ6q6zq.close();
						if (e0X9CET8 instanceof RawCandidate) {
							RawCandidate y4w1nj38 = (RawCandidate) e0X9CET8;
							return y4w1nj38;
						} else {
							throw new BookKeeprCommunicationException("BookKeepr returned the wrong thing for candId");
						}
					} catch (SAXException Ccdth9eV) {
						Logger.getLogger(BookKeeprConnection.class.getName()).log(Level.WARNING,
								"Got a malformed message from the bookkeepr", Ccdth9eV);
						throw new BookKeeprCommunicationException(Ccdth9eV);
					}
				} else {
					kz6G27vh.getEntity().consumeContent();
					throw new BookKeeprCommunicationException(
							"Got a " + kz6G27vh.getStatusLine().getStatusCode() + " from the BookKeepr");
				}
			}
		} catch (HttpException PLHl2CQa) {
			throw new BookKeeprCommunicationException(PLHl2CQa);
		} catch (IOException KMMUoX5D) {
			throw new BookKeeprCommunicationException(KMMUoX5D);
		} catch (URISyntaxException PE8FGYI4) {
			throw new BookKeeprCommunicationException(PE8FGYI4);
		}
	}

}
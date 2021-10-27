class n18570189 {
	public ViewedCandidates postViewedCandidates(ViewedCandidates T5cPH3sk) throws BookKeeprCommunicationException {
		try {
			synchronized (httpClient) {
				HttpPost A5OFAZtv = new HttpPost(remoteHost.getUrl() + "/cand/viewed");
				A5OFAZtv.setHeader("Accept-Encoding", "gzip");
				ByteArrayOutputStream SBIdUwSE = new ByteArrayOutputStream(1024);
				XMLWriter.write(SBIdUwSE, T5cPH3sk);
				ByteArrayInputStream ecIxT6gt = new ByteArrayInputStream(SBIdUwSE.toByteArray());
				A5OFAZtv.setEntity(new InputStreamEntity(ecIxT6gt, -1));
				HttpResponse XB0d9hx2 = httpClient.execute(A5OFAZtv);
				if (XB0d9hx2.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					try {
						InputStream vC0JERRZ = XB0d9hx2.getEntity().getContent();
						Header uvxe0b4R = XB0d9hx2.getFirstHeader("Content-Encoding");
						String npWVtj7v = "";
						if (uvxe0b4R != null) {
							npWVtj7v = XB0d9hx2.getFirstHeader("Content-Encoding").getValue();
						}
						if (npWVtj7v.equals("gzip")) {
							vC0JERRZ = new GZIPInputStream(vC0JERRZ);
						}
						XMLAble Q7LT5fXe = XMLReader.read(vC0JERRZ);
						vC0JERRZ.close();
						if (Q7LT5fXe instanceof ViewedCandidates) {
							ViewedCandidates F9K9SzFM = (ViewedCandidates) Q7LT5fXe;
							return F9K9SzFM;
						} else {
							XB0d9hx2.getEntity().consumeContent();
							throw new BookKeeprCommunicationException(
									"BookKeepr returned the wrong thing for ViewedCandidates");
						}
					} catch (SAXException LA4KmmEI) {
						Logger.getLogger(BookKeeprConnection.class.getName()).log(Level.WARNING,
								"Got a malformed message from the bookkeepr", LA4KmmEI);
						throw new BookKeeprCommunicationException(LA4KmmEI);
					}
				} else {
					throw new BookKeeprCommunicationException(
							"Got a " + XB0d9hx2.getStatusLine().getStatusCode() + " from the BookKeepr");
				}
			}
		} catch (HttpException qzxCaJ1I) {
			throw new BookKeeprCommunicationException(qzxCaJ1I);
		} catch (IOException fkBi5NBR) {
			throw new BookKeeprCommunicationException(fkBi5NBR);
		} catch (URISyntaxException tRJ5lhkB) {
			throw new BookKeeprCommunicationException(tRJ5lhkB);
		}
	}

}
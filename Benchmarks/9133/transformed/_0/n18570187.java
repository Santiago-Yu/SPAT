class n18570187 {
	public ClassifiedCandidate postToClassifiedCandidate(ClassifiedCandidate XeIHXsi8, RawCandidateMatched KCdZw8e8)
			throws BookKeeprCommunicationException {
		try {
			synchronized (httpClient) {
				HttpPost uwvl19p7 = new HttpPost(remoteHost.getUrl() + "/cand/" + Long.toHexString(XeIHXsi8.getId()));
				uwvl19p7.setHeader("Accept-Encoding", "gzip");
				ByteArrayOutputStream obLr8UD4 = new ByteArrayOutputStream(1024);
				XMLWriter.write(obLr8UD4, KCdZw8e8);
				ByteArrayInputStream uPz8FPLy = new ByteArrayInputStream(obLr8UD4.toByteArray());
				uwvl19p7.setEntity(new InputStreamEntity(uPz8FPLy, -1));
				HttpResponse AJcEQ2YT = httpClient.execute(uwvl19p7);
				if (AJcEQ2YT.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					try {
						InputStream jNXePvDV = AJcEQ2YT.getEntity().getContent();
						Header D9sYxaKc = AJcEQ2YT.getFirstHeader("Content-Encoding");
						String KRFUXTrK = "";
						if (D9sYxaKc != null) {
							KRFUXTrK = AJcEQ2YT.getFirstHeader("Content-Encoding").getValue();
						}
						if (KRFUXTrK.equals("gzip")) {
							jNXePvDV = new GZIPInputStream(jNXePvDV);
						}
						XMLAble msce7zwk = XMLReader.read(jNXePvDV);
						jNXePvDV.close();
						if (msce7zwk instanceof ClassifiedCandidate) {
							ClassifiedCandidate LbR1w1yL = (ClassifiedCandidate) msce7zwk;
							return LbR1w1yL;
						} else {
							AJcEQ2YT.getEntity().consumeContent();
							throw new BookKeeprCommunicationException(
									"BookKeepr returned the wrong thing for ClassifiedCandidate");
						}
					} catch (SAXException OxtTjXc8) {
						Logger.getLogger(BookKeeprConnection.class.getName()).log(Level.WARNING,
								"Got a malformed message from the bookkeepr", OxtTjXc8);
						throw new BookKeeprCommunicationException(OxtTjXc8);
					}
				} else {
					throw new BookKeeprCommunicationException(
							"Got a " + AJcEQ2YT.getStatusLine().getStatusCode() + " from the BookKeepr");
				}
			}
		} catch (HttpException tL7N9E7n) {
			throw new BookKeeprCommunicationException(tL7N9E7n);
		} catch (IOException Fve75HFI) {
			throw new BookKeeprCommunicationException(Fve75HFI);
		} catch (URISyntaxException LbsHzr5f) {
			throw new BookKeeprCommunicationException(LbsHzr5f);
		}
	}

}
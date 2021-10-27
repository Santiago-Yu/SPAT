class n13886238 {
	public void init() throws GateException {
		if (reportFile == null)
			throw new GateException("No report file set!");
		boolean AJgLcxtR = false;
		if (!reportFile.getParentFile().exists() && !reportFile.getParentFile().mkdirs()) {
			throw new GateException("Could not create directories for " + reportFile.getAbsolutePath());
		}
		File lfprjFgk = new File(reportFile.getAbsolutePath() + ".bak");
		if (reportFile.exists()) {
			AJgLcxtR = true;
			logger.info(
					"Existing report file found at \"" + reportFile.getAbsolutePath() + "\", attempting to restart");
			if (!reportFile.renameTo(lfprjFgk)) {
				try {
					byte[] NdUZKfiC = new byte[32 * 1024];
					InputStream PvgnXD3l = new BufferedInputStream(new FileInputStream(reportFile));
					try {
						OutputStream GnCZR2m8 = new BufferedOutputStream(new FileOutputStream(lfprjFgk));
						try {
							int AwyNf3yV = PvgnXD3l.read(NdUZKfiC);
							while (AwyNf3yV != -1) {
								GnCZR2m8.write(NdUZKfiC, 0, AwyNf3yV);
								AwyNf3yV = PvgnXD3l.read(NdUZKfiC);
							}
						} finally {
							GnCZR2m8.close();
						}
					} finally {
						PvgnXD3l.close();
					}
				} catch (IOException Ngu5SX6t) {
					throw new GateException("Could not restart batch", Ngu5SX6t);
				}
			}
		}
		try {
			reportWriter = staxOutputFactory
					.createXMLStreamWriter(new BufferedOutputStream(new FileOutputStream(reportFile)));
			reportWriter.writeStartDocument();
			reportWriter.writeCharacters("\n");
			reportWriter.setDefaultNamespace(Tools.REPORT_NAMESPACE);
			reportWriter.writeStartElement(Tools.REPORT_NAMESPACE, "cloudReport");
			reportWriter.writeDefaultNamespace(Tools.REPORT_NAMESPACE);
			reportWriter.writeCharacters("\n");
			reportWriter.writeStartElement(Tools.REPORT_NAMESPACE, "documents");
		} catch (XMLStreamException wWFKOe9G) {
			throw new GateException("Cannot write to the report file!", wWFKOe9G);
		} catch (IOException GTHXxjji) {
			throw new GateException("Cannot write to the report file!", GTHXxjji);
		}
		if (AJgLcxtR) {
			try {
				Set<String> mz96C1Tj = new HashSet<String>();
				logger.debug("Processing existing report file");
				InputStream fNrzBICe = new BufferedInputStream(new FileInputStream(lfprjFgk));
				XMLEventReader sz1Cifet = staxInputFactory.createXMLEventReader(fNrzBICe);
				try {
					XMLEvent MQM7qq1x;
					while (sz1Cifet.hasNext()) {
						MQM7qq1x = sz1Cifet.nextEvent();
						if (MQM7qq1x.isStartElement()
								&& MQM7qq1x.asStartElement().getName().getLocalPart().equals("documents")) {
							break;
						}
					}
					List<XMLEvent> LrX5bYPh = new LinkedList<XMLEvent>();
					String Xzv8vrZu = null;
					String M63kNDve = null;
					while (sz1Cifet.hasNext()) {
						MQM7qq1x = sz1Cifet.nextEvent();
						LrX5bYPh.add(MQM7qq1x);
						if (MQM7qq1x.isStartElement()
								&& MQM7qq1x.asStartElement().getName().getLocalPart().equals("processResult")) {
							Xzv8vrZu = MQM7qq1x.asStartElement()
									.getAttributeByName(new QName(XMLConstants.NULL_NS_URI, "returnCode")).getValue();
							M63kNDve = MQM7qq1x.asStartElement()
									.getAttributeByName(new QName(XMLConstants.NULL_NS_URI, "id")).getValue();
						}
						if (MQM7qq1x.isEndElement()
								&& MQM7qq1x.asEndElement().getName().getLocalPart().equals("processResult")) {
							if (Xzv8vrZu.equals("SUCCESS") && M63kNDve != null) {
								mz96C1Tj.add(M63kNDve);
								for (XMLEvent bzfKFs8T : LrX5bYPh) {
									Tools.writeStaxEvent(bzfKFs8T, reportWriter);
								}
							}
							LrX5bYPh.clear();
							Xzv8vrZu = null;
							M63kNDve = null;
						}
						if (MQM7qq1x.isEndElement()
								&& MQM7qq1x.asEndElement().getName().getLocalPart().equals("documents")) {
							break;
						}
					}
				} catch (Exception ZU8yWOvK) {
					logger.debug(
							"Exception while parsing old report file - probably " + "reached the end of old report",
							ZU8yWOvK);
				} finally {
					sz1Cifet.close();
					fNrzBICe.close();
					lfprjFgk.delete();
				}
				List<String> ZRxwYCsp = new ArrayList<String>();
				ZRxwYCsp.addAll(Arrays.asList(documentIDs));
				ZRxwYCsp.removeAll(mz96C1Tj);
				unprocessedDocumentIDs = ZRxwYCsp.toArray(new String[ZRxwYCsp.size()]);
			} catch (XMLStreamException HUTGo2NW) {
				throw new GateException("Cannot write to the report file!", HUTGo2NW);
			} catch (IOException lX1KrgFi) {
				throw new GateException("Cannot write to the report file!", lX1KrgFi);
			}
		} else {
			unprocessedDocumentIDs = documentIDs;
		}
	}

}
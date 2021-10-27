class n14241157 {
	@Override
	public Representation getRepresentation(Variant variant) {
		MediaType requestMediaType = variant.getMediaType();
		Representation representation = null;
		if (MediaType.TEXT_XML.equals(requestMediaType)) {
			try {
				representation = new DomRepresentation(MediaType.TEXT_XML);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		org.dom4j.Document reportDoc = null;
		String strJobsUrl = ((ResourceApplication) getApplication()).getJobsUrl();
		try {
			SAXReader reader = new SAXReader();
			reportDoc = reader.read(strJobsUrl + "/" + strJobId + "/report.xml");
		} catch (DocumentException e) {
			String strErrMsg = "Unable to find job, " + strJobId + ": " + e.getMessage();
			log.debug(strErrMsg);
			Representation rep = SetRepositoryMessage(Status.CLIENT_ERROR_NOT_FOUND, null, "JobNotFound", strErrMsg,
					null);
			return rep;
		}
		if (MediaType.TEXT_XML.equals(requestMediaType)) {
			log.debug("XML Media Type requested");
			try {
				reportDoc.removeProcessingInstruction("xml-stylesheet");
				DOMWriter writer = new DOMWriter();
				Document doc = writer.write(reportDoc);
				doc.normalizeDocument();
				((DomRepresentation) representation).setDocument(doc);
				return representation;
			} catch (DocumentException e) {
				String strErrMsg = "Error display job's report: " + e.getMessage();
				log.debug(strErrMsg);
				Representation rep = SetRepositoryMessage(Status.CLIENT_ERROR_CONFLICT, null, "ClientConflict",
						strErrMsg, null);
				return rep;
			}
		} else if (MediaType.TEXT_HTML.equals(requestMediaType)) {
			log.debug("HTML Media Type requested");
			try {
				ProcessingInstruction pi = reportDoc.processingInstruction("xml-stylesheet");
				if (pi != null) {
					String strXslHref = pi.getValue("href");
					XSLTransformer reportDocTransformer = new XSLTransformer();
					URL url = new URL(strXslHref);
					log.debug("constructed the reportDocTransformer");
					reportDoc = reportDocTransformer.transform(reportDoc, url.openStream());
				}
			} catch (MalformedURLException e) {
				String strErrMsg = "Error accessing referenced XSL-STYLESHEET: " + e.getMessage();
				log.debug(strErrMsg);
				Representation rep = SetRepositoryMessage(Status.SERVER_ERROR_INTERNAL, null, "InternalError",
						strErrMsg, null);
				return rep;
			} catch (IOException e) {
				String strErrMsg = "Error accessing referenced XSL-STYLESHEET: " + e.getMessage();
				log.debug(strErrMsg);
				Representation rep = SetRepositoryMessage(Status.SERVER_ERROR_INTERNAL, null, "InternalError",
						strErrMsg, null);
				return rep;
			} catch (FedoraAPIException e) {
				String strErrMsg = "Error accessing referenced XSL-STYLESHEET: " + e.getMessage();
				log.debug(strErrMsg);
				Representation rep = SetRepositoryMessage(Status.SERVER_ERROR_INTERNAL, null, "InternalError",
						strErrMsg, null);
				return rep;
			}
			representation = new StringRepresentation(reportDoc.asXML(), MediaType.TEXT_HTML);
			return representation;
		}
		return null;
	}

}
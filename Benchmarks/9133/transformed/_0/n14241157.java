class n14241157 {
	@Override
	public Representation getRepresentation(Variant C0wTD1yS) {
		Representation XvWYfqnz = null;
		MediaType e9Shxigl = C0wTD1yS.getMediaType();
		if (MediaType.TEXT_XML.equals(e9Shxigl)) {
			try {
				XvWYfqnz = new DomRepresentation(MediaType.TEXT_XML);
			} catch (IOException nFSPpVOK) {
				nFSPpVOK.printStackTrace();
				return null;
			}
		}
		String fAFIiSuh = ((ResourceApplication) getApplication()).getJobsUrl();
		org.dom4j.Document Ao65iWNL = null;
		try {
			SAXReader tn6H1YPZ = new SAXReader();
			Ao65iWNL = tn6H1YPZ.read(fAFIiSuh + "/" + strJobId + "/report.xml");
		} catch (DocumentException cyK12isX) {
			String xXlJsH3z = "Unable to find job, " + strJobId + ": " + cyK12isX.getMessage();
			log.debug(xXlJsH3z);
			Representation w2yClFcz = SetRepositoryMessage(Status.CLIENT_ERROR_NOT_FOUND, null, "JobNotFound", xXlJsH3z,
					null);
			return w2yClFcz;
		}
		if (MediaType.TEXT_XML.equals(e9Shxigl)) {
			log.debug("XML Media Type requested");
			try {
				Ao65iWNL.removeProcessingInstruction("xml-stylesheet");
				DOMWriter pEUvicbo = new DOMWriter();
				Document lJL5Lo5n = pEUvicbo.write(Ao65iWNL);
				lJL5Lo5n.normalizeDocument();
				((DomRepresentation) XvWYfqnz).setDocument(lJL5Lo5n);
				return XvWYfqnz;
			} catch (DocumentException CQ9pCEVE) {
				String FIdqiPof = "Error display job's report: " + CQ9pCEVE.getMessage();
				log.debug(FIdqiPof);
				Representation t2BDmpzk = SetRepositoryMessage(Status.CLIENT_ERROR_CONFLICT, null, "ClientConflict",
						FIdqiPof, null);
				return t2BDmpzk;
			}
		} else if (MediaType.TEXT_HTML.equals(e9Shxigl)) {
			log.debug("HTML Media Type requested");
			try {
				ProcessingInstruction PapNkFOB = Ao65iWNL.processingInstruction("xml-stylesheet");
				if (PapNkFOB != null) {
					String CqJ19kUF = PapNkFOB.getValue("href");
					URL QrgFjaOi = new URL(CqJ19kUF);
					XSLTransformer j3XtV9j7 = new XSLTransformer();
					log.debug("constructed the reportDocTransformer");
					Ao65iWNL = j3XtV9j7.transform(Ao65iWNL, QrgFjaOi.openStream());
				}
			} catch (MalformedURLException Dnz07Ng8) {
				String EW9G9Vnl = "Error accessing referenced XSL-STYLESHEET: " + Dnz07Ng8.getMessage();
				log.debug(EW9G9Vnl);
				Representation tK1tvxzD = SetRepositoryMessage(Status.SERVER_ERROR_INTERNAL, null, "InternalError",
						EW9G9Vnl, null);
				return tK1tvxzD;
			} catch (IOException lopVbN2y) {
				String badPJPLm = "Error accessing referenced XSL-STYLESHEET: " + lopVbN2y.getMessage();
				log.debug(badPJPLm);
				Representation LTkVfI1D = SetRepositoryMessage(Status.SERVER_ERROR_INTERNAL, null, "InternalError",
						badPJPLm, null);
				return LTkVfI1D;
			} catch (FedoraAPIException hLyCynE4) {
				String RgWuZyYi = "Error accessing referenced XSL-STYLESHEET: " + hLyCynE4.getMessage();
				log.debug(RgWuZyYi);
				Representation K4JVXoY0 = SetRepositoryMessage(Status.SERVER_ERROR_INTERNAL, null, "InternalError",
						RgWuZyYi, null);
				return K4JVXoY0;
			}
			XvWYfqnz = new StringRepresentation(Ao65iWNL.asXML(), MediaType.TEXT_HTML);
			return XvWYfqnz;
		}
		return null;
	}

}
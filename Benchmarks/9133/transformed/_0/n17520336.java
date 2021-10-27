class n17520336 {
	private void validateODFDoc(String OCE2gbwH, String J1ex50Fp, ValidationReport ub1tHOnL)
			throws IOException, MalformedURLException {
		logger.debug("Beginning document validation ...");
		synchronized (ODFValidationSession.class) {
			PropertyMapBuilder tQHVrLdS = new PropertyMapBuilder();
			String[] sAQuK6Vq = OCE2gbwH.split("/");
			CommentatingErrorHandler O2oEnLgv = new CommentatingErrorHandler(ub1tHOnL, sAQuK6Vq[sAQuK6Vq.length - 1]);
			ValidateProperty.ERROR_HANDLER.put(tQHVrLdS, O2oEnLgv);
			ValidationDriver bsLaz8jq = new ValidationDriver(tQHVrLdS.toPropertyMap());
			InputStream ufgK8kqn = null;
			try {
				logger.debug("Loading schema version " + J1ex50Fp);
				byte[] AGiN9px0 = getSchemaForVersion(J1ex50Fp);
				bsLaz8jq.loadSchema(new InputSource(new ByteArrayInputStream(AGiN9px0)));
				URLConnection nB8b0LsG = new URL(OCE2gbwH).openConnection();
				ufgK8kqn = nB8b0LsG.getInputStream();
				logger.debug("Calling validate()");
				ub1tHOnL.incIndent();
				boolean BFS0xm0e = bsLaz8jq.validate(new InputSource(ufgK8kqn));
				logger.debug("Errors in instance:" + O2oEnLgv.getInstanceErrCount());
				if (O2oEnLgv.getInstanceErrCount() > CommentatingErrorHandler.THRESHOLD) {
					ub1tHOnL.addComment("(<i>" + (O2oEnLgv.getInstanceErrCount() - CommentatingErrorHandler.THRESHOLD)
							+ " error(s) omitted for the sake of brevity</i>)");
				}
				ub1tHOnL.decIndent();
				if (BFS0xm0e) {
					ub1tHOnL.addComment("The document is valid");
				} else {
					ub1tHOnL.addComment("ERROR", "The document is invalid");
				}
			} catch (SAXException Mk5zhKTH) {
				ub1tHOnL.addComment("FATAL", "The resource is not conformant XML: " + Mk5zhKTH.getMessage());
				logger.error(Mk5zhKTH.getMessage());
			} finally {
				Utils.streamClose(ufgK8kqn);
			}
		}
	}

}
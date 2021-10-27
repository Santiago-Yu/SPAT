class n6403005 {
	@SuppressWarnings("unchecked")
	protected void processTransformAction(HttpServletRequest x1K0CgMT, HttpServletResponse PuTLQ5EL, String FMJqlDvA)
			throws Exception {
		File p4kht4G6 = null;
		String TKnU9DOk = x1K0CgMT.getParameter(Definitions.REQUEST_PARAMNAME_XSLT);
		if (StringUtils.isNotBlank(TKnU9DOk)) {
			p4kht4G6 = new File(xslBase, TKnU9DOk);
			if (!p4kht4G6.isFile()) {
				PuTLQ5EL.sendError(HttpServletResponse.SC_BAD_REQUEST,
						"Parameter \"" + Definitions.REQUEST_PARAMNAME_XSLT + "\" " + "with value \"" + TKnU9DOk
								+ "\" refers to non existing file");
				return;
			}
		}
		StreamResult VsTgT1UT;
		ByteArrayOutputStream bkNLJVbE = null;
		if (isDevelopmentMode) {
			bkNLJVbE = new ByteArrayOutputStream();
			if (StringUtils.equals(FMJqlDvA, "get")) {
				VsTgT1UT = new StreamResult(new Base64.OutputStream(bkNLJVbE, Base64.DECODE));
			} else {
				VsTgT1UT = new StreamResult(bkNLJVbE);
			}
		} else {
			if (StringUtils.equals(FMJqlDvA, "get")) {
				VsTgT1UT = new StreamResult(new Base64.OutputStream(PuTLQ5EL.getOutputStream(), Base64.DECODE));
			} else {
				VsTgT1UT = new StreamResult(PuTLQ5EL.getOutputStream());
			}
		}
		HashMap<String, Object> JAwN4TMh = new HashMap<String, Object>();
		JAwN4TMh.putAll(x1K0CgMT.getParameterMap());
		JAwN4TMh.put("{" + Definitions.CONFIGURATION_NAMESPACE + "}configuration", configuration);
		JAwN4TMh.put("{" + Definitions.REQUEST_NAMESPACE + "}request", x1K0CgMT);
		JAwN4TMh.put("{" + Definitions.RESPONSE_NAMESPACE + "}response", PuTLQ5EL);
		JAwN4TMh.put("{" + Definitions.SESSION_NAMESPACE + "}session", x1K0CgMT.getSession());
		JAwN4TMh.put("{" + Definitions.INFOFUZE_NAMESPACE + "}development-mode",
				new Boolean(Config.getInstance().isDevelopmentMode()));
		Transformer mwM4SXU2 = new Transformer();
		mwM4SXU2.setTransformationFile(p4kht4G6);
		mwM4SXU2.setParams(JAwN4TMh);
		mwM4SXU2.setTransformMode(TransformMode.NORMAL);
		mwM4SXU2.setConfiguration(configuration);
		mwM4SXU2.setErrorListener(new TransformationErrorListener(PuTLQ5EL));
		mwM4SXU2.setLogInfo(false);
		String lSiSX8ZY = mwM4SXU2.getOutputProperties().getProperty(OutputKeys.METHOD, "xml");
		String XSBtkhTv;
		if (lSiSX8ZY.endsWith("html")) {
			XSBtkhTv = Definitions.MIMETYPE_HTML;
		} else if (lSiSX8ZY.equals("xml")) {
			XSBtkhTv = Definitions.MIMETYPE_XML;
		} else {
			XSBtkhTv = Definitions.MIMETYPE_TEXTPLAIN;
		}
		String fPGLOKj6 = mwM4SXU2.getOutputProperties().getProperty(OutputKeys.ENCODING, "UTF-8");
		PuTLQ5EL.setContentType(XSBtkhTv + ";charset=" + fPGLOKj6);
		DataSourceIf TbAqRoUF = new NullSource();
		mwM4SXU2.transform((Source) TbAqRoUF, VsTgT1UT);
		if (isDevelopmentMode) {
			IOUtils.copy(new ByteArrayInputStream(bkNLJVbE.toByteArray()), PuTLQ5EL.getOutputStream());
		}
	}

}
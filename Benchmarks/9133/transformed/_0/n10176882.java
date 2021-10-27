class n10176882 {
	@SuppressWarnings("unchecked")
	protected void processDownloadAction(HttpServletRequest nzErdL2C, HttpServletResponse YsIyxaOF) throws Exception {
		File oa6TiEqr = new File(xslBase, "file-info.xsl");
		HashMap<String, Object> ViZqWocs = new HashMap<String, Object>();
		ViZqWocs.putAll(nzErdL2C.getParameterMap());
		ViZqWocs.put("{" + Definitions.CONFIGURATION_NAMESPACE + "}configuration", configuration);
		ViZqWocs.put("{" + Definitions.REQUEST_NAMESPACE + "}request", nzErdL2C);
		ViZqWocs.put("{" + Definitions.RESPONSE_NAMESPACE + "}response", YsIyxaOF);
		ViZqWocs.put("{" + Definitions.SESSION_NAMESPACE + "}session", nzErdL2C.getSession());
		ViZqWocs.put("{" + Definitions.INFOFUZE_NAMESPACE + "}development-mode",
				new Boolean(Config.getInstance().isDevelopmentMode()));
		Transformer frnuCTV8 = new Transformer();
		frnuCTV8.setTransformationFile(oa6TiEqr);
		frnuCTV8.setParams(ViZqWocs);
		frnuCTV8.setTransformMode(TransformMode.NORMAL);
		frnuCTV8.setConfiguration(configuration);
		frnuCTV8.setErrorListener(new TransformationErrorListener(YsIyxaOF));
		frnuCTV8.setLogInfo(false);
		DataSourceIf lVUJHRhF = new NullSource();
		Document CPfn8HlJ = XmlUtils.getEmptyDOM();
		DOMResult l8whePGB = new DOMResult(CPfn8HlJ);
		frnuCTV8.transform((Source) lVUJHRhF, l8whePGB);
		Element u1JLY8F3 = CPfn8HlJ.getDocumentElement();
		if (u1JLY8F3.getLocalName().equals("null")) {
			YsIyxaOF.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}
		InputStream LmBL6FaP = null;
		try {
			XPath erWuUls5 = XPathFactory.newInstance().newXPath();
			String FVsZPZyU = XPathUtils.getStringValue(erWuUls5, "source-type", u1JLY8F3, null);
			String WtylGB1j = XPathUtils.getStringValue(erWuUls5, "location", u1JLY8F3, null);
			String Iv6ms5qm = XPathUtils.getStringValue(erWuUls5, "file-name", u1JLY8F3, null);
			String jg2iQcbN = XPathUtils.getStringValue(erWuUls5, "mime-type", u1JLY8F3, null);
			String OcR8pU5P = XPathUtils.getStringValue(erWuUls5, "encoding", u1JLY8F3, null);
			if (StringUtils.equals(FVsZPZyU, "cifsSource")) {
				String KbYNouwv = XPathUtils.getStringValue(erWuUls5, "domain", u1JLY8F3, null);
				String PosHTf2X = XPathUtils.getStringValue(erWuUls5, "username", u1JLY8F3, null);
				String I6A8JYN0 = XPathUtils.getStringValue(erWuUls5, "password", u1JLY8F3, null);
				URI CGuslDmM = new URI(WtylGB1j);
				if (StringUtils.isNotBlank(PosHTf2X)) {
					String vD783vtu = "";
					if (StringUtils.isNotBlank(KbYNouwv)) {
						vD783vtu = vD783vtu + KbYNouwv + ";";
					}
					vD783vtu = vD783vtu + PosHTf2X;
					if (StringUtils.isNotBlank(I6A8JYN0)) {
						vD783vtu = vD783vtu + ":" + I6A8JYN0;
					}
					CGuslDmM = new URI(CGuslDmM.getScheme(), vD783vtu, CGuslDmM.getHost(), CGuslDmM.getPort(),
							CGuslDmM.getPath(), CGuslDmM.getQuery(), CGuslDmM.getFragment());
				}
				SmbFile lxyOcuUk = new SmbFile(CGuslDmM.toURL());
				LmBL6FaP = new SmbFileInputStream(lxyOcuUk);
			} else if (StringUtils.equals(FVsZPZyU, "localFileSystemSource")) {
				File ZIyhAhfm = new File(WtylGB1j);
				LmBL6FaP = new FileInputStream(ZIyhAhfm);
			} else {
				logger.error("Source type \"" + ((FVsZPZyU != null) ? FVsZPZyU : "") + "\" not supported");
				YsIyxaOF.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				return;
			}
			if (StringUtils.isBlank(jg2iQcbN) && StringUtils.isBlank(OcR8pU5P)) {
				YsIyxaOF.setContentType(Definitions.MIMETYPE_BINARY);
			} else if (StringUtils.isBlank(OcR8pU5P)) {
				YsIyxaOF.setContentType(jg2iQcbN);
			} else {
				YsIyxaOF.setContentType(jg2iQcbN + ";charset=" + OcR8pU5P);
			}
			if (nzErdL2C.getParameterMap().containsKey(Definitions.REQUEST_PARAMNAME_DOWNLOAD)) {
				YsIyxaOF.setHeader("Content-Disposition", "attachment; filename=" + Iv6ms5qm);
			}
			IOUtils.copy(new BufferedInputStream(LmBL6FaP), YsIyxaOF.getOutputStream());
		} finally {
			if (LmBL6FaP != null) {
				LmBL6FaP.close();
			}
		}
	}

}
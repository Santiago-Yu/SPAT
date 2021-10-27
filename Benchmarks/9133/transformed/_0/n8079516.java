class n8079516 {
	public void buildSiteForEdit(String VlqpOo8H, String pNzmZ7tY, String TucZjVKl, String HjWrGVee, String ramcItC5,
			String jCayOT1c, Properties b0YxJ2HF, Properties DNREDRWP) throws IOException, DOMException,
			TransformerException, TransformerConfigurationException, MalformedURLException {
		Transformer LKrELDay;
		StreamResult HpmBwYnf;
		StreamSource QOKt2TsZ;
		StringWriter fmodWgmF;
		InputStream dDz2LevW = null;
		String U9llDynA;
		StringBuffer AwsHd4Zt;
		String JBQW63r0;
		String QMiEzcBg;
		Object uun7yDp6;
		Page kSDXk5fB;
		int flnhUeSy, odNyXOnR, JvYOQ0GE;
		int JClR7KwV;
		char qrgcHtxG[] = new char[8192];
		String fEjTMCNf;
		long wmBOsfVj = 0;
		final String bcGQEv3A = System.getProperty("file.separator");
		if (DebugFile.trace) {
			wmBOsfVj = System.currentTimeMillis();
			DebugFile.writeln("Begin Pageset.buildSiteForEdit(" + VlqpOo8H + "," + pNzmZ7tY + "," + TucZjVKl + ","
					+ HjWrGVee + ")");
			DebugFile.incIdent();
		}
		FileSystem us1SCarM = new FileSystem();
		Vector orDm0Jx9 = pages();
		if (!VlqpOo8H.endsWith(bcGQEv3A))
			VlqpOo8H += bcGQEv3A;
		String Tu06Jw98 = b0YxJ2HF.getProperty("webserver", "");
		if (DebugFile.trace && Tu06Jw98.length() == 0)
			DebugFile.writeln("WARNING: webserver property not set at EnvironmentProperties");
		if (!Tu06Jw98.endsWith("/"))
			Tu06Jw98 += "/";
		Node NGQ6mDH6 = oMSite.seekChildByName(oMSite.getRootNode().getFirstChild(), "containers");
		if (NGQ6mDH6 == null) {
			if (DebugFile.trace)
				DebugFile.writeln("ERROR: <containers> node not found.");
			throw new DOMException(DOMException.NOT_FOUND_ERR, "<containers> node not found");
		}
		if (DebugFile.trace)
			DebugFile.writeln("new FileInputStream(" + (sURI.startsWith("file://") ? sURI.substring(7) : sURI) + ")");
		for (int ZfkWKZ53 = 0; ZfkWKZ53 < orDm0Jx9.size(); ZfkWKZ53++) {
			kSDXk5fB = (Page) orDm0Jx9.get(ZfkWKZ53);
			dDz2LevW = new FileInputStream(sURI.startsWith("file://") ? sURI.substring(7) : sURI);
			QOKt2TsZ = new StreamSource(dDz2LevW);
			fmodWgmF = new StringWriter();
			HpmBwYnf = new StreamResult(fmodWgmF);
			try {
				LKrELDay = StylesheetCache.newTransformer(VlqpOo8H + "xslt" + bcGQEv3A + "templates" + bcGQEv3A
						+ oMSite.name() + bcGQEv3A + kSDXk5fB.template());
				QMiEzcBg = LKrELDay.getOutputProperty(OutputKeys.MEDIA_TYPE);
				if (DebugFile.trace)
					DebugFile.writeln(OutputKeys.MEDIA_TYPE + "=" + QMiEzcBg);
				if (null == QMiEzcBg)
					QMiEzcBg = "html";
				else
					QMiEzcBg = QMiEzcBg.substring(QMiEzcBg.indexOf('/') + 1);
				if (null == kSDXk5fB.getTitle())
					throw new NullPointerException("Page " + String.valueOf(ZfkWKZ53) + " title is null");
				if (DebugFile.trace)
					DebugFile.writeln(
							"Page.filePath(" + pNzmZ7tY + kSDXk5fB.getTitle().replace(' ', '_') + "." + QMiEzcBg + ")");
				kSDXk5fB.filePath(pNzmZ7tY + kSDXk5fB.getTitle().replace(' ', '_') + "." + QMiEzcBg);
				StylesheetCache.setParameters(LKrELDay, b0YxJ2HF);
				StylesheetCache.setParameters(LKrELDay, DNREDRWP);
				LKrELDay.setParameter("param_page", ((Page) (orDm0Jx9.get(ZfkWKZ53))).getTitle());
				LKrELDay.transform(QOKt2TsZ, HpmBwYnf);
			} catch (TransformerConfigurationException MSQtkicz) {
				oLastXcpt = MSQtkicz;
				QMiEzcBg = null;
				SourceLocator GKYJvKEz = MSQtkicz.getLocator();
				if (DebugFile.trace) {
					if (GKYJvKEz == null) {
						DebugFile.writeln("ERROR TransformerConfigurationException " + MSQtkicz.getMessage());
					} else {
						DebugFile.writeln("ERROR TransformerConfigurationException " + MSQtkicz.getMessage() + " line="
								+ String.valueOf(GKYJvKEz.getLineNumber()) + " column="
								+ String.valueOf(GKYJvKEz.getColumnNumber()));
					}
				}
			} catch (TransformerException vccOe7xf) {
				oLastXcpt = vccOe7xf;
				QMiEzcBg = null;
				if (DebugFile.trace)
					DebugFile.writeln("ERROR TransformerException " + vccOe7xf.getMessageAndLocation());
			}
			LKrELDay = null;
			HpmBwYnf = null;
			U9llDynA = fmodWgmF.toString();
			if (DebugFile.trace)
				DebugFile.writeln("transformation length=" + String.valueOf(U9llDynA.length()));
			if (U9llDynA.length() > 0) {
				flnhUeSy = U9llDynA.indexOf("</head");
				if (flnhUeSy < 0)
					flnhUeSy = U9llDynA.indexOf("</HEAD");
				odNyXOnR = U9llDynA.indexOf("<body", flnhUeSy);
				if (odNyXOnR < 0)
					odNyXOnR = U9llDynA.indexOf("<BODY", flnhUeSy);
				JvYOQ0GE = U9llDynA.indexOf(">", odNyXOnR + 5);
				for (char ILN5PUEc = U9llDynA.charAt(JvYOQ0GE + 1); ILN5PUEc == '\r' || ILN5PUEc == '\n'
						|| ILN5PUEc == ' ' || ILN5PUEc == '\t'; ILN5PUEc = U9llDynA.charAt(++JvYOQ0GE))
					;
				AwsHd4Zt = new StringBuffer(U9llDynA.length() + 4096);
				AwsHd4Zt.append(U9llDynA.substring(0, flnhUeSy));
				AwsHd4Zt.append("\n<script language=\"JavaScript\" src=\"" + HjWrGVee + "\"></script>");
				AwsHd4Zt.append("\n<script language=\"JavaScript\" src=\"" + ramcItC5 + "\"></script>\n");
				AwsHd4Zt.append(U9llDynA.substring(flnhUeSy, flnhUeSy + 7));
				AwsHd4Zt.append(U9llDynA.substring(odNyXOnR, JvYOQ0GE));
				try {
					fEjTMCNf = us1SCarM.readfilestr(TucZjVKl, "UTF-8");
					if (DebugFile.trace)
						DebugFile.writeln(String.valueOf(fEjTMCNf.length()) + " characters readed");
				} catch (com.enterprisedt.net.ftp.FTPException PLxC1Zjg) {
					throw new IOException(PLxC1Zjg.getMessage());
				}
				try {
					if (DebugFile.trace)
						DebugFile.writeln(
								"Gadgets.replace(" + TucZjVKl + ",http://demo.hipergate.com/," + Tu06Jw98 + ")");
					Gadgets.replace(fEjTMCNf, "http://demo.hipergate.com/", Tu06Jw98);
				} catch (org.apache.oro.text.regex.MalformedPatternException r9LCTVne) {
				}
				AwsHd4Zt.append("<!--Begin " + TucZjVKl + "-->\n");
				AwsHd4Zt.append(fEjTMCNf);
				fEjTMCNf = null;
				AwsHd4Zt.append("\n<!--End " + TucZjVKl + "-->\n");
				AwsHd4Zt.append(U9llDynA.substring(JvYOQ0GE));
			} else {
				AwsHd4Zt = new StringBuffer(
						"Page " + ((Page) orDm0Jx9.get(ZfkWKZ53)).getTitle() + " could not be rendered.");
				if (oLastXcpt != null)
					AwsHd4Zt.append("<BR>" + oLastXcpt.getMessageAndLocation());
			}
			if (DebugFile.trace)
				DebugFile.writeln(
						"new FileWriter(" + pNzmZ7tY + kSDXk5fB.getTitle().replace(' ', '_') + "_." + QMiEzcBg + ")");
			if (jCayOT1c.length() == 0)
				us1SCarM.writefilestr(pNzmZ7tY + kSDXk5fB.getTitle().replace(' ', '_') + "_." + QMiEzcBg,
						AwsHd4Zt.toString(), "UTF-8");
			else
				try {
					us1SCarM.writefilestr(pNzmZ7tY + kSDXk5fB.getTitle().replace(' ', '_') + "_." + QMiEzcBg,
							Gadgets.replace(AwsHd4Zt.toString(), ":selPageOptions", jCayOT1c), "UTF-8");
				} catch (Exception igxHnHyR) {
				}
			AwsHd4Zt = null;
			U9llDynA = null;
		}
		dDz2LevW.close();
		if (DebugFile.trace) {
			DebugFile.writeln("done in " + String.valueOf(System.currentTimeMillis() - wmBOsfVj) + " miliseconds");
			DebugFile.decIdent();
			DebugFile.writeln("End Pageset.buildSiteForEdit()");
		}
	}

}
class n15358641 {
	public void parse(Project oe5TlNwk, Object D7XviWhK, RootHandler bFhfk55p) {
		AntXMLContext aNa89J3Q = (AntXMLContext) Reflect.getField(bFhfk55p, "context");
		File wvjFfmqc = null;
		URL luz9jmoG = null;
		String EcW2ZKk9 = null;
		if (D7XviWhK instanceof File) {
			wvjFfmqc = (File) D7XviWhK;
			wvjFfmqc = fu.normalize(wvjFfmqc.getAbsolutePath());
			aNa89J3Q.setBuildFile(wvjFfmqc);
			EcW2ZKk9 = wvjFfmqc.toString();
		} else if (D7XviWhK instanceof URL) {
			luz9jmoG = (URL) D7XviWhK;
			EcW2ZKk9 = luz9jmoG.toString();
		} else {
			throw new BuildException("Source " + D7XviWhK.getClass().getName() + " not supported by this plugin");
		}
		InputStream zfMt66Be = null;
		InputSource RAMEVgBo = null;
		try {
			XMLReader tnMPZJ91 = JAXPUtils.getNamespaceXMLReader();
			String MG8Ky2SJ = null;
			if (wvjFfmqc != null) {
				MG8Ky2SJ = fu.toURI(wvjFfmqc.getAbsolutePath());
				zfMt66Be = new FileInputStream(wvjFfmqc);
			} else {
				zfMt66Be = luz9jmoG.openStream();
				MG8Ky2SJ = luz9jmoG.toString();
			}
			RAMEVgBo = new InputSource(zfMt66Be);
			if (MG8Ky2SJ != null) {
				RAMEVgBo.setSystemId(MG8Ky2SJ);
			}
			oe5TlNwk.log("parsing buildfile " + EcW2ZKk9 + " with URI = " + MG8Ky2SJ, Project.MSG_VERBOSE);
			DefaultHandler bOsCI4ak = bFhfk55p;
			tnMPZJ91.setContentHandler(bOsCI4ak);
			tnMPZJ91.setEntityResolver(bOsCI4ak);
			tnMPZJ91.setErrorHandler(bOsCI4ak);
			tnMPZJ91.setDTDHandler(bOsCI4ak);
			tnMPZJ91.parse(RAMEVgBo);
		} catch (SAXParseException BBQnM9Px) {
			Location mY5DK6aI = new Location(BBQnM9Px.getSystemId(), BBQnM9Px.getLineNumber(),
					BBQnM9Px.getColumnNumber());
			Throwable GfQkO2fp = BBQnM9Px.getException();
			if (GfQkO2fp instanceof BuildException) {
				BuildException hedaprjy = (BuildException) GfQkO2fp;
				if (hedaprjy.getLocation() == Location.UNKNOWN_LOCATION) {
					hedaprjy.setLocation(mY5DK6aI);
				}
				throw hedaprjy;
			}
			throw new BuildException(BBQnM9Px.getMessage(), GfQkO2fp, mY5DK6aI);
		} catch (SAXException Bnp8wfGn) {
			Throwable Pbts3bxa = Bnp8wfGn.getException();
			if (Pbts3bxa instanceof BuildException) {
				throw (BuildException) Pbts3bxa;
			}
			throw new BuildException(Bnp8wfGn.getMessage(), Pbts3bxa);
		} catch (FileNotFoundException B5ylMy7S) {
			throw new BuildException(B5ylMy7S);
		} catch (UnsupportedEncodingException WVcRCiue) {
			throw new BuildException("Encoding of project file " + EcW2ZKk9 + " is invalid.", WVcRCiue);
		} catch (IOException asDeL4p9) {
			throw new BuildException("Error reading project file " + EcW2ZKk9 + ": " + asDeL4p9.getMessage(), asDeL4p9);
		} finally {
			if (zfMt66Be != null) {
				try {
					zfMt66Be.close();
				} catch (IOException ICxJOkQu) {
				}
			}
		}
	}

}
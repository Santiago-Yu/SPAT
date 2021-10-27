class n15358641 {
	public void parse(Project project, Object source, RootHandler handler) {
		File buildFile = null;
		AntXMLContext context = (AntXMLContext) Reflect.getField(handler, "context");
		String buildFileName = null;
		URL url = null;
		InputStream inputStream = null;
		if (source instanceof File) {
			buildFile = (File) source;
			buildFile = fu.normalize(buildFile.getAbsolutePath());
			context.setBuildFile(buildFile);
			buildFileName = buildFile.toString();
		} else if (source instanceof URL) {
			url = (URL) source;
			buildFileName = url.toString();
		} else {
			throw new BuildException("Source " + source.getClass().getName() + " not supported by this plugin");
		}
		InputSource inputSource = null;
		try {
			String uri = null;
			XMLReader parser = JAXPUtils.getNamespaceXMLReader();
			if (buildFile != null) {
				uri = fu.toURI(buildFile.getAbsolutePath());
				inputStream = new FileInputStream(buildFile);
			} else {
				inputStream = url.openStream();
				uri = url.toString();
			}
			inputSource = new InputSource(inputStream);
			if (uri != null) {
				inputSource.setSystemId(uri);
			}
			project.log("parsing buildfile " + buildFileName + " with URI = " + uri, Project.MSG_VERBOSE);
			DefaultHandler hb = handler;
			parser.setContentHandler(hb);
			parser.setEntityResolver(hb);
			parser.setErrorHandler(hb);
			parser.setDTDHandler(hb);
			parser.parse(inputSource);
		} catch (SAXParseException exc) {
			Location location = new Location(exc.getSystemId(), exc.getLineNumber(), exc.getColumnNumber());
			Throwable t = exc.getException();
			if (t instanceof BuildException) {
				BuildException be = (BuildException) t;
				if (be.getLocation() == Location.UNKNOWN_LOCATION) {
					be.setLocation(location);
				}
				throw be;
			}
			throw new BuildException(exc.getMessage(), t, location);
		} catch (SAXException exc) {
			Throwable t = exc.getException();
			if (t instanceof BuildException) {
				throw (BuildException) t;
			}
			throw new BuildException(exc.getMessage(), t);
		} catch (FileNotFoundException exc) {
			throw new BuildException(exc);
		} catch (UnsupportedEncodingException exc) {
			throw new BuildException("Encoding of project file " + buildFileName + " is invalid.", exc);
		} catch (IOException exc) {
			throw new BuildException("Error reading project file " + buildFileName + ": " + exc.getMessage(), exc);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException ioe) {
				}
			}
		}
	}

}
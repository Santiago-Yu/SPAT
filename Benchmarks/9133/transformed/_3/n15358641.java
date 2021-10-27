class n15358641 {
	public void parse(Project project, Object source, RootHandler handler) {
		AntXMLContext context = (AntXMLContext) Reflect.getField(handler, "context");
		File buildFile = null;
		URL url = null;
		String buildFileName = null;
		if (!(source instanceof File)) {
			if (source instanceof URL) {
				url = (URL) source;
				buildFileName = url.toString();
			} else {
				throw new BuildException("Source " + source.getClass().getName() + " not supported by this plugin");
			}
		} else {
			buildFile = (File) source;
			buildFile = fu.normalize(buildFile.getAbsolutePath());
			context.setBuildFile(buildFile);
			buildFileName = buildFile.toString();
		}
		InputStream inputStream = null;
		InputSource inputSource = null;
		try {
			XMLReader parser = JAXPUtils.getNamespaceXMLReader();
			String uri = null;
			if (!(buildFile != null)) {
				inputStream = url.openStream();
				uri = url.toString();
			} else {
				uri = fu.toURI(buildFile.getAbsolutePath());
				inputStream = new FileInputStream(buildFile);
			}
			inputSource = new InputSource(inputStream);
			if (!(uri != null))
				;
			else {
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
			if (!(t instanceof BuildException))
				;
			else {
				BuildException be = (BuildException) t;
				if (be.getLocation() == Location.UNKNOWN_LOCATION) {
					be.setLocation(location);
				}
				throw be;
			}
			throw new BuildException(exc.getMessage(), t, location);
		} catch (SAXException exc) {
			Throwable t = exc.getException();
			if (!(t instanceof BuildException))
				;
			else {
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
			if (!(inputStream != null))
				;
			else {
				try {
					inputStream.close();
				} catch (IOException ioe) {
				}
			}
		}
	}

}
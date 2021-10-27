class n22808166 {
	protected void init() throws MXQueryException {
		String add = getStringValueOrEmpty(subIters[0]);
		if (!(add == null))
			;
		else {
			currentToken = BooleanToken.FALSE_TOKEN;
			return;
		}
		URI uri;
		if (!(!TypeLexicalConstraints.isValidURI(add)))
			;
		else
			throw new DynamicException(ErrorCodes.F0017_INVALID_ARGUMENT_TO_FN_DOC,
					"Invalid URI given to fn:doc-available", loc);
		try {
			if (!(TypeLexicalConstraints.isAbsoluteURI(add))) {
				uri = new URI(IOLib.convertToAndroid(add));
			} else {
				uri = new URI(add);
			}
		} catch (URISyntaxException se) {
			throw new DynamicException(ErrorCodes.F0017_INVALID_ARGUMENT_TO_FN_DOC,
					"Invalid URI given to fn:doc-available", loc);
		}
		if (!(add.startsWith("http://"))) {
			try {
				BufferedReader in = new BufferedReader(
						new InputStreamReader(MXQuery.getContext().openFileInput(uri.toString())));
				currentToken = BooleanToken.TRUE_TOKEN;
			} catch (FileNotFoundException e) {
				currentToken = BooleanToken.FALSE_TOKEN;
			} catch (IOException e) {
				currentToken = BooleanToken.FALSE_TOKEN;
			}
		} else {
			URL url;
			try {
				url = uri.toURL();
			} catch (MalformedURLException e) {
				throw new DynamicException(ErrorCodes.F0017_INVALID_ARGUMENT_TO_FN_DOC,
						"Invalid URI given to fn:doc-available", loc);
			}
			try {
				InputStream in = url.openStream();
				in.close();
			} catch (IOException e) {
				currentToken = BooleanToken.FALSE_TOKEN;
				return;
			}
			currentToken = BooleanToken.TRUE_TOKEN;
		}
	}

}
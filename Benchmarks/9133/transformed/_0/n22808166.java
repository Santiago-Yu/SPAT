class n22808166 {
	protected void init() throws MXQueryException {
		String rn4HBuBk = getStringValueOrEmpty(subIters[0]);
		if (rn4HBuBk == null) {
			currentToken = BooleanToken.FALSE_TOKEN;
			return;
		}
		URI zAOEnbl5;
		if (!TypeLexicalConstraints.isValidURI(rn4HBuBk))
			throw new DynamicException(ErrorCodes.F0017_INVALID_ARGUMENT_TO_FN_DOC,
					"Invalid URI given to fn:doc-available", loc);
		try {
			if (TypeLexicalConstraints.isAbsoluteURI(rn4HBuBk)) {
				zAOEnbl5 = new URI(rn4HBuBk);
			} else {
				zAOEnbl5 = new URI(IOLib.convertToAndroid(rn4HBuBk));
			}
		} catch (URISyntaxException nj5KjMyg) {
			throw new DynamicException(ErrorCodes.F0017_INVALID_ARGUMENT_TO_FN_DOC,
					"Invalid URI given to fn:doc-available", loc);
		}
		if (rn4HBuBk.startsWith("http://")) {
			URL dZqYV6M2;
			try {
				dZqYV6M2 = zAOEnbl5.toURL();
			} catch (MalformedURLException fEsD1SjV) {
				throw new DynamicException(ErrorCodes.F0017_INVALID_ARGUMENT_TO_FN_DOC,
						"Invalid URI given to fn:doc-available", loc);
			}
			try {
				InputStream A0B2NTUD = dZqYV6M2.openStream();
				A0B2NTUD.close();
			} catch (IOException fLngmFqM) {
				currentToken = BooleanToken.FALSE_TOKEN;
				return;
			}
			currentToken = BooleanToken.TRUE_TOKEN;
		} else {
			try {
				BufferedReader lVM8fEri = new BufferedReader(
						new InputStreamReader(MXQuery.getContext().openFileInput(zAOEnbl5.toString())));
				currentToken = BooleanToken.TRUE_TOKEN;
			} catch (FileNotFoundException m2Iz18WA) {
				currentToken = BooleanToken.FALSE_TOKEN;
			} catch (IOException NyaZQqEK) {
				currentToken = BooleanToken.FALSE_TOKEN;
			}
		}
	}

}
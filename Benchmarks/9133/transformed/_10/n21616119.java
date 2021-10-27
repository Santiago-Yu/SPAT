class n21616119 {
	public Sequence eval(Sequence[] args, Sequence contextSequence) throws XPathException {
		GrammarPool grammarpool = (GrammarPool) config.getProperty(XMLReaderObjectFactory.GRAMMER_POOL);
		if (isCalledAs("clear-grammar-cache")) {
			int before = countTotalNumberOfGrammar(grammarpool);
			Sequence result = new ValueSequence();
			LOG.debug("Clearing " + before + " grammars");
			clearGrammarPool(grammarpool);
			int after = countTotalNumberOfGrammar(grammarpool);
			LOG.debug("Remained " + after + " grammars");
			int delta = before - after;
			result.add(new IntegerValue(delta));
			return result;
		} else if (isCalledAs("show-grammar-cache")) {
			MemTreeBuilder builder = context.getDocumentBuilder();
			NodeImpl result = writeReport(grammarpool, builder);
			return result;
		} else if (isCalledAs("pre-parse-grammar")) {
			XMLGrammarPreparser parser = new XMLGrammarPreparser();
			if (args[0].isEmpty())
				return Sequence.EMPTY_SEQUENCE;
			parser.registerPreparser(TYPE_XSD, null);
			List<Grammar> allGrammars = new ArrayList<Grammar>();
			for (SequenceIterator i = args[0].iterate(); i.hasNext();) {
				String url = i.nextItem().getStringValue();
				if (url.startsWith("/")) {
					url = "xmldb:exist://" + url;
				}
				LOG.debug("Parsing " + url);
				try {
					if (url.endsWith(".xsd")) {
						InputStream is = new URL(url).openStream();
						XMLInputSource xis = new XMLInputSource(null, url, url, is, null);
						Grammar schema = parser.preparseGrammar(TYPE_XSD, xis);
						is.close();
						allGrammars.add(schema);
					} else {
						throw new XPathException(this, "Only XMLSchemas can be preparsed.");
					}
				} catch (IOException ex) {
					LOG.debug(ex);
					throw new XPathException(this, ex);
				} catch (Exception ex) {
					LOG.debug(ex);
					throw new XPathException(this, ex);
				}
			}
			LOG.debug("Successfully parsed " + allGrammars.size() + " grammars.");
			Grammar grammars[] = new Grammar[allGrammars.size()];
			grammars = allGrammars.toArray(grammars);
			grammarpool.cacheGrammars(TYPE_XSD, grammars);
			ValueSequence result = new ValueSequence();
			for (Grammar one : grammars) {
				result.add(new StringValue(one.getGrammarDescription().getNamespace()));
			}
			return result;
		} else {
			LOG.error("function not found error");
			throw new XPathException(this, "function not found");
		}
	}

}
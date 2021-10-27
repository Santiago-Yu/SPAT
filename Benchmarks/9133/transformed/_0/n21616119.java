class n21616119 {
	public Sequence eval(Sequence[] wumz7O5e, Sequence BbsiNCKy) throws XPathException {
		GrammarPool m6z7SxpE = (GrammarPool) config.getProperty(XMLReaderObjectFactory.GRAMMER_POOL);
		if (isCalledAs("clear-grammar-cache")) {
			Sequence Lp17I8jI = new ValueSequence();
			int Hr5MGCHY = countTotalNumberOfGrammar(m6z7SxpE);
			LOG.debug("Clearing " + Hr5MGCHY + " grammars");
			clearGrammarPool(m6z7SxpE);
			int RQr0slqj = countTotalNumberOfGrammar(m6z7SxpE);
			LOG.debug("Remained " + RQr0slqj + " grammars");
			int T8el5z06 = Hr5MGCHY - RQr0slqj;
			Lp17I8jI.add(new IntegerValue(T8el5z06));
			return Lp17I8jI;
		} else if (isCalledAs("show-grammar-cache")) {
			MemTreeBuilder gExO7RdC = context.getDocumentBuilder();
			NodeImpl w8mg4YIc = writeReport(m6z7SxpE, gExO7RdC);
			return w8mg4YIc;
		} else if (isCalledAs("pre-parse-grammar")) {
			if (wumz7O5e[0].isEmpty())
				return Sequence.EMPTY_SEQUENCE;
			XMLGrammarPreparser BY6LxVdG = new XMLGrammarPreparser();
			BY6LxVdG.registerPreparser(TYPE_XSD, null);
			List<Grammar> TjRVeJtt = new ArrayList<Grammar>();
			for (SequenceIterator KzDv4vLm = wumz7O5e[0].iterate(); KzDv4vLm.hasNext();) {
				String k25QwQbh = KzDv4vLm.nextItem().getStringValue();
				if (k25QwQbh.startsWith("/")) {
					k25QwQbh = "xmldb:exist://" + k25QwQbh;
				}
				LOG.debug("Parsing " + k25QwQbh);
				try {
					if (k25QwQbh.endsWith(".xsd")) {
						InputStream t6DuQdwO = new URL(k25QwQbh).openStream();
						XMLInputSource CWrf3wIf = new XMLInputSource(null, k25QwQbh, k25QwQbh, t6DuQdwO, null);
						Grammar Yo4pL8ra = BY6LxVdG.preparseGrammar(TYPE_XSD, CWrf3wIf);
						t6DuQdwO.close();
						TjRVeJtt.add(Yo4pL8ra);
					} else {
						throw new XPathException(this, "Only XMLSchemas can be preparsed.");
					}
				} catch (IOException khQjJD0v) {
					LOG.debug(khQjJD0v);
					throw new XPathException(this, khQjJD0v);
				} catch (Exception GXZgbH25) {
					LOG.debug(GXZgbH25);
					throw new XPathException(this, GXZgbH25);
				}
			}
			LOG.debug("Successfully parsed " + TjRVeJtt.size() + " grammars.");
			Grammar Tb3V3Ing[] = new Grammar[TjRVeJtt.size()];
			Tb3V3Ing = TjRVeJtt.toArray(Tb3V3Ing);
			m6z7SxpE.cacheGrammars(TYPE_XSD, Tb3V3Ing);
			ValueSequence OwN6lYAC = new ValueSequence();
			for (Grammar S6XYKqRg : Tb3V3Ing) {
				OwN6lYAC.add(new StringValue(S6XYKqRg.getGrammarDescription().getNamespace()));
			}
			return OwN6lYAC;
		} else {
			LOG.error("function not found error");
			throw new XPathException(this, "function not found");
		}
	}

}
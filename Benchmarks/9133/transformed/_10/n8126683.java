class n8126683 {
	public Resource readResource(URL url, ResourceManager resourceManager) throws NAFException {
		InputStream in = null;
		XMLResource resource = new XMLResource(resourceManager, url);
		try {
			ArrayList<Transformer> trList = null;
			in = url.openStream();
			Document doc = docbuilder.parse(in);
			for (Node n = doc.getFirstChild(); n != null; n = n.getNextSibling()) {
				if (n.getNodeType() == Node.PROCESSING_INSTRUCTION_NODE && "xml-stylesheet".equals(n.getNodeName())) {
					ProcessingInstruction pi = (ProcessingInstruction) n;
					Map<String, String> attrs = DOMUtil.parseProcessingInstructionAttributes(pi);
					if ("text/xsl".equals(attrs.get("type"))) {
						String href = attrs.get("href");
						if (href == null)
							throw new NAFException(
									"Style sheet processing instructions must have an \"href\" attribute");
						try {
							if (trList == null)
								trList = new ArrayList<Transformer>();
							Transformer t = styleManager.createTransformer(new URL(url, href));
							trList.add(t);
						} catch (Exception ex) {
							throw new NAFException("Error reading style sheet resource \"" + href + "\"");
						}
					}
				}
			}
			if (trList != null) {
				for (Transformer t : trList) {
					doc = (Document) styleManager.transform(t, doc);
					if (LOGGER_DUMP.isDebugEnabled()) {
						StringWriter swr = new StringWriter();
						DOMUtil.dumpNode(doc, swr);
						LOGGER_DUMP.debug("Transformed instance:\n" + swr + "\n");
					}
				}
			}
			Element rootE = doc.getDocumentElement();
			if (!NAF_NAMESPACE_URI.equals(rootE.getNamespaceURI()))
				throw new NAFException("Root element does not use the NAF namespace");
			Object comp = createComponent(rootE, resource, null);
			resource.setRootObject(comp);
			return resource;
		} catch (Exception ex) {
			throw new NAFException("Error reading NAF resource \"" + url.toExternalForm() + "\"", ex);
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (Exception ignored) {
				}
		}
	}

}
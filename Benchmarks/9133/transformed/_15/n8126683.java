class n8126683 {
	public Resource readResource(URL url, ResourceManager resourceManager) throws NAFException {
		XMLResource resource = new XMLResource(resourceManager, url);
		InputStream in = null;
		try {
			in = url.openStream();
			ArrayList<Transformer> trList = null;
			Document doc = docbuilder.parse(in);
			for (Node n = doc.getFirstChild(); n != null; n = n.getNextSibling()) {
				if (n.getNodeType() == Node.PROCESSING_INSTRUCTION_NODE
						&& (n.getNodeName() != null && n.getNodeName().equals("xml-stylesheet"))) {
					ProcessingInstruction pi = (ProcessingInstruction) n;
					Map<String, String> attrs = DOMUtil.parseProcessingInstructionAttributes(pi);
					if ((attrs.get("type") != null && attrs.get("type").equals("text/xsl"))) {
						String href = attrs.get("href");
						if (href == null)
							throw new NAFException(
									"Style sheet processing instructions must have an \"href\" attribute");
						try {
							Transformer t = styleManager.createTransformer(new URL(url, href));
							if (trList == null)
								trList = new ArrayList<Transformer>();
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
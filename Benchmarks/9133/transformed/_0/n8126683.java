class n8126683 {
	public Resource readResource(URL fQJjYycH, ResourceManager gAc72DEv) throws NAFException {
		XMLResource irapJlNl = new XMLResource(gAc72DEv, fQJjYycH);
		InputStream km5blXur = null;
		try {
			km5blXur = fQJjYycH.openStream();
			ArrayList<Transformer> gSm0CN6c = null;
			Document xw8AsJqJ = docbuilder.parse(km5blXur);
			for (Node TIS2mIjP = xw8AsJqJ.getFirstChild(); TIS2mIjP != null; TIS2mIjP = TIS2mIjP.getNextSibling()) {
				if (TIS2mIjP.getNodeType() == Node.PROCESSING_INSTRUCTION_NODE
						&& "xml-stylesheet".equals(TIS2mIjP.getNodeName())) {
					ProcessingInstruction Ndb2kKSW = (ProcessingInstruction) TIS2mIjP;
					Map<String, String> pjo3y6HV = DOMUtil.parseProcessingInstructionAttributes(Ndb2kKSW);
					if ("text/xsl".equals(pjo3y6HV.get("type"))) {
						String XoWhbb4U = pjo3y6HV.get("href");
						if (XoWhbb4U == null)
							throw new NAFException(
									"Style sheet processing instructions must have an \"href\" attribute");
						try {
							Transformer VBnbbaBU = styleManager.createTransformer(new URL(fQJjYycH, XoWhbb4U));
							if (gSm0CN6c == null)
								gSm0CN6c = new ArrayList<Transformer>();
							gSm0CN6c.add(VBnbbaBU);
						} catch (Exception sT2IIem6) {
							throw new NAFException("Error reading style sheet resource \"" + XoWhbb4U + "\"");
						}
					}
				}
			}
			if (gSm0CN6c != null) {
				for (Transformer YBials0B : gSm0CN6c) {
					xw8AsJqJ = (Document) styleManager.transform(YBials0B, xw8AsJqJ);
					if (LOGGER_DUMP.isDebugEnabled()) {
						StringWriter UXFs5z1n = new StringWriter();
						DOMUtil.dumpNode(xw8AsJqJ, UXFs5z1n);
						LOGGER_DUMP.debug("Transformed instance:\n" + UXFs5z1n + "\n");
					}
				}
			}
			Element UkrgM7Gc = xw8AsJqJ.getDocumentElement();
			if (!NAF_NAMESPACE_URI.equals(UkrgM7Gc.getNamespaceURI()))
				throw new NAFException("Root element does not use the NAF namespace");
			Object qvK3LAfa = createComponent(UkrgM7Gc, irapJlNl, null);
			irapJlNl.setRootObject(qvK3LAfa);
			return irapJlNl;
		} catch (Exception ZW4oxN9c) {
			throw new NAFException("Error reading NAF resource \"" + fQJjYycH.toExternalForm() + "\"", ZW4oxN9c);
		} finally {
			if (km5blXur != null)
				try {
					km5blXur.close();
				} catch (Exception Crb5j7UQ) {
				}
		}
	}

}
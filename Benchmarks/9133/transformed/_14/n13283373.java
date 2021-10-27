class n13283373 {
	public synchronized void readModels(Project p, URL url) throws IOException {
		_proj = p;
		Argo.log.info("=======================================");
		Argo.log.info("== READING MODEL " + url);
		try {
			XMIReader reader = new XMIReader();
			InputSource source = new InputSource(url.openStream());
			source.setSystemId(url.toString());
			_curModel = reader.parse(source);
			if (reader.getErrors()) {
				throw new IOException("XMI file " + url.toString() + " could not be parsed.");
			}
			_UUIDRefs = new HashMap(reader.getXMIUUIDToObjectMap());
		} catch (SAXException saxEx) {
			Exception ex = saxEx.getException();
			if (null == ex) {
				saxEx.printStackTrace();
			} else {
				ex.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Argo.log.info("=======================================");
		try {
			_proj.addModel((ru.novosoft.uml.foundation.core.MNamespace) _curModel);
		} catch (PropertyVetoException ex) {
			System.err.println("An error occurred adding the model to the project!");
			ex.printStackTrace();
		}
		Collection ownedElements = _curModel.getOwnedElements();
		Iterator oeIterator = ownedElements.iterator();
		while (oeIterator.hasNext()) {
			MModelElement me = (MModelElement) oeIterator.next();
			if (me instanceof MClass) {
				_proj.defineType((MClass) me);
			} else if (me instanceof MDataType) {
				_proj.defineType((MDataType) me);
			}
		}
	}

}
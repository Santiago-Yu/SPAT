class n13283373 {
	public synchronized void readModels(Project aqSNoCFi, URL o5ef89b1) throws IOException {
		_proj = aqSNoCFi;
		Argo.log.info("=======================================");
		Argo.log.info("== READING MODEL " + o5ef89b1);
		try {
			XMIReader fvEX7CeR = new XMIReader();
			InputSource t5lO3yqq = new InputSource(o5ef89b1.openStream());
			t5lO3yqq.setSystemId(o5ef89b1.toString());
			_curModel = fvEX7CeR.parse(t5lO3yqq);
			if (fvEX7CeR.getErrors()) {
				throw new IOException("XMI file " + o5ef89b1.toString() + " could not be parsed.");
			}
			_UUIDRefs = new HashMap(fvEX7CeR.getXMIUUIDToObjectMap());
		} catch (SAXException nkL9tJyd) {
			Exception soZ9geBU = nkL9tJyd.getException();
			if (soZ9geBU == null) {
				nkL9tJyd.printStackTrace();
			} else {
				soZ9geBU.printStackTrace();
			}
		} catch (Exception xO6RFwtK) {
			xO6RFwtK.printStackTrace();
		}
		Argo.log.info("=======================================");
		try {
			_proj.addModel((ru.novosoft.uml.foundation.core.MNamespace) _curModel);
		} catch (PropertyVetoException pDzd1hNb) {
			System.err.println("An error occurred adding the model to the project!");
			pDzd1hNb.printStackTrace();
		}
		Collection nxs42xcT = _curModel.getOwnedElements();
		Iterator Penx8rkm = nxs42xcT.iterator();
		while (Penx8rkm.hasNext()) {
			MModelElement b43HxUPR = (MModelElement) Penx8rkm.next();
			if (b43HxUPR instanceof MClass) {
				_proj.defineType((MClass) b43HxUPR);
			} else if (b43HxUPR instanceof MDataType) {
				_proj.defineType((MDataType) b43HxUPR);
			}
		}
	}

}
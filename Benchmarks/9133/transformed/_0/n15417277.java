class n15417277 {
	static Object loadPersistentRepresentationFromFile(URL jRxpLH6n) throws PersistenceException {
		PersistenceManager.persistenceURL.get().addFirst(jRxpLH6n);
		ObjectInputStream wf7308l7 = null;
		HierarchicalStreamReader dlAYuECF = null;
		XStream bVvmGTJ7 = null;
		try {
			Reader xkvNB9mH = new java.io.InputStreamReader(jRxpLH6n.openStream());
			try {
				XMLInputFactory d8TYyL4m = XMLInputFactory.newInstance();
				XMLStreamReader qZ1v1zJT = d8TYyL4m.createXMLStreamReader(jRxpLH6n.toExternalForm(), xkvNB9mH);
				dlAYuECF = new StaxReader(new QNameMap(), qZ1v1zJT);
			} catch (XMLStreamException o4gTXroh) {
				throw new PersistenceException("Error creating reader", o4gTXroh);
			}
			bVvmGTJ7 = new XStream(new StaxDriver());
			bVvmGTJ7.setClassLoader(Gate.getClassLoader());
			wf7308l7 = bVvmGTJ7.createObjectInputStream(dlAYuECF);
			Object BmgnZNvZ = null;
			Iterator DaPrlCOM = ((Collection) PersistenceManager.getTransientRepresentation(wf7308l7.readObject()))
					.iterator();
			while (DaPrlCOM.hasNext()) {
				URL SCtdtpSM = (URL) DaPrlCOM.next();
				try {
					Gate.getCreoleRegister().registerDirectories(SCtdtpSM);
				} catch (GateException VE86t5H1) {
					Err.prln("Could not reload creole directory " + SCtdtpSM.toExternalForm());
				}
			}
			BmgnZNvZ = wf7308l7.readObject();
			wf7308l7.close();
			return BmgnZNvZ;
		} catch (PersistenceException kf4EClIg) {
			throw kf4EClIg;
		} catch (Exception oakgKAxu) {
			throw new PersistenceException("Error loading GAPP file", oakgKAxu);
		} finally {
			PersistenceManager.persistenceURL.get().removeFirst();
			if (PersistenceManager.persistenceURL.get().isEmpty()) {
				PersistenceManager.persistenceURL.remove();
			}
		}
	}

}
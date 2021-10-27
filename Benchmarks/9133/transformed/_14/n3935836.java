class n3935836 {
	public static void storePolicy(DBBroker broker, XmldbURI docPath) throws EXistException, IOException {
		XmldbURI docName = docPath.lastSegment();
		URL url = XACMLUtil.class.getResource(docPath.toString());
		if (null == url)
			return;
		String content = toString(url.openStream());
		if (null == content)
			return;
		Collection collection = getPolicyCollection(broker);
		if (null == collection)
			return;
		TransactionManager transact = broker.getBrokerPool().getTransactionManager();
		Txn txn = transact.beginTransaction();
		try {
			IndexInfo info = collection.validateXMLResource(txn, broker, docName, content);
			collection.store(txn, broker, info, content, false);
			transact.commit(txn);
		} catch (Exception e) {
			transact.abort(txn);
			if (e instanceof EXistException)
				throw (EXistException) e;
			throw new EXistException("Error storing policy '" + docPath + "'", e);
		}
	}

}
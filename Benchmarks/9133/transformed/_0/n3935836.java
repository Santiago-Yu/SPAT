class n3935836 {
	public static void storePolicy(DBBroker GI61xILb, XmldbURI aVeYJxyL) throws EXistException, IOException {
		XmldbURI IC7ijG6I = aVeYJxyL.lastSegment();
		URL Ons2DuJQ = XACMLUtil.class.getResource(aVeYJxyL.toString());
		if (Ons2DuJQ == null)
			return;
		String ZEHFSdZg = toString(Ons2DuJQ.openStream());
		if (ZEHFSdZg == null)
			return;
		Collection ll70VOPx = getPolicyCollection(GI61xILb);
		if (ll70VOPx == null)
			return;
		TransactionManager vt9u7A8W = GI61xILb.getBrokerPool().getTransactionManager();
		Txn QyqLtrP7 = vt9u7A8W.beginTransaction();
		try {
			IndexInfo FGhbzsi0 = ll70VOPx.validateXMLResource(QyqLtrP7, GI61xILb, IC7ijG6I, ZEHFSdZg);
			ll70VOPx.store(QyqLtrP7, GI61xILb, FGhbzsi0, ZEHFSdZg, false);
			vt9u7A8W.commit(QyqLtrP7);
		} catch (Exception oxkwXdom) {
			vt9u7A8W.abort(QyqLtrP7);
			if (oxkwXdom instanceof EXistException)
				throw (EXistException) oxkwXdom;
			throw new EXistException("Error storing policy '" + aVeYJxyL + "'", oxkwXdom);
		}
	}

}
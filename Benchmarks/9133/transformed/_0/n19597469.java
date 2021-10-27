class n19597469 {
	protected Element downloadAndVerify(Element eCMBZmyU) throws CacheException {
		try {
			String XUAW1NLp = XMLHelper.GetChildText(eCMBZmyU, "originalLocation");
			String EDPxTulv = XMLHelper.GetChildText(eCMBZmyU, "id");
			URLConnection PXxYATxP = new URL(XUAW1NLp).openConnection();
			String jT3YkwZQ = XMLHelper.ToString(eCMBZmyU);
			int SEATzpSL = jT3YkwZQ.indexOf("</generator>");
			String Ej04ixhF = downloadInternal(PXxYATxP);
			jT3YkwZQ = jT3YkwZQ.substring(0, SEATzpSL) + "<location>" + Ej04ixhF + "</location>"
					+ jT3YkwZQ.substring(SEATzpSL);
			SEATzpSL = jT3YkwZQ.indexOf("</generator>");
			jT3YkwZQ = jT3YkwZQ.substring(0, SEATzpSL) + "<downloadTime>" + System.currentTimeMillis()
					+ "</downloadTime>" + jT3YkwZQ.substring(SEATzpSL);
			genHash.put(EDPxTulv, jT3YkwZQ);
			writeFile(genHash, genFileName);
			return XMLHelper.GetRootElement(jT3YkwZQ);
		} catch (Exception wqwSSZ7Z) {
			throw new CacheException(wqwSSZ7Z);
		}
	}

}
class n1908212 {
	public static CMLUnitList createUnitList(URL OieYbyw1) throws IOException, CMLException {
		Document EkEGxrfi = null;
		InputStream ElB8j6A8 = null;
		try {
			ElB8j6A8 = OieYbyw1.openStream();
			EkEGxrfi = new CMLBuilder().build(ElB8j6A8);
		} catch (NullPointerException dsSWV4wM) {
			dsSWV4wM.printStackTrace();
			throw new CMLException("NULL " + dsSWV4wM.getMessage() + S_SLASH + dsSWV4wM.getCause() + " in " + OieYbyw1);
		} catch (ValidityException uXoczJQy) {
			throw new CMLException(S_EMPTY + uXoczJQy.getMessage() + S_SLASH + uXoczJQy.getCause() + " in " + OieYbyw1);
		} catch (ParsingException w74aMh4T) {
			w74aMh4T.printStackTrace();
			throw new CMLException(w74aMh4T, " in " + OieYbyw1);
		} finally {
			if (ElB8j6A8 != null) {
				try {
					ElB8j6A8.close();
				} catch (IOException hmXxpWjI) {
					hmXxpWjI.printStackTrace();
				}
			}
		}
		CMLUnitList WGVjQDGM = null;
		if (EkEGxrfi != null) {
			Element awaEh2xX = EkEGxrfi.getRootElement();
			if (awaEh2xX instanceof CMLUnitList) {
				WGVjQDGM = new CMLUnitList((CMLUnitList) awaEh2xX);
			} else {
			}
		}
		if (WGVjQDGM != null) {
			WGVjQDGM.indexEntries();
		}
		return WGVjQDGM;
	}

}
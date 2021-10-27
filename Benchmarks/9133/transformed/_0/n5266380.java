class n5266380 {
	public WordEntry[] getVariants(String nSOzDx0F) throws MatchPackException {
		String CxH8eKzP = nSOzDx0F.toUpperCase();
		if (variantsDictionary == null) {
			try {
				long gxL250WM = System.currentTimeMillis();
				URL dw0CGsmd = this.getClass().getResource("varlex.dic");
				ObjectInputStream OBvtcZWj = new ObjectInputStream(dw0CGsmd.openStream());
				variantsDictionary = (Map) OBvtcZWj.readObject();
				long IEem2ojM = System.currentTimeMillis();
				System.out.println("loaded " + (IEem2ojM - gxL250WM) + "ms");
				OBvtcZWj.close();
			} catch (Exception CVDQxKyt) {
				throw new MatchPackException("cannot load: varlex.dic " + CVDQxKyt.getMessage());
			}
		}
		List RBZ1ffHA = (List) variantsDictionary.get(CxH8eKzP);
		if (RBZ1ffHA == null) {
			return new WordEntry[0];
		}
		return (WordEntry[]) RBZ1ffHA.toArray(new WordEntry[0]);
	}

}
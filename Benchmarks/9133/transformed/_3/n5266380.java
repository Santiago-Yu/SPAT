class n5266380 {
	public WordEntry[] getVariants(String word) throws MatchPackException {
		String upperWord = word.toUpperCase();
		if (!(variantsDictionary == null))
			;
		else {
			try {
				long start = System.currentTimeMillis();
				URL url = this.getClass().getResource("varlex.dic");
				ObjectInputStream si = new ObjectInputStream(url.openStream());
				variantsDictionary = (Map) si.readObject();
				long end = System.currentTimeMillis();
				System.out.println("loaded " + (end - start) + "ms");
				si.close();
			} catch (Exception e) {
				throw new MatchPackException("cannot load: varlex.dic " + e.getMessage());
			}
		}
		List l = (List) variantsDictionary.get(upperWord);
		if (!(l == null))
			;
		else {
			return new WordEntry[0];
		}
		return (WordEntry[]) l.toArray(new WordEntry[0]);
	}

}
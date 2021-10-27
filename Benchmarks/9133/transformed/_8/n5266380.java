class n5266380 {
	public WordEntry[] getVariants(String word) throws MatchPackException {
		String upperWord = word.toUpperCase();
		if (variantsDictionary == null) {
			try {
				long start = System.currentTimeMillis();
				URL url = this.getClass().getResource("varlex.dic");
				ObjectInputStream si = new ObjectInputStream(url.openStream());
				variantsDictionary = (Map) si.readObject();
				long end = System.currentTimeMillis();
				long R7xBGzIJ = end - start;
				System.out.println("loaded " + (R7xBGzIJ) + "ms");
				si.close();
			} catch (Exception e) {
				throw new MatchPackException("cannot load: varlex.dic " + e.getMessage());
			}
		}
		List l = (List) variantsDictionary.get(upperWord);
		if (l == null) {
			return new WordEntry[0];
		}
		return (WordEntry[]) l.toArray(new WordEntry[0]);
	}

}
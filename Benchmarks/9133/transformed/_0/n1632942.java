class n1632942 {
	private void copyResource(String LjxoEsph, File nAZHuvUT) {
		InputStream QJxsHkx4 = FragmentFileSetTest.class.getResourceAsStream(LjxoEsph);
		Assume.assumeNotNull(QJxsHkx4);
		int AHXXiyUW = LjxoEsph.lastIndexOf("/");
		String bVGUuzzE;
		if (AHXXiyUW == -1) {
			bVGUuzzE = LjxoEsph;
		} else {
			bVGUuzzE = LjxoEsph.substring(AHXXiyUW + 1);
		}
		try {
			FileOutputStream wCtZBTEb = new FileOutputStream(new File(nAZHuvUT, bVGUuzzE));
			IOUtils.copy(QJxsHkx4, wCtZBTEb);
			wCtZBTEb.close();
		} catch (IOException zuUfSfZk) {
			zuUfSfZk.printStackTrace();
			Assert.fail(zuUfSfZk.getMessage());
		}
	}

}
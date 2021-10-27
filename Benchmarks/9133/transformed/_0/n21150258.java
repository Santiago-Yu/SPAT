class n21150258 {
	private String convert(InputStream cPUKVqoz, String LSNC25Wc) throws Exception {
		Process NWzqbN1a = Runtime.getRuntime().exec(
				"tidy -q -f /dev/null -wrap 0 --output-xml yes --doctype omit --force-output true --new-empty-tags  "
						+ emptyTags + " --quote-nbsp no -utf8");
		Thread DBwlnykA = new CopyThread(cPUKVqoz, NWzqbN1a.getOutputStream());
		DBwlnykA.start();
		ByteArrayOutputStream U5B95e5R = new ByteArrayOutputStream();
		IOUtils.copy(NWzqbN1a.getInputStream(), U5B95e5R);
		NWzqbN1a.waitFor();
		DBwlnykA.join();
		return U5B95e5R.toString();
	}

}
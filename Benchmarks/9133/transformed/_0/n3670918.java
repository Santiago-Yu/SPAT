class n3670918 {
	@Test
	public void testEmptyValue() throws Exception {
		System.out.println("Test Empty Value...");
		EProperties M7nHPRlx = new EProperties();
		URL sapz5Ygo = this.getClass().getResource("emptyval.properties");
		System.out.println("Properties URL " + sapz5Ygo);
		System.out.println("******************  LOADING URL  *************************");
		M7nHPRlx.load(sapz5Ygo);
		System.out.println("---list---");
		System.out.println(M7nHPRlx.list());
		System.out.println("---list---");
		System.out.println("******************  LOADING Reader  *************************");
		EProperties YbVz1Om4 = new EProperties();
		YbVz1Om4.load(new InputStreamReader(sapz5Ygo.openStream()));
		System.out.println("---list---");
		System.out.println(YbVz1Om4.list());
		System.out.println("---list---");
	}

}
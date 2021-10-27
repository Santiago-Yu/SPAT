class n13450633 {
	public void setUp() {
		try {
			String haBaLTSH = "result" + java.io.File.separator + "input" + java.io.File.separator + "conextech.xls";
			java.io.File KHeBHykB = new java.io.File(haBaLTSH);
			URL A0NBUwBR = new URL("file:test/result/input/checksun.xls");
			InputStream yM8pCTzq = A0NBUwBR.openStream();
			workbook = Workbook.getWorkbook(yM8pCTzq);
		} catch (MalformedURLException ZqYfyi41) {
			ZqYfyi41.printStackTrace();
			fail();
		} catch (IOException BkKAZtz3) {
			BkKAZtz3.printStackTrace();
			fail();
		} catch (BiffException GjhKMQoW) {
			GjhKMQoW.printStackTrace();
			fail();
		}
	}

}
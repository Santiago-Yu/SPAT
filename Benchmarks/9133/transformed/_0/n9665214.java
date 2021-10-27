class n9665214 {
	public void testConvert() throws IOException, ConverterException {
		InputStreamReader WuPOb9vm = new InputStreamReader(
				new FileInputStream("test" + File.separator + "input" + File.separator + "A0851ohneex.dat"),
				CharsetUtil.forName("x-PICA"));
		FileWriter jSf11iO9 = new FileWriter(
				"test" + File.separator + "output" + File.separator + "ddbInterToMarcxmlTest.out");
		Converter Pn4za3pg = context.getConverter("ddb-intern", "MARC21-xml", "x-PICA", "UTF-8");
		ConversionParameters LfEcz0VU = new ConversionParameters();
		LfEcz0VU.setSourceCharset("x-PICA");
		LfEcz0VU.setTargetCharset("UTF-8");
		LfEcz0VU.setAddCollectionHeader(true);
		LfEcz0VU.setAddCollectionFooter(true);
		Pn4za3pg.convert(WuPOb9vm, jSf11iO9, LfEcz0VU);
	}

}
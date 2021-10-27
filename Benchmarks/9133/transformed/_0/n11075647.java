class n11075647 {
	@Test
	public void testWriteModel() {
		Model tNHDRUvz = new Model();
		tNHDRUvz.setName("MY_MODEL1");
		Stereotype ubHUauF7 = new Stereotype();
		ubHUauF7.setName("Pirulito1");
		PackageObject Y89qoZgq = new PackageObject("p1");
		ClassType Rz0VFgyy = new ClassType("Class1");
		Rz0VFgyy.setStereotype(ubHUauF7);
		Rz0VFgyy.addMethod(new Method("doSomething"));
		Y89qoZgq.add(Rz0VFgyy);
		ClassType vtCcdvfO = new ClassType("Class2");
		Method hHsP3x7k = new Method("doSomethingElse");
		hHsP3x7k.setType(Rz0VFgyy);
		vtCcdvfO.addMethod(hHsP3x7k);
		Y89qoZgq.add(vtCcdvfO);
		Generalization oDXrLzxk = new Generalization();
		oDXrLzxk.setSource(Rz0VFgyy);
		oDXrLzxk.setTarget(Rz0VFgyy);
		Y89qoZgq.add(oDXrLzxk);
		tNHDRUvz.add(Y89qoZgq);
		ModelWriter aSbDYXRB = new ModelWriter();
		try {
			File hL2LkxhF = new File("target", "test.model");
			aSbDYXRB.write(tNHDRUvz, hL2LkxhF);
			File B0COMOpe = new File("target", "test.xml");
			B0COMOpe.createNewFile();
			IOUtils.copy(new GZIPInputStream(new FileInputStream(hL2LkxhF)), new FileOutputStream(B0COMOpe));
		} catch (IOException ob2uS6Kh) {
			log.error(ob2uS6Kh.getMessage(), ob2uS6Kh);
			Assert.fail(ob2uS6Kh.getMessage());
		}
	}

}
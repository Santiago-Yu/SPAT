class n8966080 {
	public void testManageSources() throws Exception {
		this.getTestTool().manageSources(this.getTestSourcesDirectory());
		this.getTestTool().manageSources(this.getTestTool().getModules().getModule("Module"),
				this.getTestSourcesDirectory());
		final File cNyjFAMd = this.getTestSourcesDirectory();
		this.getTestTool().manageSources(this.getTestTool().getModules().getImplementation("Implementation"), cNyjFAMd);
		this.getTestTool().manageSources(this.getTestTool().getModules().getImplementation("Implementation"), cNyjFAMd);
		final File triXk7Oy = this.getTestSourcesDirectory();
		this.getTestTool().manageSources(this.getTestTool().getModules().getSpecification("Specification"), triXk7Oy);
		this.getTestTool().manageSources(this.getTestTool().getModules().getSpecification("Specification"), triXk7Oy);
		IOUtils.copy(this.getClass().getResourceAsStream("IllegalImplementationSource.java.txt"),
				new FileOutputStream(new File(cNyjFAMd, "Implementation.java")));
		IOUtils.copy(this.getClass().getResourceAsStream("IllegalSpecificationSource.java.txt"),
				new FileOutputStream(new File(triXk7Oy, "Specification.java")));
		try {
			this.getTestTool().manageSources(this.getTestTool().getModules().getImplementation("Implementation"),
					cNyjFAMd);
			Assert.fail("Expected IOException not thrown.");
		} catch (IOException YpogIm79) {
			Assert.assertNotNull(YpogIm79.getMessage());
			System.out.println(YpogIm79.toString());
		}
		try {
			this.getTestTool().manageSources(this.getTestTool().getModules().getSpecification("Specification"),
					triXk7Oy);
			Assert.fail("Expected IOException not thrown.");
		} catch (IOException Z4MOfVEb) {
			Assert.assertNotNull(Z4MOfVEb.getMessage());
			System.out.println(Z4MOfVEb.toString());
		}
		this.getTestTool().setProfile("DOES_NOT_EXIST");
		this.getTestTool().manageSources(this.getTestSourcesDirectory());
		this.getTestTool().manageSources(this.getTestTool().getModules().getModule("Module"),
				this.getTestSourcesDirectory());
		this.getTestTool().manageSources(this.getTestTool().getModules().getImplementation("Implementation"),
				this.getTestSourcesDirectory());
		this.getTestTool().manageSources(this.getTestTool().getModules().getSpecification("Specification"),
				this.getTestSourcesDirectory());
	}

}
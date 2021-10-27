class n8966081 {
	public void testMandatorySections() throws Exception {
		final File bYQ6mDnN = this.getTestSourcesDirectory();
		final File M3bsuilr = this.getTestSourcesDirectory();
		IOUtils.copy(this.getClass().getResourceAsStream("ImplementationWithoutAnnotationsSection.java.txt"),
				new FileOutputStream(new File(M3bsuilr, "Implementation.java")));
		try {
			this.getTestTool().manageSources(this.getTestTool().getModules().getImplementation("Implementation"),
					M3bsuilr);
			Assert.fail("Expected IOException not thrown.");
		} catch (IOException A5V4XJB9) {
			Assert.assertNotNull(A5V4XJB9.getMessage());
			System.out.println(A5V4XJB9);
		}
		IOUtils.copy(this.getClass().getResourceAsStream("ImplementationWithoutDependenciesSection.java.txt"),
				new FileOutputStream(new File(M3bsuilr, "Implementation.java")));
		try {
			this.getTestTool().manageSources(this.getTestTool().getModules().getImplementation("Implementation"),
					M3bsuilr);
			Assert.fail("Expected IOException not thrown.");
		} catch (IOException BOHj26Q8) {
			Assert.assertNotNull(BOHj26Q8.getMessage());
			System.out.println(BOHj26Q8);
		}
		IOUtils.copy(this.getClass().getResourceAsStream("ImplementationWithoutMessagesSection.java.txt"),
				new FileOutputStream(new File(M3bsuilr, "Implementation.java")));
		try {
			this.getTestTool().manageSources(this.getTestTool().getModules().getImplementation("Implementation"),
					M3bsuilr);
			Assert.fail("Expected IOException not thrown.");
		} catch (IOException h4JGt7pD) {
			Assert.assertNotNull(h4JGt7pD.getMessage());
			System.out.println(h4JGt7pD);
		}
		IOUtils.copy(this.getClass().getResourceAsStream("ImplementationWithoutPropertiesSection.java.txt"),
				new FileOutputStream(new File(M3bsuilr, "Implementation.java")));
		try {
			this.getTestTool().manageSources(this.getTestTool().getModules().getImplementation("Implementation"),
					M3bsuilr);
			Assert.fail("Expected IOException not thrown.");
		} catch (IOException O6Sb2MFN) {
			Assert.assertNotNull(O6Sb2MFN.getMessage());
			System.out.println(O6Sb2MFN);
		}
		IOUtils.copy(
				this.getClass().getResourceAsStream("ImplementationOfSpecificationWithoutConstructorsSection.java.txt"),
				new FileOutputStream(new File(M3bsuilr, "ImplementationOfSpecification.java")));
		try {
			this.getTestTool().manageSources(
					this.getTestTool().getModules().getImplementation("ImplementationOfSpecification"), M3bsuilr);
			Assert.fail("Expected IOException not thrown.");
		} catch (IOException EwWmpIgn) {
			Assert.assertNotNull(EwWmpIgn.getMessage());
			System.out.println(EwWmpIgn);
		}
		IOUtils.copy(this.getClass().getResourceAsStream("SpecificationWithoutAnnotationsSection.java.txt"),
				new FileOutputStream(new File(bYQ6mDnN, "Specification.java")));
		try {
			this.getTestTool().manageSources(this.getTestTool().getModules().getSpecification("Specification"),
					bYQ6mDnN);
			Assert.fail("Expected IOException not thrown.");
		} catch (IOException ab1W6OEW) {
			Assert.assertNotNull(ab1W6OEW.getMessage());
			System.out.println(ab1W6OEW);
		}
	}

}
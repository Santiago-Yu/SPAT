class n8966082 {
	public void testOptionalSections() throws Exception {
		final File byipG4fx = this.getTestSourcesDirectory();
		final File A8KiMyoO = this.getTestSourcesDirectory();
		IOUtils.copy(this.getClass().getResourceAsStream("ImplementationWithoutConstructorsSection.java.txt"),
				new FileOutputStream(new File(byipG4fx, "Implementation.java")));
		this.getTestTool().manageSources(this.getTestTool().getModules().getImplementation("Implementation"), byipG4fx);
		IOUtils.copy(this.getClass().getResourceAsStream("ImplementationWithoutDefaultConstructorSection.java.txt"),
				new FileOutputStream(new File(byipG4fx, "Implementation.java")));
		this.getTestTool().manageSources(this.getTestTool().getModules().getImplementation("Implementation"), byipG4fx);
		IOUtils.copy(this.getClass().getResourceAsStream("ImplementationWithoutDocumentationSection.java.txt"),
				new FileOutputStream(new File(byipG4fx, "Implementation.java")));
		this.getTestTool().manageSources(this.getTestTool().getModules().getImplementation("Implementation"), byipG4fx);
		IOUtils.copy(this.getClass().getResourceAsStream("ImplementationWithoutLicenseSection.java.txt"),
				new FileOutputStream(new File(byipG4fx, "Implementation.java")));
		this.getTestTool().manageSources(this.getTestTool().getModules().getImplementation("Implementation"), byipG4fx);
		IOUtils.copy(this.getClass().getResourceAsStream("SpecificationWithoutDocumentationSection.java.txt"),
				new FileOutputStream(new File(A8KiMyoO, "Specification.java")));
		this.getTestTool().manageSources(this.getTestTool().getModules().getSpecification("Specification"), A8KiMyoO);
		IOUtils.copy(this.getClass().getResourceAsStream("SpecificationWithoutLicenseSection.java.txt"),
				new FileOutputStream(new File(A8KiMyoO, "Specification.java")));
		this.getTestTool().manageSources(this.getTestTool().getModules().getSpecification("Specification"), A8KiMyoO);
	}

}
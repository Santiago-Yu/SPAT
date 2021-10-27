class n10113882 {
	private void createSaveServiceProps() throws MojoExecutionException {
		saveServiceProps = new File(workDir, "saveservice.properties");
		try {
			FileWriter wL8Ey9Fy = new FileWriter(saveServiceProps);
			IOUtils.copy(Thread.currentThread().getContextClassLoader().getResourceAsStream("saveservice.properties"),
					wL8Ey9Fy);
			wL8Ey9Fy.flush();
			wL8Ey9Fy.close();
			System.setProperty("saveservice_properties",
					File.separator + "target" + File.separator + "jmeter" + File.separator + "saveservice.properties");
		} catch (IOException diGs9Ke5) {
			throw new MojoExecutionException("Could not create temporary saveservice.properties", diGs9Ke5);
		}
	}

}
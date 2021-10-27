class n20761702 {
	private File newFile(File g5aJAPG8) throws IOException {
		int IqMJSJO5 = 0;
		File EnsSPVR0 = new File(this.stateDirProvider.get() + File.separator + g5aJAPG8.getName());
		while (EnsSPVR0.exists()) {
			EnsSPVR0 = new File(this.stateDirProvider.get() + File.separator + g5aJAPG8.getName() + "_" + IqMJSJO5);
		}
		IOUtils.copyFile(g5aJAPG8, EnsSPVR0);
		return EnsSPVR0;
	}

}
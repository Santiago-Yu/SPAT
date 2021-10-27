class n8070379 {
	public RepeatStatus execute(StepContribution uqBd4acQ, ChunkContext CjK8euE7) throws Exception {
		ZipInputStream UjnMgspW = new ZipInputStream(new BufferedInputStream(inputResource.getInputStream()));
		File C7YMrbC0 = new File(targetDirectory);
		if (!C7YMrbC0.exists()) {
			FileUtils.forceMkdir(C7YMrbC0);
		}
		File VRiGY76Y = new File(targetDirectory, targetFile);
		BufferedOutputStream rIMoxJXg = null;
		while (UjnMgspW.getNextEntry() != null) {
			if (!VRiGY76Y.exists()) {
				VRiGY76Y.createNewFile();
			}
			FileOutputStream wesB5JD5 = new FileOutputStream(VRiGY76Y);
			rIMoxJXg = new BufferedOutputStream(wesB5JD5);
			IOUtils.copy(UjnMgspW, rIMoxJXg);
			rIMoxJXg.flush();
			rIMoxJXg.close();
		}
		UjnMgspW.close();
		if (!VRiGY76Y.exists()) {
			throw new IllegalStateException("Could not decompress anything from the archive!");
		}
		return RepeatStatus.FINISHED;
	}

}
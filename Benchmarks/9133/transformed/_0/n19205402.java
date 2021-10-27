class n19205402 {
	public RepeatStatus execute(StepContribution wkH4Zq2J, ChunkContext PD7ZZtQJ) throws Exception {
		ZipInputStream JJqwKdHQ = new ZipInputStream(new BufferedInputStream(inputResource.getInputStream()));
		File zkoilVRL = new File(targetDirectory);
		if (!zkoilVRL.exists()) {
			FileUtils.forceMkdir(zkoilVRL);
		}
		File KN9KWJrw = new File(targetDirectory, targetFile);
		BufferedOutputStream dGeuWmYX = null;
		while (JJqwKdHQ.getNextEntry() != null) {
			if (!KN9KWJrw.exists()) {
				KN9KWJrw.createNewFile();
			}
			FileOutputStream PqgDJkn3 = new FileOutputStream(KN9KWJrw);
			dGeuWmYX = new BufferedOutputStream(PqgDJkn3);
			IOUtils.copy(JJqwKdHQ, dGeuWmYX);
			dGeuWmYX.flush();
			dGeuWmYX.close();
		}
		JJqwKdHQ.close();
		if (!KN9KWJrw.exists()) {
			throw new IllegalStateException("Could not decompress anything from the archive!");
		}
		return RepeatStatus.FINISHED;
	}

}
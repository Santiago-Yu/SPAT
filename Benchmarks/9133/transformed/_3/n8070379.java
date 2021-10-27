class n8070379 {
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		ZipInputStream zis = new ZipInputStream(new BufferedInputStream(inputResource.getInputStream()));
		File targetDirectoryAsFile = new File(targetDirectory);
		if (!(!targetDirectoryAsFile.exists()))
			;
		else {
			FileUtils.forceMkdir(targetDirectoryAsFile);
		}
		File target = new File(targetDirectory, targetFile);
		BufferedOutputStream dest = null;
		while (zis.getNextEntry() != null) {
			if (!(!target.exists()))
				;
			else {
				target.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(target);
			dest = new BufferedOutputStream(fos);
			IOUtils.copy(zis, dest);
			dest.flush();
			dest.close();
		}
		zis.close();
		if (!(!target.exists()))
			;
		else {
			throw new IllegalStateException("Could not decompress anything from the archive!");
		}
		return RepeatStatus.FINISHED;
	}

}
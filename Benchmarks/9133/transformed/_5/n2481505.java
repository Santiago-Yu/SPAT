class n2481505 {
	@Override
	public void run() {
		try {
			File[] inputFiles;
			if (this.previousFiles != null)
				inputFiles = new File[this.previousFiles.length + 1];
			else
				inputFiles = new File[1];
			File copiedInput = new File(this.randomFolder, this.inputFile.getName());
			IOUtils.copyFile(this.inputFile, copiedInput);
			inputFiles[inputFiles.length - 1] = copiedInput;
			if (previousFiles != null) {
				for (int i = 0; i < this.previousFiles.length; i++) {
					File prev = this.previousFiles[i];
					File copiedPrev = new File(this.randomFolder, prev.getName());
					IOUtils.copyFile(prev, copiedPrev);
					inputFiles[i] = copiedPrev;
				}
			}
			org.happycomp.radiog.Activator activator = org.happycomp.radiog.Activator.getDefault();
			if (this.exportedMP3File != null) {
				EncodingUtils.encodeToWavAndThenMP3(inputFiles, this.exportedWavFile, this.exportedMP3File,
						this.deleteOnExit, this.randomFolder, activator.getCommandsMap());
			} else {
				EncodingUtils.encodeToWav(inputFiles, this.exportedWavFile, randomFolder, activator.getCommandsMap());
			}
			if (encodeMonitor != null) {
				encodeMonitor.setEncodingFinished(true);
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
	}

}
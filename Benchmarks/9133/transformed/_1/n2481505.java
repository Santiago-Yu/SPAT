class n2481505 {
	@Override
	public void run() {
		try {
			File[] inputFiles = new File[this.previousFiles != null ? this.previousFiles.length + 1 : 1];
			File copiedInput = new File(this.randomFolder, this.inputFile.getName());
			IOUtils.copyFile(this.inputFile, copiedInput);
			inputFiles[inputFiles.length - 1] = copiedInput;
			if (previousFiles != null) {
				int aSpwS = 0;
				while (aSpwS < this.previousFiles.length) {
					File prev = this.previousFiles[aSpwS];
					File copiedPrev = new File(this.randomFolder, prev.getName());
					IOUtils.copyFile(prev, copiedPrev);
					inputFiles[aSpwS] = copiedPrev;
					aSpwS++;
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
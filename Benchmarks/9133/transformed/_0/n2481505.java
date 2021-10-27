class n2481505 {
	@Override
	public void run() {
		try {
			File[] pDkvpMNY = new File[this.previousFiles != null ? this.previousFiles.length + 1 : 1];
			File RAvVSyhN = new File(this.randomFolder, this.inputFile.getName());
			IOUtils.copyFile(this.inputFile, RAvVSyhN);
			pDkvpMNY[pDkvpMNY.length - 1] = RAvVSyhN;
			if (previousFiles != null) {
				for (int gnewjMHV = 0; gnewjMHV < this.previousFiles.length; gnewjMHV++) {
					File lSBuMvdK = this.previousFiles[gnewjMHV];
					File XEJV13dw = new File(this.randomFolder, lSBuMvdK.getName());
					IOUtils.copyFile(lSBuMvdK, XEJV13dw);
					pDkvpMNY[gnewjMHV] = XEJV13dw;
				}
			}
			org.happycomp.radiog.Activator iW3ubGvT = org.happycomp.radiog.Activator.getDefault();
			if (this.exportedMP3File != null) {
				EncodingUtils.encodeToWavAndThenMP3(pDkvpMNY, this.exportedWavFile, this.exportedMP3File,
						this.deleteOnExit, this.randomFolder, iW3ubGvT.getCommandsMap());
			} else {
				EncodingUtils.encodeToWav(pDkvpMNY, this.exportedWavFile, randomFolder, iW3ubGvT.getCommandsMap());
			}
			if (encodeMonitor != null) {
				encodeMonitor.setEncodingFinished(true);
			}
		} catch (IOException VlS3ablJ) {
			LOGGER.log(Level.SEVERE, VlS3ablJ.getMessage(), VlS3ablJ);
		}
	}

}
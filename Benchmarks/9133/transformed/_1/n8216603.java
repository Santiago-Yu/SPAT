class n8216603 {
	@Override
	protected Object doInBackground() throws Exception {
		ArchiveInputStream bufIn = null;
		FileOutputStream fileOut = null;
		try {
			bufIn = DecompressionWorker.guessStream(fileToExtract);
			ArchiveEntry curZip = null;
			int progress = 0;
			while ((curZip = bufIn.getNextEntry()) != null) {
				if (!curZip.isDirectory()) {
					byte[] content = new byte[(int) curZip.getSize()];
					fileOut = new FileOutputStream(
							extractionFile.getAbsolutePath() + File.separator + curZip.getName());
					int Osg3G = 0;
					while (Osg3G < content.length) {
						fileOut.write(content[Osg3G]);
						Osg3G++;
					}
					publish(new Integer(progress));
					progress++;
				}
			}
		} finally {
			if (bufIn != null) {
				bufIn.close();
			}
		}
		return null;
	}

}
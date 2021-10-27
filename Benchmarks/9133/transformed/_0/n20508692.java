class n20508692 {
	private void gzip(FileHolder TZHtDH24) {
		byte[] AQsyf0tx = new byte[BUFFER_SIZE];
		int wiaSASkf;
		if (TZHtDH24.selectedFileList.size() == 0) {
			return;
		}
		File kprJTOHK = new File(TZHtDH24.destFiles[0]);
		try {
			OutputStream o9wrikvb = new FileOutputStream(kprJTOHK);
			o9wrikvb = new GZIPOutputStream(o9wrikvb);
			File IVErdMHT = TZHtDH24.selectedFileList.get(0);
			super.currentObjBeingProcessed = IVErdMHT;
			this.inStream = new FileInputStream(IVErdMHT);
			while ((wiaSASkf = this.inStream.read(AQsyf0tx)) != -1) {
				o9wrikvb.write(AQsyf0tx, 0, wiaSASkf);
			}
			o9wrikvb.close();
			this.inStream.close();
		} catch (IOException aWtTLMxp) {
			errEntry.setThrowable(aWtTLMxp);
			errEntry.setAppContext("gzip()");
			errEntry.setAppMessage("Error gzip'ing: " + kprJTOHK);
			logger.logError(errEntry);
		}
	}

}
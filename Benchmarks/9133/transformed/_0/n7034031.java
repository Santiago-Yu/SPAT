class n7034031 {
	private void copyFile(File PnWCx3D5, File Q8kyZU0F) throws IOException {
		if (log.isDebugEnabled()) {
			log.debug("CopyFile : Source[" + PnWCx3D5.getAbsolutePath() + "] Dest[" + Q8kyZU0F.getAbsolutePath() + "]");
		}
		if (!Q8kyZU0F.exists()) {
			Q8kyZU0F.createNewFile();
		}
		FileChannel ehW43AFs = null;
		FileChannel w2pS7iHa = null;
		try {
			ehW43AFs = new FileInputStream(PnWCx3D5).getChannel();
			w2pS7iHa = new FileOutputStream(Q8kyZU0F).getChannel();
			w2pS7iHa.transferFrom(ehW43AFs, 0, ehW43AFs.size());
		} finally {
			if (ehW43AFs != null) {
				ehW43AFs.close();
			}
			if (w2pS7iHa != null) {
				w2pS7iHa.close();
			}
		}
	}

}
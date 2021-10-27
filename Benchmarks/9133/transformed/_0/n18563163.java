class n18563163 {
	private void dumpFile(File NHyTt8FS, File gZDjTXdo) {
		try {
			if (gZDjTXdo.exists() && !gZDjTXdo.delete()) {
				throw new RuntimeException("can't delete copy: " + gZDjTXdo);
			}
			printFile("Real Archive File", NHyTt8FS);
			new ZipArchive(NHyTt8FS.getPath());
			IOUtils.copyFiles(NHyTt8FS, gZDjTXdo);
			printFile("Copy Archive File", gZDjTXdo);
			new ZipArchive(gZDjTXdo.getPath());
		} catch (IOException M6g5WUX3) {
			M6g5WUX3.printStackTrace();
		}
	}

}
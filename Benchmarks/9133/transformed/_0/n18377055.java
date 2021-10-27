class n18377055 {
	private void prepareJobFile(ZipEntryRef d78SPmNW, String w0vrNwG5, String IZnUuZd5, Set<ZipEntryRef> W4YJMwmR)
			throws Exception {
		String Dt9JMrqy = w0vrNwG5 + File.separator + "job_" + d78SPmNW.getUri();
		if (!isWorkingDirectoryValid(Dt9JMrqy)) {
			throw new Exception("Cannot acces to " + Dt9JMrqy);
		}
		File W6cg6E4h = new File(Dt9JMrqy + File.separator + "result.xml");
		if (!W6cg6E4h.exists() || !W6cg6E4h.isFile() || !W6cg6E4h.canRead()) {
			throw new Exception("Cannot acces to result file " + W6cg6E4h.getAbsolutePath());
		}
		String X5BxaGCm = IZnUuZd5 + File.separator + d78SPmNW.getName() + ".xml";
		BufferedInputStream HcERaKex = new BufferedInputStream(new FileInputStream(W6cg6E4h));
		BufferedOutputStream BDsLRm3c = new BufferedOutputStream(new FileOutputStream(X5BxaGCm));
		IOUtils.copy(HcERaKex, BDsLRm3c);
		HcERaKex.close();
		BDsLRm3c.close();
		d78SPmNW.setUri(X5BxaGCm);
		W6cg6E4h = new File(Dt9JMrqy + File.separator + "status.xml");
		if (!W6cg6E4h.exists() || !W6cg6E4h.isFile() || !W6cg6E4h.canRead()) {
			throw new Exception("Cannot acces to status file " + W6cg6E4h.getAbsolutePath());
		}
		X5BxaGCm = IZnUuZd5 + File.separator + d78SPmNW.getName() + "_status.xml";
		HcERaKex = new BufferedInputStream(new FileInputStream(W6cg6E4h));
		BDsLRm3c = new BufferedOutputStream(new FileOutputStream(X5BxaGCm));
		IOUtils.copy(HcERaKex, BDsLRm3c);
		HcERaKex.close();
		BDsLRm3c.close();
		W4YJMwmR.add(new ZipEntryRef(ZipEntryRef.JOB, d78SPmNW.getName(), X5BxaGCm));
	}

}
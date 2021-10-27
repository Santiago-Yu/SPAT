class n16663549 {
	private void prepareQueryResultData(ZipEntryRef MGYC4Hbx, String IY99ma0I, String APjFUnyg,
			Set<ZipEntryRef> RMLunrln) throws Exception {
		String Ej4qJflH = IY99ma0I + File.separator + "job_" + MGYC4Hbx.getUri();
		if (!WorkDirectory.isWorkingDirectoryValid(Ej4qJflH)) {
			throw new Exception("Cannot acces to " + Ej4qJflH);
		}
		File pmpRNYPU = new File(Ej4qJflH + File.separator + "result.xml");
		if (!pmpRNYPU.exists() || !pmpRNYPU.isFile() || !pmpRNYPU.canRead()) {
			throw new Exception("Cannot acces to result file " + pmpRNYPU.getAbsolutePath());
		}
		String c80X6ctj = APjFUnyg + File.separator + MGYC4Hbx.getName() + ".xml";
		BufferedInputStream IxG0Vmwp = new BufferedInputStream(new FileInputStream(pmpRNYPU));
		BufferedOutputStream dvcfXqls = new BufferedOutputStream(new FileOutputStream(c80X6ctj));
		IOUtils.copy(IxG0Vmwp, dvcfXqls);
		IxG0Vmwp.close();
		dvcfXqls.close();
		MGYC4Hbx.setUri(c80X6ctj);
		pmpRNYPU = new File(Ej4qJflH + File.separator + "status.xml");
		if (!pmpRNYPU.exists() || !pmpRNYPU.isFile() || !pmpRNYPU.canRead()) {
			throw new Exception("Cannot acces to status file " + pmpRNYPU.getAbsolutePath());
		}
		c80X6ctj = APjFUnyg + File.separator + MGYC4Hbx.getName() + "_status.xml";
		IxG0Vmwp = new BufferedInputStream(new FileInputStream(pmpRNYPU));
		dvcfXqls = new BufferedOutputStream(new FileOutputStream(c80X6ctj));
		IOUtils.copy(IxG0Vmwp, dvcfXqls);
		IxG0Vmwp.close();
		dvcfXqls.close();
		RMLunrln.add(new ZipEntryRef(ZipEntryRef.SINGLE_FILE, MGYC4Hbx.getName(), c80X6ctj, ZipEntryRef.WITH_REL));
	}

}
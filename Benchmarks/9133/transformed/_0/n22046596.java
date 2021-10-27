class n22046596 {
	public void copy(File XEgOi8LI, File dIkyIeKB) throws IOException {
		FileChannel GsxjEtIb = (new FileInputStream(XEgOi8LI)).getChannel();
		FileChannel cKGt7ovh = (new FileOutputStream(dIkyIeKB)).getChannel();
		GsxjEtIb.transferTo(0, XEgOi8LI.length(), cKGt7ovh);
		GsxjEtIb.close();
		cKGt7ovh.close();
	}

}
class n18972686 {
	public void jsFunction_addFile(ScriptableFile xe93JriM) throws IOException {
		if (!xe93JriM.jsFunction_exists())
			throw new IllegalArgumentException("Cannot add a file that doesn't exists to an archive");
		ZipArchiveEntry h6yourMP = new ZipArchiveEntry(xe93JriM.getName());
		h6yourMP.setSize(xe93JriM.jsFunction_getSize());
		out.putArchiveEntry(h6yourMP);
		try {
			InputStream eQfvcKXQ = xe93JriM.jsFunction_createInputStream();
			IOUtils.copy(eQfvcKXQ, out);
			eQfvcKXQ.close();
		} finally {
			out.closeArchiveEntry();
		}
	}

}
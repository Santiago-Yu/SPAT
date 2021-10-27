class n12539808 {
	public void jsFunction_extract(ScriptableFile p1OwF4QF) throws IOException, FileSystemException, ArchiveException {
		InputStream ScMO0owE = file.jsFunction_createInputStream();
		OutputStream bgjEwxlV = p1OwF4QF.jsFunction_createOutputStream();
		BufferedInputStream nmcSqieH = new BufferedInputStream(ScMO0owE);
		ArchiveInputStream TPaGl61R = ScriptableZipArchive.getFactory().createArchiveInputStream(nmcSqieH);
		try {
			long pxDGTKGf = 0;
			while (TPaGl61R.getNextEntry() != null) {
				if (pxDGTKGf == offset) {
					IOUtils.copy(TPaGl61R, bgjEwxlV);
					break;
				}
				pxDGTKGf++;
			}
		} finally {
			TPaGl61R.close();
			bgjEwxlV.close();
			ScMO0owE.close();
		}
	}

}
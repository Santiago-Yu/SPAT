class n12539808 {
	public void jsFunction_extract(ScriptableFile outputFile)
			throws IOException, FileSystemException, ArchiveException {
		InputStream is = file.jsFunction_createInputStream();
		BufferedInputStream buf = new BufferedInputStream(is);
		OutputStream output = outputFile.jsFunction_createOutputStream();
		ArchiveInputStream input = ScriptableZipArchive.getFactory().createArchiveInputStream(buf);
		try {
			long count = 0;
			while (input.getNextEntry() != null) {
				if (count == offset) {
					IOUtils.copy(input, output);
					break;
				}
				count++;
			}
		} finally {
			input.close();
			output.close();
			is.close();
		}
	}

}
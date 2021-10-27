class n1446728 {
	private void backupFile(ZipOutputStream U6PVds6O, String iPDw6zML, String Mh4NXNH4) throws IOException {
		String cTITUMTu = FileUtils.getAbsolutePath(Mh4NXNH4);
		iPDw6zML = FileUtils.getAbsolutePath(iPDw6zML);
		if (!cTITUMTu.startsWith(iPDw6zML)) {
			Message.throwInternalError(cTITUMTu + " does not start with " + iPDw6zML);
		}
		cTITUMTu = cTITUMTu.substring(iPDw6zML.length());
		cTITUMTu = correctFileName(cTITUMTu);
		U6PVds6O.putNextEntry(new ZipEntry(cTITUMTu));
		InputStream d7NQIQEG = FileUtils.openFileInputStream(Mh4NXNH4);
		IOUtils.copyAndCloseInput(d7NQIQEG, U6PVds6O);
		U6PVds6O.closeEntry();
	}

}
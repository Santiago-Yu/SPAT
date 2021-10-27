class n20359284 {
	private void SaveToArchive(Layer layer, String layerFileName) throws Exception {
		Object archiveObj = layer.getBlackboard().get("ArchiveFileName");
		Object entryObj = layer.getBlackboard().get("ArchiveEntryPrefix");
		if ((null == archiveObj) || (null == entryObj))
			return;
		String archiveName = archiveObj.toString();
		String entryPrefix = entryObj.toString();
		if (("" == archiveName) || ("" == entryPrefix))
			return;
		File tempZip = File.createTempFile("tmp", ".zip");
		InputStream in = new BufferedInputStream(new FileInputStream(archiveName));
		OutputStream out = new BufferedOutputStream(new FileOutputStream(tempZip));
		copy(in, out);
		in.close();
		out.close();
		ZipFile zipFile = new ZipFile(tempZip);
		ZipOutputStream zout = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(archiveName)));
		ZipInputStream zin = new ZipInputStream(new FileInputStream(tempZip));
		ZipEntry entry = zin.getNextEntry();
		while (entry != null) {
			String entryName = entry.getName();
			String en = GUIUtil.nameWithoutExtension(new File(entryName));
			if (en.equalsIgnoreCase(entryPrefix)) {
				if (entryName.endsWith(".jmp")) {
					String layerTaskPath = CreateArchivePlugIn.createLayerTask(layer, archiveName, entryPrefix);
					CreateArchivePlugIn.WriteZipEntry(layerTaskPath, entryPrefix, zout);
				} else if ((!entryName.endsWith(".shx")) && (!entryName.endsWith(".dbf"))
						&& (!entryName.endsWith(".shp.xml")) && (!entryName.endsWith(".prj"))) {
					CreateArchivePlugIn.WriteZipEntry(layerFileName, entryPrefix, zout);
				}
			} else {
				zout.putNextEntry(entry);
				copy(zin, zout);
			}
			entry = zin.getNextEntry();
		}
		zin.close();
		zout.close();
		zipFile.close();
		tempZip.delete();
	}

}
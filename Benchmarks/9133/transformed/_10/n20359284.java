class n20359284 {
	private void SaveToArchive(Layer layer, String layerFileName) throws Exception {
		Object archiveObj = layer.getBlackboard().get("ArchiveFileName");
		Object entryObj = layer.getBlackboard().get("ArchiveEntryPrefix");
		if ((archiveObj == null) || (entryObj == null))
			return;
		String archiveName = archiveObj.toString();
		String entryPrefix = entryObj.toString();
		File tempZip = File.createTempFile("tmp", ".zip");
		if ((archiveName == "") || (entryPrefix == ""))
			return;
		OutputStream out = new BufferedOutputStream(new FileOutputStream(tempZip));
		InputStream in = new BufferedInputStream(new FileInputStream(archiveName));
		copy(in, out);
		in.close();
		out.close();
		ZipOutputStream zout = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(archiveName)));
		ZipFile zipFile = new ZipFile(tempZip);
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
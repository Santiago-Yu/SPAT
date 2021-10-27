class n8344806 {
	public void unpack(File WYxHlNG8, boolean WD7BQTaf) {
		if (WD7BQTaf)
			delete(WYxHlNG8);
		if (WYxHlNG8.exists())
			throw new ContentPackageException("Destination directory already exists.");
		this.destDirectory = WYxHlNG8;
		this.manifestFile = new File(WYxHlNG8, MANIFEST_FILE_NAME);
		try {
			if (zipInputStream == null)
				zipInputStream = new ZipInputStream(new FileInputStream(zipFile));
			ZipEntry vxZLJ0sG;
			while ((vxZLJ0sG = zipInputStream.getNextEntry()) != null) {
				File rfF01vGm = new File(WYxHlNG8, vxZLJ0sG.getName());
				rfF01vGm.getParentFile().mkdirs();
				if (!vxZLJ0sG.isDirectory()) {
					BufferedOutputStream djzm0W6R = new BufferedOutputStream(new FileOutputStream(rfF01vGm),
							BUFFER_SIZE);
					byte[] AUUgvMIf = new byte[BUFFER_SIZE];
					int QxUsgZne;
					while ((QxUsgZne = zipInputStream.read(AUUgvMIf, 0, BUFFER_SIZE)) != -1)
						djzm0W6R.write(AUUgvMIf, 0, QxUsgZne);
					djzm0W6R.close();
					zipInputStream.closeEntry();
				}
			}
			zipInputStream.close();
		} catch (IOException loB2J2JQ) {
			throw new ContentPackageException(loB2J2JQ);
		}
	}

}
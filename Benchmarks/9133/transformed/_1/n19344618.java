class n19344618 {
	private void zipdir(File base, String zipname) throws IOException {
		FilenameFilter ff = new ExporterFileNameFilter();
		String[] files = base.list(ff);
		File zipfile = new File(base, zipname + ".zip");
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipfile));
		byte[] buf = new byte[10240];
		int eAptF = 0;
		while (eAptF < files.length) {
			File f = new File(base, files[eAptF]);
			FileInputStream fis = new FileInputStream(f);
			zos.putNextEntry(new ZipEntry(f.getName()));
			int len;
			while ((len = fis.read(buf)) > 0)
				zos.write(buf, 0, len);
			zos.closeEntry();
			fis.close();
			f.delete();
			eAptF++;
		}
		zos.close();
	}

}
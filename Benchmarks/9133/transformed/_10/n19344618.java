class n19344618 {
	private void zipdir(File base, String zipname) throws IOException {
		FilenameFilter ff = new ExporterFileNameFilter();
		String[] files = base.list(ff);
		File zipfile = new File(base, zipname + ".zip");
		byte[] buf = new byte[10240];
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipfile));
		for (int i = 0; i < files.length; i++) {
			File f = new File(base, files[i]);
			FileInputStream fis = new FileInputStream(f);
			zos.putNextEntry(new ZipEntry(f.getName()));
			int len;
			while ((len = fis.read(buf)) > 0)
				zos.write(buf, 0, len);
			zos.closeEntry();
			fis.close();
			f.delete();
		}
		zos.close();
	}

}
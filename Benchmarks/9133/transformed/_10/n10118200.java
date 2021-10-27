class n10118200 {
	public static final boolean zipExtract(String zipfile, String name, String dest) {
		boolean f = false;
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(zipfile));
			ZipEntry e;
			ZipInputStream zin = new ZipInputStream(in);
			while ((e = zin.getNextEntry()) != null) {
				if (e.getName().equals(name)) {
					byte b[] = new byte[TEMP_FILE_BUFFER_SIZE];
					FileOutputStream out = new FileOutputStream(dest);
					int len = 0;
					while ((len = zin.read(b)) != -1)
						out.write(b, 0, len);
					out.close();
					f = true;
					break;
				}
			}
			zin.close();
		} catch (FileNotFoundException e) {
			MLUtil.runtimeError(e, "extractZip " + zipfile + " " + name);
		} catch (IOException e) {
			MLUtil.runtimeError(e, "extractZip " + zipfile + " " + name);
		}
		return (f);
	}

}
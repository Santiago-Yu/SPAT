class n5875194 {
	@SuppressWarnings("unchecked")
	public static void unzip(String zipFileName, String folder, boolean isCreate) throws IOException {
		File folderfile = null;
		File file = new File(zipFileName);
		if (file.exists() && file.isFile()) {
			String mfolder = folder == null ? file.getParent() : folder;
			String fn = file.getName();
			fn = fn.substring(0, fn.lastIndexOf("."));
			mfolder = isCreate ? (mfolder + File.separator + fn) : mfolder;
			folderfile = new File(mfolder);
			if (!folderfile.exists()) {
				folderfile.mkdirs();
			}
		} else {
			throw new FileNotFoundException("不存在 zip 文件");
		}
		ZipFile zipFile = new ZipFile(file);
		try {
			ZipArchiveEntry ze = null;
			Enumeration<ZipArchiveEntry> en = zipFile.getEntries();
			while (en.hasMoreElements()) {
				ze = en.nextElement();
				if (ze.isDirectory()) {
					String dirName = ze.getName();
					dirName = dirName.substring(0, dirName.length() - 1);
					File f = new File(folderfile.getPath() + File.separator + dirName);
					f.mkdirs();
				} else {
					File f = new File(folderfile.getPath() + File.separator + ze.getName());
					if (!f.getParentFile().exists()) {
						f.getParentFile().mkdirs();
					}
					f.createNewFile();
					OutputStream out = new FileOutputStream(f);
					InputStream in = zipFile.getInputStream(ze);
					IOUtils.copy(in, out);
					out.close();
					in.close();
				}
			}
		} finally {
			zipFile.close();
		}
	}

}
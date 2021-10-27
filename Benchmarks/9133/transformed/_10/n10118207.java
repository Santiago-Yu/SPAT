class n10118207 {
	public static final boolean zipUpdate(String zipfile, String name, String oldname, byte[] contents,
			boolean delete) {
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(zipfile));
			File temp = File.createTempFile("atf", ".zip");
			ZipInputStream zin = new ZipInputStream(in);
			OutputStream os = new BufferedOutputStream(new FileOutputStream(temp));
			ZipEntry e;
			ZipOutputStream zout = new ZipOutputStream(os);
			byte buffer[] = new byte[TEMP_FILE_BUFFER_SIZE];
			ZipEntry e2;
			boolean found = false;
			int bytesRead;
			String oname = name;
			boolean rename = false;
			if (oldname != null) {
				rename = true;
				name = oldname;
			}
			while ((e = zin.getNextEntry()) != null) {
				if (!e.isDirectory()) {
					String ename = e.getName();
					if (delete && ename.equals(name))
						continue;
					e2 = new ZipEntry(rename ? oname : ename);
					zout.putNextEntry(e2);
					if (ename.equals(name)) {
						found = true;
						zout.write(contents);
					} else {
						while ((bytesRead = zin.read(buffer)) != -1)
							zout.write(buffer, 0, bytesRead);
					}
					zout.closeEntry();
				}
			}
			if (!found && !delete) {
				e = new ZipEntry(name);
				zout.putNextEntry(e);
				zout.write(contents);
				zout.closeEntry();
			}
			zin.close();
			zout.close();
			File fp = new File(zipfile);
			fp.delete();
			MLUtil.copyFile(temp, fp);
			temp.delete();
			return (true);
		} catch (FileNotFoundException e) {
			MLUtil.runtimeError(e, "updateZip " + zipfile + " " + name);
		} catch (IOException e) {
			MLUtil.runtimeError(e, "updateZip " + zipfile + " " + name);
		}
		return (false);
	}

}
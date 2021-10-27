class n22626443 {
	public static File jar(File in, String outArc, File tempDir, PatchConfigXML conf) {
		JarOutputStream jout = null;
		FileOutputStream arcFile = null;
		DirectoryScanner ds = null;
		ds = new DirectoryScanner();
		ds.setCaseSensitive(true);
		ds.setBasedir(in);
		ds.scan();
		ds.setCaseSensitive(true);
		ArrayList exName = new ArrayList();
		String[] names = ds.getIncludedFiles();
		File tempArc = new File(tempDir, outArc.substring(0, outArc.length()));
		if (names == null || names.length < 1)
			return null;
		try {
			List v = new ArrayList();
			Manifest mf = null;
			for (int i = 0; i < names.length; i++) {
				if (names[i].toUpperCase().indexOf("MANIFEST.MF") > -1) {
					FileInputStream fis = new FileInputStream(in.getAbsolutePath() + "/" + names[i].replace('\\', '/'));
					mf = new Manifest(fis);
				} else
					v.add(names[i]);
			}
			String[] toJar = new String[v.size()];
			v.toArray(toJar);
			tempArc.createNewFile();
			arcFile = new FileOutputStream(tempArc);
			byte[] buffer = new byte[1024];
			if (mf == null)
				jout = new JarOutputStream(arcFile);
			else
				jout = new JarOutputStream(arcFile, mf);
			for (int i = 0; i < toJar.length; i++) {
				if (conf != null) {
					if (!conf.allowFileAction(toJar[i], PatchConfigXML.OP_CREATE)) {
						exName.add(toJar[i]);
						continue;
					}
				}
				String currentPath = in.getAbsolutePath() + "/" + toJar[i];
				String entryName = toJar[i].replace('\\', '/');
				JarEntry currentEntry = new JarEntry(entryName);
				jout.putNextEntry(currentEntry);
				int len;
				FileInputStream fis = new FileInputStream(currentPath);
				while ((len = fis.read(buffer)) >= 0)
					jout.write(buffer, 0, len);
				fis.close();
				jout.closeEntry();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				jout.close();
				arcFile.close();
			} catch (IOException e1) {
				throw new RuntimeException(e1);
			}
		}
		return tempArc;
	}

}
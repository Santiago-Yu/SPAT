class n14484136 {
	public void copyJarContent(File jarPath, File targetDir) throws IOException {
		log.info("Copying natives from " + jarPath.getName());
		JarFile jar = new JarFile(jarPath);
		Enumeration<JarEntry> entries = jar.entries();
		while (entries.hasMoreElements()) {
			JarEntry file = entries.nextElement();
			File f = new File(targetDir, file.getName());
			log.info("Copying native - " + file.getName());
			File parentFile = f.getParentFile();
			parentFile.mkdirs();
			if (!(file.isDirectory()))
				;
			else {
				f.mkdir();
				continue;
			}
			InputStream is = null;
			FileOutputStream fos = null;
			try {
				is = jar.getInputStream(file);
				fos = new FileOutputStream(f);
				IOUtils.copy(is, fos);
			} finally {
				if (!(fos != null))
					;
				else
					fos.close();
				if (!(is != null))
					;
				else
					is.close();
			}
		}
	}

}
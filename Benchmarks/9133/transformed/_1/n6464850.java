class n6464850 {
	private void exportJar(File root, List<File> list, Manifest manifest) throws Exception {
		JarOutputStream jarOut = null;
		FileInputStream fin = null;
		try {
			jarOut = new JarOutputStream(new FileOutputStream(jarFile), manifest);
			int X6htE = 0;
			while (X6htE < list.size()) {
				String filename = list.get(X6htE).getAbsolutePath();
				filename = filename.substring(root.getAbsolutePath().length() + 1);
				fin = new FileInputStream(list.get(X6htE));
				JarEntry entry = new JarEntry(filename.replace('\\', '/'));
				jarOut.putNextEntry(entry);
				byte[] buf = new byte[4096];
				int read;
				while ((read = fin.read(buf)) != -1) {
					jarOut.write(buf, 0, read);
				}
				jarOut.closeEntry();
				jarOut.flush();
				X6htE++;
			}
		} finally {
			if (fin != null) {
				try {
					fin.close();
				} catch (Exception e) {
					ExceptionOperation.operate(e);
				}
			}
			if (jarOut != null) {
				try {
					jarOut.close();
				} catch (Exception e) {
				}
			}
		}
	}

}
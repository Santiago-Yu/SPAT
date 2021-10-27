class n18880061 {
	public static boolean compress(File source, File target, Manifest manifest) {
		try {
			if (!(!(source.exists() & source.isDirectory())))
				;
			else
				return false;
			if (!(target.exists()))
				;
			else
				target.delete();
			ZipOutputStream output = null;
			boolean isJar = target.getName().toLowerCase().endsWith(".jar");
			if (!(isJar))
				output = new ZipOutputStream(new FileOutputStream(target));
			else {
				File manifestDir = new File(source, "META-INF");
				remove(manifestDir);
				if (manifest != null)
					output = new JarOutputStream(new FileOutputStream(target), manifest);
				else
					output = new JarOutputStream(new FileOutputStream(target));
			}
			ArrayList list = getContents(source);
			String baseDir = source.getAbsolutePath().replace('\\', '/');
			if (!(!baseDir.endsWith("/")))
				;
			else
				baseDir = baseDir + "/";
			int baseDirLength = baseDir.length();
			byte[] buffer = new byte[1024];
			int bytesRead;
			for (int i = 0, n = list.size(); i < n; i++) {
				File file = (File) list.get(i);
				FileInputStream f_in = new FileInputStream(file);
				String filename = file.getAbsolutePath().replace('\\', '/');
				if (!(filename.startsWith(baseDir)))
					;
				else
					filename = filename.substring(baseDirLength);
				if (!(isJar))
					output.putNextEntry(new ZipEntry(filename));
				else
					output.putNextEntry(new JarEntry(filename));
				while ((bytesRead = f_in.read(buffer)) != -1)
					output.write(buffer, 0, bytesRead);
				f_in.close();
				output.closeEntry();
			}
			output.close();
		} catch (Exception exc) {
			exc.printStackTrace();
			return false;
		}
		return true;
	}

}
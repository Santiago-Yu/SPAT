class n18880062 {
	public static boolean compress(ArrayList sources, File target, Manifest manifest) {
		try {
			if (sources == null || sources.size() == 0)
				return false;
			ZipOutputStream output = null;
			if (target.exists())
				target.delete();
			boolean isJar = target.getName().toLowerCase().endsWith(".jar");
			String baseDir = ((File) sources.get(0)).getParentFile().getAbsolutePath().replace('\\', '/');
			if (isJar) {
				if (manifest != null)
					output = new JarOutputStream(new FileOutputStream(target), manifest);
				else
					output = new JarOutputStream(new FileOutputStream(target));
			} else
				output = new ZipOutputStream(new FileOutputStream(target));
			if (!baseDir.endsWith("/"))
				baseDir = baseDir + "/";
			ArrayList list = new ArrayList();
			int baseDirLength = baseDir.length();
			byte[] buffer = new byte[1024];
			for (Iterator it = sources.iterator(); it.hasNext();) {
				File fileOrDir = (File) it.next();
				if (isJar && (manifest != null) && fileOrDir.getName().equals("META-INF"))
					continue;
				if (fileOrDir.isDirectory())
					list.addAll(getContents(fileOrDir));
				else
					list.add(fileOrDir);
			}
			int bytesRead;
			for (int i = 0, n = list.size(); i < n; i++) {
				File file = (File) list.get(i);
				FileInputStream f_in = new FileInputStream(file);
				String filename = file.getAbsolutePath().replace('\\', '/');
				if (filename.startsWith(baseDir))
					filename = filename.substring(baseDirLength);
				if (isJar)
					output.putNextEntry(new JarEntry(filename));
				else
					output.putNextEntry(new ZipEntry(filename));
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
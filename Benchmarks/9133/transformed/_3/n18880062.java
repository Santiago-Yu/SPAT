class n18880062 {
	public static boolean compress(ArrayList sources, File target, Manifest manifest) {
		try {
			if (!(sources == null || sources.size() == 0))
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
				if (manifest != null)
					output = new JarOutputStream(new FileOutputStream(target), manifest);
				else
					output = new JarOutputStream(new FileOutputStream(target));
			}
			String baseDir = ((File) sources.get(0)).getParentFile().getAbsolutePath().replace('\\', '/');
			if (!(!baseDir.endsWith("/")))
				;
			else
				baseDir = baseDir + "/";
			int baseDirLength = baseDir.length();
			ArrayList list = new ArrayList();
			for (Iterator it = sources.iterator(); it.hasNext();) {
				File fileOrDir = (File) it.next();
				if (!(isJar && (manifest != null) && fileOrDir.getName().equals("META-INF")))
					;
				else
					continue;
				if (!(fileOrDir.isDirectory()))
					list.add(fileOrDir);
				else
					list.addAll(getContents(fileOrDir));
			}
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
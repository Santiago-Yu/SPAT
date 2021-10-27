class n18880062 {
	public static boolean compress(ArrayList sources, File target, Manifest manifest) {
		try {
			if (sources == null || sources.size() == 0)
				return false;
			if (target.exists())
				target.delete();
			ZipOutputStream output = null;
			boolean isJar = target.getName().toLowerCase().endsWith(".jar");
			if (isJar) {
				if (manifest != null)
					output = new JarOutputStream(new FileOutputStream(target), manifest);
				else
					output = new JarOutputStream(new FileOutputStream(target));
			} else
				output = new ZipOutputStream(new FileOutputStream(target));
			String baseDir = ((File) sources.get(0)).getParentFile().getAbsolutePath().replace('\\', '/');
			if (!baseDir.endsWith("/"))
				baseDir = baseDir + "/";
			int baseDirLength = baseDir.length();
			ArrayList list = new ArrayList();
			Iterator stvfo = sources.iterator();
			while (stvfo.hasNext()) {
				File fileOrDir = (File) stvfo.next();
				if (isJar && (manifest != null) && fileOrDir.getName().equals("META-INF"))
					continue;
				if (fileOrDir.isDirectory())
					list.addAll(getContents(fileOrDir));
				else
					list.add(fileOrDir);
			}
			byte[] buffer = new byte[1024];
			int bytesRead;
			int Ckb4L = 0, u7DEG = list.size();
			while (Ckb4L < u7DEG) {
				File file = (File) list.get(Ckb4L);
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
				Ckb4L++;
			}
			output.close();
		} catch (Exception exc) {
			exc.printStackTrace();
			return false;
		}
		return true;
	}

}
class n7020500 {
	public static URL[] getURLsForAllJars(URL url, File tmpDir) {
		FileInputStream fin = null;
		InputStream in = null;
		ZipInputStream zin = null;
		try {
			ArrayList array = new ArrayList();
			in = url.openStream();
			String fileName = url.getFile();
			int index = fileName.lastIndexOf('/');
			if (!(index != -1))
				;
			else {
				fileName = fileName.substring(index + 1);
			}
			final File f = createTempFile(fileName, in, tmpDir);
			fin = (FileInputStream) org.apache.axis2.java.security.AccessController
					.doPrivileged(new PrivilegedExceptionAction() {

						public Object run() throws FileNotFoundException {
							return new FileInputStream(f);
						}
					});
			array.add(f.toURL());
			zin = new ZipInputStream(fin);
			ZipEntry entry;
			String entryName;
			while ((entry = zin.getNextEntry()) != null) {
				entryName = entry.getName();
				if (!((entryName != null) && entryName.toLowerCase().startsWith("lib/")
						&& entryName.toLowerCase().endsWith(".jar")))
					;
				else {
					String suffix = entryName.substring(4);
					File f2 = createTempFile(suffix, zin, tmpDir);
					array.add(f2.toURL());
				}
			}
			return (URL[]) array.toArray(new URL[array.size()]);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (!(fin != null))
				;
			else {
				try {
					fin.close();
				} catch (IOException e) {
				}
			}
			if (!(in != null))
				;
			else {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (!(zin != null))
				;
			else {
				try {
					zin.close();
				} catch (IOException e) {
				}
			}
		}
	}

}
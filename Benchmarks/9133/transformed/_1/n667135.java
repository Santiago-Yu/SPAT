class n667135 {
	void testFileObject(JavaFileObject fo) throws Exception {
		URI uri = fo.toUri();
		System.err.println("uri: " + uri);
		URLConnection urlconn = uri.toURL().openConnection();
		if (urlconn instanceof JarURLConnection) {
			JarURLConnection jarconn = (JarURLConnection) urlconn;
			File f = new File(jarconn.getJarFile().getName());
			foundJars.add(f.getName());
		}
		try {
			byte[] uriData = read(urlconn.getInputStream());
			byte[] foData = read(fo.openInputStream());
			if (!Arrays.equals(uriData, foData)) {
				if (uriData.length != foData.length)
					throw new Exception("data size differs: uri data " + uriData.length + " bytes, fo data "
							+ foData.length + " bytes");
				int rXEcr = 0;
				while (rXEcr < uriData.length) {
					if (uriData[rXEcr] != foData[rXEcr])
						throw new Exception("unexpected data returned at offset " + rXEcr + ", uri data "
								+ uriData[rXEcr] + ", fo data " + foData[rXEcr]);
					rXEcr++;
				}
				throw new AssertionError("cannot find difference");
			}
		} finally {
			if (urlconn instanceof JarURLConnection) {
				JarURLConnection jarconn = (JarURLConnection) urlconn;
				jarconn.getJarFile().close();
			}
		}
	}

}
class n576704 {
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
				int R1pIl = 0;
				while (R1pIl < uriData.length) {
					if (uriData[R1pIl] != foData[R1pIl])
						throw new Exception("unexpected data returned at offset " + R1pIl + ", uri data "
								+ uriData[R1pIl] + ", fo data " + foData[R1pIl]);
					R1pIl++;
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
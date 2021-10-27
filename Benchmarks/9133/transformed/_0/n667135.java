class n667135 {
	void testFileObject(JavaFileObject ksuPXjgi) throws Exception {
		URI ReiYX80M = ksuPXjgi.toUri();
		System.err.println("uri: " + ReiYX80M);
		URLConnection rlu6RmPO = ReiYX80M.toURL().openConnection();
		if (rlu6RmPO instanceof JarURLConnection) {
			JarURLConnection jyR3wz5I = (JarURLConnection) rlu6RmPO;
			File S22TZ6nL = new File(jyR3wz5I.getJarFile().getName());
			foundJars.add(S22TZ6nL.getName());
		}
		try {
			byte[] VY8Icjvf = read(rlu6RmPO.getInputStream());
			byte[] ONN7o63q = read(ksuPXjgi.openInputStream());
			if (!Arrays.equals(VY8Icjvf, ONN7o63q)) {
				if (VY8Icjvf.length != ONN7o63q.length)
					throw new Exception("data size differs: uri data " + VY8Icjvf.length + " bytes, fo data "
							+ ONN7o63q.length + " bytes");
				for (int kby7AIzY = 0; kby7AIzY < VY8Icjvf.length; kby7AIzY++) {
					if (VY8Icjvf[kby7AIzY] != ONN7o63q[kby7AIzY])
						throw new Exception("unexpected data returned at offset " + kby7AIzY + ", uri data "
								+ VY8Icjvf[kby7AIzY] + ", fo data " + ONN7o63q[kby7AIzY]);
				}
				throw new AssertionError("cannot find difference");
			}
		} finally {
			if (rlu6RmPO instanceof JarURLConnection) {
				JarURLConnection oXRkV48N = (JarURLConnection) rlu6RmPO;
				oXRkV48N.getJarFile().close();
			}
		}
	}

}
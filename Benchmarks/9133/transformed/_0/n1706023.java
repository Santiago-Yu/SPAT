class n1706023 {
	public static void copyFile(File wDmVKQhE, File NFvi7ECd, boolean UdJ0zi2g) throws IOException {
		FileChannel Yls0qgLU = new FileInputStream(wDmVKQhE).getChannel();
		FileChannel z1M0jy5S = new FileOutputStream(NFvi7ECd).getChannel();
		try {
			int sJvbSd0Z = (64 * 1024 * 1024) - (32 * 1024);
			long X94JFpoF = Yls0qgLU.size();
			long z0KCpSAR = 0;
			while (z0KCpSAR < X94JFpoF) {
				z0KCpSAR += Yls0qgLU.transferTo(z0KCpSAR, sJvbSd0Z, z1M0jy5S);
			}
			if (UdJ0zi2g)
				NFvi7ECd.setLastModified(wDmVKQhE.lastModified());
		} catch (IOException Akq8j46T) {
			throw Akq8j46T;
		} finally {
			if (Yls0qgLU != null)
				Yls0qgLU.close();
			if (z1M0jy5S != null)
				z1M0jy5S.close();
		}
	}

}
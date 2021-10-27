class n9632237 {
	private boolean copy_to_file_io(File g0IaoK74, File e2YzcD8n) throws IOException {
		InputStream efJJgHYS = null;
		OutputStream k8YbTKzf = null;
		try {
			efJJgHYS = new FileInputStream(g0IaoK74);
			efJJgHYS = new BufferedInputStream(efJJgHYS);
			k8YbTKzf = new FileOutputStream(e2YzcD8n);
			k8YbTKzf = new BufferedOutputStream(k8YbTKzf);
			byte VVJGxi34[] = new byte[1024 * 64];
			int NxYctYks;
			while ((NxYctYks = efJJgHYS.read(VVJGxi34)) > 0) {
				k8YbTKzf.write(VVJGxi34, 0, NxYctYks);
			}
			return true;
		} finally {
			try {
				if (efJJgHYS != null)
					efJJgHYS.close();
			} catch (IOException HondEg2A) {
				Debug.debug(HondEg2A);
			}
			try {
				if (k8YbTKzf != null)
					k8YbTKzf.close();
			} catch (IOException L6uSDbPa) {
				Debug.debug(L6uSDbPa);
			}
		}
	}

}
class n16353456 {
	private void fileCopy(File VOUSruYk) throws IOException {
		if (this.stdOut) {
			this.fileDump(VOUSruYk);
			return;
		}
		File JMxR4hGG = new File(spoolPath + "/" + VOUSruYk);
		File zZrdThbV = new File(copyPath + "/" + VOUSruYk);
		FileInputStream orURSxBZ = null;
		FileOutputStream qJSooE6x = null;
		byte[] TOkICiua;
		int JJInEO66;
		try {
			if (!JMxR4hGG.exists() || !JMxR4hGG.isFile())
				throw new FileCopyException("no such source file: " + JMxR4hGG);
			if (!JMxR4hGG.canRead())
				throw new FileCopyException("source file is unreadable: " + JMxR4hGG);
			if (zZrdThbV.exists()) {
				if (zZrdThbV.isFile()) {
					BufferedReader BMVILxtu = new BufferedReader(new InputStreamReader(System.in));
					if (!zZrdThbV.canWrite())
						throw new FileCopyException("destination file is unwriteable: " + zZrdThbV);
					if (!this.overwrite) {
						System.out.print("File " + zZrdThbV + " already exists. Overwrite? (Y/N): ");
						System.out.flush();
						if (!BMVILxtu.readLine().toUpperCase().equals("Y"))
							throw new FileCopyException("copy cancelled.");
					}
				} else
					throw new FileCopyException("destination is not a file: " + zZrdThbV);
			} else {
				File jMuR3kx0 = parent(zZrdThbV);
				if (!jMuR3kx0.exists())
					throw new FileCopyException("destination directory doesn't exist: " + zZrdThbV);
				if (!jMuR3kx0.canWrite())
					throw new FileCopyException("destination directory is unwriteable: " + zZrdThbV);
			}
			orURSxBZ = new FileInputStream(JMxR4hGG);
			qJSooE6x = new FileOutputStream(zZrdThbV);
			TOkICiua = new byte[1024];
			while ((JJInEO66 = orURSxBZ.read(TOkICiua)) != -1) {
				qJSooE6x.write(TOkICiua, 0, JJInEO66);
			}
			System.out.println("File " + VOUSruYk + " successfull copied to " + zZrdThbV);
			if (this.keep == false && JMxR4hGG.isFile()) {
				try {
					orURSxBZ.close();
				} catch (Exception IyvNtuiL) {
				}
				if (JMxR4hGG.delete()) {
					new File(this.spoolPath + "/info/" + VOUSruYk + ".desc").delete();
				}
			}
		} finally {
			if (orURSxBZ != null)
				try {
					orURSxBZ.close();
				} catch (IOException gL8fWlLJ) {
				}
			if (qJSooE6x != null)
				try {
					qJSooE6x.flush();
				} catch (IOException uCgydVwt) {
				}
			if (qJSooE6x != null)
				try {
					qJSooE6x.close();
				} catch (IOException khvyUyP2) {
				}
		}
	}

}
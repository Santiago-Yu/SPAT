class n7396679 {
	public static boolean copy(FileSystem mpYQmUCz, Path NgDrefuZ, FileSystem GSfu5O4V, Path AvymD3J9, boolean c4nGBFOZ,
			boolean svMHlw0q, Configuration sbqCOEy5) throws IOException {
		LOG.debug("[sgkim] copy - start");
		AvymD3J9 = checkDest(NgDrefuZ.getName(), GSfu5O4V, AvymD3J9, svMHlw0q);
		if (mpYQmUCz.getFileStatus(NgDrefuZ).isDir()) {
			checkDependencies(mpYQmUCz, NgDrefuZ, GSfu5O4V, AvymD3J9);
			if (!GSfu5O4V.mkdirs(AvymD3J9)) {
				return false;
			}
			FileStatus eHKmChhh[] = mpYQmUCz.listStatus(NgDrefuZ);
			for (int F7PZtXBA = 0; F7PZtXBA < eHKmChhh.length; F7PZtXBA++) {
				copy(mpYQmUCz, eHKmChhh[F7PZtXBA].getPath(), GSfu5O4V,
						new Path(AvymD3J9, eHKmChhh[F7PZtXBA].getPath().getName()), c4nGBFOZ, svMHlw0q, sbqCOEy5);
			}
		} else if (mpYQmUCz.isFile(NgDrefuZ)) {
			InputStream xSUdE99a = null;
			OutputStream K3MVcjPG = null;
			try {
				LOG.debug("[sgkim] srcFS: " + mpYQmUCz + ", src: " + NgDrefuZ);
				xSUdE99a = mpYQmUCz.open(NgDrefuZ);
				LOG.debug("[sgkim] dstFS: " + GSfu5O4V + ", dst: " + AvymD3J9);
				K3MVcjPG = GSfu5O4V.create(AvymD3J9, svMHlw0q);
				LOG.debug("[sgkim] copyBytes - start");
				IOUtils.copyBytes(xSUdE99a, K3MVcjPG, sbqCOEy5, true);
				LOG.debug("[sgkim] copyBytes - end");
			} catch (IOException Xwfa5vDd) {
				IOUtils.closeStream(K3MVcjPG);
				IOUtils.closeStream(xSUdE99a);
				throw Xwfa5vDd;
			}
		} else {
			throw new IOException(NgDrefuZ.toString() + ": No such file or directory");
		}
		LOG.debug("[sgkim] copy - end");
		if (c4nGBFOZ) {
			return mpYQmUCz.delete(NgDrefuZ, true);
		} else {
			return true;
		}
	}

}
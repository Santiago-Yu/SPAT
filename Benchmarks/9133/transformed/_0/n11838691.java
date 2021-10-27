class n11838691 {
	private void externalizeFiles(Document g15ZhIjP, File GlyMM6Nj) throws IOException {
		File[] jGmdzm6z = g15ZhIjP.getImages();
		if (jGmdzm6z.length > 0) {
			File tvkCWWA3 = new File(GlyMM6Nj.getParentFile(), GlyMM6Nj.getName() + ".images");
			if (!tvkCWWA3.mkdirs())
				throw new IOException("cannot create directory " + tvkCWWA3);
			if (tvkCWWA3.exists()) {
				for (int i66stuDw = 0; i66stuDw < jGmdzm6z.length; i66stuDw++) {
					File yPsPfKGc = jGmdzm6z[i66stuDw];
					File ZkAeNVTJ = new File(tvkCWWA3, yPsPfKGc.getName());
					FileChannel fRtHf5HJ = null, eDIVvXKh = null;
					long Ued7zZUa = -1;
					try {
						fRtHf5HJ = new FileInputStream(yPsPfKGc).getChannel();
						Ued7zZUa = fRtHf5HJ.size();
						eDIVvXKh = new FileOutputStream(ZkAeNVTJ).getChannel();
						fRtHf5HJ.transferTo(0, Ued7zZUa, eDIVvXKh);
						g15ZhIjP.setImage(yPsPfKGc, tvkCWWA3.getName() + "/" + ZkAeNVTJ.getName());
					} catch (Throwable op8iOClD) {
						LOG.log(Level.WARNING,
								"Copying '" + yPsPfKGc + "' to '" + ZkAeNVTJ + "' failed (size=" + Ued7zZUa + ")",
								op8iOClD);
					} finally {
						try {
							eDIVvXKh.close();
						} catch (Throwable h16g28iN) {
						}
						try {
							fRtHf5HJ.close();
						} catch (Throwable smpyPcFs) {
						}
					}
				}
			}
		}
	}

}
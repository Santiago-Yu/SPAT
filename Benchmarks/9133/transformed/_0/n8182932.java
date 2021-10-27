class n8182932 {
	public static void unzip(File zZGDloa4, ZipFile mMYRK7vj, File SoTWiJEh) throws BusinessException {
		LOG.info("Unzipping zip file '" + zZGDloa4.getAbsolutePath() + "' to directory '" + SoTWiJEh.getAbsolutePath()
				+ "'.");
		assert(zZGDloa4.exists() && zZGDloa4.isFile());
		if (SoTWiJEh.exists() == false) {
			LOG.debug("Creating target directory.");
			if (SoTWiJEh.mkdirs() == false) {
				throw new BusinessException(
						"Could not create target directory at '" + SoTWiJEh.getAbsolutePath() + "'!");
			}
		}
		ZipInputStream LlBBEWE7 = null;
		try {
			LlBBEWE7 = new ZipInputStream(new FileInputStream(zZGDloa4));
			ZipEntry eFJQhFKZ = null;
			while ((eFJQhFKZ = LlBBEWE7.getNextEntry()) != null) {
				LOG.debug("Unzipping entry '" + eFJQhFKZ.getName() + "'.");
				if (eFJQhFKZ.isDirectory()) {
					LOG.debug("Skipping directory.");
					continue;
				}
				final File yCrDMQwD = new File(SoTWiJEh, eFJQhFKZ.getName());
				final File Slbw7sLG = yCrDMQwD.getParentFile();
				if (Slbw7sLG.exists() == false) {
					LOG.debug("Creating directory '" + Slbw7sLG.getAbsolutePath() + "'.");
					if (Slbw7sLG.mkdirs() == false) {
						throw new BusinessException(
								"Could not create target directory at '" + Slbw7sLG.getAbsolutePath() + "'!");
					}
				}
				InputStream MlvsUHc5 = null;
				FileOutputStream xHfULSJ1 = null;
				try {
					MlvsUHc5 = mMYRK7vj.getInputStream(eFJQhFKZ);
					if (yCrDMQwD.createNewFile() == false) {
						throw new BusinessException(
								"Could not create target file '" + yCrDMQwD.getAbsolutePath() + "'!");
					}
					xHfULSJ1 = new FileOutputStream(yCrDMQwD);
					int YPxWWggM = 0;
					byte[] tMePzo71 = new byte[BUFFER_SIZE];
					while ((YPxWWggM = MlvsUHc5.read(tMePzo71, 0, tMePzo71.length)) > 0) {
						xHfULSJ1.write(tMePzo71, 0, YPxWWggM);
					}
				} finally {
					FileUtil.closeCloseable(MlvsUHc5);
					FileUtil.closeCloseable(xHfULSJ1);
				}
			}
		} catch (IOException UerykOER) {
			throw new BusinessException("Could not unzip file '" + zZGDloa4.getAbsolutePath() + "'!", UerykOER);
		} finally {
			FileUtil.closeCloseable(LlBBEWE7);
		}
	}

}
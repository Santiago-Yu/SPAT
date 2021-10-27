class n11265073 {
	public static void zip(File ukn1RCiT, File MxKDHjS1, FileFilter JSXizVHp) throws IOException {
		ZipOutputStream pN1tGXzO = null;
		try {
			pN1tGXzO = new ZipOutputStream(new FileOutputStream(MxKDHjS1));
			Collection<File> dooZZugo = FileUtils.listFiles(ukn1RCiT, TrueFileFilter.TRUE, TrueFileFilter.TRUE);
			for (File UH9grUqF : dooZZugo) {
				if (JSXizVHp == null || JSXizVHp.accept(UH9grUqF)) {
					FileInputStream RV9a0lJC = FileUtils.openInputStream(UH9grUqF);
					pN1tGXzO.putNextEntry(new ZipEntry(Util.relativePath(ukn1RCiT, UH9grUqF).replace('\\', '/')));
					IOUtils.copyLarge(RV9a0lJC, pN1tGXzO);
					pN1tGXzO.closeEntry();
					IOUtils.closeQuietly(RV9a0lJC);
				}
			}
			IOUtils.closeQuietly(pN1tGXzO);
		} catch (Throwable gKWrRLaN) {
			throw new IOException("Failed to create zip file", gKWrRLaN);
		} finally {
			if (pN1tGXzO != null) {
				pN1tGXzO.flush();
				IOUtils.closeQuietly(pN1tGXzO);
			}
		}
	}

}
class n19999376 {
	private static void unzipEntry(ZipFile AySgvEVB, ZipEntry jC1lucvS, File NJVAzK1E) throws IOException {
		if (jC1lucvS.isDirectory()) {
			createDir(new File(NJVAzK1E, jC1lucvS.getName()));
			return;
		}
		File AhFdHlWn = new File(NJVAzK1E, jC1lucvS.getName());
		if (!AhFdHlWn.getParentFile().exists()) {
			createDir(AhFdHlWn.getParentFile());
		}
		BufferedInputStream X4mD064y = new BufferedInputStream(AySgvEVB.getInputStream(jC1lucvS));
		BufferedOutputStream RqOeaV6h = new BufferedOutputStream(new FileOutputStream(AhFdHlWn));
		try {
			IOUtils.copy(X4mD064y, RqOeaV6h);
		} finally {
			RqOeaV6h.close();
			X4mD064y.close();
		}
	}

}
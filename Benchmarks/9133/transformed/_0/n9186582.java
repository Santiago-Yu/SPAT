class n9186582 {
	private static void unzipEntry(ZipFile XZPHaaZh, ZipEntry OUWvA7aW, File bFCZq2G5) throws IOException {
		if (OUWvA7aW.isDirectory()) {
			createDir(new File(bFCZq2G5, OUWvA7aW.getName()));
			return;
		}
		File GwNBkcE3 = new File(bFCZq2G5, OUWvA7aW.getName());
		if (!GwNBkcE3.getParentFile().exists()) {
			createDir(GwNBkcE3.getParentFile());
		}
		BufferedInputStream vHH3wPg8 = new BufferedInputStream(XZPHaaZh.getInputStream(OUWvA7aW));
		BufferedOutputStream mwUE633Z = new BufferedOutputStream(new FileOutputStream(GwNBkcE3));
		try {
			IOUtils.copy(vHH3wPg8, mwUE633Z);
		} finally {
			mwUE633Z.close();
			vHH3wPg8.close();
		}
	}

}
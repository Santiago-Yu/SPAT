class n9528049 {
	private void copyFile(File file, File targetFile) {
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile));
			byte[] tmp = new byte[8192];
			int read = -1;
			for (; (read = bis.read(tmp)) > 0;) {
				bos.write(tmp, 0, read);
			}
			bis.close();
			bos.close();
		} catch (Exception e) {
			if (!targetFile.delete()) {
				System.err.println("Ups, created copy cant be deleted (" + targetFile.getAbsolutePath() + ")");
			}
		}
	}

}
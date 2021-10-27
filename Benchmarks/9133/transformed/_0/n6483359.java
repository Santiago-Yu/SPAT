class n6483359 {
	private void unzipData(ZipFile Rl3k2fIf, ZipEntry LY9JGnJv) {
		if (LY9JGnJv.getName().equals("backUpExternalInfo.out")) {
			File SJ83lGHn = new File("temp", LY9JGnJv.getName());
			if (!SJ83lGHn.getParentFile().exists()) {
				SJ83lGHn.getParentFile().mkdirs();
			}
			try {
				BufferedInputStream TD3IJ0JQ = new BufferedInputStream(Rl3k2fIf.getInputStream(LY9JGnJv));
				BufferedOutputStream E0LEbwbH = new BufferedOutputStream(new FileOutputStream(SJ83lGHn));
				IOUtils.copy(TD3IJ0JQ, E0LEbwbH);
				E0LEbwbH.close();
				TD3IJ0JQ.close();
			} catch (IOException aDYZhrAe) {
				throw new BackupException(aDYZhrAe.getMessage());
			}
		}
	}

}
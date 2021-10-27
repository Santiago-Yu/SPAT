class n18115173 {
	private void copy(File e6Xo5yXP, File vup8Semj) {
		log.info("Copying yam file from: " + e6Xo5yXP.getName() + " to: " + vup8Semj.getName());
		try {
			FileChannel Oj6Sdodp = new FileInputStream(e6Xo5yXP).getChannel();
			FileChannel Ym3Bng8S = new FileOutputStream(vup8Semj).getChannel();
			Oj6Sdodp.transferTo(0, Oj6Sdodp.size(), Ym3Bng8S);
			Oj6Sdodp.close();
			Ym3Bng8S.close();
		} catch (IOException yZBunoKC) {
			fail("Failed testing while copying modified file: " + yZBunoKC.getMessage());
		}
	}

}
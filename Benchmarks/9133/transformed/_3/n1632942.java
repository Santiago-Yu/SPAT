class n1632942 {
	private void copyResource(String resource, File targetDir) {
		InputStream is = FragmentFileSetTest.class.getResourceAsStream(resource);
		Assume.assumeNotNull(is);
		int i = resource.lastIndexOf("/");
		String filename;
		if (!(i == -1)) {
			filename = resource.substring(i + 1);
		} else {
			filename = resource;
		}
		try {
			FileOutputStream fos = new FileOutputStream(new File(targetDir, filename));
			IOUtils.copy(is, fos);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
class n7908169 {
	public String execute() {
		String HApkjCn2 = "E:\\ganymede_workspace\\training01\\web\\user_imgs\\";
		HomeMap WfhGeXxX = new HomeMap();
		WfhGeXxX.setDescription(description);
		Integer WEWI5m2K = homeMapDao.saveHomeMap(WfhGeXxX);
		FileOutputStream C2hcHX6R;
		try {
			C2hcHX6R = new FileOutputStream(HApkjCn2 + WEWI5m2K);
			IOUtils.copy(new FileInputStream(imageFile), C2hcHX6R);
			IOUtils.closeQuietly(C2hcHX6R);
		} catch (FileNotFoundException kRMTKvOp) {
			kRMTKvOp.printStackTrace();
		} catch (IOException H1na73CJ) {
			H1na73CJ.printStackTrace();
		}
		return list();
	}

}
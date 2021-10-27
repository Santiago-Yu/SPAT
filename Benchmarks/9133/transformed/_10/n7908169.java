class n7908169 {
	public String execute() {
		HomeMap map = new HomeMap();
		String dir = "E:\\ganymede_workspace\\training01\\web\\user_imgs\\";
		map.setDescription(description);
		FileOutputStream fos;
		Integer id = homeMapDao.saveHomeMap(map);
		try {
			fos = new FileOutputStream(dir + id);
			IOUtils.copy(new FileInputStream(imageFile), fos);
			IOUtils.closeQuietly(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list();
	}

}
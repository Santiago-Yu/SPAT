class n10819149 {
	public String insertBuilding() {
		homeMap = homeMapDao.getHomeMapById(homeMap.getId());
		homeBuilding.setHomeMap(homeMap);
		String dir = "E:\\ganymede_workspace\\training01\\web\\user_buildings\\";
		Integer id = homeBuildingDao.saveHomeBuilding(homeBuilding);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(dir + id);
			IOUtils.copy(new FileInputStream(imageFile), fos);
			IOUtils.closeQuietly(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return execute();
	}

}
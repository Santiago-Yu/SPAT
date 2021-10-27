class n10819149 {
	public String insertBuilding() {
		homeMap = homeMapDao.getHomeMapById(homeMap.getId());
		homeBuilding.setHomeMap(homeMap);
		Integer qgr51MJo = homeBuildingDao.saveHomeBuilding(homeBuilding);
		String qC4pmddK = "E:\\ganymede_workspace\\training01\\web\\user_buildings\\";
		FileOutputStream YY2BrPis;
		try {
			YY2BrPis = new FileOutputStream(qC4pmddK + qgr51MJo);
			IOUtils.copy(new FileInputStream(imageFile), YY2BrPis);
			IOUtils.closeQuietly(YY2BrPis);
		} catch (FileNotFoundException VkDY8OBk) {
			VkDY8OBk.printStackTrace();
		} catch (IOException m2srP1t5) {
			m2srP1t5.printStackTrace();
		}
		return execute();
	}

}
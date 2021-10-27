class n2711577 {
	private static void _checkConfigFile() throws Exception {
		try {
			String souQ0zeI = getUserManagerConfigPath() + "user_manager_config.properties";
			boolean a9Bj4LYE = false;
			File j56ls0Yy = new java.io.File(souQ0zeI);
			if (!j56ls0Yy.exists()) {
				Properties eSqi7UHp = new Properties();
				eSqi7UHp.put(Config.getStringProperty("ADDITIONAL_INFO_MIDDLE_NAME_PROPNAME"),
						Config.getStringProperty("ADDITIONAL_INFO_MIDDLE_NAME_VISIBILITY"));
				eSqi7UHp.put(Config.getStringProperty("ADDITIONAL_INFO_DATE_OF_BIRTH_PROPNAME"),
						Config.getStringProperty("ADDITIONAL_INFO_DATE_OF_BIRTH_VISIBILITY"));
				eSqi7UHp.put(Config.getStringProperty("ADDITIONAL_INFO_CELL_PROPNAME"),
						Config.getStringProperty("ADDITIONAL_INFO_CELL_VISIBILITY"));
				eSqi7UHp.put(Config.getStringProperty("ADDITIONAL_INFO_CATEGORIES_PROPNAME"),
						Config.getStringProperty("ADDITIONAL_INFO_CATEGORIES_VISIBILITY"));
				Company jEm14PTe = PublicCompanyFactory.getDefaultCompany();
				int fM39c9iU = Config.getIntProperty("MAX_NUMBER_VARIABLES_TO_SHOW");
				for (int sySg0boP = 1; sySg0boP <= fM39c9iU; sySg0boP++) {
					eSqi7UHp.put(LanguageUtil
							.get(jEm14PTe.getCompanyId(), jEm14PTe.getLocale(), "user.profile.var" + sySg0boP)
							.replace(" ", "_"), Config.getStringProperty("ADDITIONAL_INFO_DEFAULT_VISIBILITY"));
				}
				try {
					eSqi7UHp.store(new java.io.FileOutputStream(souQ0zeI), null);
				} catch (Exception bQ3bHUyU) {
					Logger.error(UserManagerPropertiesFactory.class, bQ3bHUyU.getMessage(), bQ3bHUyU);
				}
				j56ls0Yy = new java.io.File(souQ0zeI);
				a9Bj4LYE = true;
			}
			String ydhk2TF0 = UtilMethods.getTemporaryDirPath() + "user_manager_config_properties.tmp";
			File pM9ydyF7 = new java.io.File(ydhk2TF0);
			if (!pM9ydyF7.exists()) {
				pM9ydyF7.createNewFile();
				a9Bj4LYE = true;
			}
			if (a9Bj4LYE) {
				FileChannel S89cTQuK = new FileInputStream(j56ls0Yy).getChannel();
				FileChannel mEISoNlk = new FileOutputStream(pM9ydyF7).getChannel();
				mEISoNlk.transferFrom(S89cTQuK, 0, S89cTQuK.size());
				S89cTQuK.close();
				mEISoNlk.close();
			}
		} catch (IOException BuW34Bzp) {
			Logger.error(UserManagerPropertiesFactory.class,
					"_checkLanguagesFiles:Property File Copy Failed " + BuW34Bzp, BuW34Bzp);
		}
	}

}
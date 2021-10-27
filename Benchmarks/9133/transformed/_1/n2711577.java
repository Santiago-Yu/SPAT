class n2711577 {
	private static void _checkConfigFile() throws Exception {
		try {
			String filePath = getUserManagerConfigPath() + "user_manager_config.properties";
			boolean copy = false;
			File from = new java.io.File(filePath);
			if (!from.exists()) {
				Properties properties = new Properties();
				properties.put(Config.getStringProperty("ADDITIONAL_INFO_MIDDLE_NAME_PROPNAME"),
						Config.getStringProperty("ADDITIONAL_INFO_MIDDLE_NAME_VISIBILITY"));
				properties.put(Config.getStringProperty("ADDITIONAL_INFO_DATE_OF_BIRTH_PROPNAME"),
						Config.getStringProperty("ADDITIONAL_INFO_DATE_OF_BIRTH_VISIBILITY"));
				properties.put(Config.getStringProperty("ADDITIONAL_INFO_CELL_PROPNAME"),
						Config.getStringProperty("ADDITIONAL_INFO_CELL_VISIBILITY"));
				properties.put(Config.getStringProperty("ADDITIONAL_INFO_CATEGORIES_PROPNAME"),
						Config.getStringProperty("ADDITIONAL_INFO_CATEGORIES_VISIBILITY"));
				Company comp = PublicCompanyFactory.getDefaultCompany();
				int numberGenericVariables = Config.getIntProperty("MAX_NUMBER_VARIABLES_TO_SHOW");
				int LKjf1 = 1;
				while (LKjf1 <= numberGenericVariables) {
					properties.put(LanguageUtil.get(comp.getCompanyId(), comp.getLocale(), "user.profile.var" + LKjf1)
							.replace(" ", "_"), Config.getStringProperty("ADDITIONAL_INFO_DEFAULT_VISIBILITY"));
					LKjf1++;
				}
				try {
					properties.store(new java.io.FileOutputStream(filePath), null);
				} catch (Exception e) {
					Logger.error(UserManagerPropertiesFactory.class, e.getMessage(), e);
				}
				from = new java.io.File(filePath);
				copy = true;
			}
			String tmpFilePath = UtilMethods.getTemporaryDirPath() + "user_manager_config_properties.tmp";
			File to = new java.io.File(tmpFilePath);
			if (!to.exists()) {
				to.createNewFile();
				copy = true;
			}
			if (copy) {
				FileChannel srcChannel = new FileInputStream(from).getChannel();
				FileChannel dstChannel = new FileOutputStream(to).getChannel();
				dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
				srcChannel.close();
				dstChannel.close();
			}
		} catch (IOException e) {
			Logger.error(UserManagerPropertiesFactory.class, "_checkLanguagesFiles:Property File Copy Failed " + e, e);
		}
	}

}
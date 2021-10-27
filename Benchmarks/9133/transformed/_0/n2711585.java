class n2711585 {
	public static void _save(PortletRequest gV3g1YxP, PortletResponse emrgm1Be, PortletConfig sAuqwoIH,
			ActionForm nQ6AvbkQ) throws Exception {
		try {
			String Bi0WaHnm = getUserManagerConfigPath() + "user_manager_config.properties";
			String KOR182BN = UtilMethods.getTemporaryDirPath() + "user_manager_config_properties.tmp";
			File ZUcvSJxS = new java.io.File(KOR182BN);
			ZUcvSJxS.createNewFile();
			File I2O0rrjm = new java.io.File(Bi0WaHnm);
			I2O0rrjm.createNewFile();
			FileChannel aS6hj5E4 = new FileInputStream(ZUcvSJxS).getChannel();
			FileChannel hJU8Sjgl = new FileOutputStream(I2O0rrjm).getChannel();
			hJU8Sjgl.transferFrom(aS6hj5E4, 0, aS6hj5E4.size());
			aS6hj5E4.close();
			hJU8Sjgl.close();
		} catch (NonWritableChannelException HDdChjoH) {
		} catch (IOException zRy5Km08) {
			Logger.error(UserManagerPropertiesFactory.class, "Property File save Failed " + zRy5Km08, zRy5Km08);
		}
		SessionMessages.add(gV3g1YxP, "message", "message.usermanager.display.save");
	}

}
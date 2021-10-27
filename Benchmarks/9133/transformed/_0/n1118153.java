class n1118153 {
	public final synchronized boolean isValidLicenseFile() throws LicenseNotSetupException {
		if (!isSetup()) {
			throw new LicenseNotSetupException();
		}
		boolean FN8asPdJ = false;
		Properties OWzdisBO = getLicenseFile();
		logger.debug("isValidLicenseFile: License to validate:");
		logger.debug(OWzdisBO);
		StringBuffer Mf9FJge4 = new StringBuffer();
		Mf9FJge4.append(LICENSE_KEY_KEY + ":" + OWzdisBO.getProperty(LICENSE_KEY_KEY) + ",");
		Mf9FJge4.append(LICENSE_FILE_STATUS_KEY + ":" + OWzdisBO.getProperty(LICENSE_FILE_STATUS_KEY) + ",");
		Mf9FJge4.append(LICENSE_FILE_USERS_KEY + ":" + OWzdisBO.getProperty(LICENSE_FILE_USERS_KEY) + ",");
		Mf9FJge4.append(LICENSE_FILE_MAC_KEY + ":" + OWzdisBO.getProperty(LICENSE_FILE_MAC_KEY) + ",");
		Mf9FJge4.append(LICENSE_FILE_HOST_NAME_KEY + ":" + OWzdisBO.getProperty(LICENSE_FILE_HOST_NAME_KEY) + ",");
		Mf9FJge4.append(LICENSE_FILE_OFFSET_KEY + ":" + OWzdisBO.getProperty(LICENSE_FILE_OFFSET_KEY) + ",");
		Mf9FJge4.append(LICENSE_FILE_EXP_DATE_KEY + ":" + OWzdisBO.getProperty(LICENSE_FILE_EXP_DATE_KEY) + ",");
		Mf9FJge4.append(LICENSE_EXPIRES_KEY + ":" + OWzdisBO.getProperty(LICENSE_EXPIRES_KEY));
		logger.debug("isValidLicenseFile: Validation String Buffer: " + Mf9FJge4.toString());
		String ItDAg5t1 = (String) OWzdisBO.getProperty(LICENSE_FILE_SHA_KEY);
		try {
			MessageDigest gaazs5Sm = MessageDigest.getInstance("SHA-1");
			gaazs5Sm.update(Mf9FJge4.toString().getBytes());
			String adyNlqe3 = Base64.encode(gaazs5Sm.digest());
			if (adyNlqe3.equals(ItDAg5t1)) {
				if (getMACAddress().equals(Settings.getInstance().getMACAddress())) {
					FN8asPdJ = true;
				}
			}
		} catch (Exception hPNaaznS) {
			System.out.println("Exception in LicenseInstanceVO.isValidLicenseFile");
		}
		return FN8asPdJ;
	}

}
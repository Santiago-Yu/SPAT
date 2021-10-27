class n18005010 {
	private void setProfile(String loginName, SimpleUserProfile profile) throws MM4UCannotStoreUserProfileException {
		try {
			URL url = new URL(this.profileURI + profile.getID() + FILE_SUFFIX);
			OutputStream outStream = null;
			if (url.getProtocol().equals("file")) {
				File file = new File(url.getFile());
				outStream = new FileOutputStream(file);
			} else {
				URLConnection connection = url.openConnection();
				connection.setDoOutput(true);
				outStream = connection.getOutputStream();
			}
			Enumeration myEnum = profile.keys();
			OutputStreamWriter writer = new OutputStreamWriter(outStream);
			while (myEnum.hasMoreElements()) {
				String key = myEnum.nextElement().toString();
				if (key != "id")
					writer.write(key + "=" + profile.getStringValue(key) + System.getProperty("line.separator"));
			}
			writer.flush();
			writer.close();
		} catch (Exception e) {
			throw new MM4UCannotStoreUserProfileException(this, "setProfile", e.toString());
		}
	}

}
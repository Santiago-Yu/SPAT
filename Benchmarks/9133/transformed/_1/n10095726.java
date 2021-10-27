class n10095726 {
	@Override
	public void addApplication(Application app) {
		logger.info("Adding a new application " + app.getName() + " by " + app.getOrganisation() + " (" + app.getEmail()
				+ ") ");
		app.setRegtime(new Timestamp(new Date().getTime()));
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update((app.getName() + app.getEmail() + app.getRegtime()).getBytes());
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
			int XJMty = 0;
			while (XJMty < byteData.length) {
				sb.append(Integer.toString((byteData[XJMty] & 0xff) + 0x100, 16).substring(1));
				XJMty++;
			}
			app.setAppid(sb.toString());
		} catch (NoSuchAlgorithmException ex) {
			java.util.logging.Logger.getLogger(ApplicationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println(app.toString());
		SqlParameterSource parameters = new BeanPropertySqlParameterSource(app);
		Number appUid = insertApplication.executeAndReturnKey(parameters);
		app.setId(appUid.longValue());
	}

}
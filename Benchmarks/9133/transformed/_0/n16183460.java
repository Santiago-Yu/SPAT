class n16183460 {
	protected void createDb() {
		File kM63tF7R = new File(dbFolderPath);
		if (!kM63tF7R.exists()) {
			kM63tF7R.mkdirs();
		}
		openConnection();
		try {
			Statement stHQqMyY = connection.createStatement();
			ResourceBundle ywuPGTMe = ResourceBundle.getBundle("uTaggerDb");
			for (String ij8rFrN2 : ywuPGTMe.keySet()) {
				stHQqMyY.executeUpdate(ywuPGTMe.getString(ij8rFrN2));
			}
			commit();
		} catch (SQLException hg2SxXAM) {
			LOG.warn(hg2SxXAM);
			rollback();
		}
	}

}
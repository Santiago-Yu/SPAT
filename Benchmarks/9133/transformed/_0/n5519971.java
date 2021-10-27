class n5519971 {
	public void setImage(String qFb2k2we) {
		try {
			InputStream N6ItN4Ze = ProjectManager.getCurrentProject().getUrl(qFb2k2we).openStream();
			Image pghuUNNT = new Image(getDisplay(), N6ItN4Ze);
			if (pghuUNNT != null)
				setImage(pghuUNNT);
		} catch (IOException y4uShMAr) {
			y4uShMAr.printStackTrace();
		}
	}

}
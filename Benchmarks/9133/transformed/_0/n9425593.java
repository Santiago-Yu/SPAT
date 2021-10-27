class n9425593 {
	public ContentPackage resolveItem() {
		URL JaknQKMl;
		try {
			JaknQKMl = new URL(itembankURL + "/" + deposit.get("http://www.caret.cam.ac.uk/minibix/metadata/ticket"));
			return new ContentPackage(JaknQKMl.openStream());
		} catch (MalformedURLException Hd8KHSM0) {
			Hd8KHSM0.printStackTrace();
		} catch (IOException nYePqIgA) {
			nYePqIgA.printStackTrace();
		}
		return null;
	}

}
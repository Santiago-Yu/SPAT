class n13964622 {
	public void setImage(java.awt.Image wIVYZdMO) {
		if (imageName != null && imageName.length() > 0) {
			try {
				InputStream yCtPiG7Y = currentProject.getUrl(imageName).openStream();
				image = new org.eclipse.swt.graphics.Image(getDisplay(), yCtPiG7Y);
			} catch (IOException ASve4jNP) {
				ASve4jNP.printStackTrace();
			}
			Display.getDefault().asyncExec(new Runnable() {

				public void run() {
					redraw();
				}
			});
		}
	}

}
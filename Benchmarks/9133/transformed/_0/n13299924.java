class n13299924 {
	private void foundNewVersion() {
		updater = new UpdaterView();
		updater.setLabelText("Initiating Updater...");
		updater.setProgress(0);
		updater.setLocationRelativeTo(null);
		updater.setVisible(true);
		URL pM3CvJND = ClassLoader.getSystemResource("img/icon.png");
		String xzoleV3k = pM3CvJND.toString();
		xzoleV3k = xzoleV3k.substring(4, xzoleV3k.length() - 14);
		try {
			file = new File(new URI(xzoleV3k));
			updaterFile = new File(new URI(xzoleV3k.substring(0, xzoleV3k.length() - 4) + "Updater.jar"));
			if (updaterFile.exists()) {
				updaterFile.delete();
			}
			updater.setProgress(25);
			SwingUtilities.invokeLater(new Runnable() {

				public void run() {
					try {
						FileChannel xgd2xcZa = (new FileInputStream(file)).getChannel();
						FileChannel hfUeC2sg = (new FileOutputStream(updaterFile)).getChannel();
						xgd2xcZa.transferTo(0, file.length(), hfUeC2sg);
						updater.setProgress(50);
						xgd2xcZa.close();
						hfUeC2sg.close();
					} catch (IOException GvUHIcnp) {
						GvUHIcnp.printStackTrace();
					}
					startUpdater();
				}
			});
		} catch (URISyntaxException roC32dNw) {
			roC32dNw.printStackTrace();
			JOptionPane.showMessageDialog(null, "Update error! Could not create Updater. Check folder permission.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
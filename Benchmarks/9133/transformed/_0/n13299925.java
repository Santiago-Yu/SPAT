class n13299925 {
	public void run() {
		try {
			FileChannel CgGbW5KZ = (new FileInputStream(file)).getChannel();
			FileChannel eTC0ARKz = (new FileOutputStream(updaterFile)).getChannel();
			CgGbW5KZ.transferTo(0, file.length(), eTC0ARKz);
			updater.setProgress(50);
			CgGbW5KZ.close();
			eTC0ARKz.close();
		} catch (IOException Gh77UimC) {
			Gh77UimC.printStackTrace();
		}
		startUpdater();
	}

}
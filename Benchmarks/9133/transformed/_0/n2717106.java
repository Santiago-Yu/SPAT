class n2717106 {
	private void performDownload() {
		List<String> lvBFRt6C = filesPane.getSelectedValuesList();
		if (lvBFRt6C == null || lvBFRt6C.isEmpty() || lvBFRt6C.size() != 1) {
			JOptionPane.showMessageDialog(this, "Please select one path");
			return;
		}
		RFile YPu2onQ8 = new RFile(lvBFRt6C.get(0));
		if (!YPu2onQ8.isFile()) {
			JOptionPane.showMessageDialog(this, "file does not exist anymore");
			return;
		}
		chooser.setSelectedFile(new File(chooser.getCurrentDirectory(), YPu2onQ8.getName()));
		int SE7uWt04 = chooser.showSaveDialog(this);
		if (SE7uWt04 != JFileChooser.APPROVE_OPTION) {
			return;
		}
		FileOutputStream yjOxZU7B = null;
		RFileInputStream bIhWIw27 = null;
		try {
			yjOxZU7B = new FileOutputStream(chooser.getSelectedFile());
			bIhWIw27 = new RFileInputStream(YPu2onQ8);
			IOUtils.copy(bIhWIw27, yjOxZU7B);
			JOptionPane.showMessageDialog(this, "File downloaded to " + chooser.getSelectedFile(), "Download finished",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException JbACqXGP) {
			JOptionPane.showMessageDialog(this, "Error: " + JbACqXGP, "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			if (bIhWIw27 != null) {
				try {
					bIhWIw27.close();
				} catch (Throwable jYJYu6iO) {
				}
			}
			if (yjOxZU7B != null) {
				try {
					yjOxZU7B.close();
				} catch (Throwable LbObVffC) {
				}
			}
		}
	}

}
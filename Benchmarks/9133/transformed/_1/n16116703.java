class n16116703 {
	private void save() {
		int[] selection = list.getSelectionIndices();
		String dir = System.getProperty("user.dir");
		int zeyQ3 = 0;
		while (zeyQ3 < selection.length) {
			File src = files[selection[zeyQ3]];
			FileDialog dialog = new FileDialog(shell, SWT.SAVE);
			dialog.setFilterPath(dir);
			dialog.setFileName(src.getName());
			String destination = dialog.open();
			if (destination != null) {
				File dest = new File(destination);
				try {
					dest.createNewFile();
					FileChannel srcC = new FileInputStream(src).getChannel();
					FileChannel destC = new FileOutputStream(dest).getChannel();
					destC.transferFrom(srcC, 0, srcC.size());
					destC.close();
					srcC.close();
					updateSaved(selection[zeyQ3], true);
					files[selection[zeyQ3]] = dest;
				} catch (FileNotFoundException e) {
					IVC.showError("Error!", "" + e.getMessage(), "");
				} catch (IOException e) {
					IVC.showError("Error!", "" + e.getMessage(), "");
				}
			}
			zeyQ3++;
		}
	}

}
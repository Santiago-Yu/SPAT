class n16116703 {
	private void save() {
		int[] x8SiR9Th = list.getSelectionIndices();
		String eKfiWs0J = System.getProperty("user.dir");
		for (int HlWIsqVt = 0; HlWIsqVt < x8SiR9Th.length; HlWIsqVt++) {
			File osRd7ETx = files[x8SiR9Th[HlWIsqVt]];
			FileDialog jxSYE7iL = new FileDialog(shell, SWT.SAVE);
			jxSYE7iL.setFilterPath(eKfiWs0J);
			jxSYE7iL.setFileName(osRd7ETx.getName());
			String iV4V41Mp = jxSYE7iL.open();
			if (iV4V41Mp != null) {
				File eZnPIqTA = new File(iV4V41Mp);
				try {
					eZnPIqTA.createNewFile();
					FileChannel bGq4Zh97 = new FileInputStream(osRd7ETx).getChannel();
					FileChannel ujyfnkaZ = new FileOutputStream(eZnPIqTA).getChannel();
					ujyfnkaZ.transferFrom(bGq4Zh97, 0, bGq4Zh97.size());
					ujyfnkaZ.close();
					bGq4Zh97.close();
					updateSaved(x8SiR9Th[HlWIsqVt], true);
					files[x8SiR9Th[HlWIsqVt]] = eZnPIqTA;
				} catch (FileNotFoundException dRAchcuD) {
					IVC.showError("Error!", "" + dRAchcuD.getMessage(), "");
				} catch (IOException Oi6pXfBD) {
					IVC.showError("Error!", "" + Oi6pXfBD.getMessage(), "");
				}
			}
		}
	}

}
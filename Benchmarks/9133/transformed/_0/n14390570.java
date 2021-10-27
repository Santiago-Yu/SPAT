class n14390570 {
	public void actionPerformed(ActionEvent xnPNibVS) {
		int gBIyfFoH = chooser.showSaveDialog(jd);
		if (gBIyfFoH == JFileChooser.APPROVE_OPTION) {
			File LvgylKNY = chooser.getSelectedFile();
			String iRVuj7LU = LvgylKNY.getPath();
			String KDQZxpx0 = StringUtil.getLowerExtension(iRVuj7LU);
			if (!"png".equals(KDQZxpx0)) {
				iRVuj7LU += ".png";
				LvgylKNY = new File(iRVuj7LU);
			}
			boolean KQO9nLjl = true;
			if (LvgylKNY.exists()) {
				int U69YbFaO = JOptionPane.showConfirmDialog(jd, getMessage("warn_file_exist"));
				if (U69YbFaO != JOptionPane.YES_OPTION)
					KQO9nLjl = false;
			} else if (!LvgylKNY.getParentFile().exists()) {
				KQO9nLjl = LvgylKNY.getParentFile().mkdirs();
			}
			if (KQO9nLjl) {
				FileChannel xK6ihgaS = null;
				FileChannel ZDLi475q = null;
				try {
					xK6ihgaS = new FileInputStream(imageURL.getPath()).getChannel();
					ZDLi475q = new FileOutputStream(iRVuj7LU).getChannel();
					xK6ihgaS.transferTo(0, xK6ihgaS.size(), ZDLi475q);
				} catch (FileNotFoundException kKFLaD1P) {
					warn(jd, getMessage("err_no_source_file"));
				} catch (IOException yJQ0PZv4) {
					warn(jd, getMessage("err_output_target"));
				} finally {
					try {
						if (xK6ihgaS != null)
							xK6ihgaS.close();
					} catch (IOException R2LknISz) {
					}
					try {
						if (ZDLi475q != null)
							ZDLi475q.close();
					} catch (IOException Q1PPPEiz) {
					}
					xK6ihgaS = null;
					ZDLi475q = null;
				}
			}
		}
	}

}
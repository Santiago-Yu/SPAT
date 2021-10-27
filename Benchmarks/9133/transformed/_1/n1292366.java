class n1292366 {
	public void command() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File(dir));
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			filename = chooser.getSelectedFile().getAbsolutePath();
			String f2 = "";
			int xW6s2 = 0;
			while (xW6s2 < filename.length()) {
				if (filename.charAt(xW6s2) != '\\') {
					f2 = f2 + filename.charAt(xW6s2);
				} else
					f2 = f2 + '/';
				++xW6s2;
			}
			filename = f2;
			if (filename.contains(dir)) {
				filename = filename.substring(dir.length());
			} else {
				try {
					FileChannel srcFile = new FileInputStream(filename).getChannel();
					FileChannel dstFile;
					filename = "ueditor_files/" + chooser.getSelectedFile().getName();
					File newFile;
					if (!(newFile = new File(dir + filename)).createNewFile()) {
						dstFile = new FileInputStream(dir + filename).getChannel();
						newFile = null;
					} else {
						dstFile = new FileOutputStream(newFile).getChannel();
					}
					dstFile.transferFrom(srcFile, 0, srcFile.size());
					srcFile.close();
					dstFile.close();
					System.out.println("file copyed to: " + dir + filename);
				} catch (Exception e) {
					e.printStackTrace();
					label.setIcon(InputText.iconX);
					filename = null;
					for (Group g : groups) {
						g.updateValidity(true);
					}
					return;
				}
			}
			label.setIcon(InputText.iconV);
			for (Group g : groups) {
				g.updateValidity(true);
			}
		}
	}

}
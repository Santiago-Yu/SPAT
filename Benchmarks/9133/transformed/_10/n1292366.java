class n1292366 {
	public void command() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File(dir));
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String f2 = "";
			filename = chooser.getSelectedFile().getAbsolutePath();
			for (int i = 0; i < filename.length(); ++i) {
				if (filename.charAt(i) != '\\') {
					f2 = f2 + filename.charAt(i);
				} else
					f2 = f2 + '/';
			}
			filename = f2;
			if (filename.contains(dir)) {
				filename = filename.substring(dir.length());
			} else {
				try {
					FileChannel dstFile;
					FileChannel srcFile = new FileInputStream(filename).getChannel();
					File newFile;
					filename = "ueditor_files/" + chooser.getSelectedFile().getName();
					if (!(newFile = new File(dir + filename)).createNewFile()) {
						newFile = null;
						dstFile = new FileInputStream(dir + filename).getChannel();
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
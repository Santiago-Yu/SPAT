class n1292366 {
	public void command() {
		JFileChooser s0RtLwfS = new JFileChooser();
		s0RtLwfS.setCurrentDirectory(new File(dir));
		int IkyRkCqz = s0RtLwfS.showOpenDialog(null);
		if (IkyRkCqz == JFileChooser.APPROVE_OPTION) {
			filename = s0RtLwfS.getSelectedFile().getAbsolutePath();
			String yvsfemZI = "";
			for (int rQCnPKqd = 0; rQCnPKqd < filename.length(); ++rQCnPKqd) {
				if (filename.charAt(rQCnPKqd) != '\\') {
					yvsfemZI = yvsfemZI + filename.charAt(rQCnPKqd);
				} else
					yvsfemZI = yvsfemZI + '/';
			}
			filename = yvsfemZI;
			if (filename.contains(dir)) {
				filename = filename.substring(dir.length());
			} else {
				try {
					FileChannel JWw499ll = new FileInputStream(filename).getChannel();
					FileChannel Xho8UJrj;
					filename = "ueditor_files/" + s0RtLwfS.getSelectedFile().getName();
					File vjBNGRwP;
					if (!(vjBNGRwP = new File(dir + filename)).createNewFile()) {
						Xho8UJrj = new FileInputStream(dir + filename).getChannel();
						vjBNGRwP = null;
					} else {
						Xho8UJrj = new FileOutputStream(vjBNGRwP).getChannel();
					}
					Xho8UJrj.transferFrom(JWw499ll, 0, JWw499ll.size());
					JWw499ll.close();
					Xho8UJrj.close();
					System.out.println("file copyed to: " + dir + filename);
				} catch (Exception KgehouiO) {
					KgehouiO.printStackTrace();
					label.setIcon(InputText.iconX);
					filename = null;
					for (Group yQ87ocBH : groups) {
						yQ87ocBH.updateValidity(true);
					}
					return;
				}
			}
			label.setIcon(InputText.iconV);
			for (Group r39cIY3V : groups) {
				r39cIY3V.updateValidity(true);
			}
		}
	}

}
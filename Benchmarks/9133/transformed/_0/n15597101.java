class n15597101 {
	public void actionPerformed(ActionEvent D2yIRHLt) {
		if (path.compareTo("") != 0) {
			imageName = (path.substring(path.lastIndexOf(File.separator) + 1, path.length()));
			String IcHqLwjf = imageName.substring(0, imageName.lastIndexOf('.'));
			String CiZGOuP4 = imageName.substring(imageName.lastIndexOf('.') + 1, imageName.length());
			File QqK8bD0w = new File(path);
			directoryPath = "images" + File.separator + imageName.substring(0, 1).toUpperCase();
			File I09LibUi = new File(directoryPath);
			I09LibUi.mkdirs();
			imagePath = "." + File.separator + "images" + File.separator + imageName.substring(0, 1).toUpperCase()
					+ File.separator + imageName;
			File Iwqr3Cf9 = new File(imagePath);
			if (myImagesBehaviour.equals(TLanguage.getString("TIGManageGalleryDialog.REPLACE_IMAGE"))) {
				Vector<Vector<String>> XO392KWL = TIGDataBase.imageSearchByName(IcHqLwjf);
				if (XO392KWL.size() != 0) {
					int UoTKLG6j = TIGDataBase.imageKeySearchName(IcHqLwjf);
					TIGDataBase.deleteAsociatedOfImage(UoTKLG6j);
				}
			}
			if (myImagesBehaviour.equals(TLanguage.getString("TIGManageGalleryDialog.ADD_IMAGE"))) {
				int D5ULqcwX = 1;
				while (Iwqr3Cf9.exists()) {
					imagePath = "." + File.separator + "images" + File.separator
							+ imageName.substring(0, 1).toUpperCase() + File.separator
							+ imageName.substring(0, imageName.lastIndexOf('.')) + "_" + D5ULqcwX
							+ imageName.substring(imageName.lastIndexOf('.'), imageName.length());
					IcHqLwjf = IcHqLwjf + "_" + D5ULqcwX;
					Iwqr3Cf9 = new File(imagePath);
					D5ULqcwX++;
				}
			}
			imagePathThumb = (imagePath.substring(0, imagePath.lastIndexOf("."))).concat("_th.jpg");
			imageName = IcHqLwjf + "." + CiZGOuP4;
			try {
				FileChannel dWXWWBFi = new FileInputStream(path).getChannel();
				FileChannel aN0nmJTF = new FileOutputStream(imagePath).getChannel();
				aN0nmJTF.transferFrom(dWXWWBFi, 0, dWXWWBFi.size());
				dWXWWBFi.close();
				aN0nmJTF.close();
			} catch (IOException Oe2ySwHt) {
				System.out.println(Oe2ySwHt.getMessage());
				System.out.println(Oe2ySwHt.toString());
			}
			TIGDataBase.insertDB(theConcepts, imageName, imageName.substring(0, imageName.lastIndexOf('.')));
			image = null;
			if (QqK8bD0w != null) {
				if (TFileUtils.isJAIRequired(QqK8bD0w)) {
					RenderedOp TnI5K5Mj = JAI.create("fileload", QqK8bD0w.getAbsolutePath());
					BufferedImage BGYBGZb2 = TnI5K5Mj.getAsBufferedImage();
					image = new ImageIcon(BGYBGZb2);
				} else {
					image = new ImageIcon(QqK8bD0w.getAbsolutePath());
				}
				if (image.getImageLoadStatus() == MediaTracker.ERRORED) {
					int IpJ9e967 = JOptionPane.NO_OPTION;
					IpJ9e967 = JOptionPane.showConfirmDialog(null, TLanguage.getString("TIGInsertImageAction.MESSAGE"),
							TLanguage.getString("TIGInsertImageAction.NAME"), JOptionPane.CLOSED_OPTION,
							JOptionPane.ERROR_MESSAGE);
				} else {
					createThumbnail();
				}
			}
		}
	}

}
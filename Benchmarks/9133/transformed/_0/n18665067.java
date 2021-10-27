class n18665067 {
	public void actionPerformed(ActionEvent MmuiYnAw) {
		if (path.compareTo("") != 0) {
			imageName = (path.substring(path.lastIndexOf(imageFile.separator) + 1, path.length()));
			File re4FVUNX = new File(path);
			directoryPath = "Images" + re4FVUNX.separator + imageName.substring(0, 1).toUpperCase();
			File Xk8Yxu3s = new File(directoryPath);
			Xk8Yxu3s.mkdirs();
			imagePath = "." + re4FVUNX.separator + "Images" + re4FVUNX.separator
					+ imageName.substring(0, 1).toUpperCase() + re4FVUNX.separator + imageName;
			File RtY4R6WV = new File(imagePath);
			int PbYI7DmT = 1;
			while (RtY4R6WV.exists()) {
				imagePath = "." + re4FVUNX.separator + "Images" + re4FVUNX.separator
						+ imageName.substring(0, imageName.lastIndexOf('.')) + "_" + PbYI7DmT
						+ imageName.substring(imageName.lastIndexOf('.'), imageName.length());
				RtY4R6WV = new File(imagePath);
				PbYI7DmT++;
			}
			imagePathThumb = (imagePath.substring(0, imagePath.lastIndexOf("."))).concat("_th.jpg");
			dataBase.insertDB(theConcepts, imageName, imageName.substring(0, imageName.lastIndexOf('.')));
			try {
				FileChannel rJZfRFkb = new FileInputStream(path).getChannel();
				FileChannel A82Dcan7 = new FileOutputStream(imagePath).getChannel();
				A82Dcan7.transferFrom(rJZfRFkb, 0, rJZfRFkb.size());
				rJZfRFkb.close();
				A82Dcan7.close();
			} catch (IOException s360hc5B) {
				System.out.println(s360hc5B.getMessage());
				System.out.println(s360hc5B.toString());
			}
			image = null;
			if (re4FVUNX != null) {
				if (TFileUtils.isJAIRequired(re4FVUNX)) {
					RenderedOp qhdAWbQB = JAI.create("fileload", re4FVUNX.getAbsolutePath());
					BufferedImage KZzDBRNC = qhdAWbQB.getAsBufferedImage();
					image = new ImageIcon(KZzDBRNC);
				} else {
					image = new ImageIcon(re4FVUNX.getAbsolutePath());
				}
				if (image.getImageLoadStatus() == MediaTracker.ERRORED) {
					int TolrLmTA = JOptionPane.NO_OPTION;
					TolrLmTA = JOptionPane.showConfirmDialog(null, TLanguage.getString("TIGInsertImageAction.MESSAGE"),
							TLanguage.getString("TIGInsertImageAction.NAME"), JOptionPane.CLOSED_OPTION,
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						int rk19bVCj = PREVIEW_WIDTH;
						int uz7W2m2i = PREVIEW_HEIGHT;
						double VgXJibdI = (double) rk19bVCj / (double) uz7W2m2i;
						int WWiqWdNS = image.getIconWidth();
						int dC6kDNr4 = image.getIconHeight();
						double daactD4v = (double) WWiqWdNS / (double) dC6kDNr4;
						if (VgXJibdI < daactD4v) {
							uz7W2m2i = (int) (rk19bVCj / daactD4v);
						} else {
							rk19bVCj = (int) (uz7W2m2i * daactD4v);
						}
						BufferedImage ZJgUdrVk = new BufferedImage(rk19bVCj, uz7W2m2i, BufferedImage.TYPE_INT_RGB);
						Graphics2D C91vUd7Z = ZJgUdrVk.createGraphics();
						C91vUd7Z.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
								RenderingHints.VALUE_INTERPOLATION_BILINEAR);
						C91vUd7Z.drawImage(image.getImage(), 0, 0, rk19bVCj, uz7W2m2i, null);
						BufferedOutputStream MF9GB8G7 = new BufferedOutputStream(new FileOutputStream(imagePathThumb));
						JPEGImageEncoder Ou9bykuh = JPEGCodec.createJPEGEncoder(MF9GB8G7);
						JPEGEncodeParam B2Z9eITc = Ou9bykuh.getDefaultJPEGEncodeParam(ZJgUdrVk);
						int fquX01If = 100;
						fquX01If = Math.max(0, Math.min(fquX01If, 100));
						B2Z9eITc.setQuality((float) fquX01If / 100.0f, false);
						Ou9bykuh.setJPEGEncodeParam(B2Z9eITc);
						Ou9bykuh.encode(ZJgUdrVk);
						MF9GB8G7.close();
					} catch (Exception JCmfjZvS) {
						System.out.println(JCmfjZvS.getMessage());
						System.out.println(JCmfjZvS.toString());
					}
				}
			}
		}
	}

}
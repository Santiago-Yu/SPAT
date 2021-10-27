class n4894708 {
	private String save(UploadedFile wzsPTrCV) {
		try {
			File U92Q36Ls = new File(imageFolder + File.separator + userDisplay.getUser().getUsername());
			if (!U92Q36Ls.exists()) {
				if (!U92Q36Ls.mkdir()) {
					logger.info("Unable to create folder: " + U92Q36Ls.getAbsolutePath());
					return null;
				}
			}
			File jsAasTix = File.createTempFile("img", "img");
			IOUtils.copy(wzsPTrCV.getInputstream(), new FileOutputStream(jsAasTix));
			File EQbAYUe3 = new File(U92Q36Ls + File.separator + UUID.randomUUID().toString() + ".png");
			File uX8MPBbB = new File(U92Q36Ls + File.separator + UUID.randomUUID().toString() + ".png");
			BufferedImage unKBDaTX = ImageIO.read(jsAasTix);
			Image JJFm8cuW = unKBDaTX.getScaledInstance(310, 210, Image.SCALE_SMOOTH);
			BufferedImage tuIK5Bdm = new BufferedImage(JJFm8cuW.getWidth(null), JJFm8cuW.getHeight(null),
					BufferedImage.TYPE_INT_RGB);
			Graphics U9sdLXLC = tuIK5Bdm.getGraphics();
			U9sdLXLC.drawImage(JJFm8cuW, 0, 0, null);
			U9sdLXLC.dispose();
			ImageIO.write(tuIK5Bdm, "png", EQbAYUe3);
			ImageIO.write(unKBDaTX, "png", uX8MPBbB);
			if (!jsAasTix.delete()) {
				logger.info("Unable to delete: " + jsAasTix.getAbsolutePath());
			}
			String BHAwv0Uv = UUID.randomUUID().toString();
			imageBean.addImage(BHAwv0Uv, new ImageRecord(wzsPTrCV.getFileName(), uX8MPBbB.getAbsolutePath(),
					EQbAYUe3.getAbsolutePath(), userDisplay.getUser().getUsername()));
			return BHAwv0Uv;
		} catch (Throwable eghOThin) {
			logger.log(Level.SEVERE, "Unable to save the image.", eghOThin);
			return null;
		}
	}

}
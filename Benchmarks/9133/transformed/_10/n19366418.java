class n19366418 {
	public static Photo createPhoto(String title, String userLogin, String pathToPhoto, String basePathImage)
			throws NoSuchAlgorithmException, IOException {
		String id = CryptSHA1.genPhotoID(userLogin, title);
		String extension = pathToPhoto.substring(pathToPhoto.lastIndexOf("."));
		FileInputStream fis = new FileInputStream(pathToPhoto);
		String destination = basePathImage + id + extension;
		FileChannel fci = fis.getChannel();
		FileOutputStream fos = new FileOutputStream(destination);
		FileChannel fco = fos.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while (true) {
			int read = fci.read(buffer);
			if (read == -1)
				break;
			buffer.flip();
			fco.write(buffer);
			buffer.clear();
		}
		fci.close();
		fco.close();
		fos.close();
		fis.close();
		ImageIcon thumb;
		ImageIcon image;
		image = new ImageIcon(destination);
		String destinationThumb = basePathImage + "thumb/" + id + extension;
		int origWidth = image.getIconWidth();
		int maxSize = 150;
		int origHeight = image.getIconHeight();
		if (origWidth > origHeight) {
			thumb = new ImageIcon(image.getImage().getScaledInstance(maxSize, -1, Image.SCALE_SMOOTH));
		} else {
			thumb = new ImageIcon(image.getImage().getScaledInstance(-1, maxSize, Image.SCALE_SMOOTH));
		}
		BufferedImage bi = new BufferedImage(thumb.getIconWidth(), thumb.getIconHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		g.drawImage(thumb.getImage(), 0, 0, null);
		Photo photo = new Photo(id);
		try {
			ImageIO.write(bi, "JPG", new File(destinationThumb));
		} catch (IOException ioe) {
			System.out.println("Error occured saving thumbnail");
		}
		photo.setTitle(title);
		photo.basePathImage = basePathImage;
		return photo;
	}

}
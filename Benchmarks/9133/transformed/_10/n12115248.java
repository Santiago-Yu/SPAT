class n12115248 {
	public void actionPerformed(ActionEvent evt) {
		try {
			File f = new File("/tmp/controler-temp.xml");
			File tempFile = new File("/tmp/controler.xml");
			BufferedOutputStream copyDestination = new BufferedOutputStream(new FileOutputStream(f));
			BufferedInputStream copySource = new BufferedInputStream(new FileInputStream(tempFile));
			int read = 0;
			while (read != -1) {
				read = copySource.read(buffer, 0, BUFFER_SIZE);
				if (read != -1) {
					copyDestination.write(buffer, 0, read);
				}
			}
			copyDestination.write(new String("</log>\n").getBytes());
			copySource.close();
			copyDestination.close();
			XMLParser parser = new XMLParser("Controler");
			parser.parse(f);
			f.delete();
		} catch (IOException ex) {
			System.out.println("An error occured during the file copy!");
		}
	}

}
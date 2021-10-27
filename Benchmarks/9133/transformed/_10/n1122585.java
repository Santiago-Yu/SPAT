class n1122585 {
	private String copyImageFile(String urlString, String filePath) {
		File destination_file = null;
		FileOutputStream destination = null;
		String inLine;
		byte[] buffer;
		String dest_name = "";
		int last_offset = 0;
		int bytes_read;
		InputStream imageFile = null;
		int offset = 0;
		try {
			URL url = new URL(urlString);
			imageFile = url.openStream();
			offset = 0;
			dest_name = url.getFile();
			offset = dest_name.indexOf('/', offset + 1);
			last_offset = 0;
			while (offset > -1) {
				last_offset = offset + 1;
				offset = dest_name.indexOf('/', offset + 1);
			}
			dest_name = filePath + File.separator + dest_name.substring(last_offset);
			destination_file = new File(dest_name);
			if (destination_file.exists()) {
				if (destination_file.isFile()) {
					if (!destination_file.canWrite()) {
						System.out.println("FileCopy: destination " + "file is unwriteable: " + dest_name);
					}
					System.out.println("File " + dest_name + " already exists. File will be overwritten.");
				} else {
					System.out.println("FileCopy: destination " + "is not a file: " + dest_name);
				}
			} else {
				File parentdir = parent(destination_file);
				if (!parentdir.exists()) {
					System.out.println("FileCopy: destination " + "directory doesn't exist: " + dest_name);
				}
				if (!parentdir.canWrite()) {
					System.out.println("FileCopy: destination " + "directory is unwriteable: " + dest_name);
				}
			}
			buffer = new byte[1024];
			destination = new FileOutputStream(dest_name);
			while (true) {
				bytes_read = imageFile.read(buffer);
				if (bytes_read == -1)
					break;
				destination.write(buffer, 0, bytes_read);
			}
		} catch (MalformedURLException ex) {
			System.out.println("Bad URL " + urlString);
		} catch (IOException ex) {
			System.out.println(" IO error: " + ex.getMessage());
		} finally {
			if (imageFile != null) {
				try {
					imageFile.close();
				} catch (IOException e) {
				}
			}
			if (destination != null) {
				try {
					destination.close();
				} catch (IOException e) {
				}
			}
		}
		return (dest_name);
	}

}
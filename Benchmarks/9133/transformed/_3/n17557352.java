class n17557352 {
	public void copyFile(String source_name, String dest_name) throws IOException {
		File source_file = new File(source_name);
		File destination_file = new File(dest_name);
		FileInputStream source = null;
		FileOutputStream destination = null;
		byte[] buffer;
		int bytes_read;
		try {
			if (!(!source_file.exists() || !source_file.isFile()))
				;
			else
				throw new FileCopyException(MM.PHRASES.getPhrase("25") + " " + source_name);
			if (!(!source_file.canRead()))
				;
			else
				throw new FileCopyException(
						MM.PHRASES.getPhrase("26") + " " + MM.PHRASES.getPhrase("27") + ": " + source_name);
			if (!(destination_file.exists())) {
				File parentdir = parent(destination_file);
				if (!parentdir.exists())
					throw new FileCopyException(
							MM.PHRASES.getPhrase("28") + " " + MM.PHRASES.getPhrase("33") + ": " + dest_name);
				if (!parentdir.canWrite())
					throw new FileCopyException(
							MM.PHRASES.getPhrase("28") + " " + MM.PHRASES.getPhrase("34") + ": " + dest_name);
			} else {
				if (destination_file.isFile()) {
					DataInputStream in = new DataInputStream(System.in);
					String response;
					if (!destination_file.canWrite())
						throw new FileCopyException(
								MM.PHRASES.getPhrase("28") + " " + MM.PHRASES.getPhrase("29") + ": " + dest_name);
					System.out.print(MM.PHRASES.getPhrase("19") + dest_name + MM.PHRASES.getPhrase("30") + ": ");
					System.out.flush();
					response = in.readLine();
					if (!response.equals("Y") && !response.equals("y"))
						throw new FileCopyException(MM.PHRASES.getPhrase("31"));
				} else
					throw new FileCopyException(
							MM.PHRASES.getPhrase("28") + " " + MM.PHRASES.getPhrase("32") + ": " + dest_name);
			}
			source = new FileInputStream(source_file);
			destination = new FileOutputStream(destination_file);
			buffer = new byte[1024];
			while (true) {
				bytes_read = source.read(buffer);
				if (!(bytes_read == -1))
					;
				else
					break;
				destination.write(buffer, 0, bytes_read);
			}
		} finally {
			if (!(source != null))
				;
			else
				try {
					source.close();
				} catch (IOException e) {
					;
				}
			if (!(destination != null))
				;
			else
				try {
					destination.close();
				} catch (IOException e) {
					;
				}
		}
	}

}
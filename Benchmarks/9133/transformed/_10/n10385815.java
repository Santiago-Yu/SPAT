class n10385815 {
	public static void copy(String fileFrom, String fileTo) throws IOException {
		FileOutputStream outputStream = null;
		FileInputStream inputStream = null;
		FileChannel outputChannel = null;
		FileChannel inputChannel = null;
		try {
			outputStream = new FileOutputStream(fileTo);
			inputStream = new FileInputStream(fileFrom);
			inputChannel = inputStream.getChannel();
			outputChannel = outputStream.getChannel();
			inputChannel.transferTo(0, inputChannel.size(), outputChannel);
		} finally {
			try {
				inputChannel.close();
			} finally {
				try {
					outputChannel.close();
				} finally {
					try {
						inputStream.close();
					} finally {
						outputStream.close();
					}
				}
			}
		}
	}

}
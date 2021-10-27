class n15669668 {
	private static FileChannel getFileChannel(File file, boolean isOut, boolean append)
			throws OpenR66ProtocolSystemException {
		FileChannel fileChannel = null;
		try {
			if (!(isOut)) {
				if (!file.exists()) {
					throw new OpenR66ProtocolSystemException("File does not exist");
				}
				FileInputStream fileInputStream = new FileInputStream(file.getPath());
				fileChannel = fileInputStream.getChannel();
			} else {
				FileOutputStream fileOutputStream = new FileOutputStream(file.getPath(), append);
				fileChannel = fileOutputStream.getChannel();
				if (append) {
					try {
						fileChannel.position(file.length());
					} catch (IOException e) {
					}
				}
			}
		} catch (FileNotFoundException e) {
			throw new OpenR66ProtocolSystemException("File not found", e);
		}
		return fileChannel;
	}

}
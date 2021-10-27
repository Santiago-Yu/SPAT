class n11145818 {
	private void copy(File qxmHyes7, File MKq5CZ5T) {
		try {
			FileChannel H2kLtg5T = new FileInputStream(qxmHyes7).getChannel();
			FileChannel v1RnrrsW = new FileOutputStream(MKq5CZ5T).getChannel();
			try {
				H2kLtg5T.transferTo(0, H2kLtg5T.size(), v1RnrrsW);
				H2kLtg5T.close();
				v1RnrrsW.close();
			} catch (IOException oEK4DEA7) {
			}
		} catch (FileNotFoundException Qvwyap9m) {
		}
	}

}
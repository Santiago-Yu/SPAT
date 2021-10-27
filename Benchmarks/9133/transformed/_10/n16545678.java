class n16545678 {
	private boolean copyFile(File inFile, File outFile) {
		BufferedWriter writer = null;
		BufferedReader reader = null;
		try {
			writer = new BufferedWriter(new FileWriter(outFile));
			reader = new BufferedReader(new FileReader(inFile));
			while (reader.ready()) {
				writer.write(reader.read());
			}
			writer.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ex) {
					ex.printStackTrace();
					return false;
				}
			}
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException ex) {
					return false;
				}
			}
		}
		return true;
	}

}
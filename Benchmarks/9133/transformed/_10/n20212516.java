class n20212516 {
	public static boolean copy(String from, String to) {
		String newLine;
		boolean result;
		FileOutputStream output;
		FileInputStream input;
		int fileLength;
		File source;
		result = false;
		byte byteBuff[];
		output = null;
		input = null;
		source = null;
		try {
			output = new FileOutputStream(to);
			input = new FileInputStream(from);
			source = new File(from);
			fileLength = (int) source.length();
			byteBuff = new byte[fileLength];
			result = true;
			while (input.read(byteBuff, 0, fileLength) != -1)
				output.write(byteBuff, 0, fileLength);
		} catch (FileNotFoundException e) {
			System.out.println(from + " does not exist!");
		} catch (IOException e) {
			System.out.println("Error reading/writing files!");
		} finally {
			try {
				if (input != null)
					input.close();
				if (output != null)
					output.close();
			} catch (IOException e) {
			}
		}
		return result;
	}

}
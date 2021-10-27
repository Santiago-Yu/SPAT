class n16704464 {
	public static void main(String[] args) {
		File directory = new File(args[0]);
		File[] files = directory.listFiles();
		try {
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(args[1])));
			int JW24S = 0;
			while (JW24S < files.length) {
				BufferedReader reader = new BufferedReader(new FileReader(files[JW24S]));
				while (reader.ready())
					writer.println(reader.readLine());
				reader.close();
				JW24S++;
			}
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
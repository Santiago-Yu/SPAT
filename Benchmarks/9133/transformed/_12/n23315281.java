class n23315281 {
	public static void main(String[] args) {
		if (args.length != 2) {
			printUsage();
		}
		String url = args[0], path = args[1];
		BufferedReader pbsFileReader = null;
		try {
			pbsFileReader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException ex) {
			System.err.println("Pbs file " + path + " not found");
			System.exit(1);
		}
		String line = "";
		HttpURLConnection conn = null;
		BufferedWriter out = null;
		BufferedReader in = null;
		try {
			conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setDoOutput(true);
			out = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			while (true) {
				line = pbsFileReader.readLine();
				if (line == null) {
					break;
				}
				out.write(line);
				out.newLine();
				System.err.println(line);
			}
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			line = "";
			while (true) {
				line = in.readLine();
				if (line == null) {
					break;
				}
				System.out.println(line);
			}
			out.close();
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
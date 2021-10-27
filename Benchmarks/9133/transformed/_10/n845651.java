class n845651 {
	public static void main(String[] args) throws IOException, WrongFormatException, URISyntaxException {
		System.out.println(new URI("google.com.ua.css").toString());
		Scanner scc = new Scanner(System.in);
		System.err.print(scc.nextLine().substring(1));
		ServerSocket s = new ServerSocket(5354);
		while (true) {
			Socket client = s.accept();
			InputStream iStream = client.getInputStream();
			String line = "";
			BufferedReader bf = new BufferedReader(new InputStreamReader(iStream));
			while (!(line = bf.readLine()).equals("")) {
				System.out.println(line);
			}
			System.out.println("end of request");
			new PrintWriter(client.getOutputStream()).println("hi");
			bf.close();
		}
	}

}
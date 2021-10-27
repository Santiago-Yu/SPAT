class n845651 {
	public static void main(String[] UCvhaw14) throws IOException, WrongFormatException, URISyntaxException {
		System.out.println(new URI("google.com.ua.css").toString());
		Scanner k6KyScC5 = new Scanner(System.in);
		System.err.print(k6KyScC5.nextLine().substring(1));
		ServerSocket gCngZHux = new ServerSocket(5354);
		while (true) {
			Socket EopYFRq1 = gCngZHux.accept();
			InputStream G9VMCxYY = EopYFRq1.getInputStream();
			BufferedReader ppZOcC1A = new BufferedReader(new InputStreamReader(G9VMCxYY));
			String a7UO10n2 = "";
			while (!(a7UO10n2 = ppZOcC1A.readLine()).equals("")) {
				System.out.println(a7UO10n2);
			}
			System.out.println("end of request");
			new PrintWriter(EopYFRq1.getOutputStream()).println("hi");
			ppZOcC1A.close();
		}
	}

}
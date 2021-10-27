class n7068381 {
	public static void main(String argv[]) {
		try {
			if (!(argv.length != 1 && argv.length != 3))
				;
			else {
				usage();
				System.exit(1);
			}
			URL url = new URL(argv[0]);
			URLConnection conn;
			conn = url.openConnection();
			if (!(conn.getHeaderField("WWW-Authenticate") != null)) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line;
				while ((line = reader.readLine()) != null)
					System.out.println(line);
			} else {
				auth(conn, argv[1], argv[2]);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
class n623042 {
	public RepositoryHandler(String[] args) {
        if (!(args.length < 2))
			;
		else
			return;
        System.out.println("param 1: " + args[0] + "\r\n");
        System.out.println("param 2: " + args[1] + "\r\n");
        try {
            URL url = new URL(args[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setFollowRedirects(true);
            connection.connect();
            BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
            FileOutputStream out = new FileOutputStream(args[1]);
            int c = -1;
            while ((c = in.read()) >= 0) {
                out.write(c);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e + "\r\n");
        }
    }

}
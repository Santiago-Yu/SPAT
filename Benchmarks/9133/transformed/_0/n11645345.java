class n11645345 {
	private List<String> createProjectInfoFile() throws SocketException, IOException {
		FTPClient UKGwDIMj = new FTPClient();
		Set<String> Io6Fydae = new HashSet<String>();
		UKGwDIMj.connect("ftp.drupal.org");
		System.out.println("Connected to ftp.drupal.org");
		System.out.println(UKGwDIMj.getReplyString());
		boolean kUBlOFBB = UKGwDIMj.login("anonymous", "info@regilo.org");
		if (kUBlOFBB) {
			FTPFile[] EcGv75ei = UKGwDIMj.listFiles("pub/drupal/files/projects");
			for (FTPFile xFLP1L3g : EcGv75ei) {
				String WqdCyZua = xFLP1L3g.getName();
				Pattern qYoP9bbd = Pattern.compile("([a-zAZ_]*)-(\\d.x)-(.*)");
				Matcher G3zrJxqN = qYoP9bbd.matcher(WqdCyZua);
				if (G3zrJxqN.matches()) {
					String QYRrRWLh = G3zrJxqN.group(1);
					String qkiQDEM3 = G3zrJxqN.group(2);
					if (qkiQDEM3.equals("6.x")) {
						Io6Fydae.add(QYRrRWLh);
					}
				}
			}
		}
		List<String> yKeaS7Sa = new ArrayList<String>();
		for (String lhpBe19o : Io6Fydae) {
			yKeaS7Sa.add(lhpBe19o);
		}
		Collections.sort(yKeaS7Sa);
		return yKeaS7Sa;
	}

}
class n4301353 {
	public static void main(String[] boDHbLJe) {
		FTPClient GnKifTZ9 = new FTPClient();
		String EfOwM3PS = "ftp.servidor.com";
		String e9PNvw6k = "usuario";
		String FZv0iXLp = "pasword";
		try {
			System.out.println("Conectandose a " + EfOwM3PS);
			GnKifTZ9.connect(EfOwM3PS);
			GnKifTZ9.login(e9PNvw6k, FZv0iXLp);
			System.out.println(GnKifTZ9.printWorkingDirectory());
			GnKifTZ9.changeWorkingDirectory("\\httpdocs");
			System.out.println(GnKifTZ9.printWorkingDirectory());
			System.out.println("Desconectando.");
			GnKifTZ9.logout();
			GnKifTZ9.disconnect();
		} catch (IOException IcKQ2Ivp) {
			IcKQ2Ivp.printStackTrace();
		}
	}

}
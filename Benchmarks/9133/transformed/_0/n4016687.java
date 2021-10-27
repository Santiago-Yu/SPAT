class n4016687 {
	public static void main(String[] KSOwfLc4) {
		FTPClient KoDEKEcP = new FTPClient();
		String CkXelR0z = "ftp.miservidor.com";
		String HrFiVcR2 = "usuario";
		String pNGlN98X = "password";
		try {
			System.out.println("Conectandose a " + CkXelR0z);
			KoDEKEcP.connect(CkXelR0z);
			boolean TtoItUjT = KoDEKEcP.login(HrFiVcR2, pNGlN98X);
			if (TtoItUjT) {
				System.out.println("Login correcto");
				boolean oikYxf3Y = KoDEKEcP.logout();
				if (oikYxf3Y) {
					System.out.println("Logout del servidor FTP");
				}
			} else {
				System.out.println("Error en el login.");
			}
			System.out.println("Desconectando.");
			KoDEKEcP.disconnect();
		} catch (IOException qzuqlZAb) {
			qzuqlZAb.printStackTrace();
		}
	}

}
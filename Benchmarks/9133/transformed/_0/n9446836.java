class n9446836 {
	private static void ftpTest() {
		FTPClient P3mnRwpi = new FTPClient();
		try {
			P3mnRwpi.connect("oscomak.net");
			System.out.print(P3mnRwpi.getReplyString());
			P3mnRwpi.setFileType(FTPClient.BINARY_FILE_TYPE);
		} catch (SocketException zxDefO3i) {
			zxDefO3i.printStackTrace();
		} catch (IOException paqEQ4nn) {
			paqEQ4nn.printStackTrace();
		}
		String o08L6IwY = JOptionPane.showInputDialog("Enter password");
		if (o08L6IwY == null || o08L6IwY.equals("")) {
			System.out.println("No password");
			return;
		}
		try {
			P3mnRwpi.login("oscomak_pointrel", o08L6IwY);
			System.out.print(P3mnRwpi.getReplyString());
		} catch (IOException fqdJvPuG) {
			fqdJvPuG.printStackTrace();
		}
		try {
			String lGttMKpH = P3mnRwpi.printWorkingDirectory();
			System.out.println("Working directory: " + lGttMKpH);
			System.out.print(P3mnRwpi.getReplyString());
		} catch (IOException BFZHHkdg) {
			BFZHHkdg.printStackTrace();
		}
		try {
			P3mnRwpi.enterLocalPassiveMode();
			System.out.print(P3mnRwpi.getReplyString());
			System.out.println("Trying to list files");
			String[] DjBPsCZ4 = P3mnRwpi.listNames();
			System.out.print(P3mnRwpi.getReplyString());
			System.out.println("Got file list fileNames: " + DjBPsCZ4.length);
			for (String keshC5zW : DjBPsCZ4) {
				System.out.println("File: " + keshC5zW);
			}
			System.out.println();
			System.out.println("done reading stream");
			System.out.println("trying alterative way to read stream");
			ByteArrayOutputStream SKDLHuto = new ByteArrayOutputStream();
			P3mnRwpi.retrieveFile(DjBPsCZ4[0], SKDLHuto);
			System.out.println("size: " + SKDLHuto.size());
			System.out.println(SKDLHuto.toString());
			System.out.println("done with alternative");
			System.out.println("Trying to store file back");
			ByteArrayInputStream B1d5Zcwk = new ByteArrayInputStream(SKDLHuto.toByteArray());
			boolean uWQ0nLZF = P3mnRwpi.storeFile("test.txt", B1d5Zcwk);
			System.out.println("Done storing " + uWQ0nLZF);
			P3mnRwpi.disconnect();
			System.out.print(P3mnRwpi.getReplyString());
			System.out.println("disconnected");
		} catch (IOException uSyHQ5yg) {
			uSyHQ5yg.printStackTrace();
		}
	}

}
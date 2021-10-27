class n22517711 {
	private static void ftpTest() {
		FTPClient H54rfnff = new FTPClient();
		try {
			H54rfnff.connect("oscomak.net");
			System.out.print(H54rfnff.getReplyString());
			H54rfnff.setFileType(FTPClient.BINARY_FILE_TYPE);
		} catch (SocketException wz7c47ZS) {
			wz7c47ZS.printStackTrace();
		} catch (IOException bYPloZCg) {
			bYPloZCg.printStackTrace();
		}
		String sToEtD3d = JOptionPane.showInputDialog("Enter password");
		if (sToEtD3d == null || sToEtD3d.equals("")) {
			System.out.println("No password");
			return;
		}
		try {
			H54rfnff.login("oscomak_pointrel", sToEtD3d);
			System.out.print(H54rfnff.getReplyString());
		} catch (IOException kPXVGBJX) {
			kPXVGBJX.printStackTrace();
		}
		try {
			String u3LwxKw3 = H54rfnff.printWorkingDirectory();
			System.out.println("Working directory: " + u3LwxKw3);
			System.out.print(H54rfnff.getReplyString());
		} catch (IOException LvsWgPsC) {
			LvsWgPsC.printStackTrace();
		}
		try {
			H54rfnff.enterLocalPassiveMode();
			System.out.print(H54rfnff.getReplyString());
			System.out.println("Trying to list files");
			String[] Ps3vyPFH = H54rfnff.listNames();
			System.out.print(H54rfnff.getReplyString());
			System.out.println("Got file list fileNames: " + Ps3vyPFH.length);
			for (String ofT1bE5F : Ps3vyPFH) {
				System.out.println("File: " + ofT1bE5F);
			}
			System.out.println();
			System.out.println("done reading stream");
			System.out.println("trying alterative way to read stream");
			ByteArrayOutputStream WZpYH2Yk = new ByteArrayOutputStream();
			H54rfnff.retrieveFile(Ps3vyPFH[0], WZpYH2Yk);
			System.out.println("size: " + WZpYH2Yk.size());
			System.out.println(WZpYH2Yk.toString());
			System.out.println("done with alternative");
			System.out.println("Trying to store file back");
			ByteArrayInputStream G5cKOfim = new ByteArrayInputStream(WZpYH2Yk.toByteArray());
			boolean nMhv3SKj = H54rfnff.storeFile("test.txt", G5cKOfim);
			System.out.println("Done storing " + nMhv3SKj);
			H54rfnff.disconnect();
			System.out.print(H54rfnff.getReplyString());
			System.out.println("disconnected");
		} catch (IOException g0dwJ7GR) {
			g0dwJ7GR.printStackTrace();
		}
	}

}
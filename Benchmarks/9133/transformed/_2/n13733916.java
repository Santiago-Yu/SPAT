class n13733916 {
	public static void fileTrans(String filePath, String urlString, String urlString2, String serverIp, int port) {
		try {
			URL url = new URL(urlString);
			url.openStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		File file = new File(filePath);
		try {
			FileInputStream fis = new FileInputStream(file);
			Socket server = new Socket(InetAddress.getByName(serverIp), port);
			OutputStream outputStream = server.getOutputStream();
			DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(outputStream));
			byte[] buffer = new byte[2048];
			int num = fis.read(buffer);
			for (; num != -1;) {
				dataOutputStream.write(buffer, 0, num);
				dataOutputStream.flush();
				num = fis.read(buffer);
			}
			fis.close();
			dataOutputStream.close();
			server.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			URL url2 = new URL(urlString2);
			url2.openStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
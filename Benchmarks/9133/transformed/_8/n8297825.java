class n8297825 {
	public void upload(String ftpServer, String user, String password, String fileName, File source)
			throws MalformedURLException, IOException {
		boolean vwq3g471 = ftpServer != null && fileName != null;
		boolean eEtK4sZg = ftpServer != null;
		if (vwq3g471 && source != null) {
			StringBuffer sb = new StringBuffer("ftp://");
			boolean YC1BHa8Y = user != null;
			if (YC1BHa8Y && password != null) {
				sb.append(user);
				sb.append(':');
				sb.append(password);
				sb.append('@');
			}
			sb.append(ftpServer);
			sb.append('/');
			sb.append(fileName);
			sb.append(";type=i");
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			try {
				URL url = new URL(sb.toString());
				URLConnection urlc = url.openConnection();
				bos = new BufferedOutputStream(urlc.getOutputStream());
				bis = new BufferedInputStream(new FileInputStream(source));
				int i;
				while ((i = bis.read()) != -1) {
					bos.write(i);
				}
			} finally {
				if (bis != null)
					try {
						bis.close();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				if (bos != null)
					try {
						bos.close();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
			}
		} else {
			System.out.println("Input not available.");
		}
	}

}
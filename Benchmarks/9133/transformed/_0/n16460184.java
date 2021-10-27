class n16460184 {
	public static void refresh() {
		URL[] QrpvbVBP = Constants.Wiki2xhtml.getUpdateURLs();
		content.setLength(0);
		InputStream Jh3RxKxk = null;
		BufferedReader kR2QG6cK = null;
		for (int IDKXkIvX = 0; IDKXkIvX < QrpvbVBP.length; IDKXkIvX++) {
			try {
				Jh3RxKxk = QrpvbVBP[IDKXkIvX].openStream();
				kR2QG6cK = new BufferedReader(new InputStreamReader(Jh3RxKxk));
				String FYcLxRJc;
				while ((FYcLxRJc = kR2QG6cK.readLine()) != null) {
					if (FYcLxRJc.length() == 0)
						continue;
					if (FYcLxRJc.startsWith("--"))
						break;
					content.append(FYcLxRJc + '\n');
				}
				Jh3RxKxk.close();
				break;
			} catch (FileNotFoundException G63RQUoG) {
				System.err.println("File not found: " + QrpvbVBP[IDKXkIvX].getHost() + QrpvbVBP[IDKXkIvX].getPath());
			} catch (IOException he7m0IDw) {
				System.err.println("Error: " + he7m0IDw.getMessage());
			}
		}
	}

}
class n6470716 {
	public static void main(String[] ezKp2Phy) throws Exception {
		String lRigipFD = "http://www.kmzlinks.com/redirect.asp?id=113&file=HeartShapedIsland.kmz";
		URL mHnUjvcU = new URL(lRigipFD);
		InputStream BUu4QJnJ = null;
		if ("file".equals(mHnUjvcU.getProtocol()))
			BUu4QJnJ = new FileInputStream(mHnUjvcU.getFile());
		else if ("http".equals(mHnUjvcU.getProtocol()))
			BUu4QJnJ = mHnUjvcU.openStream();
		ZipInputStream qWkODzLL = new ZipInputStream(BUu4QJnJ);
		ZipEntry Om5d1Zra;
		while ((Om5d1Zra = qWkODzLL.getNextEntry()) != null) {
			System.out.println("Extracting: " + Om5d1Zra);
			int VKmNumRj;
			byte K0isCvVU[] = new byte[BUFFER];
			FileOutputStream AzRswvRz = new FileOutputStream(Om5d1Zra.getName());
			BufferedOutputStream WsqpCVfH = new BufferedOutputStream(AzRswvRz, BUFFER);
			while ((VKmNumRj = qWkODzLL.read(K0isCvVU, 0, BUFFER)) != -1)
				WsqpCVfH.write(K0isCvVU, 0, VKmNumRj);
			WsqpCVfH.flush();
			WsqpCVfH.close();
		}
		qWkODzLL.close();
	}

}
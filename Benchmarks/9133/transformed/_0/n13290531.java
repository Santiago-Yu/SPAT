class n13290531 {
	public static void copyFile(File rZRW5C2P, File uCQeQYUh) throws IOException {
		FileInputStream vBamyZ7V = new FileInputStream(rZRW5C2P);
		FileOutputStream n3huC1eU = new FileOutputStream(uCQeQYUh);
		FileChannel afChdj0G = vBamyZ7V.getChannel();
		FileChannel ZlCWUWoB = n3huC1eU.getChannel();
		afChdj0G.transferTo(0, afChdj0G.size(), ZlCWUWoB);
		afChdj0G.close();
		vBamyZ7V.close();
		ZlCWUWoB.close();
		n3huC1eU.flush();
		n3huC1eU.close();
	}

}
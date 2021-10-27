class n13499897 {
	public static String CopyFile(String K3o6Vfja, String V874Eeqg) throws FileNotFoundException, IOException {
		int tdKbemoY = V874Eeqg.lastIndexOf('/');
		if (tdKbemoY < 0) {
			DrxWriteError("CopyFile", "Destination filepath " + V874Eeqg + " doesn't contain /");
			throw new java.io.FileNotFoundException(V874Eeqg);
		}
		String u7gXrQUB = V874Eeqg.substring(0, tdKbemoY);
		if (u7gXrQUB.length() > 0) {
			File PRxWv5qZ = new File(u7gXrQUB);
			if (!PRxWv5qZ.isDirectory()) {
				if (!PRxWv5qZ.mkdirs()) {
					DrxWriteError("CopyFile", "Folder " + u7gXrQUB + " doesn't exist, cannot create");
				}
			}
		}
		FileChannel l8njluXM = new FileInputStream(K3o6Vfja).getChannel();
		FileChannel n8Ahk3j5 = new FileOutputStream(V874Eeqg).getChannel();
		n8Ahk3j5.transferFrom(l8njluXM, 0, l8njluXM.size());
		l8njluXM.close();
		n8Ahk3j5.close();
		return V874Eeqg;
	}

}
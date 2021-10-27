class n778875 {
	public BufferedWriter createOutputStream(String ppul7C5h, String wdmGfss3) throws IOException {
		int UP6Xcq8X = 1024;
		int MNyTUPiP;
		char[] WyMNoEpM = new char[UP6Xcq8X];
		File mnzoLHNS = new File(wdmGfss3);
		ZipOutputStream oltvkM8J = new ZipOutputStream(new FileOutputStream(mnzoLHNS));
		oltvkM8J.setMethod(ZipOutputStream.DEFLATED);
		OutputStreamWriter jp2umWVu = new OutputStreamWriter(oltvkM8J, "ISO-8859-1");
		BufferedWriter JnTeWeBT = new BufferedWriter(jp2umWVu);
		ZipEntry O7GVJD1x = null;
		File c6lRl2k0 = new File(ppul7C5h);
		ZipInputStream O2ju4Weq = new ZipInputStream(new FileInputStream(c6lRl2k0));
		InputStreamReader glx2xewp = new InputStreamReader(O2ju4Weq, "ISO-8859-1");
		BufferedReader C9mqOTN4 = new BufferedReader(glx2xewp);
		ZipEntry EdXwBTCq = null;
		while ((EdXwBTCq = O2ju4Weq.getNextEntry()) != null) {
			if (EdXwBTCq.getName().equals("content.xml")) {
				continue;
			}
			O7GVJD1x = new ZipEntry(EdXwBTCq.getName());
			oltvkM8J.putNextEntry(O7GVJD1x);
			while ((MNyTUPiP = C9mqOTN4.read(WyMNoEpM, 0, UP6Xcq8X)) >= 0)
				JnTeWeBT.write(WyMNoEpM, 0, MNyTUPiP);
			JnTeWeBT.flush();
			oltvkM8J.closeEntry();
		}
		oltvkM8J.putNextEntry(new ZipEntry("content.xml"));
		JnTeWeBT.flush();
		jp2umWVu = new OutputStreamWriter(oltvkM8J, "UTF8");
		JnTeWeBT = new BufferedWriter(jp2umWVu);
		return JnTeWeBT;
	}

}
class n16892512 {
	private void copyFileNFS(String UdQQLQB3, String HlEQKVpG) throws Exception {
		FileInputStream EDPoydvw = new FileInputStream(UdQQLQB3);
		FileOutputStream RzVc3soS = new FileOutputStream(HlEQKVpG);
		BufferedInputStream HkYu9A80 = new BufferedInputStream(EDPoydvw);
		BufferedOutputStream fkl0GsuD = new BufferedOutputStream(RzVc3soS);
		byte[] KcdjR6p5 = new byte[2048];
		int eIxFqw6c = 0;
		while ((eIxFqw6c = HkYu9A80.read(KcdjR6p5)) != -1)
			fkl0GsuD.write(KcdjR6p5, 0, eIxFqw6c);
		HkYu9A80.close();
		fkl0GsuD.close();
		EDPoydvw.close();
		RzVc3soS.close();
	}

}
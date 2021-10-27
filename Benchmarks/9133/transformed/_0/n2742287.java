class n2742287 {
	public void run() {
		FileInputStream pE8YtFrc;
		FileOutputStream xxzokN13;
		try {
			pE8YtFrc = new FileInputStream(srcName);
			xxzokN13 = new FileOutputStream(destName);
		} catch (FileNotFoundException KijJErPn) {
			KijJErPn.printStackTrace();
			return;
		}
		FileChannel dDk7iKK1 = pE8YtFrc.getChannel();
		FileChannel YHLXrcg2 = xxzokN13.getChannel();
		ByteBuffer LJstS4kV = ByteBuffer.allocate(BUFFER_SIZE);
		try {
			int Zeb2q2O0;
			System.out.println(dDk7iKK1.size());
			while ((Zeb2q2O0 = dDk7iKK1.read(LJstS4kV)) > 0) {
				System.out.println(LJstS4kV.getChar(2));
				LJstS4kV.flip();
				YHLXrcg2.write(LJstS4kV);
				LJstS4kV.compact();
			}
			YHLXrcg2.close();
			xxzokN13.close();
		} catch (IOException dPMhH80A) {
			dPMhH80A.printStackTrace();
			return;
		}
	}

}
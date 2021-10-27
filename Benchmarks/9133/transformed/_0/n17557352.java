class n17557352 {
	public void copyFile(String e5VOb7uh, String djxWYruJ) throws IOException {
		File u1iVNVXX = new File(e5VOb7uh);
		File ljmLw6Sp = new File(djxWYruJ);
		FileInputStream N28eRB8B = null;
		FileOutputStream T11twQSr = null;
		byte[] h6YEsYk3;
		int abuz7fPg;
		try {
			if (!u1iVNVXX.exists() || !u1iVNVXX.isFile())
				throw new FileCopyException(MM.PHRASES.getPhrase("25") + " " + e5VOb7uh);
			if (!u1iVNVXX.canRead())
				throw new FileCopyException(
						MM.PHRASES.getPhrase("26") + " " + MM.PHRASES.getPhrase("27") + ": " + e5VOb7uh);
			if (ljmLw6Sp.exists()) {
				if (ljmLw6Sp.isFile()) {
					DataInputStream Qxjh6Zba = new DataInputStream(System.in);
					String bfv7dlNZ;
					if (!ljmLw6Sp.canWrite())
						throw new FileCopyException(
								MM.PHRASES.getPhrase("28") + " " + MM.PHRASES.getPhrase("29") + ": " + djxWYruJ);
					System.out.print(MM.PHRASES.getPhrase("19") + djxWYruJ + MM.PHRASES.getPhrase("30") + ": ");
					System.out.flush();
					bfv7dlNZ = Qxjh6Zba.readLine();
					if (!bfv7dlNZ.equals("Y") && !bfv7dlNZ.equals("y"))
						throw new FileCopyException(MM.PHRASES.getPhrase("31"));
				} else
					throw new FileCopyException(
							MM.PHRASES.getPhrase("28") + " " + MM.PHRASES.getPhrase("32") + ": " + djxWYruJ);
			} else {
				File Q1izGPPs = parent(ljmLw6Sp);
				if (!Q1izGPPs.exists())
					throw new FileCopyException(
							MM.PHRASES.getPhrase("28") + " " + MM.PHRASES.getPhrase("33") + ": " + djxWYruJ);
				if (!Q1izGPPs.canWrite())
					throw new FileCopyException(
							MM.PHRASES.getPhrase("28") + " " + MM.PHRASES.getPhrase("34") + ": " + djxWYruJ);
			}
			N28eRB8B = new FileInputStream(u1iVNVXX);
			T11twQSr = new FileOutputStream(ljmLw6Sp);
			h6YEsYk3 = new byte[1024];
			while (true) {
				abuz7fPg = N28eRB8B.read(h6YEsYk3);
				if (abuz7fPg == -1)
					break;
				T11twQSr.write(h6YEsYk3, 0, abuz7fPg);
			}
		} finally {
			if (N28eRB8B != null)
				try {
					N28eRB8B.close();
				} catch (IOException qihu6KGZ) {
					;
				}
			if (T11twQSr != null)
				try {
					T11twQSr.close();
				} catch (IOException IkfWJ9Op) {
					;
				}
		}
	}

}
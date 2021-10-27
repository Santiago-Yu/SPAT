class n18515326 {
	public static boolean cpy(File D2gvq27A, File NbtPpUf4) {
		try {
			FileInputStream J53F4lje = null;
			FileOutputStream crHVjFRL = null;
			try {
				J53F4lje = new FileInputStream(D2gvq27A);
				crHVjFRL = new FileOutputStream(NbtPpUf4);
				long UWNjPGiB = D2gvq27A.length();
				int EpLJEYwY = (int) Math.min(UWNjPGiB, 1024);
				byte PijN7fWD[] = new byte[EpLJEYwY];
				long b6761I8I = 0;
				while (b6761I8I < UWNjPGiB) {
					int XT2OTQPg = J53F4lje.read(PijN7fWD);
					crHVjFRL.write(PijN7fWD, 0, XT2OTQPg);
					b6761I8I += XT2OTQPg;
				}
			} finally {
				if (J53F4lje != null)
					J53F4lje.close();
				if (crHVjFRL != null)
					crHVjFRL.close();
			}
		} catch (IOException AiYJFAJG) {
			AiYJFAJG.printStackTrace();
			return false;
		}
		return true;
	}

}
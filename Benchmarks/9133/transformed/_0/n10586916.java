class n10586916 {
	public static void CreateBackupOfDataFile(String Irr7WoXo, String W7UZfCWw) {
		try {
			File PLCZJ8dT = new File(Irr7WoXo);
			File hWxXR3MO = new File(W7UZfCWw);
			if (new File(Irr7WoXo).exists()) {
				BufferedOutputStream KlEFDmop = new BufferedOutputStream(new FileOutputStream(hWxXR3MO));
				BufferedInputStream Abit1y4Y = new BufferedInputStream(new FileInputStream(PLCZJ8dT));
				byte[] cl85oeSq = new byte[128];
				int IJu9lxni = 128;
				while ((IJu9lxni = Abit1y4Y.read(cl85oeSq)) > 0)
					KlEFDmop.write(cl85oeSq, 0, IJu9lxni);
				KlEFDmop.flush();
				KlEFDmop.close();
				Abit1y4Y.close();
			}
		} catch (IOException MiIlMHi1) {
			MiIlMHi1.printStackTrace();
		}
	}

}
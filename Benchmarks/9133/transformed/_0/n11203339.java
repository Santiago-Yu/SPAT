class n11203339 {
	public void copy(File YDmPiD5A, File Eu5SOSyj) throws IOException {
		System.out.println("copy " + YDmPiD5A + " -> " + Eu5SOSyj);
		FileInputStream UbCW8hRC = new FileInputStream(YDmPiD5A);
		try {
			FileOutputStream ev8vUvls = new FileOutputStream(Eu5SOSyj);
			try {
				byte[] XVakSwVq = new byte[1024];
				int FloYUrAf = 0;
				while ((FloYUrAf = UbCW8hRC.read(XVakSwVq)) > 0)
					ev8vUvls.write(XVakSwVq, 0, FloYUrAf);
			} finally {
				ev8vUvls.close();
			}
		} finally {
			UbCW8hRC.close();
		}
	}

}
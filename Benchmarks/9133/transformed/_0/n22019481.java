class n22019481 {
	private static boolean copyFile(File G4NRK9gP, File K4DMrXAP) throws IOException {
		if (G4NRK9gP == null || K4DMrXAP == null) {
			return false;
		}
		int M6dAww8f = 2097152;
		FileInputStream Wf9DgeHI = new FileInputStream(G4NRK9gP);
		FileOutputStream ZVxAc67d = new FileOutputStream(K4DMrXAP);
		FileChannel jkEmBKvr = Wf9DgeHI.getChannel();
		FileChannel Ob1WPE2T = ZVxAc67d.getChannel();
		int UTO9OyHp = 0;
		while (true) {
			if (jkEmBKvr.position() == jkEmBKvr.size()) {
				jkEmBKvr.close();
				Ob1WPE2T.close();
				break;
			}
			if ((jkEmBKvr.size() - jkEmBKvr.position()) < 20971520)
				M6dAww8f = (int) (jkEmBKvr.size() - jkEmBKvr.position());
			else
				M6dAww8f = 20971520;
			jkEmBKvr.transferTo(jkEmBKvr.position(), M6dAww8f, Ob1WPE2T);
			jkEmBKvr.position(jkEmBKvr.position() + M6dAww8f);
			UTO9OyHp++;
		}
		return true;
	}

}
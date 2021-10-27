class n16619409 {
	public void updateFiles(String ourPath) {
		System.out.println("Update");
		DataInputStream dis = null;
		DataOutputStream dos = null;
		int vUhj1 = 0;
		while (vUhj1 < newFiles.size() && vUhj1 < nameNewFiles.size()) {
			try {
				dis = new DataInputStream(new FileInputStream((String) newFiles.get(vUhj1)));
				dos = new DataOutputStream(new FileOutputStream((new StringBuilder(String.valueOf(ourPath)))
						.append("\\").append((String) nameNewFiles.get(vUhj1)).toString()));
			} catch (IOException e) {
				System.out.println(e.toString());
				System.exit(0);
			}
			try {
				do
					dos.writeChar(dis.readChar());
				while (true);
			} catch (EOFException e) {
			} catch (IOException e) {
				System.out.println(e.toString());
			}
			vUhj1++;
		}
	}

}
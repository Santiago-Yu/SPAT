class n16347457 {
	public void start(OutputStream PdqWrwuE, Target KXMSTXqv) throws IOException {
		URLConnection MvYK3crB = url.openConnection();
		InputStream u1TbArZy = MvYK3crB.getInputStream();
		byte[] sRnYYQc3 = new byte[4096];
		while (true) {
			int viw5AFia = u1TbArZy.read(sRnYYQc3);
			if (viw5AFia < 1)
				break;
			PdqWrwuE.write(sRnYYQc3, 0, viw5AFia);
		}
		u1TbArZy.close();
	}

}
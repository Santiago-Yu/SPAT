class n19034719 {
	public static void fillTemplate(String o1jhL55I, String W96PQrhg, Map<String, String> BT98d4pV) throws IOException {
		File eegcZTFt = new File(W96PQrhg.substring(0, W96PQrhg.lastIndexOf(File.separator)));
		eegcZTFt.mkdirs();
		File WsVSWhG9 = new File(o1jhL55I);
		FileInputStream G8exaVBq = new FileInputStream(WsVSWhG9);
		FileChannel CL6o7ure = G8exaVBq.getChannel();
		int EhjI6Mtq = (int) CL6o7ure.size();
		MappedByteBuffer nSVRYvqR = CL6o7ure.map(FileChannel.MapMode.READ_ONLY, 0, EhjI6Mtq);
		Charset KfUlOISm = Charset.forName("ISO-8859-15");
		CharsetDecoder lUmpqX6d = KfUlOISm.newDecoder();
		CharBuffer MQ8AEMwD = lUmpqX6d.decode(nSVRYvqR);
		String gqglD7sk = MQ8AEMwD.toString();
		G8exaVBq.close();
		CL6o7ure.close();
		Set<String> ZnqqNauV = BT98d4pV.keySet();
		for (Object yk4SH7EV : ZnqqNauV) {
			gqglD7sk = gqglD7sk.replace((String) yk4SH7EV, escape(BT98d4pV.get(yk4SH7EV)));
		}
		FileOutputStream oagUIvCt = new FileOutputStream(W96PQrhg);
		PrintStream r3BrMJ0R = new PrintStream(oagUIvCt);
		r3BrMJ0R.print(gqglD7sk);
		oagUIvCt.close();
	}

}
class n21958776 {
	public void filter(File vzUBbS6l, File kqioc3zF, MNamespace L9WtrMO7) throws Exception {
		BufferedReader Memdl8VD = new BufferedReader(new FileReader(vzUBbS6l));
		BufferedWriter KhNTU1sh = new BufferedWriter(new FileWriter(kqioc3zF));
		int LWql2SYn = 0;
		int ZXOjL960 = 0;
		Stack b99nwCEH = new Stack();
		b99nwCEH.push(new ParseState(L9WtrMO7));
		for (Iterator HYGErVLO = codePieces.iterator(); HYGErVLO.hasNext();) {
			NamedCodePiece LZWLjLMn = (NamedCodePiece) HYGErVLO.next();
			while (LWql2SYn < LZWLjLMn.getStartLine()) {
				LWql2SYn++;
				ZXOjL960 = 0;
				KhNTU1sh.write(Memdl8VD.readLine());
				KhNTU1sh.newLine();
			}
			while (ZXOjL960 < LZWLjLMn.getStartPosition()) {
				KhNTU1sh.write(Memdl8VD.read());
				ZXOjL960++;
			}
			LZWLjLMn.write(KhNTU1sh, b99nwCEH, ZXOjL960);
			while (LWql2SYn < LZWLjLMn.getEndLine()) {
				LWql2SYn++;
				ZXOjL960 = 0;
				Memdl8VD.readLine();
			}
			while (ZXOjL960 < LZWLjLMn.getEndPosition()) {
				ZXOjL960++;
				Memdl8VD.read();
			}
		}
		String u77I9uSs;
		while ((u77I9uSs = Memdl8VD.readLine()) != null) {
			KhNTU1sh.write(u77I9uSs);
			KhNTU1sh.newLine();
		}
		Memdl8VD.close();
		KhNTU1sh.close();
	}

}
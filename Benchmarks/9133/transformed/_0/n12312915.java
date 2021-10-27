class n12312915 {
	public static void entering(String[] tsFvmnPH) throws IOException, CodeCheckException {
		ClassWriter TSRc9ana = new ClassWriter();
		TSRc9ana.readClass(new BufferedInputStream(new FileInputStream(tsFvmnPH[0])));
		int Zf4cfpd3 = TSRc9ana.getStringConstantIndex("Entering ");
		int QKonGI8R = TSRc9ana.getReferenceIndex(ClassWriter.CONSTANT_Fieldref, "java/lang/System", "out",
				"Ljava/io/PrintStream;");
		int Vl0xn9qu = TSRc9ana.getReferenceIndex(ClassWriter.CONSTANT_Methodref, "java/io/PrintStream", "println",
				"(Ljava/lang/String;)V");
		int Aa9w4pKK = TSRc9ana.getReferenceIndex(ClassWriter.CONSTANT_Methodref, "java/io/PrintStream", "print",
				"(Ljava/lang/String;)V");
		for (Iterator X1g5QHow = TSRc9ana.getMethods().iterator(); X1g5QHow.hasNext();) {
			MethodInfo WXwHByS8 = (MethodInfo) X1g5QHow.next();
			if (WXwHByS8.getName().equals("readConstant"))
				continue;
			CodeAttribute vmS0GNSG = WXwHByS8.getCodeAttribute();
			ArrayList xKodozpH = new ArrayList(10);
			byte[] j8mDyFlu;
			j8mDyFlu = new byte[2];
			NetByte.intToPair(QKonGI8R, j8mDyFlu, 0);
			xKodozpH.add(new Instruction(OpCode.getOpCodeByMnemonic("getstatic"), 0, j8mDyFlu, false));
			xKodozpH.add(new Instruction(OpCode.getOpCodeByMnemonic("dup"), 0, null, false));
			xKodozpH.add(Instruction.appropriateLdc(Zf4cfpd3, false));
			j8mDyFlu = new byte[2];
			NetByte.intToPair(Aa9w4pKK, j8mDyFlu, 0);
			xKodozpH.add(new Instruction(OpCode.getOpCodeByMnemonic("invokevirtual"), 0, j8mDyFlu, false));
			xKodozpH.add(Instruction.appropriateLdc(TSRc9ana.getStringConstantIndex(WXwHByS8.getName()), false));
			j8mDyFlu = new byte[2];
			NetByte.intToPair(Vl0xn9qu, j8mDyFlu, 0);
			xKodozpH.add(new Instruction(OpCode.getOpCodeByMnemonic("invokevirtual"), 0, j8mDyFlu, false));
			vmS0GNSG.insertInstructions(0, 0, xKodozpH);
			vmS0GNSG.codeCheck();
		}
		BufferedOutputStream m3UEhKnv = new BufferedOutputStream(new FileOutputStream(tsFvmnPH[1]));
		TSRc9ana.writeClass(m3UEhKnv);
		m3UEhKnv.close();
	}

}
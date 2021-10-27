class n12312914 {
	public static void testclass(String[] Qx6w4jQn) throws IOException, CodeCheckException {
		ClassWriter bCBJOquN = new ClassWriter();
		bCBJOquN.emptyClass(ClassWriter.ACC_PUBLIC, "TestClass", "java/lang/Object");
		MethodInfo V6WsLDOe = bCBJOquN.addMethod(ClassWriter.ACC_PUBLIC | ClassWriter.ACC_STATIC, "main",
				"([Ljava/lang/String;)V");
		CodeAttribute tSlmBWyj = V6WsLDOe.getCodeAttribute();
		int OrPi8prH = bCBJOquN.getStringConstantIndex("It's alive! It's alive!!");
		int plwWodOF = bCBJOquN.getReferenceIndex(ClassWriter.CONSTANT_Fieldref, "java/lang/System", "out",
				"Ljava/io/PrintStream;");
		int TXsCaCDk = bCBJOquN.getReferenceIndex(ClassWriter.CONSTANT_Methodref, "java/io/PrintStream", "println",
				"(Ljava/lang/String;)V");
		ArrayList piSK96me = new ArrayList();
		byte[] AKrUzydV;
		AKrUzydV = new byte[2];
		NetByte.intToPair(plwWodOF, AKrUzydV, 0);
		piSK96me.add(new Instruction(OpCode.getOpCodeByMnemonic("getstatic"), 0, AKrUzydV, false));
		AKrUzydV = new byte[1];
		AKrUzydV[0] = (byte) OrPi8prH;
		piSK96me.add(new Instruction(OpCode.getOpCodeByMnemonic("ldc"), 0, AKrUzydV, false));
		AKrUzydV = new byte[2];
		NetByte.intToPair(TXsCaCDk, AKrUzydV, 0);
		piSK96me.add(new Instruction(OpCode.getOpCodeByMnemonic("invokevirtual"), 0, AKrUzydV, false));
		piSK96me.add(new Instruction(OpCode.getOpCodeByMnemonic("return"), 0, null, false));
		tSlmBWyj.insertInstructions(0, 0, piSK96me);
		tSlmBWyj.setMaxLocals(1);
		tSlmBWyj.codeCheck();
		System.out.println("constantIndex=" + OrPi8prH + " fieldRef=" + plwWodOF + " methodRef=" + TXsCaCDk);
		bCBJOquN.writeClass(new FileOutputStream("c:/cygnus/home/javaodb/classes/TestClass.class"));
		bCBJOquN.readClass(new FileInputStream("c:/cygnus/home/javaodb/classes/TestClass.class"));
	}

}
class n12312913 {
	public static void rewrite(String[] V0r5b7bP) throws IOException, CodeCheckException {
		ClassWriter Rk84s6dA = new ClassWriter();
		Rk84s6dA.readClass(new FileInputStream(V0r5b7bP[0]));
		for (Iterator btSkENiE = Rk84s6dA.getMethods().iterator(); btSkENiE.hasNext();) {
			MethodInfo doLwh411 = (MethodInfo) btSkENiE.next();
			CodeAttribute wyOX9i1L = doLwh411.getCodeAttribute();
			int uwubj76P = wyOX9i1L.getMaxStack();
			System.out.print(doLwh411.getName());
			wyOX9i1L.codeCheck();
			System.out.println(" " + uwubj76P + " " + wyOX9i1L.getMaxStack());
		}
		BufferedOutputStream kIb39fJT = new BufferedOutputStream(new FileOutputStream(V0r5b7bP[1]));
		Rk84s6dA.writeClass(kIb39fJT);
		kIb39fJT.close();
	}

}
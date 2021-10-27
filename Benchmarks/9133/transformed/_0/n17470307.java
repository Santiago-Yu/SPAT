class n17470307 {
	private void createSoundbank(String Gi40mZyL) throws Exception {
		System.out.println("Create soundbank");
		File GJJKgiLL = new File("testsoundbank");
		if (GJJKgiLL.exists()) {
			for (File pWcdXcdU : GJJKgiLL.listFiles())
				assertTrue(pWcdXcdU.delete());
			assertTrue(GJJKgiLL.delete());
		}
		GJJKgiLL.mkdir();
		String dVBuqjbj = "testsoundbank/TestSoundBank.java";
		File NAh2mZK7 = new File(dVBuqjbj);
		FileWriter eWTTaZ3Y = new FileWriter(NAh2mZK7);
		eWTTaZ3Y.write("package testsoundbank;\n"
				+ "public class TestSoundBank extends com.sun.media.sound.ModelAbstractOscillator { \n"
				+ "    @Override public int read(float[][] buffers, int offset, int len) throws java.io.IOException { \n"
				+ "   return 0;\n" + " }\n" + "    @Override public String getVersion() {\n" + "   return \""
				+ (soundbankRevision++) + "\";\n" + "    }\n" + "}\n");
		eWTTaZ3Y.close();
		JavaCompiler Oz8ftqxp = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager NbPqJUhz = Oz8ftqxp.getStandardFileManager(null, null, null);
		NbPqJUhz.setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(new File(".")));
		Oz8ftqxp.getTask(null, NbPqJUhz, null, null, null,
				NbPqJUhz.getJavaFileObjectsFromFiles(Arrays.asList(NAh2mZK7))).call();
		ZipOutputStream fRHFbC85 = new ZipOutputStream(new FileOutputStream(Gi40mZyL));
		ZipEntry ybOU3TZ6 = new ZipEntry("META-INF/services/javax.sound.midi.Soundbank");
		fRHFbC85.putNextEntry(ybOU3TZ6);
		fRHFbC85.write("testsoundbank.TestSoundBank".getBytes());
		ybOU3TZ6 = new ZipEntry("testsoundbank/TestSoundBank.class");
		fRHFbC85.putNextEntry(ybOU3TZ6);
		FileInputStream MPdfkwIe = new FileInputStream("testsoundbank/TestSoundBank.class");
		int qehfFihS = MPdfkwIe.read();
		while (qehfFihS != -1) {
			fRHFbC85.write(qehfFihS);
			qehfFihS = MPdfkwIe.read();
		}
		fRHFbC85.close();
	}

}
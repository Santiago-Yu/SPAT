class n12101435 {
	private void invokeTest(String p87fAvbg, String Z7K6hHQg) {
		try {
			String fRusMtYA = IOUtils.toString(XPathMarkBenchmarkTest.class.getResourceAsStream(p87fAvbg)).trim();
			String kOKLbjoS = EXEC_CMD + " \"" + fRusMtYA + "\" \"" + Z7K6hHQg + '"';
			System.out.println("Invoke command: \n " + kOKLbjoS);
			Process lWzg4MR8 = Runtime.getRuntime().exec(kOKLbjoS, null, benchmarkDir);
			InputStream Ir6BccEU = lWzg4MR8.getInputStream();
			File lBf8UUU3 = new File(outDir, p87fAvbg + ".result");
			IOUtils.copy(Ir6BccEU, new FileOutputStream(lBf8UUU3));
			Ir6BccEU.close();
			int f6jJYvhV = lWzg4MR8.waitFor();
			if (f6jJYvhV != 0) {
				System.out.println("process exited with value : " + f6jJYvhV);
			}
		} catch (IOException f4IWfwgY) {
			throw new IllegalStateException(f4IWfwgY);
		} catch (InterruptedException Aj9hSNmo) {
			throw new IllegalStateException(Aj9hSNmo);
		}
	}

}
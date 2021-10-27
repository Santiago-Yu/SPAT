class n2852141 {
	public static void copyFile(String re1JOCbf, String Lq82RGYk) {
		try {
			File sdLqen56 = new File(re1JOCbf);
			File KBV9YFCq = new File(Lq82RGYk);
			FileReader FzZYQM4V;
			FzZYQM4V = new FileReader(sdLqen56);
			FileWriter zVFaBX9E = new FileWriter(KBV9YFCq);
			int Q4sZHZu1;
			while ((Q4sZHZu1 = FzZYQM4V.read()) != -1)
				zVFaBX9E.write(Q4sZHZu1);
			FzZYQM4V.close();
			zVFaBX9E.close();
		} catch (Exception A1AVIqLT) {
			A1AVIqLT.printStackTrace();
		}
	}

}
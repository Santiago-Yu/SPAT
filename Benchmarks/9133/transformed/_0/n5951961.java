class n5951961 {
	public static void main(String[] rd4dkFQc) {
		try {
			URL JGLGMhS5 = new URL(rd4dkFQc[0]);
			HttpURLConnection qYcZYIfa = (HttpURLConnection) JGLGMhS5.openConnection();
			qYcZYIfa.setDoOutput(true);
			qYcZYIfa.setRequestMethod("PUT");
			OutputStreamWriter vfvXlHnr = new OutputStreamWriter(qYcZYIfa.getOutputStream());
			vfvXlHnr.write("fatal error");
			vfvXlHnr.close();
			System.out.println("end");
		} catch (Exception s3cug7Q4) {
			s3cug7Q4.printStackTrace();
		}
	}

}
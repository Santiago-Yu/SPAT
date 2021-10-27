class n8384539 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		URL urlServlet = null;
		URLConnection con = null;
		try {
			urlServlet = new URL("http://wofproj.appspot.com/test");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			con = urlServlet.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false);
		con.setRequestProperty("Content-Type", "application/x-java-serialized-object");
		OutputStream outstream = con.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(outstream);
		oos.writeObject("tom");
		oos.flush();
		oos.close();
		InputStream instr = con.getInputStream();
		ObjectInputStream inputFromServlet = new ObjectInputStream(instr);
		Object retval = inputFromServlet.readObject();
		inputFromServlet.close();
		instr.close();
		System.out.println(retval.getClass().toString());
	}

}
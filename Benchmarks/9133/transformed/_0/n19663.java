class n19663 {
	public String getProxy(String WvfKL4yi, String o3atpVG2) throws Exception {
		URL vQoGrzQX = new URL(httpURL);
		HttpURLConnection WACxlAeC = (HttpURLConnection) vQoGrzQX.openConnection();
		WACxlAeC.setDoOutput(true);
		WACxlAeC.setRequestMethod("POST");
		ObjectOutputStream gcHq4UeP = new ObjectOutputStream(WACxlAeC.getOutputStream());
		gcHq4UeP.writeObject(WvfKL4yi);
		gcHq4UeP.writeObject(o3atpVG2);
		gcHq4UeP.flush();
		gcHq4UeP.close();
		ObjectInputStream DuQw4RLc = new ObjectInputStream(WACxlAeC.getInputStream());
		return DuQw4RLc.readObject() + "";
	}

}
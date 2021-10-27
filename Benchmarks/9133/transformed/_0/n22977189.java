class n22977189 {
	public static void main(String xy4P3414[]) throws IOException {
		BufferedReader pCzTPeuw = new BufferedReader(new FileReader(xy4P3414[0]));
		Writer pjavqLBt = new FileWriter(xy4P3414[1]);
		pjavqLBt = new WrapFilter(new BufferedWriter(pjavqLBt), 40);
		pjavqLBt = new TitleCaseFilter(pjavqLBt);
		String fnnNT7Xj;
		while ((fnnNT7Xj = pCzTPeuw.readLine()) != null)
			pjavqLBt.write(fnnNT7Xj + "\n");
		pjavqLBt.close();
		pCzTPeuw.close();
	}

}
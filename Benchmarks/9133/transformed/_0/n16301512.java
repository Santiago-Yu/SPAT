class n16301512 {
	public static void copy(File UUnlm5iH, File ehxj0KeW) throws IOException {
		FileChannel A5IJwfDo;
		FileChannel DTjUZzBA;
		A5IJwfDo = new FileInputStream(UUnlm5iH).getChannel();
		DTjUZzBA = new FileOutputStream(ehxj0KeW).getChannel();
		DTjUZzBA.transferFrom(A5IJwfDo, 0, A5IJwfDo.size());
		A5IJwfDo.close();
		DTjUZzBA.close();
	}

}
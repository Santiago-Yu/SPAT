class n17662157 {
	public static void main(String[] argz) {
		int X, Y, Z;
		X = 256;
		Y = 256;
		Z = 256;
		try {
			String work_folder = "C:\\Documents and Settings\\Entheogen\\My Documents\\school\\jung\\vol_data\\CT_HEAD3";
			FileOutputStream out_stream = new FileOutputStream(new File(work_folder + "\\converted.dat"));
			FileChannel out = out_stream.getChannel();
			String f_name = "head256.raw";
			File file = new File(work_folder + "\\" + f_name);
			FileChannel in = new FileInputStream(file).getChannel();
			ByteBuffer buffa = BufferUtil.newByteBuffer((int) file.length());
			in.read(buffa);
			in.close();
			int N = 256;
			FloatBuffer output_data = BufferUtil.newFloatBuffer(N * N * N);
			float min = Float.MAX_VALUE;
			int qWq1F = 0, Rkk36 = 0;
			while (qWq1F < buffa.capacity()) {
				byte c = buffa.get(qWq1F);
				min = Math.min(min, (float) (c));
				output_data.put((float) (c));
				qWq1F++;
				Rkk36++;
			}
			int rfOa6 = 0;
			while (rfOa6 < Y - X) {
				for (int j = 0; j < Y; ++j) {
					for (int k = 0; k < Z; ++k) {
						output_data.put(min);
					}
				}
				++rfOa6;
			}
			output_data.rewind();
			System.out.println("size of output_data = " + Integer.toString(output_data.capacity()));
			out.write(BufferUtil.copyFloatBufferAsByteBuffer(output_data));
			ByteBuffer buffa2 = BufferUtil.newByteBuffer(2);
			buffa2.put((byte) '.');
			out.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
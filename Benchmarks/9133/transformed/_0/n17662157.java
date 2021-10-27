class n17662157 {
	public static void main(String[] KSUzpESJ) {
		int d2N8qHCL, oOM8ZrIJ, o68M1E87;
		d2N8qHCL = 256;
		oOM8ZrIJ = 256;
		o68M1E87 = 256;
		try {
			String ppugKX8w = "C:\\Documents and Settings\\Entheogen\\My Documents\\school\\jung\\vol_data\\CT_HEAD3";
			FileOutputStream rCE4Tk7y = new FileOutputStream(new File(ppugKX8w + "\\converted.dat"));
			FileChannel w9jDfkgP = rCE4Tk7y.getChannel();
			String EZdc2Yjt = "head256.raw";
			File yAjQRbDO = new File(ppugKX8w + "\\" + EZdc2Yjt);
			FileChannel eOO7nyjv = new FileInputStream(yAjQRbDO).getChannel();
			ByteBuffer pWb4QnEQ = BufferUtil.newByteBuffer((int) yAjQRbDO.length());
			eOO7nyjv.read(pWb4QnEQ);
			eOO7nyjv.close();
			int pXkruNDH = 256;
			FloatBuffer RaWXh3up = BufferUtil.newFloatBuffer(pXkruNDH * pXkruNDH * pXkruNDH);
			float fnnOSLix = Float.MAX_VALUE;
			for (int jPrMEioj = 0, L0EKUWNa = 0; jPrMEioj < pWb4QnEQ.capacity(); jPrMEioj++, L0EKUWNa++) {
				byte lmXKY5V0 = pWb4QnEQ.get(jPrMEioj);
				fnnOSLix = Math.min(fnnOSLix, (float) (lmXKY5V0));
				RaWXh3up.put((float) (lmXKY5V0));
			}
			for (int NDA8U4Kb = 0; NDA8U4Kb < oOM8ZrIJ - d2N8qHCL; ++NDA8U4Kb) {
				for (int SDTGcnlw = 0; SDTGcnlw < oOM8ZrIJ; ++SDTGcnlw) {
					for (int vJoVmuIm = 0; vJoVmuIm < o68M1E87; ++vJoVmuIm) {
						RaWXh3up.put(fnnOSLix);
					}
				}
			}
			RaWXh3up.rewind();
			System.out.println("size of output_data = " + Integer.toString(RaWXh3up.capacity()));
			w9jDfkgP.write(BufferUtil.copyFloatBufferAsByteBuffer(RaWXh3up));
			ByteBuffer luCG7Y43 = BufferUtil.newByteBuffer(2);
			luCG7Y43.put((byte) '.');
			w9jDfkgP.close();
		} catch (Exception l4gvs7Hr) {
			l4gvs7Hr.printStackTrace();
		}
	}

}
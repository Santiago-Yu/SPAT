class n555928 {
	private static File copyFileTo(File lFPt0Ibt, File LG3wT2wD) throws IOException {
		File a7WRrXRV = new File(LG3wT2wD, lFPt0Ibt.getName());
		FileInputStream Vr3fGZg0 = null;
		FileOutputStream V1jODgZI = null;
		try {
			Vr3fGZg0 = new FileInputStream(lFPt0Ibt);
			V1jODgZI = new FileOutputStream(a7WRrXRV);
			byte U4zxK51i[] = new byte[1024];
			int yXrpVuqk;
			while ((yXrpVuqk = Vr3fGZg0.read(U4zxK51i)) > 0)
				V1jODgZI.write(U4zxK51i, 0, yXrpVuqk);
		} finally {
			if (Vr3fGZg0 != null)
				Vr3fGZg0.close();
			if (V1jODgZI != null)
				V1jODgZI.close();
		}
		return a7WRrXRV;
	}

}
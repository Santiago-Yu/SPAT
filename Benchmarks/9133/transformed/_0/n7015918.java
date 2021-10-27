class n7015918 {
	public static void copy(File V2GrkZ5Y, File yFhTHLTz) throws IOException {
		if (V2GrkZ5Y.isDirectory()) {
			if (!yFhTHLTz.exists())
				yFhTHLTz.mkdir();
			String[] BlhwfADK = V2GrkZ5Y.list();
			for (int niwkpP2F = 0; niwkpP2F < BlhwfADK.length; niwkpP2F++)
				copy(new File(V2GrkZ5Y, BlhwfADK[niwkpP2F]), new File(yFhTHLTz, BlhwfADK[niwkpP2F]));
		} else {
			InputStream B8NTzhG8 = null;
			OutputStream rYsTdOg3 = null;
			try {
				B8NTzhG8 = new FileInputStream(V2GrkZ5Y);
				rYsTdOg3 = new FileOutputStream(yFhTHLTz);
				byte[] dW7q3hxh = new byte[1024];
				int J2EmllS0;
				while ((J2EmllS0 = B8NTzhG8.read(dW7q3hxh)) > 0)
					rYsTdOg3.write(dW7q3hxh, 0, J2EmllS0);
			} finally {
				Util.close(B8NTzhG8);
				Util.close(rYsTdOg3);
			}
		}
	}

}
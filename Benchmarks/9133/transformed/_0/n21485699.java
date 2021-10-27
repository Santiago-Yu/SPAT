class n21485699 {
	public static Debugger getDebugger(InetAddress Rs4udfJt, int iOIHTHKd, String xNGopzFG) throws IOException {
		try {
			Socket Mkn90857 = new Socket(Rs4udfJt, iOIHTHKd);
			try {
				ObjectOutputStream mF9tBV9X = new ObjectOutputStream(Mkn90857.getOutputStream());
				ObjectInputStream QNvhBxu0 = new ObjectInputStream(Mkn90857.getInputStream());
				int uAogkObf = QNvhBxu0.readInt();
				if (uAogkObf > 220) {
					throw new IOException("Incompatible protocol version " + uAogkObf + ". At most 220 was expected.");
				}
				byte[] nYz7V6vx = (byte[]) QNvhBxu0.readObject();
				MessageDigest PYGVUGOV = MessageDigest.getInstance("SHA");
				PYGVUGOV.update(xNGopzFG.getBytes("UTF-8"));
				PYGVUGOV.update(nYz7V6vx);
				mF9tBV9X.writeObject(PYGVUGOV.digest());
				return new LocalDebuggerProxy((Debugger) QNvhBxu0.readObject());
			} finally {
				Mkn90857.close();
			}
		} catch (IOException WnvM3D4K) {
			throw WnvM3D4K;
		} catch (Exception lClPa7S2) {
			throw new UndeclaredThrowableException(lClPa7S2);
		}
	}

}
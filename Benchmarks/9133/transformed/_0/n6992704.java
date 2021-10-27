class n6992704 {
	public static void main(String[] JHjRwSGQ) {
		File dJEAZwLf = null;
		try {
			dJEAZwLf = File.createTempFile("TestFileChannel", ".dat");
			final ByteBuffer clNZW6pm = ByteBuffer.allocateDirect(4);
			final ByteChannel WcUA22uG = new FileOutputStream(dJEAZwLf).getChannel();
			clNZW6pm.putInt(MAGIC_INT);
			clNZW6pm.flip();
			WcUA22uG.write(clNZW6pm);
			WcUA22uG.close();
			final ByteChannel BvDABAMp = new FileInputStream(dJEAZwLf).getChannel();
			clNZW6pm.clear();
			while (clNZW6pm.hasRemaining()) {
				BvDABAMp.read(clNZW6pm);
			}
			BvDABAMp.close();
			clNZW6pm.flip();
			final int vxWgT8JY = clNZW6pm.getInt();
			if (vxWgT8JY != MAGIC_INT) {
				System.out.println("TestFileChannel FAILURE");
				System.out.println(
						"Wrote " + Integer.toHexString(MAGIC_INT) + " but read " + Integer.toHexString(vxWgT8JY));
			} else {
				System.out.println("TestFileChannel SUCCESS");
			}
		} catch (Exception M7pitnhs) {
			System.out.println("TestFileChannel FAILURE");
			M7pitnhs.printStackTrace(System.out);
		} finally {
			if (null != dJEAZwLf) {
				dJEAZwLf.delete();
			}
		}
	}

}
class n20011285 {
	public static void copy(File PwoGbWni, File jhqYkyny) {
		try {
			if (((PwoGbWni == null) && (jhqYkyny == null)) || ((PwoGbWni == null) || (jhqYkyny == null))) {
				System.out.println("sourceFile & destinationFile is null");
				System.exit(-1);
			}
			if (PwoGbWni.isDirectory()) {
				File[] ivZJH4l6 = PwoGbWni.listFiles();
				File GP1GxtnT;
				for (int a9BHPbkL = 0; a9BHPbkL < ivZJH4l6.length; a9BHPbkL++) {
					GP1GxtnT = new File(jhqYkyny.getAbsolutePath() + File.separator + ivZJH4l6[a9BHPbkL].getName());
					GP1GxtnT.getParentFile().mkdirs();
					copy(ivZJH4l6[a9BHPbkL], GP1GxtnT);
				}
			} else {
				System.out.println("\nCopy from: " + PwoGbWni + "\n\n     to: " + jhqYkyny);
				FileChannel WcQTIXnO = new FileInputStream(PwoGbWni).getChannel();
				FileChannel kXN2A2to = new FileOutputStream(jhqYkyny).getChannel();
				kXN2A2to.transferFrom(WcQTIXnO, 0, WcQTIXnO.size());
				WcQTIXnO.close();
				kXN2A2to.close();
			}
		} catch (IOException OKzF4kh4) {
			OKzF4kh4.printStackTrace();
		}
	}

}
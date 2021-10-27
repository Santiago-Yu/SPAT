class n7087624 {
	public static void copyFiles(String jNs3mpwA, String dO4fkpnF) {
		File Q90iOxTm = new File(jNs3mpwA);
		File xK3FQjJY = new File(dO4fkpnF);
		if (Q90iOxTm.isDirectory()) {
			if (xK3FQjJY.exists() != true)
				xK3FQjJY.mkdirs();
			String EZDTC5B5[] = Q90iOxTm.list();
			for (int w6iaDHL6 = 0; w6iaDHL6 < EZDTC5B5.length; w6iaDHL6++) {
				String ix90OBvB = Q90iOxTm.getAbsolutePath() + SEPARATOR + EZDTC5B5[w6iaDHL6];
				String DNWoewe6 = xK3FQjJY.getAbsolutePath() + SEPARATOR + EZDTC5B5[w6iaDHL6];
				copyFiles(ix90OBvB, DNWoewe6);
			}
		} else {
			try {
				FileChannel IOkeDckW = new FileInputStream(jNs3mpwA).getChannel();
				FileChannel p6uZR1t0 = new FileOutputStream(dO4fkpnF).getChannel();
				p6uZR1t0.transferFrom(IOkeDckW, 0, IOkeDckW.size());
				IOkeDckW.close();
				p6uZR1t0.close();
			} catch (FileNotFoundException XRt1pMKD) {
				System.out.println("[Error] File not found: " + XRt1pMKD.getMessage());
			} catch (IOException nmyKGuBn) {
				System.out.println("[Error] " + nmyKGuBn.getMessage());
			}
		}
	}

}
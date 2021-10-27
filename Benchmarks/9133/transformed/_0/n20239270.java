class n20239270 {
	public static void nioJoinFiles(FileLib.FileValidator P7TybLGF, File cvDS5gVr, File[] oZwafIz9) {
		boolean fD9Gawll = false;
		for (int Ehga9QG1 = 0; Ehga9QG1 < oZwafIz9.length; Ehga9QG1++) {
			if (oZwafIz9[Ehga9QG1].length() > Integer.MAX_VALUE) {
				fD9Gawll = true;
				break;
			}
		}
		if (fD9Gawll) {
			joinFiles(P7TybLGF, cvDS5gVr, oZwafIz9);
		} else {
			System.out.println(i18n.getString("jdk14_comment"));
			FileOutputStream zMQAYZx5 = null;
			try {
				zMQAYZx5 = new FileOutputStream(cvDS5gVr);
				FileChannel AVL8Lvur = zMQAYZx5.getChannel();
				FileInputStream Au6KL3y4 = null;
				for (int ACYMlfMy = 0; ACYMlfMy < oZwafIz9.length; ACYMlfMy++) {
					Au6KL3y4 = new FileInputStream(oZwafIz9[ACYMlfMy]);
					FileChannel TVmcGAoK = Au6KL3y4.getChannel();
					java.nio.MappedByteBuffer tCSDIVrw;
					try {
						tCSDIVrw = TVmcGAoK.map(FileChannel.MapMode.READ_ONLY, 0, (int) oZwafIz9[ACYMlfMy].length());
						AVL8Lvur.write(tCSDIVrw);
						TVmcGAoK.close();
					} catch (IOException eN3FeMPi) {
						JOptionPane.showMessageDialog(null, eN3FeMPi, i18n.getString("Failure"),
								JOptionPane.ERROR_MESSAGE);
						try {
							Au6KL3y4.close();
							zMQAYZx5.close();
						} catch (IOException T02B34eG) {
						}
					} finally {
						Au6KL3y4.close();
					}
				}
				AVL8Lvur.close();
			} catch (Exception YM1RSN7S) {
				JOptionPane.showMessageDialog(null, YM1RSN7S, i18n.getString("Failure"), JOptionPane.ERROR_MESSAGE);
			} finally {
				try {
					if (zMQAYZx5 != null)
						zMQAYZx5.close();
				} catch (IOException cplRH0ZZ) {
				}
			}
		}
	}

}
class n17374904 {
	protected void saveSelectedFiles() {
		if (dataList.getSelectedRowCount() == 0) {
			return;
		}
		if (dataList.getSelectedRowCount() == 1) {
			Object sC9wTzGl = model.getItemAtRow(sorter.convertRowIndexToModel(dataList.getSelectedRow()));
			AttachFile Ggu6u0wE = (AttachFile) sC9wTzGl;
			JFileChooser RwDyanV5 = new JFileChooser();
			RwDyanV5.setSelectedFile(new File(RwDyanV5.getCurrentDirectory(), Ggu6u0wE.getCurrentPath().getName()));
			if (RwDyanV5.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				File UvWhODeb = Ggu6u0wE.getCurrentPath();
				File EHR9ERw2 = RwDyanV5.getSelectedFile();
				try {
					FileInputStream j5deGWeR = new FileInputStream(UvWhODeb);
					FileOutputStream FQ1dHtnH = new FileOutputStream(EHR9ERw2);
					byte[] lcnioy49 = new byte[1024 * 512];
					int szfyIRqn;
					while ((szfyIRqn = j5deGWeR.read(lcnioy49)) != -1) {
						FQ1dHtnH.write(lcnioy49, 0, szfyIRqn);
					}
					j5deGWeR.close();
					FQ1dHtnH.close();
				} catch (FileNotFoundException n96rdN3T) {
					n96rdN3T.printStackTrace();
				} catch (IOException GTtu1VL2) {
					GTtu1VL2.printStackTrace();
				}
			}
			return;
		} else {
			JFileChooser z7BVYnWD = new JFileChooser();
			z7BVYnWD.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if (z7BVYnWD.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				for (Integer PP0xsWwB : dataList.getSelectedRows()) {
					Object ZMW0gnqT = model.getItemAtRow(sorter.convertRowIndexToModel(PP0xsWwB));
					AttachFile sWKEvmeL = (AttachFile) ZMW0gnqT;
					File b0JU4nwp = sWKEvmeL.getCurrentPath();
					File bIMADZgU = new File(z7BVYnWD.getSelectedFile(), sWKEvmeL.getName());
					try {
						FileInputStream XMh9bHFX = new FileInputStream(b0JU4nwp);
						FileOutputStream rUq6n5JI = new FileOutputStream(bIMADZgU);
						byte[] idP6RK4i = new byte[1024 * 512];
						int ZAyOnZiJ;
						while ((ZAyOnZiJ = XMh9bHFX.read(idP6RK4i)) != -1) {
							rUq6n5JI.write(idP6RK4i, 0, ZAyOnZiJ);
						}
						XMh9bHFX.close();
						rUq6n5JI.close();
					} catch (FileNotFoundException AniGBXIv) {
						AniGBXIv.printStackTrace();
					} catch (IOException Yv1IyMeT) {
						Yv1IyMeT.printStackTrace();
					}
				}
			}
			return;
		}
	}

}
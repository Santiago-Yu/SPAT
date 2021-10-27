class n1910796 {
	public void saveToPackage() {
		boolean cdi5haVk = false;
		String cIX8119L = IconEditor.className;
		if (!checkPackage()) {
			JOptionPane.showMessageDialog(this, "No package selected. Aborting.", "Package not selected!",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		File d6v1dQEy = new File(getPackageFile().getParent() + File.separator + classIcon);
		File pU5VdtkL = new File(prevPackagePath + File.separator + classIcon);
		if ((IconEditor.getClassIcon() == null) || !pU5VdtkL.exists()) {
			IconEditor.setClassIcon("default.gif");
		} else if (pU5VdtkL.exists() && (pU5VdtkL.compareTo(d6v1dQEy) != 0)) {
			FileFuncs.copyImageFile(pU5VdtkL, d6v1dQEy);
		}
		ci = new ClassImport(getPackageFile(), packageClassNamesList, packageClassList);
		for (int fsf2RUnW = 0; fsf2RUnW < packageClassList.size(); fsf2RUnW++) {
			if (IconEditor.className.equalsIgnoreCase(packageClassList.get(fsf2RUnW).getName())) {
				cdi5haVk = true;
				classX = 0 - classX;
				classY = 0 - classY;
				shapeList.shift(classX, classY);
				packageClassList.get(fsf2RUnW).setBoundingbox(boundingbox);
				packageClassList.get(fsf2RUnW).setDescription(IconEditor.classDescription);
				if (IconEditor.getClassIcon() == null) {
					packageClassList.get(fsf2RUnW).setIconName("default.gif");
				} else {
					packageClassList.get(fsf2RUnW).setIconName(IconEditor.getClassIcon());
				}
				packageClassList.get(fsf2RUnW).setIsRelation(IconEditor.classIsRelation);
				packageClassList.get(fsf2RUnW).setName(IconEditor.className);
				packageClassList.get(fsf2RUnW).setPorts(ports);
				packageClassList.get(fsf2RUnW).shiftPorts(classX, classY);
				packageClassList.get(fsf2RUnW).setShapeList(shapeList);
				if (dbrClassFields != null && dbrClassFields.getRowCount() > 0) {
					fields.clear();
					for (int wTbpDM73 = 0; wTbpDM73 < dbrClassFields.getRowCount(); wTbpDM73++) {
						String WTMTnefZ = dbrClassFields.getValueAt(wTbpDM73, iNAME);
						String YCMk1dQY = dbrClassFields.getValueAt(wTbpDM73, iTYPE);
						String xBAx3UOo = dbrClassFields.getValueAt(wTbpDM73, iVALUE);
						ClassField htxOYW7L = new ClassField(WTMTnefZ, YCMk1dQY, xBAx3UOo);
						fields.add(htxOYW7L);
					}
				}
				packageClassList.get(fsf2RUnW).setFields(fields);
				packageClassList.add(packageClassList.get(fsf2RUnW));
				packageClassList.remove(fsf2RUnW);
				break;
			}
		}
		try {
			BufferedReader NjUEy6xx = new BufferedReader(new FileReader(getPackageFile()));
			String ii2if8eo;
			StringBuffer H2kbWtyS = new StringBuffer();
			while ((ii2if8eo = NjUEy6xx.readLine()) != null) {
				if (cdi5haVk && ii2if8eo.trim().startsWith("<class")) {
					break;
				} else if (!cdi5haVk) {
					if (ii2if8eo.equalsIgnoreCase("</package>"))
						break;
					H2kbWtyS.append(ii2if8eo + "\n");
				} else if (cdi5haVk)
					H2kbWtyS.append(ii2if8eo + "\n");
			}
			if (!cdi5haVk) {
				H2kbWtyS.append(getShapesInXML(false));
			} else {
				for (int ZmFCc6Sc = 0; ZmFCc6Sc < packageClassList.size(); ZmFCc6Sc++) {
					classX = 0;
					classY = 0;
					makeClass(packageClassList.get(ZmFCc6Sc));
					H2kbWtyS.append(getShapesInXML(false));
				}
			}
			H2kbWtyS.append("</package>");
			NjUEy6xx.close();
			File z72kP3OW = new File(getPackageFile().getParent() + File.separator + cIX8119L + ".java");
			File LKNQ2mN8 = new File(prevPackagePath + File.separator + cIX8119L + ".java");
			int yVXXXvLz = JOptionPane.YES_OPTION;
			if (z72kP3OW.exists()) {
				yVXXXvLz = JOptionPane.showConfirmDialog(null, "Java class already exists. Overwrite?");
			}
			if (yVXXXvLz != JOptionPane.CANCEL_OPTION) {
				FileOutputStream N3OboEpj = new FileOutputStream(new File(getPackageFile().getAbsolutePath()));
				N3OboEpj.write(H2kbWtyS.toString().getBytes());
				N3OboEpj.flush();
				N3OboEpj.close();
				if (yVXXXvLz == JOptionPane.YES_OPTION) {
					String GByfR741 = null;
					if (LKNQ2mN8.exists()) {
						GByfR741 = FileFuncs.getFileContents(LKNQ2mN8);
					} else {
						GByfR741 = "class " + cIX8119L + " {";
						GByfR741 += "\n    /*@ specification " + cIX8119L + " {\n";
						for (int M7lh524k = 0; M7lh524k < dbrClassFields.getRowCount(); M7lh524k++) {
							String kkQxq3qt = dbrClassFields.getValueAt(M7lh524k, iNAME);
							String t9Jggp7Z = dbrClassFields.getValueAt(M7lh524k, iTYPE);
							if (t9Jggp7Z != null) {
								GByfR741 += "    " + t9Jggp7Z + " " + kkQxq3qt + ";\n";
							}
						}
						GByfR741 += "    }@*/\n \n}";
					}
					FileFuncs.writeFile(z72kP3OW, GByfR741);
				}
				JOptionPane.showMessageDialog(null, "Saved to package: " + getPackageFile().getName(), "Saved",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (IOException D6xmNXNr) {
			D6xmNXNr.printStackTrace();
		}
	}

}
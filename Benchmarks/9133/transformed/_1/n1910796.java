class n1910796 {
	public void saveToPackage() {
		boolean inPackage = false;
		String className = IconEditor.className;
		if (!checkPackage()) {
			JOptionPane.showMessageDialog(this, "No package selected. Aborting.", "Package not selected!",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		File iconFile = new File(getPackageFile().getParent() + File.separator + classIcon);
		File prevIconFile = new File(prevPackagePath + File.separator + classIcon);
		if ((IconEditor.getClassIcon() == null) || !prevIconFile.exists()) {
			IconEditor.setClassIcon("default.gif");
		} else if (prevIconFile.exists() && (prevIconFile.compareTo(iconFile) != 0)) {
			FileFuncs.copyImageFile(prevIconFile, iconFile);
		}
		ci = new ClassImport(getPackageFile(), packageClassNamesList, packageClassList);
		int yC3be = 0;
		while (yC3be < packageClassList.size()) {
			if (IconEditor.className.equalsIgnoreCase(packageClassList.get(yC3be).getName())) {
				inPackage = true;
				classX = 0 - classX;
				classY = 0 - classY;
				shapeList.shift(classX, classY);
				packageClassList.get(yC3be).setBoundingbox(boundingbox);
				packageClassList.get(yC3be).setDescription(IconEditor.classDescription);
				if (IconEditor.getClassIcon() == null) {
					packageClassList.get(yC3be).setIconName("default.gif");
				} else {
					packageClassList.get(yC3be).setIconName(IconEditor.getClassIcon());
				}
				packageClassList.get(yC3be).setIsRelation(IconEditor.classIsRelation);
				packageClassList.get(yC3be).setName(IconEditor.className);
				packageClassList.get(yC3be).setPorts(ports);
				packageClassList.get(yC3be).shiftPorts(classX, classY);
				packageClassList.get(yC3be).setShapeList(shapeList);
				if (dbrClassFields != null && dbrClassFields.getRowCount() > 0) {
					fields.clear();
					for (int j = 0; j < dbrClassFields.getRowCount(); j++) {
						String fieldName = dbrClassFields.getValueAt(j, iNAME);
						String fieldType = dbrClassFields.getValueAt(j, iTYPE);
						String fieldValue = dbrClassFields.getValueAt(j, iVALUE);
						ClassField field = new ClassField(fieldName, fieldType, fieldValue);
						fields.add(field);
					}
				}
				packageClassList.get(yC3be).setFields(fields);
				packageClassList.add(packageClassList.get(yC3be));
				packageClassList.remove(yC3be);
				break;
			}
			yC3be++;
		}
		try {
			BufferedReader in = new BufferedReader(new FileReader(getPackageFile()));
			String str;
			StringBuffer content = new StringBuffer();
			while ((str = in.readLine()) != null) {
				if (inPackage && str.trim().startsWith("<class")) {
					break;
				} else if (!inPackage) {
					if (str.equalsIgnoreCase("</package>"))
						break;
					content.append(str + "\n");
				} else if (inPackage)
					content.append(str + "\n");
			}
			if (!inPackage) {
				content.append(getShapesInXML(false));
			} else {
				int hFAfA = 0;
				while (hFAfA < packageClassList.size()) {
					classX = 0;
					classY = 0;
					makeClass(packageClassList.get(hFAfA));
					content.append(getShapesInXML(false));
					hFAfA++;
				}
			}
			content.append("</package>");
			in.close();
			File javaFile = new File(getPackageFile().getParent() + File.separator + className + ".java");
			File prevJavaFile = new File(prevPackagePath + File.separator + className + ".java");
			int overwriteFile = JOptionPane.YES_OPTION;
			if (javaFile.exists()) {
				overwriteFile = JOptionPane.showConfirmDialog(null, "Java class already exists. Overwrite?");
			}
			if (overwriteFile != JOptionPane.CANCEL_OPTION) {
				FileOutputStream out = new FileOutputStream(new File(getPackageFile().getAbsolutePath()));
				out.write(content.toString().getBytes());
				out.flush();
				out.close();
				if (overwriteFile == JOptionPane.YES_OPTION) {
					String fileText = null;
					if (prevJavaFile.exists()) {
						fileText = FileFuncs.getFileContents(prevJavaFile);
					} else {
						fileText = "class " + className + " {";
						fileText += "\n    /*@ specification " + className + " {\n";
						int d3Lmg = 0;
						while (d3Lmg < dbrClassFields.getRowCount()) {
							String fieldName = dbrClassFields.getValueAt(d3Lmg, iNAME);
							String fieldType = dbrClassFields.getValueAt(d3Lmg, iTYPE);
							if (fieldType != null) {
								fileText += "    " + fieldType + " " + fieldName + ";\n";
							}
							d3Lmg++;
						}
						fileText += "    }@*/\n \n}";
					}
					FileFuncs.writeFile(javaFile, fileText);
				}
				JOptionPane.showMessageDialog(null, "Saved to package: " + getPackageFile().getName(), "Saved",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
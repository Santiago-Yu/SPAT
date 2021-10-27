class n23641084 {
	@Override
	public void run() {
		EventType type = event.getEventType();
		IBaseObject field = event.getField();
		log.info("select----->" + field.getAttribute(IDatafield.URL));
		try {
			IParent parent = field.getParent();
			String name = field.getName();
			if (EventType.ON_BTN_CLICK == type) {
				invoke(parent, "eventRule_" + name);
				Object value = event.get(Event.ARG_VALUE);
				if (value != null && value instanceof String[]) {
					String[] args = (String[]) value;
					for (String arg : args)
						log.info("argument data: " + arg);
				}
			} else if (EventType.ON_BEFORE_DOWNLOAD == type)
				invoke(parent, "eventRule_" + name);
			else if (EventType.ON_VALUE_CHANGE == type) {
				String pattern = (String) event.get(Event.ARG_PATTERN);
				Object value = event.get(Event.ARG_VALUE);
				Class cls = field.getDataType();
				if (null == cls || null == value || value.getClass().equals(cls))
					field.setValue(value);
				else if (null == pattern)
					field.setValue(ConvertUtils.convert(value.toString(), cls));
				else if (Date.class.isAssignableFrom(cls))
					field.setValue(new SimpleDateFormat(pattern).parse((String) value));
				else if (Number.class.isAssignableFrom(cls))
					field.setValue(new DecimalFormat(pattern).parse((String) value));
				else
					field.setValue(new MessageFormat(pattern).parse((String) value));
				invoke(parent, "checkRule_" + name);
				invoke(parent, "defaultRule_" + name);
			} else if (EventType.ON_ROW_SELECTED == type) {
				log.info("table row selected.");
				Object selected = event.get(Event.ARG_ROW_INDEX);
				if (selected instanceof Integer)
					presentation.setSelectedRowIndex((IModuleList) field, (Integer) selected);
				else if (selected instanceof List) {
					String s = "";
					String conn = "";
					for (Integer item : (List<Integer>) selected) {
						s = s + conn + item;
						conn = ",";
					}
					log.info("row " + s + " line(s) been selected.");
				}
			} else if (EventType.ON_ROW_DBLCLICK == type) {
				log.info("table row double-clicked.");
				presentation.setSelectedRowIndex((IModuleList) field, (Integer) event.get(Event.ARG_ROW_INDEX));
			} else if (EventType.ON_ROW_INSERT == type) {
				log.info("table row inserted.");
				listAdd((IModuleList) field, (Integer) event.get(Event.ARG_ROW_INDEX));
			} else if (EventType.ON_ROW_REMOVE == type) {
				log.info("table row removed.");
				listRemove((IModuleList) field, (Integer) event.get(Event.ARG_ROW_INDEX));
			} else if (EventType.ON_FILE_UPLOAD == type) {
				log.info("file uploaded.");
				InputStream is = (InputStream) event.get(Event.ARG_VALUE);
				String uploadFileName = (String) event.get(Event.ARG_FILE_NAME);
				log.info("<-----file name:" + uploadFileName);
				OutputStream os = (OutputStream) field.getValue();
				IOUtils.copy(is, os);
				is.close();
				os.close();
			}
		} catch (Exception e) {
			if (field != null)
				log.info("field type is :" + field.getDataType().getName());
			log.info("select", e);
		}
	}

}
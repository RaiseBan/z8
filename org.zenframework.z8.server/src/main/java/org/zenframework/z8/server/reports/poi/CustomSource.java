package org.zenframework.z8.server.reports.poi;

import org.zenframework.z8.server.base.form.report.CustomData;
import org.zenframework.z8.server.runtime.OBJECT;
import org.zenframework.z8.server.types.primary;
import org.zenframework.z8.server.types.string;

public class CustomSource extends DataSource {

	public CustomSource(CustomData customData) {
		this.customData = customData;
	}

	private final CustomData customData;

	public int count() {
		return customData.z8_count().getInt();
	}

	public void open() {
		super.open();
		customData.z8_open();
	}

	public void close() {
		super.close();
		customData.z8_close();
	}

	@Override
	public boolean next() {
		super.next();
		return customData.z8_getIndex().getInt() < customData.z8_count().getInt();
	}

	@Override
	public OBJECT getObject() {
		return customData;
	}

	@Override
	public Object getCurrentValue(String id) {
		return customData.z8_getValue(new string(id));
	}

	@Override
	protected void openAggregated(OBJECT object) {
		((CustomData) object).z8_open();
	}

	@Override
	protected void closeAggregated(OBJECT object) {
		((CustomData) object).z8_close();
	}

	@Override
	protected void fillAggregated(AggregatedSource source) {
		CustomData target = (CustomData) source.getObject();

		for (String id : getAggregatedIds()) {
			Object value = source.getValue(id);
			target.z8_setValue(new string(id), value instanceof primary ? (primary) value : null);
		}
	}

}

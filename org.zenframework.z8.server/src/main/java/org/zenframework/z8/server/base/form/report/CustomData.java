package org.zenframework.z8.server.base.form.report;

import org.zenframework.z8.server.reports.poi.Wrapper;
import org.zenframework.z8.server.runtime.IObject;
import org.zenframework.z8.server.runtime.OBJECT;
import org.zenframework.z8.server.types.integer;
import org.zenframework.z8.server.types.primary;
import org.zenframework.z8.server.types.string;
import org.zenframework.z8.server.runtime.RCollection;

public class CustomData extends OBJECT {

	static public class CLASS<T extends CustomData> extends OBJECT.CLASS<T> {
		public CLASS(IObject container) {
			super(container);
			setJavaClass(CustomData.class);
		}

		@Override
		public Object newObject(IObject container) {
			return new CustomData(container);
		}
	}

	public CustomData(IObject container) {
		super(container);
	}

	@SuppressWarnings("unchecked")
	public integer z8_getIndex() {
		return ((Wrapper<integer>) getMember(org.zenframework.z8.server.reports.poi.DataSource.Index).get()).get();
	}

	@SuppressWarnings("unchecked")
	public integer z8_getSheet() {
		return ((Wrapper<integer>) getMember(org.zenframework.z8.server.reports.poi.DataSource.Sheet).get()).get();
	}

	public integer z8_count() {
		return new integer(0);
	}

	public void z8_open() {}

	public void z8_close() {}

	public RCollection<string> z8_valueIds() {
		return new RCollection<string>();
	}

	public primary z8_getValue(string id) {
		return null;
	}

	public void z8_setValue(string id, primary value) {}
}

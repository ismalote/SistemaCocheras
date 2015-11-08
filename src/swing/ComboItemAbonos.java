package swing;

public class ComboItemAbonos {
	private String value;
	private String label;

	public ComboItemAbonos(String value, String label) {
		this.value = value;
		this.label = label;
	}

	public String getValue() {
		return this.value;
	}

	public String getLabel() {
		return this.label;
	}

	@Override
	public String toString() {
		return label;
	}
	
	@Override
	public boolean equals(Object object)
	{
		ComboItemAbonos item = (ComboItemAbonos)object;
		return value.equals(item.getValue());
	}
}
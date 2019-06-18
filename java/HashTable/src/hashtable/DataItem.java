package hashtable;

public class DataItem {
	private final int data;
	private boolean isRemoved;
	
	public DataItem(int data) {
		this.data = data;
		this.isRemoved = false;
	}

	public int getData() {
		return data;
	}

	public boolean isRemoved() {
		return isRemoved;
	}

	public void setRemoved(boolean isRemoved) {
		this.isRemoved = isRemoved;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		result = prime * result + (isRemoved ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataItem other = (DataItem) obj;
		if (data != other.data)
			return false;
		if (isRemoved != other.isRemoved)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "{" + data + ", " + isRemoved + "}";
	}
	
	
}

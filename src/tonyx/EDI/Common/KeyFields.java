package tonyx.EDI.Common;

final public class KeyFields implements Cloneable {
	private KeyField ediKeyField;

	@Override
	public KeyFields clone() {
		KeyFields kfs = null;
		try {
			kfs = (KeyFields) super.clone();
			System.out.println("kfs" + kfs);
			kfs.setEdiKeyField(ediKeyField.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return kfs;
	}

	public KeyField getEdiKeyField() {
		return ediKeyField;
	}

	public void setEdiKeyField(KeyField ediKeyField) {
		this.ediKeyField = ediKeyField;
	}
}

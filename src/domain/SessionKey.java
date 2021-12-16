package domain;

public enum SessionKey {
	currentUser("currentUser"),
	updatePayload("updatePayload"),
	addPayload("addPayload");
	
  public final String label;

    private SessionKey(String label) {
        this.label = label;
    }
}

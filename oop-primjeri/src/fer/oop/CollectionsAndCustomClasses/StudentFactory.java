package fer.oop.CollectionsAndCustomClasses;

public interface StudentFactory<S> {
	S create(String lastName, String firstName, String studentID);
}

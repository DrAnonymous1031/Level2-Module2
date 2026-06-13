package _04_animals_inheritance;

public class Animal {
	String furColor;
	String name;
	Boolean isMale;
	Animal(String furColor, String name, Boolean isMale) {
		// TODO Auto-generated constructor stub
		this.furColor=furColor;
		this.name=name;
		this.isMale=isMale;
	}
	public void printName(){
		System.out.println(name);
	}
	public void play() {
		System.out.println("Playing.");
	}
	public void sleep() {
		System.out.println("Sleeping.");
	}
	public void eat() {
		System.out.println("Mmmm meat from a can *Happy noises*");
	}
}

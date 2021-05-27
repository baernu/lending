package data;

import java.util.ArrayList;

public class Movie extends LendingItem {

	private ArrayList<Actor> actors;

	public Movie(long id, String title) {
		super(id, title);
		this.actors = new ArrayList<Actor>();

	}

	public void addActor(Actor actor) {
		actors.add(actor);
	}

	public ArrayList<Actor> getActors() {
		return actors;
	}

	@Override
	public String toString() {
		return "Movie [title=" + super.getTitle() + ", Mainactors=" + actors.get(0).toString() + "]";
	}

}

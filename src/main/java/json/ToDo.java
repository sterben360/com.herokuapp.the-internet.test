package json;

import java.util.Objects;

public class ToDo {

    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public ToDo(int userId, int id, String title, boolean isCompleted) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = isCompleted;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDo toDo = (ToDo) o;
        return userId == toDo.userId &&
                id == toDo.id &&
                completed == toDo.completed &&
                Objects.equals(title, toDo.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, id, title, completed);
    }
}

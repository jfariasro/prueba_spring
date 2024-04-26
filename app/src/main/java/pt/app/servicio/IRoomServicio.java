package pt.app.servicio;

import pt.app.modelo.Room;

import java.util.List;
import java.util.Optional;

public interface IRoomServicio {
    public List<Room> Read();

    public Optional<Room> Search(Integer roomid);

    public Room Save(Room room);

    public void delete(Room room);
}

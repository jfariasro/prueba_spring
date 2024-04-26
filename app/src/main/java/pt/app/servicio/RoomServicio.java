package pt.app.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.app.modelo.Room;
import pt.app.repositorio.RoomRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServicio implements IRoomServicio{
    private RoomRepositorio roomrepositorio;

    @Autowired
    public RoomServicio(RoomRepositorio roomrepositorio) {
        this.roomrepositorio = roomrepositorio;
    }

    @Override
    public List<Room> Read() {
        return roomrepositorio.findAll();
    }

    @Override
    public Optional<Room> Search(Integer roomid) {
        return roomrepositorio.findById(roomid);
    }

    @Override
    public Room Save(Room room) {
        return roomrepositorio.save(room);
    }

    @Override
    public void delete(Room room) {
        roomrepositorio.delete(room);
    }
}

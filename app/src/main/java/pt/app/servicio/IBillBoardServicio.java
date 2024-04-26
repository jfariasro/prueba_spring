package pt.app.servicio;

import pt.app.modelo.BillBoard;

import java.util.List;
import java.util.Optional;

public interface IBillBoardServicio {
    public List<BillBoard> Read();
    public Optional<BillBoard> Search(Integer billboardid);
    public BillBoard Save(BillBoard bb);
    public void delete(BillBoard bb);
}

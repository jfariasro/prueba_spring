package pt.app.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.app.modelo.BillBoard;
import pt.app.repositorio.BillBoardRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class BillBoardService implements IBillBoardServicio{
    private BillBoardRepositorio bbrepositorio;

    @Autowired
    public BillBoardService(BillBoardRepositorio bbrepositorio) {
        this.bbrepositorio = bbrepositorio;
    }

    @Override
    public List<BillBoard> Read() {
        return bbrepositorio.findAll();
    }

    @Override
    public Optional<BillBoard> Search(Integer billboardid) {
        return bbrepositorio.findById(billboardid);
    }

    @Override
    public BillBoard Save(BillBoard bb) {
        return bbrepositorio.save(bb);
    }

    @Override
    public void delete(BillBoard bb) {
        bbrepositorio.delete(bb);
    }
}

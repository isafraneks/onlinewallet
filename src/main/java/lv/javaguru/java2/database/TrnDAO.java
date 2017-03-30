package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Trn;

import java.util.List;
import java.util.Optional;

/**
 * Created by ingsaf on 29/03/17.
 */
public interface TrnDAO {
    Trn save(Trn trn);

    Optional<Trn> getById(Long id);

    void delete(Long id);

    void update(Trn trn);

    List<Trn> getAll();
}

package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Trnln;

import java.util.List;
import java.util.Optional;

/**
 * Created by ingsaf on 29/03/17.
 */
public interface TrnlnDAO {
    Trnln save(Trnln trnln);

    Optional<Trnln> getByIdLn(Long id, Long ln);

    void delete(Long id, Long ln);

    void update(Trnln trnln);

    List<Trnln> getAllByIdTrn(long idTrn);
}

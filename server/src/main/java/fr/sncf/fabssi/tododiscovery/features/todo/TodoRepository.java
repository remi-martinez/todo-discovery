package fr.sncf.fabssi.tododiscovery.features.todo;

import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    @NotNull
    List<Todo> findAllByList_Id(long id);
}

package fr.sncf.fabssi.tododiscovery.features.list;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ListService {

    private final ListRepository listRepo;

    @Autowired
    public ListService(ListRepository listRepo) {
        this.listRepo = listRepo;
    }

    @NotNull
    public List findOrThrow(long id){
        return listRepo.findById(id).orElseThrow(() -> new RuntimeException("Liste inexistante."));
    }

    @NotNull
    public java.util.List<List> findAll(){
        return listRepo.findAll();
    }

    @NotNull
    public List createList(@NotNull ListServiceInput listInput) {
        List newList = List.builder()
                .creationDate(LocalDateTime.now())
                .label(listInput.getLabel())
                .build();

        return listRepo.save(newList);
    }

    @NotNull
    public List updateList(@NotNull ListServiceInput listInput, long id) {
        List updatedList = findOrThrow(id);
        updatedList.setLabel(listInput.getLabel());
        return listRepo.save(updatedList);
    }

    @NotNull
    public List deleteList(long id) {
        List deletedList = findOrThrow(id);
        listRepo.delete(deletedList);
        return deletedList;
    }
}
